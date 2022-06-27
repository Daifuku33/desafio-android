package com.example.desafio_android.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class RepositoriesAPI(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val repositories: ArrayList<Repository>,
    @SerializedName("total_count")
    val totalCount: Int
)