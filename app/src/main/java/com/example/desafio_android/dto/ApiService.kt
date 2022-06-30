package com.example.desafio_android.dto

import com.example.desafio_android.dto.model.PullRequest
import com.example.desafio_android.dto.model.RepositoriesAPI
import com.example.desafio_android.dto.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun reposList(@Query("page") page: Int): Call<List<Repository>>


    @GET("repos/{owner}/{repository}/pulls")
    fun getPullRequests(@Path("owner") owner: String, @Path("repository") repository: String): Call<List<PullRequest>>


}