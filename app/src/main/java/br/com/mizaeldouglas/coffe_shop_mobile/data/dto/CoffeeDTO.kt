package br.com.mizaeldouglas.coffe_shop_mobile.data.dto

data class CoffeeDTO(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val image: String = "",
    val type: TypeDTO = TypeDTO()
) {
    // Construtor sem argumentos para o Firestore
    constructor() : this(0, "", "", 0.0, "", TypeDTO())
}

fun CoffeeDTO.toCoffee() = br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee(
    id = id,
    name = name,
    description = description,
    price = price,
    image = image,
    type = type.toType()
)