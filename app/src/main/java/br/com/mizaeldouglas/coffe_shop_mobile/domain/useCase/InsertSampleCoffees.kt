package br.com.mizaeldouglas.coffe_shop_mobile.domain.useCase

import br.com.mizaeldouglas.coffe_shop_mobile.domain.repository.ICoffeRepository
import javax.inject.Inject

class InsertSampleCoffees @Inject constructor(private val repository: ICoffeRepository){
    suspend operator fun invoke() = repository.insertSampleCoffees()
}