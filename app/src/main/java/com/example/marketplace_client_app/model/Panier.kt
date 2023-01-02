package com.example.marketplace_client_app.model

data class Panier(
    val nombreGroupProduit: Int,
    val items: MutableList<GroupProduit>
)
