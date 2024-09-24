package com.cats.ui.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cats.data.model.CatModel
import com.cats.databinding.ItemCatBinding

class CatsAdapter : ListAdapter<CatModel, CatsAdapter.ViewHolder>(CatAdapterDiffCallback()) {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val itemCatsBinding: ItemCatBinding) :
        RecyclerView.ViewHolder(itemCatsBinding.root) {

        fun bind(
            catModel: CatModel
        ) {
            itemCatsBinding.catmodel = catModel
            itemCatsBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemCatsBinding = ItemCatBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(itemCatsBinding)
            }
        }
    }
}

class CatAdapterDiffCallback : DiffUtil.ItemCallback<CatModel>() {

    override fun areItemsTheSame(
        oldItem: CatModel, newItem: CatModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CatModel, newItem: CatModel
    ): Boolean {
        return oldItem == newItem
    }
}