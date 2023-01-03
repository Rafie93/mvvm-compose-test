package com.netwerk.salttest.viewmodel
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netwerk.salttest.data.ApiClient
import com.netwerk.salttest.data.request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject




class LoginViewModel: ViewModel()  {
    val isSuccessLoading = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val messageErrorAuth = mutableStateOf(value = "")

    private val loginRequestLiveData = MutableLiveData<Boolean>()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = ApiClient.service()
                val responseService = authService.loginUser(LoginRequest(email = email, password = password))
//                Log.d("Logging", "Code "+responseService.code().toString())

                if (responseService.code()==200){
                    isSuccessLoading.value = true
                    loginRequestLiveData.postValue(responseService.isSuccessful)

                }else if (responseService.code()==400){
                    isSuccessLoading.value = false
                    val jObjError = JSONObject(responseService.errorBody()?.string())
                    val message = jObjError.getString("error").toString()
                    imageErrorAuth.value = true
                    messageErrorAuth.value = message
                }

                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }
}