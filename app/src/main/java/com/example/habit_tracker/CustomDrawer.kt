package com.example.habit_tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.TextColor
import org.w3c.dom.Text

@Composable
fun CustomDrawer() {
    Column (

        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(BackgroundColor, PrimaryColor),
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(1000f, 1000f)
                )
            )
    ){
       Column (
       ){
           Column(
               modifier = Modifier.padding(15.dp)
           ) {
               Text(
                   text = "Daily Notes",
                   style = TextStyle(
                       color = TextColor,
                       fontSize = 24.sp,
                       fontWeight = FontWeight.Bold
                   )
               )
               Text(text = "V1.0.0")
           }

           Divider(thickness = 1.dp, color = TextColor)
            ListButton(
                onClick = { /*TODO*/ },
                text = "Forgot Password"
            )
           ListButton(
               onClick = { /*TODO*/ },
               text = "Privacy Policy"
           )
           ListButton(
               onClick = { /*TODO*/ },
               text = "Terms of use"
           )

       }
    }
}

@Composable
fun ListButton(
    onClick : ()-> Unit,
    text: String
){
    TextButton(
        modifier = Modifier.width(250.dp),
        shape = RoundedCornerShape(0.dp),
        contentPadding = ButtonDefaults.ContentPadding,
        onClick = { /*TODO*/ }

    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart // Aligns the text to the start
        ) {
            Text(text = text, style = TextStyle(color = TextColor, fontSize = 14.sp, fontWeight = FontWeight.Bold))
        }
    }
}
