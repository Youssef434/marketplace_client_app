package com.example.marketplace_client_app.model

data class Produit(
    val image: Int,
    val numeroSerie: Int,
    val nom: String,
    val description: String,
    val prix: Int,
    val categories: List<Categorie>
) {
    fun estDisponible(): Boolean {
        return true
    }
}