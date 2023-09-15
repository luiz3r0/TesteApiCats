package com.movie.ui.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.movie.data.model.CatsModel
import com.movie.databinding.ItemCatsBinding


class CatsAdapter : ListAdapter<CatsModel, CatsAdapter.ViewHolder>(CatsAdapterDiffCallback()) {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val itemCatsBinding: ItemCatsBinding) :
        RecyclerView.ViewHolder(itemCatsBinding.root) {

        fun bind(
            catsModel: CatsModel
        ) {
            itemCatsBinding.catsmodel = catsModel
            itemCatsBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemCatsBinding = ItemCatsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(itemCatsBinding)
            }
        }
    }
}

class CatsAdapterDiffCallback : DiffUtil.ItemCallback<CatsModel>() {

    override fun areItemsTheSame(
        oldItem: CatsModel, newItem: CatsModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CatsModel, newItem: CatsModel
    ): Boolean {
        return oldItem == newItem
    }
}