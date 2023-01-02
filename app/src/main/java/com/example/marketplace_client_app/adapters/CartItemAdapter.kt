package com.example.marketplace_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.databinding.CartItemCardBinding
import com.example.marketplace_client_app.holders.CartItemViewHolder
import com.example.marketplace_client_app.listeners.CartItemClickListener
import com.example.marketplace_client_app.model.GroupProduit

class CartItemAdapter(
    private val productGroups: List<GroupProduit>,
    private val clickListener: CartItemClickListener
): RecyclerView.Adapter<CartItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CartItemCardBinding.inflate(from, parent, false)
        return CartItemViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.bindCartItem(productGroups[position])
    }

    override fun getItemCount() = productGroups.size
}