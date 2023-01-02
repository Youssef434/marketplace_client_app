package com.example.marketplace_client_app.listeners

import com.example.marketplace_client_app.model.GroupProduit

interface CartItemClickListener {
    fun onCartItemDelete(cartItem: GroupProduit)
}