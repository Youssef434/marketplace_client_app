package com.example.marketplace_client_app.model

data class Produit(
    val numeroSerie: String,
    val nom: String,
    val description: String,
    val prix: Int,
    val disponible: Boolean,
    val categories: List<Categorie>
)