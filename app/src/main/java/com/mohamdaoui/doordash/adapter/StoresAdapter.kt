package com.mohamdaoui.doordash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mohamdaoui.doordash.R
import com.mohamdaoui.doordash.databinding.StoreRowItemBinding
import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.viewmodel.StoreViewModel

class StoresAdapter : RecyclerView.Adapter<StoresAdapter.StoreViewHolder>() {

    private var storeList: ArrayList<Store>? = null

    fun setStoreList(storeList: ArrayList<Store>?) {
        this.storeList = storeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val storeRowItemBinding = DataBindingUtil.inflate<StoreRowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.store_row_item, parent, false
        )

        return StoreViewHolder(storeRowItemBinding)
    }

    override fun getItemCount(): Int {
        return storeList?.size ?: 0
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store = storeList!![position]
        holder.storeRowItemBinding.storeVM = StoreViewModel(store)
    }

    inner class StoreViewHolder(val storeRowItemBinding: StoreRowItemBinding) :
        RecyclerView.ViewHolder(storeRowItemBinding.root)
}