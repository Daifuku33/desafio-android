package com.example.desafio_android.dto.model

import com.google.gson.annotations.SerializedName

data class RepositoryError(
    @SerializedName("message")
    val message: String,
    @SerializedName("errors")
    val errors: Error
)