package com.example.desafio_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.desafio_android.dto.model.Repository
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.databinding.RepositoryItemBinding

class RepositoriesAdapter(
    private var repos: ArrayList<Repository>,
    private val listener: RecyclerViewClickListener
): RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RepositoryItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
        holder.binding.repositoriesLayout.setOnClickListener(){
            listener.onRecyclerViewItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    inner class ViewHolder(val binding: RepositoryItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(repository: Repository){
            binding.tvRepName.text = repository.name
            binding.tvRepDescription.text = repository.description
            binding.tvForks.text = repository.forks.toString()
            binding.tvStars.text = repository.stars.toString()
            binding.tvUserName.text = repository.owner.toString()
            /*pendiente avatar de usuario*/
        }
    }

    interface RecyclerViewClickListener {
        fun onRecyclerViewItemClick(position: Int)
    }
}