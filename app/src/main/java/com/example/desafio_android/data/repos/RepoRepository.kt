package com.example.desafio_android.data.repos

import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.data.ResponseListener
import com.example.desafio_android.model.Repo

class RepoRepository (
    private val remoteDataSource: RepoRemoteDataSource
    ){
        fun getRepos(listener: ResponseListener<List<Repo>>){
            this.remoteDataSource.getRepos(listener)
        }
}