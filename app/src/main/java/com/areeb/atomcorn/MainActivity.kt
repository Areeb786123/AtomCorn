package com.areeb.atomcorn

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.areeb.atomcorn.ui.main.viewModel.MainViewModel
import com.areeb.atomcorn.ui.theme.AtomCornTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModels: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtomCornTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (viewModels.isLoading) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding),
                            this, viewModels
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    context: Context,
    viewModels: MainViewModel
) {
    val list = viewModels.productManager.productData
    Column(modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
            modifier = modifier.clickable {
                viewModels.getProducts()
            }
        )
        Spacer(modifier = modifier.padding(top = 10.dp))
        if (list != null) {
            Text(
                text = "$list",
                modifier = modifier,
            )
        }

    }

}
