package com.areeb.atomcorn.domain.repoImp

import com.areeb.atomcorn.data.entites.ProductDtoItem
import com.areeb.atomcorn.data.home.api.ProductApi
import com.areeb.atomcorn.data.home.repository.ProdRepo
import com.areeb.atomcorn.utils.Resource
import javax.inject.Inject

class ProductRepImp @Inject constructor(private val productApi: ProductApi) : ProdRepo {
    override suspend fun getProducts(): Resource<List<ProductDtoItem>> {
        return try {
            val response = productApi.getAllProducts()
            Resource.SUCCESS(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.ERROR("${e.message}")
        }
    }
}