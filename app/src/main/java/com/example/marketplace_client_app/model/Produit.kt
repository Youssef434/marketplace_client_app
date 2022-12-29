package com.example.supermarket_client.model

data class Produit(
    val numeroSerie: String,
    val nom: String,
    val description: String,
    val prix: Int,
    val disponible: Boolean,
    val categories: List<Categorie>
)