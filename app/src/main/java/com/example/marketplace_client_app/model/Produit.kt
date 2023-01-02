package com.example.marketplace_client_app.model

val PRODUCT_ID_EXTRA = ""

data class Produit(
    val image: Int,
    val numeroSerie: Int,
    val nom: String,
    val description: String,
    val prix: Int,
    val categories: List<Categorie>,
    val detailImage: Int?
) {
    fun estDisponible(): Boolean {
        return true
    }
}