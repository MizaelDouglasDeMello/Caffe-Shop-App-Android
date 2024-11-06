package br.com.mizaeldouglas.coffe_shop_mobile.data.dto

data class TypeDTO(
    val id: Int,
    val name: String
)

fun TypeDTO.toType() = br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Type(
    id = id,
    name = name
)
