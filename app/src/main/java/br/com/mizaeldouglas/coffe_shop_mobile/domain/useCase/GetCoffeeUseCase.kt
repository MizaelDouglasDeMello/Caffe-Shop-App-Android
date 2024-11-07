package br.com.mizaeldouglas.coffe_shop_mobile.domain.useCase

import android.util.Log
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee
import br.com.mizaeldouglas.coffe_shop_mobile.domain.repository.ICoffeRepository
import javax.inject.Inject

class GetCoffeeUseCase @Inject constructor(private val repository: ICoffeRepository) {
    suspend operator fun invoke(): List<Coffee> {
        return try {
            val coffeeDTOs = repository.getCoffees()
            coffeeDTOs.map { dto ->
                Coffee(
                    id = dto.id,
                    name = dto.name,
                    description = dto.description,
                    price = dto.price,
                    image = dto.image,
                    type = dto.type
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}