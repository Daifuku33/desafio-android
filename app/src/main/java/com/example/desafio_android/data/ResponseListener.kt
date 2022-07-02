package com.example.desafio_android.data

import com.example.desafio_android.model.SearchResponse

interface ResponseListener {

    fun onResponse(response: SearchResponse)
    fun onError(repositoryError: RepositoryError)

}