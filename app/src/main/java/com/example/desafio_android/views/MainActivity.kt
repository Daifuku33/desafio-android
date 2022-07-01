package com.example.desafio_android.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.desafio_android.databinding.ActivityMainBinding
import com.example.desafio_android.viewModel.MainViewModel
import com.example.desafio_android.viewModel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { ViewModelFactory() }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRepos()



        /*usar el adapter aqui par ver los repos*/

        viewModel.repos.observe(this) {value ->
            if (value != null) {
                adapter
            }
        }
    }
}