package com.netwerk.salttest.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netwerk.salttest.data.ApiClient
import com.netwerk.salttest.data.response.UserList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    var userListResponse:List<UserList> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getUser(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val service = ApiClient.service()
                val responseService = service.getUser()

                if (responseService.isSuccessful){
                    Log.d("Logging", "Code "+responseService.body()!!.total_pages)

                    val list = responseService.body()!!.data
                    userListResponse = list
                }else{
                    errorMessage="Error"
                }
            }catch (e:Exception){
                errorMessage=e.message.toString()

            }
        }
    }
}