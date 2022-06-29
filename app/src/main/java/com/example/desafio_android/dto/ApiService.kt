package com.example.desafio_android.dto

import com.example.desafio_android.dto.model.RepositoriesAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun getRepositories(@Query("q") q: String, @Query("sort") sort: String, @Query("page") page: Int) : Call<RepositoriesAPI>


}