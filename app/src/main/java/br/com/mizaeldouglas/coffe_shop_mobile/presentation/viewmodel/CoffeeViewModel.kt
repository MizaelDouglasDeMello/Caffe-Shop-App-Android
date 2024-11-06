package br.com.mizaeldouglas.coffe_shop_mobile.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Type
import br.com.mizaeldouglas.coffe_shop_mobile.domain.useCase.GetCoffeeUseCase
import br.com.mizaeldouglas.coffe_shop_mobile.domain.useCase.GetInsertSampleCoffees
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val getCoffeeUseCase: GetCoffeeUseCase,
    private val getInsertSampleCoffees: GetInsertSampleCoffees
) : ViewModel() {

    private val _coffees = MutableLiveData<List<Coffee>>()

    val coffees: LiveData<List<Coffee>>
        get() = _coffees

    init {
        getCoffees()

    }


    private fun getFakeCoffees() {
        val fakeCoffees = listOf(
            Coffee(1, "Espresso", "Strong and bold coffee", 2.5, "image_url_1", Type(1, "Coffee")),
            Coffee(2, "Latte", "Smooth and creamy coffee", 3.0, "image_url_2", Type(1, "Coffee")),
            Coffee(3, "Cappuccino", "Rich and foamy coffee", 3.5, "image_url_3", Type(1, "Coffee"))
        )
        _coffees.postValue(fakeCoffees)
    }

    private fun insertSampleData() {
        viewModelScope.launch {
            getInsertSampleCoffees.invoke()
            getCoffees() // Chama getCoffees após a inserção dos dados
        }
    }

    private fun getCoffees() {
        viewModelScope.launch {
            val listCoffees = getCoffeeUseCase()
            _coffees.postValue(listCoffees)
        }
    }
}


//
//private fun getFakeCoffees() {
//    val fakeCoffees = listOf(
//        Coffee(1, "Espresso", "Strong and bold coffee", 2.5, "image_url_1", Type(1, "Coffee")),
//        Coffee(2, "Latte", "Smooth and creamy coffee", 3.0, "image_url_2", Type(1, "Coffee")),
//        Coffee(3, "Cappuccino", "Rich and foamy coffee", 3.5, "image_url_3", Type(1, "Coffee"))
//    )
//    _coffees.postValue(fakeCoffees)
//}