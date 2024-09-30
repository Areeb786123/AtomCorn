package com.areeb.atomcorn.di

import com.areeb.atomcorn.data.home.repository.ProdRepo
import com.areeb.atomcorn.domain.repoImp.ProductRepImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoInjection {
    @Singleton
    @Provides
    fun providesProvides(productRepImp: ProductRepImp): ProdRepo {
        return productRepImp
    }
}