package com.example.desafio_android.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android.adapter.RepoAdapter
import com.example.desafio_android.databinding.ActivityMainBinding
import com.example.desafio_android.viewModel.MainViewModel
import com.example.desafio_android.viewModel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var page = 1
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { ViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.repositoryList.layoutManager = LinearLayoutManager(this)
        val adapter = RepoAdapter(emptyList())
        binding.repositoryList.adapter = adapter

        viewModel.getRepos(page)

        /*usar el adapter aqui par ver los repos*/
        viewModel.repos.observe(this) {value ->
            if (value != null) {
               adapter.setRepos(value)
            } else {
                adapter.setRepos(emptyList())
            }
        }

        /*visibilidad de la progress bar*/
        viewModel.loading.observe(this) { value ->
            binding.progressBar.visibility = if (value) View.VISIBLE else View.GONE
        }

        /*errores en pantalla en caso de llegar*/
        viewModel.error.observe(this) { value ->
            if (value != null) {
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()
            }
        }
    }
}