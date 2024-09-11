package com.bernardopereira.catanmapgenerator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.bernardopereira.catanmapgenerator.ui.generator.MapGeneratorScreen
import com.bernardopereira.catanmapgenerator.ui.theme.CatanMapGeneratorTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatanMapGeneratorTheme {
                MapGeneratorScreen()
            }
        }
    }
}