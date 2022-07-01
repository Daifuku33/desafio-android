package com.example.desafio_android.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafio_android.data.repos.RepoRemoteDataSource
import com.example.desafio_android.data.repos.RepoRepository

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val remoteDataSource = RepoRemoteDataSource()
        val repository = RepoRepository(remoteDataSource)

        return MainViewModel(repository) as T
    }
}