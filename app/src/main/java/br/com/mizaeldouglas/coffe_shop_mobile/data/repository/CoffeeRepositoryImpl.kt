package br.com.mizaeldouglas.coffe_shop_mobile.data.repository

import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.CoffeeDTO
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.toCoffee
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.CoffeeFetcher
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.CoffeeInserter
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.FirestoreManager
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee
import br.com.mizaeldouglas.coffe_shop_mobile.domain.repository.ICoffeRepository
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val firestoreManager: FirestoreManager
) : ICoffeRepository {

    override suspend fun getCoffees(): List<Coffee> {
        val response = firestoreManager.getCoffees()
        return response.map(CoffeeDTO::toCoffee)
    }

    override suspend fun insertSampleCoffees() = firestoreManager.insertSampleCoffees()
}

