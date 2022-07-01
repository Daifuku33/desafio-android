package com.example.desafio_android.data

interface ResponseListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)

}