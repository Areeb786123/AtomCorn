package com.areeb.atomcorn.domain.manager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.areeb.atomcorn.data.entites.ProductDtoItem
import com.areeb.atomcorn.data.home.repository.ProdRepo
import com.areeb.atomcorn.utils.Resource
import javax.inject.Inject

class ProductManager @Inject constructor(private val productRepo: ProdRepo) {
    var productData by mutableStateOf<List<ProductDtoItem>?>(null)
    suspend fun getProductData(onSuccess: () -> Unit, onFailure: () -> Unit) {
        if (productRepo.getProducts() is Resource.SUCCESS) {
            productData = productRepo.getProducts().data
            onSuccess()
        } else {
            onFailure()
        }
    }
}