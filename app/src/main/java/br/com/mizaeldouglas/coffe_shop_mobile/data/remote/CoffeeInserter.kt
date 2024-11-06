package br.com.mizaeldouglas.coffe_shop_mobile.data.remote

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.CoffeeDTO
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.TypeDTO

class CoffeeInserter(private val database: SQLiteDatabase) {

    fun insertSampleCoffees() {
        val sampleCoffees = listOf(
            CoffeeDTO(
                1,
                "Espresso",
                "Strong and bold coffee",
                2.5,
                "image_url_1",
                TypeDTO(1, "Coffee")
            ),
            CoffeeDTO(
                2,
                "Latte",
                "Smooth and creamy coffee",
                3.0,
                "image_url_2",
                TypeDTO(1, "Coffee")
            ),
            CoffeeDTO(
                3,
                "Cappuccino",
                "Rich and foamy coffee",
                3.5,
                "image_url_3",
                TypeDTO(1, "Coffee")
            )
        )

        for (caffe in sampleCoffees) {
            insertCoffee(caffe)
        }
    }

    fun insertCoffee(caffe: CoffeeDTO) {
        val contentValues = ContentValues().apply {
            put("name", caffe.name)
            put("description", caffe.description)
            put("price", caffe.price)
            put("image", caffe.image)
            put("type_id", caffe.type.id)
        }
        val result = database.insert("caffe", null, contentValues)
        Log.i("CoffeeInserter", "Inserted coffee with id: ${caffe.id}, result: $result")
    }
}