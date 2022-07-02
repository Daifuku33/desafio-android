package com.example.desafio_android.data.repos

import com.example.desafio_android.model.Repo
import com.example.desafio_android.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getRepos(@Query("page") page: Int): Call<SearchResponse>

    /* **Not yet :CCCC
    @GET("repos/{owner}/{repository}/pulls")
    fun getPullRequests(@Path("owner") owner: String, @Path("repository") repository: String): Call<List<PullRequest>>
    */

}