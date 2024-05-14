package com.example.habit_tracker
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Column {
        Text(text = "Welcome to")
        Text(text = "Daily Notes")
        Image(
            painter = painterResource(id = R.drawable.onboard_1),
            contentDescription = "Onboarding"
        )
        CustomButton(
            onClick = {},
            buttonName = "CREATE ACCOUNT"
        )
        CustomButton(
            onClick = {},
            buttonName = "LOG IN"
        )

    }
}

@Composable
fun CustomButton(buttonName: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    )
    {
        Text(
            text = buttonName,
            color = Color.Blue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}