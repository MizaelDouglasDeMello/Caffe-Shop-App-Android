package br.com.mizaeldouglas.coffe_shop_mobile.domain.model

data class Coffee(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: String,
    val type: Type
)
