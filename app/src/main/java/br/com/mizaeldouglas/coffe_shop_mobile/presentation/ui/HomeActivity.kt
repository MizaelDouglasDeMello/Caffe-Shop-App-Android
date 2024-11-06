package br.com.mizaeldouglas.coffe_shop_mobile.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.coffe_shop_mobile.R
import br.com.mizaeldouglas.coffe_shop_mobile.databinding.ActivityHomeBinding
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        coffeeViewModel.coffees.observe(this) { listCoffee ->
            var listResult = ""
            listCoffee.forEach { coffee ->
                listResult += "${coffee.name}\n"
            }
            binding.txtCoffes.text = listResult
        }
    }
}