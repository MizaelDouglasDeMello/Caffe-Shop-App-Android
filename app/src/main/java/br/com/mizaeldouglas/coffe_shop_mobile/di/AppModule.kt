package br.com.mizaeldouglas.coffe_shop_mobile.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.CoffeeFetcher
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.CoffeeInserter
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.DatabaseHelper
import br.com.mizaeldouglas.coffe_shop_mobile.data.remote.FirestoreManager
import br.com.mizaeldouglas.coffe_shop_mobile.data.repository.CoffeeRepositoryImpl
import br.com.mizaeldouglas.coffe_shop_mobile.domain.repository.ICoffeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabaseHelper(@ApplicationContext context: Context): DatabaseHelper {
        return DatabaseHelper(context)
    }

    @Provides
    @Singleton
    fun provideSQLiteDatabase(databaseHelper: DatabaseHelper): SQLiteDatabase {
        return databaseHelper.writableDatabase
    }

    @Provides
    @Singleton
    fun provideCoffeeFetcher(database: SQLiteDatabase): CoffeeFetcher {
        return CoffeeFetcher(database)
    }

    @Provides
    @Singleton
    fun provideCoffeeInserter(database: SQLiteDatabase): CoffeeInserter {
        return CoffeeInserter(database)
    }

    @Provides
    @Singleton
    fun provideFirestoreManager(): FirestoreManager {
        return FirestoreManager()
    }

    @Provides
    @Singleton
    fun provideCoffeeRepository(
        firestoreManager: FirestoreManager
    ): ICoffeRepository {
        return CoffeeRepositoryImpl(firestoreManager)
    }
}
