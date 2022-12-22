package com.netwerk.salttest.data.methods

import com.netwerk.salttest.data.ApiClient
import com.netwerk.salttest.data.request.LoginRequest
import com.netwerk.salttest.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface UserApi {

    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

}