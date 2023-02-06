package com.example.soko.di

import android.app.Application
import androidx.room.Room
import com.example.soko.api.ProductsListApi
import com.example.soko.data.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ProductsListApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun provideProductListApi(retrofit: Retrofit): ProductsListApi =
        retrofit.create(ProductsListApi::class.java)


    @Provides
    @Singleton
    fun provideDatabase(app: Application): ProductsDatabase=
        Room.databaseBuilder(app,ProductsDatabase::class.java, name = "products_database")
            .build()

}