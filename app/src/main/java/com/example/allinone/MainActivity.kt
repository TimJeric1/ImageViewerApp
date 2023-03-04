package com.example.allinone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.allinone.feature_unsplash.presentation.NavGraph
import com.example.allinone.feature_unsplash.presentation.NavGraphs
import com.example.allinone.ui.theme.AllInOneTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllInOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background.copy(alpha = 0.97f),
                ){
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }


            }
        }
    }
}