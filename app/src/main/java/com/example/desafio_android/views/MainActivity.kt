package com.example.desafio_android.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.desafio_android.R
import com.example.desafio_android.adapter.RepositoriesAdapter
import com.example.desafio_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RepositoriesAdapter.RecyclerViewClickListener {
    private val adapterRepository = RepositoriesAdapter(ArrayList(), this)
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onRecyclerViewItemClick(position: Int) {
        TODO("Not yet implemented")
    }

}