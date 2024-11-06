package br.com.mizaeldouglas.coffe_shop_mobile.domain.useCase

import android.util.Log
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee
import br.com.mizaeldouglas.coffe_shop_mobile.domain.repository.ICoffeRepository
import javax.inject.Inject

class GetCoffeeUseCase @Inject constructor(private val repository: ICoffeRepository) {
    suspend operator fun invoke(): List<Coffee> {
        return try {
            val coffees = repository.getCoffees()
            Log.i("getCoffees", "invoke: ${coffees.toList()}")
            coffees
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("getCoffees", "invoke: ${e.message}")
            emptyList()
        }
    }
}