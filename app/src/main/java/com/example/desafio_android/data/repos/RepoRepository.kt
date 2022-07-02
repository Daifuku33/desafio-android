package com.example.desafio_android.data.repos

import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.data.ResponseListener
import com.example.desafio_android.model.Repo

class RepoRepository (
    private val remoteDataSource: RepoRemoteDataSource
    ){
        fun getRepos(page: Int, listener: ResponseListener){
            this.remoteDataSource.getRepos(page, listener)
        }

    /*falta de pull request*/
}