package com.example.desafio_android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_android.data.RepositoryError
import com.example.desafio_android.data.RepositoryResponse
import com.example.desafio_android.data.ResponseListener
import com.example.desafio_android.data.repos.RepoRepository
import com.example.desafio_android.model.Repo

class MainViewModel(
    private val repository: RepoRepository
): ViewModel(){
    val repos = MutableLiveData<List<Repo>>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getRepos(){
        error.value = null
        repos.value = null
        loading.value = true

        repository.getRepos(object: ResponseListener<List<Repo>>{
            override fun onResponse(response: RepositoryResponse<List<Repo>>) {
                val reposResponse = response.data

                error.value = null
                repos.value = reposResponse
                loading.value = false
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message}"

                error.value = message
                repos.value = null
                loading.value = false
            }
        })

    }
}