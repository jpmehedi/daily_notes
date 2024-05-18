package com.example.habit_tracker

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.DailyNotes
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition(
            condition = { false }
        )
        Thread.sleep(1000)
        enableEdgeToEdge()
        setContent {
            DailyNotes {
                Surface(modifier = Modifier.fillMaxSize(), color = BackgroundColor) {
                    OnBoardingScreen(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

            }
        }
    }
}

