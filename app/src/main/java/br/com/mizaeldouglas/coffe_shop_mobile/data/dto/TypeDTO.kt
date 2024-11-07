package br.com.mizaeldouglas.coffe_shop_mobile.data.dto

data class TypeDTO(
    val id: Int = 0,
    val name: String = ""
) {
    // Construtor sem argumentos para o Firestore
    constructor() : this(0, "")
}

fun TypeDTO.toType() = br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Type(
    id = id,
    name = name
)