package com.example.desafio_android.dto

import com.example.desafio_android.dto.model.Repository
import com.google.gson.annotations.SerializedName

class RepositoryResponse<T> (
    val totalResponse: Long,
    val incompleteResults: Boolean,
    val items: List<Repository>
)