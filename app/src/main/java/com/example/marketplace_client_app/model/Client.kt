package com.example.supermarket_client.model

import java.time.LocalDate

data class Client(
    val nom: String,
    val prenom: String,
    val dateNaissance: LocalDate,
    val numeroTelephone: String,
    val email: String,
    val panier: Panier
)
