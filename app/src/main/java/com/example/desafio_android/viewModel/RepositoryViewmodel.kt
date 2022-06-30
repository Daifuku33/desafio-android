package com.example.desafio_android.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_android.dto.InitRetrofitService
import com.example.desafio_android.dto.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewmodel : ViewModel() {
    /*Inicializo repositorio*/
    private val initRepo by lazy { InitRetrofitService.init() }

    val liveDataRepositorySuccess: MutableLiveData<List<Repository>> = MutableLiveData()
    val liveDataRepositoryError = MutableLiveData<Any>()

    fun getRepository(page: Int) {
        /*corregir :CCCC*/
        initRepo.reposList(page).enqueue(object : Callback<Repository> {
            override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveDataRepositorySuccess.postValue(it.Repository)
                    }
                }
            }

            override fun onFailure(call: Call<Repository>, t: Throwable) {
                Log.d("Error: ", t.message.toString())
                liveDataRepositoryError.postValue(t)
            }
        })
    }
}