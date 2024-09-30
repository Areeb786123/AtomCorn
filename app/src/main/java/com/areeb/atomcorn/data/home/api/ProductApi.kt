package com.areeb.atomcorn.data.home.api

import com.areeb.atomcorn.data.AppConstant
import com.areeb.atomcorn.data.entites.ProductDtoItem
import retrofit2.http.GET

interface ProductApi {
    @GET(AppConstant.PRODUCTS)
    suspend fun getAllProducts(): List<ProductDtoItem>
}