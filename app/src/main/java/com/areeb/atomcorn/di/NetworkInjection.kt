package com.areeb.atomcorn.di

import com.areeb.atomcorn.data.home.api.ProductApi
import com.areeb.atomcorn.data.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkInjection {
   @Provides
   @Singleton
   fun providesRetrofit() :Retrofit {
       return Retrofit.Builder()
           .baseUrl(AppConstant.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }
    @Provides
    @Singleton
    fun providesProductApi(retrofit: Retrofit) : ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
}