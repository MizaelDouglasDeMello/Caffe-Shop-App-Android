package br.com.mizaeldouglas.coffe_shop_mobile.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
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
