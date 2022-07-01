package com.example.desafio_android.model

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("resource")
    val resource: String,
    @SerializedName("field")
    val field: String,
    @SerializedName("code")
    val code: String
)