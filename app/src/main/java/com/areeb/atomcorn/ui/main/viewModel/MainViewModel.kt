package com.areeb.atomcorn.ui.main.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.atomcorn.domain.manager.ProductManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val productManager: ProductManager) : ViewModel() {
    var isLoading by mutableStateOf(false)
    fun getProducts() {
        viewModelScope.launch {
            isLoading = true
            productManager.getProductData(onSuccess = {
                isLoading = false
            }, onFailure = {
                isLoading = false
            })

        }
    }
}