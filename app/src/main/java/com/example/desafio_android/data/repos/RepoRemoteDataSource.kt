package com.example.desafio_android.data.repos

import com.example.desafio_android.data.*
import com.example.desafio_android.model.Repo
import com.example.desafio_android.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRemoteDataSource {

    fun getRepos(page: Int , listener: ResponseListener) {
        val service = RetrofitService.instance
            .create(RepoService::class.java)
            .getRepos(page)

        service.enqueue(object : Callback<SearchResponse>{

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val responseResult = response.body()
                if (response.isSuccessful && null != responseResult) {
                    listener.onResponse(
                        SearchResponse(
                            totalResponse = responseResult.totalResponse,
                            incompleteResults = responseResult.incompleteResults,
                            items = responseResult.items
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "Conextion Error", errors = null
                        )
                    )
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Unexpected Error", errors = null

                    )
                )
            }
        })

        }
    }
