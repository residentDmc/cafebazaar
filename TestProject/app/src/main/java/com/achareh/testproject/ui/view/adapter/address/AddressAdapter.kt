package com.achareh.testproject.ui.view.adapter.address

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achareh.testproject.data.model.response.address_list.AddressItem
import com.achareh.testproject.databinding.ItemAddressBinding

class AddressAdapter(
    private val context: Context,
) : RecyclerView.Adapter<AddressAdapter.AddressItemViewHolder>() {

    private var list: ArrayList<AddressItem> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressItemViewHolder {
        val itemAddressBinding =
            ItemAddressBinding.inflate(LayoutInflater.from(context), parent, false)
        return AddressItemViewHolder(itemAddressBinding)

    }

    override fun onBindViewHolder(holder: AddressItemViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = list.size

    fun updateList(listAddressItem: List<AddressItem>) {
        list.clear()
        list.addAll(listAddressItem)
        notifyDataSetChanged()
    }

    inner class AddressItemViewHolder(private val binding: ItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: AddressItem) {
            binding.txtNameAndFamily.text="${item.firstName} ${item.lastName}"
            binding.txtMobile.text=item.coordinateMobile
            binding.txtAddress.text=item.address
        }
    }
}