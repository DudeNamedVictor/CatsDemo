package com.example.catsdemo.presentation.fragments.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.catsdemo.databinding.ItemLayoutBinding

class CatsAdapter : PagingDataAdapter<CatsRecyclerModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CatAdapterHolder(
            ItemLayoutBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder as CatAdapterHolder).bindTo(item)
        }
    }

    inner class CatAdapterHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTo(model: CatsRecyclerModel) {
            binding.image.load(model.url)
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatsRecyclerModel>() {
            override fun areItemsTheSame(
                oldItem: CatsRecyclerModel,
                newItem: CatsRecyclerModel,
            ) = oldItem.id == newItem.id && oldItem.url == newItem.url

            override fun areContentsTheSame(
                oldItem: CatsRecyclerModel,
                newItem: CatsRecyclerModel,
            ) = oldItem.id == newItem.id && oldItem.url == newItem.url
        }
    }

}