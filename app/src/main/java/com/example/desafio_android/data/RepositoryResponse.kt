package com.example.desafio_android.data

import com.example.desafio_android.model.Repo

class RepositoryResponse<T> (
    val data: T,
    val source: Source
)