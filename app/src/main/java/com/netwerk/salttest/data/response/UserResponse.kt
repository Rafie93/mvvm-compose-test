package com.netwerk.salttest.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page:String,
    @SerializedName("total")
    val total:String,
    @SerializedName("total_pages")
    val total_pages:String,
    @SerializedName("data")
    val data:ArrayList<UserList>,
    )