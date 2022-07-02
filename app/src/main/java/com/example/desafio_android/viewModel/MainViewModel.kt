package com.example.desafio_android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_android.data.RepositoryError
import com.example.desafio_android.data.RepositoryResponse
import com.example.desafio_android.data.ResponseListener
import com.example.desafio_android.data.repos.RepoRepository
import com.example.desafio_android.model.Repo
import com.example.desafio_android.model.SearchResponse

class MainViewModel(
    private val repository: RepoRepository
): ViewModel(){
    val repos = MutableLiveData<List<Repo>>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getRepos(page: Int){
        error.value = null
        repos.value = null
        loading.value = true

        repository.getRepos(page, object: ResponseListener{
            override fun onResponse(response: SearchResponse) {
                repos.value = response.items
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = repositoryError.message
                error.value = message
                repos.value = null
                loading.value = false
            }
        })

    }
}