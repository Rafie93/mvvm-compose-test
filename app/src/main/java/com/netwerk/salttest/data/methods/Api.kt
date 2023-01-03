package com.netwerk.salttest.data.methods

import com.netwerk.salttest.data.request.LoginRequest
import com.netwerk.salttest.data.response.LoginResponse
import com.netwerk.salttest.data.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("users")
    suspend fun getUser(): Response<UserResponse>

}