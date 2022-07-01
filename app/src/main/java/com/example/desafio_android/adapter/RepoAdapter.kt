package com.example.desafio_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.desafio_android.model.Repo
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.databinding.RepositoryItemBinding

class RepoAdapter(
    private var repos: List<Repo>
): RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    fun setRepos(repos: List<Repo>){
        this.repos = repos
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RepositoryItemBinding.inflate(layoutInflater,parent,false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    inner class RepoViewHolder(val binding: RepositoryItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(repo: Repo){
            binding.tvRepName.text = repo.name
            binding.tvRepDescription.text = repo.description
            binding.tvForks.text = repo.forks.toString()
            binding.tvStars.text = repo.stars.toString()
            binding.tvUserName.text = repo.owner.toString()
            /*pendiente avatar de usuario con glide*/
        }
    }

}