package com.example.desafio_android.data.repos

import com.example.desafio_android.model.Repo
import retrofit2.Call
import retrofit2.http.GET

interface RepoService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getrepos(): Call<List<Repo>>

    /* **Not yet :CCCC
    @GET("repos/{owner}/{repository}/pulls")
    fun getPullRequests(@Path("owner") owner: String, @Path("repository") repository: String): Call<List<PullRequest>>
    */

}