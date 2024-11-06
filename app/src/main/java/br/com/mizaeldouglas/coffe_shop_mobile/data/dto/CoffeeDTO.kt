package br.com.mizaeldouglas.coffe_shop_mobile.data.dto


data class CoffeeDTO(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: String,
    val type: TypeDTO
)

fun CoffeeDTO.toCoffee() = br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee(
    id = id,
    name = name,
    description = description,
    price = price,
    image = image,
    type = TypeDTO(id = type.id, name = type.name).toType()

)