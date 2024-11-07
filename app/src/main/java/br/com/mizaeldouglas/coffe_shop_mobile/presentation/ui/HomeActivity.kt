package br.com.mizaeldouglas.coffe_shop_mobile.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mizaeldouglas.coffe_shop_mobile.databinding.ActivityHomeBinding
import br.com.mizaeldouglas.coffe_shop_mobile.presentation.adapter.CoffeeAdapter
import br.com.mizaeldouglas.coffe_shop_mobile.presentation.viewmodel.CoffeeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val coffeeViewModel by viewModels<CoffeeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val coffeeAdapter = CoffeeAdapter(emptyList())
        binding.rvHome.adapter = coffeeAdapter
        binding.rvHome.layoutManager = GridLayoutManager(this, 2)

        coffeeViewModel.coffees.observe(this) { listCoffee ->
            coffeeAdapter.updateData(listCoffee)
        }
    }
}