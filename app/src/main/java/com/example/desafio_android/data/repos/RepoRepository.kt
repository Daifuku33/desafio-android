package com.example.desafio_android.data.repos

import com.example.desafio_android.data.ResponseListener


class RepoRepository (
    private val remoteDataSource: RepoRemoteDataSource
    ){
        fun getRepos(page: Int, listener: ResponseListener){
            this.remoteDataSource.getRepos(page, listener)
        }

    /*falta de pull request*/
}