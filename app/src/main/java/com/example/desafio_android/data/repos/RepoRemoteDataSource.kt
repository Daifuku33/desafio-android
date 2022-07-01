package com.example.desafio_android.data.repos

import com.example.desafio_android.data.*
import com.example.desafio_android.model.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRemoteDataSource {

    fun getRepos(listener: ResponseListener<List<Repo>>) {
        val service = RetrofitService.instance
            .create(RepoService::class.java)
            .getrepos()

        service.enqueue(object : Callback<List<Repo>>{

            override fun onResponse(
                call: Call<List<Repo>>,
                response: Response<List<Repo>>
            ) {
                val repos = response.body()
                if (response.isSuccessful && repos != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = repos,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }
        })

        }
    }

}