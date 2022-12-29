package com.example.marketplace_client_app.model

import java.time.LocalDate

data class Client(
    val nom: String,
    val prenom: String,
    val dateNaissance: LocalDate,
    val numeroTelephone: String,
    val email: String,
    val panier: Panier
)
