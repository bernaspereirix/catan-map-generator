package com.bernardopereira.catanmapgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.bernardopereira.catanmapgenerator.ui.generator.MapGeneratorScreen
import com.bernardopereira.catanmapgenerator.ui.theme.CatanMapGeneratorTheme
import com.bernardopereira.catanmapgenerator.ui.theme.CatanRed

class MainActivity : ComponentActivity() {
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