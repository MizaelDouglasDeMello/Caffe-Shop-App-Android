package br.com.mizaeldouglas.coffe_shop_mobile.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mizaeldouglas.coffe_shop_mobile.databinding.ItemCoffeeBinding
import br.com.mizaeldouglas.coffe_shop_mobile.domain.model.Coffee
import com.squareup.picasso.Picasso

class CoffeeAdapter(private var coffeeList: List<Coffee>) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {


    fun updateData(newCoffeeList: List<Coffee>) {
        coffeeList = newCoffeeList
        notifyDataSetChanged()
    }

    inner class CoffeeViewHolder(val binding: ItemCoffeeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coffee: Coffee) {

            Picasso.get().load(coffee.image).into(binding.imgCoffee)
            binding.tvCoffeeName.text = coffee.name
            binding.tvCoffeeDescription.text = coffee.type.name
            binding.tvCoffeePrice.text = String.format("R$ %.2f", coffee.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCoffeeBinding.inflate(layoutInflater, parent, false)
        return CoffeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(coffeeList[position])
    }

    override fun getItemCount(): Int = coffeeList.size

}