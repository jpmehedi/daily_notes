package com.example.habit_tracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.PurpleGrey40
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.example.habit_tracker.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            AvatarImage()
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Md Mehedi Hasan", fontWeight = FontWeight.Bold)
                Text(text = "mehedihasanin@gmail.com")
            }
        }
        Divider(thickness = 1.dp, color = PurpleGrey40)
        ListTileButton(
            painterResource = R.drawable.archive,
            title = "Archive notes",
            onClick = {}
        )
        ListTileButton(
            painterResource = R.drawable.settings,
            title = "Settings",
            onClick = {}
        )
        ListTileButton(
            painterResource = R.drawable.info,
            title = "About",
            onClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = PrimaryColor
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription ="Logout"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Logout")
            }

        }
    }
}

@Composable
fun ListTileButton(
    painterResource: Int,
    title: String = "Like",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = PrimaryColor,
            containerColor = BackgroundColor
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(0.dp),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Icon(
                painter = painterResource(id = painterResource),
                contentDescription = "Favorite",
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(24.dp),
                tint = TextColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                style = TextStyle(
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }
}

@Composable
fun AvatarImage() {
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = null,
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(PrimaryColor)
            .padding(8.dp)
    )
}