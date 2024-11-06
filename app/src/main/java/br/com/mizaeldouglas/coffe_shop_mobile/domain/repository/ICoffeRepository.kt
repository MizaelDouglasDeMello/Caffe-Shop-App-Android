package br.com.mizaeldouglas.coffe_shop_mobile.domain.repository

import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee

interface ICoffeRepository {
    suspend fun getCoffees(): List<Coffee>
    suspend fun insertSampleCoffees()
}