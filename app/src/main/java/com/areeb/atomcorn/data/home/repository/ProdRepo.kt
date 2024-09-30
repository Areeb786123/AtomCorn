package com.areeb.atomcorn.data.home.repository

import com.areeb.atomcorn.data.entites.ProductDtoItem
import com.areeb.atomcorn.utils.Resource

interface ProdRepo {
    suspend fun getProducts(): Resource<List<ProductDtoItem>>
}