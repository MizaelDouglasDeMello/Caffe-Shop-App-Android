package br.com.mizaeldouglas.coffe_shop_mobile.data.remote

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.CoffeeDTO
import br.com.mizaeldouglas.coffe_shop_mobile.data.dto.TypeDTO

// CoffeeFetcher.kt
class CoffeeFetcher(private val database: SQLiteDatabase) {

    fun getCoffees(): List<CoffeeDTO> {
        val cursor = database.rawQuery("SELECT * FROM caffe", null)
        val coffees = mutableListOf<CoffeeDTO>()
        while (cursor.moveToNext()) {
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val descriptionIndex = cursor.getColumnIndex("description")
            val priceIndex = cursor.getColumnIndex("price")
            val imageIndex = cursor.getColumnIndex("image")
            val typeIdIndex = cursor.getColumnIndex("type_id")

            if (idIndex >= 0 && nameIndex >= 0 && descriptionIndex >= 0 && priceIndex >= 0 && imageIndex >= 0 && typeIdIndex >= 0) {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                val description = cursor.getString(descriptionIndex)
                val price = cursor.getDouble(priceIndex)
                val image = cursor.getString(imageIndex)
                val typeId = cursor.getInt(typeIdIndex)
                val type = getType(typeId)
                coffees.add(CoffeeDTO(id, name, description, price, image, type))
                Log.i("CoffeeFetcher", "Fetched coffee: $name")
            }
        }
        cursor.close()
        return coffees
    }

    private fun getType(typeId: Int): TypeDTO {
        val cursor = database.rawQuery("SELECT * FROM type WHERE id = $typeId", null)
        if (cursor.moveToNext()) {
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")

            if (idIndex >= 0 && nameIndex >= 0) {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                cursor.close()
                return TypeDTO(id, name)
            }
        }
        cursor.close()
        throw IllegalArgumentException("Type not found for id: $typeId")
    }
}