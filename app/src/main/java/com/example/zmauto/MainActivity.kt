package com.example.zmauto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.zmauto.screens.payment.EdahabiaScreen
import com.example.zmauto.screens.payment.PaymentMethodScreen
import com.example.zmauto.screens.payment.ThankYouScreen
import com.example.zmauto.ui.theme.ZMAutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZMAutoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showThankYou by remember { mutableStateOf(false) }
                    var showEdahabia by remember { mutableStateOf(false) }

                    when {
                        showThankYou -> {
                            ThankYouScreen(
                                onExitClick = {
                                    showThankYou = false
                                }
                            )
                        }
                        showEdahabia -> {
                            EdahabiaScreen(
                                onBackClick = {
                                    showEdahabia = false
                                },
                                onContinueClick = {
                                    showEdahabia = false
                                    showThankYou = true
                                }
                            )
                        }
                        else -> {
                            PaymentMethodScreen(
                                onBackClick = { finish() },
                                onContinueClick = {
                                    showThankYou = true
                                },
                                onEdahabiaClick = {
                                    showEdahabia = true
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
