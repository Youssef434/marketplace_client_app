package com.example.marketplace_client_app.listeners

import com.example.marketplace_client_app.model.Produit

interface ProductCardClickListener {
    fun onProductCardClick(product: Produit)
}