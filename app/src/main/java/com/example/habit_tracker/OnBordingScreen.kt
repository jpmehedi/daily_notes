package com.example.habit_tracker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.example.habit_tracker.ui.theme.TextColor


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
          Text(text = "Welcome to", style = TextStyle(color = TextColor, fontSize = 24.sp, fontWeight = FontWeight.Bold))
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = "Daily Notes", style = TextStyle(color = TextColor))
        }
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.onboard_1),
            contentDescription = "Onboarding"
        )
        OnboardingIndicator (totalPages = 3, currentPage = 1)
        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(
            onClick = {},
            buttonName = "CREATE ACCOUNT",
            color = PrimaryColor,
            textColor = SecondaryColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            onClick = {},
            buttonName = "LOG IN",
            color = SecondaryColor,
            textColor = PrimaryColor
        )
    }
}

@Composable
fun OnboardingIndicator(totalPages: Int, currentPage: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in 0 until totalPages) {
            val color = if (i == currentPage) Color.Black else Color.Gray
            val shape = if (i == currentPage) CircleShape else RoundedCornerShape(ZeroCornerSize)
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color, shape)
            )
        }
    }
}
@Composable
fun CustomButton(buttonName: String,color: Color, textColor: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    )
    {
        Text(
            text = buttonName,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}