package com.example.zmauto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.zmauto.screens.payment.PaymentMethodScreen
import com.example.zmauto.ui.theme.ZMAutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContent {
            Log.d("MainActivity", "setContent called")
            ZMAutoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Log.d("MainActivity", "Rendering PaymentMethodScreen")
                    PaymentMethodScreen(
                        onBackClick = { 
                            Log.d("MainActivity", "Back button clicked")
                        },
                        onContinueClick = { 
                            Log.d("MainActivity", "Continue button clicked")
                        }
                    )
                }
            }
        }
    }
}
