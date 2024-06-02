package com.example.habit_tracker

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable

fun HelpScreen() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val statusBarColor = PrimaryColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
    DisposableEffect(Unit) {
        onDispose {
            systemUiController.setStatusBarColor(
                color = BackgroundColor,
                darkIcons = useDarkIcons
            )
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(color = PrimaryColor),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "User Guide", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = BackgroundColor))
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            onClick = { /*TODO*/ },
            painter = R.drawable.sticky_note,
            text = "Notes"
        )
        CustomButton(
            onClick = { /*TODO*/ },
            painter = R.drawable.image_search,
            text = "OCR"
        )
        CustomButton(
            onClick = { /*TODO*/ },
            painter = R.drawable.lock,
            text = "Password Reset"
        )

    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    painter: Int,
    text: String,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor
        ),
        shape = RoundedCornerShape(4.dp),


        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id =  painter),
                contentDescription ="note"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = text, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BackgroundColor))
                Text(text = "Tap to view")
            }
        }
    }
}