package br.com.mizaeldouglas.coffe_shop_mobile.data.remote

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "coffe_shop.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Ativando Foreign Key Constraints
        db.execSQL("PRAGMA foreign_keys=ON;")

        // Criando tabelas
        db.execSQL(CREATE_TABLE_TYPE)
        db.execSQL(CREATE_TABLE_CAFFE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE_CAFFE)
        db.execSQL(DROP_TABLE_TYPE)
        onCreate(db)
    }

    // Função para inicializar dados de exemplo
    fun insertSampleData() {
        writableDatabase?.let { db ->
            try {
                CoffeeInserter(db).insertSampleCoffees()
            } catch (e: Exception) {
                Log.e("DatabaseHelper", "Erro ao inserir cafés de exemplo: ${e.message}")
            }
        }
    }

    private val CREATE_TABLE_CAFFE = """
        CREATE TABLE caffe (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            description TEXT,
            price REAL,
            image TEXT,
            type_id INTEGER,
            FOREIGN KEY (type_id) REFERENCES type(id)
        )
    """.trimIndent()

    private val CREATE_TABLE_TYPE = """
        CREATE TABLE type (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT
        )
    """.trimIndent()

    private val DROP_TABLE_CAFFE = "DROP TABLE IF EXISTS caffe"
    private val DROP_TABLE_TYPE = "DROP TABLE IF EXISTS type"
}
