package br.com.mizaeldouglas.coffe_shop_mobile.data.remote

import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.CoffeeDTO
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.TypeDTO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreManager {

    private val db = FirebaseFirestore.getInstance()

    suspend fun getCoffees(): List<CoffeeDTO> {
        val snapshot = db.collection("coffees").get().await()
        return snapshot.documents.mapNotNull { it.toObject(CoffeeDTO::class.java) }
    }

    suspend fun insertSampleCoffees() {
        val sampleCoffees = listOf(
            CoffeeDTO(
                1,
                "Cappuccino",
                "Cappuccino is a coffee drink that today is composed of double espresso and hot milk, with the surface topped with foamed milk.",
                5.0,
                "https://www.starbucks.com.br/images/products/zoom/cappuccino.jpg",
                TypeDTO(1, "Coffee")
            ), CoffeeDTO(
                2,
                "Espresso",
                "Espresso is a coffee-making method of Italian origin, in which a small amount of nearly boiling water is forced under pressure through finely-ground coffee beans.",
                3.0,
                "https://www.starbucks.com.br/images/products/zoom/espresso.jpg",
                TypeDTO(1, "Coffee")
            ), CoffeeDTO(
                3,
                "Latte",
                "Latte is a coffee drink made with espresso and steamed milk.",
                4.0,
                "https://www.starbucks.com.br/images/products/zoom/latte.jpg",
                TypeDTO(1, "Coffee")
            ), CoffeeDTO(
                4,
                "Mocha",
                "Mocha is a high quality coffee made from a specific coffee bean, and comes with a chocolate flavor.",
                6.0,
                "https://www.starbucks.com.br/images/products/zoom/mocha.jpg",
                TypeDTO(1, "Coffee")
            ), CoffeeDTO(
                5,
                "Macchiato",
                "Macchiato is a coffee beverage that is made up of espresso and a small amount of milk.",
                4.5,
                "https://www.starbucks.com.br/images/products/zoom/macchiato.jpg",
                TypeDTO(1, "Coffee")
            )
        )

        sampleCoffees.forEach { db.collection("coffees").add(it).await() }
    }
}