package com.example.habit_tracker

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.InputFieldColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.example.habit_tracker.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  SignUpScreen() {
    var isPasswordVisible = remember { mutableStateOf(false) }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text("Create account")},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = BackgroundColor
                    ),
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            content = {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = PrimaryColor
                                )
                            }
                        )
                    }
                )
            },

            content = {it ->
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(BackgroundColor),
                ) {
                   Column(
                       modifier = Modifier.fillMaxHeight()
                           .padding(15.dp)
                           .verticalScroll(rememberScrollState()),
                       horizontalAlignment = Alignment.Start,
                       verticalArrangement = Arrangement.SpaceAround
                   ) {
                       Column (
                           horizontalAlignment = Alignment.Start,
                           verticalArrangement = Arrangement.SpaceAround
                       ){
                           Text(text = "Let’s get to know you !",
                               style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp)
                           )
                           Text(text = "Enter your details to continue")
                       }
                       CustomInputField(
                           value = "Display Name",
                           onValueChange = {},
                           prefixIcon = Icons.Filled.Person,
                           hasSuffix = false
                       )
                       CustomInputField(
                           value = "Email Address",
                           onValueChange = {},
                           prefixIcon = Icons.Filled.Email,
                           hasSuffix = false
                       )
                       CustomInputField(
                           value = "Password",
                           onValueChange = {},
                           prefixIcon = Icons.Filled.Lock,
                           hasSuffix = true,
                           onClick = {
                               isPasswordVisible.value = !isPasswordVisible.value
                           },
                           suffixIcon = painterResource(id = if(isPasswordVisible.value) R.drawable.visibility else R.drawable.visibility_off)
                       )
                       CustomInputField(
                           value = "Confirm Password",
                           onValueChange = {},
                           prefixIcon = Icons.Filled.Lock,
                           hasSuffix = false
                       )
                       Column {
                           Text(text = "Already have an account?")
                           ClickableText(
                               text = AnnotatedString("Login here"),
                               style = TextStyle(
                                   color = PrimaryColor,
                                   fontSize = 18.sp,
                                   textDecoration = TextDecoration.Underline
                               ),
                               onClick = { offset ->
                                   Log.i("debug", "SignUpScreen:")
                               }
                           )
                       }
                       CustomClickableText()
                       CustomButton(
                           buttonName = "Create Account",
                           color = PrimaryColor,
                           textColor = SecondaryColor
                       ) {

                       }
                   }
                }
            },
        )
    }
}

@Composable
fun CustomClickableText() {
    val tnc = "Terms of use"
    val privacyPolicy = "Privacy policy"
    val annotatedString = buildAnnotatedString {
        append("By clicking the “CREATE ACCOUNT” button, you agree to ",)
        withStyle(style = SpanStyle(color = PrimaryColor), ) {
            pushStringAnnotation(tag = tnc, annotation = tnc)
            append(tnc)
        }
        append(" and ")
        withStyle(style = SpanStyle(color = PrimaryColor), ) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.let { span ->
                println("Clicked on ${span.item}")
            }
        }
    )
}


@Composable
fun CustomInputField(
    value: String, onValueChange: (String) -> Unit, prefixIcon: ImageVector,
    suffixIcon: Painter? = null, hasSuffix: Boolean, onClick: () -> Unit = {}
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = prefixIcon,
                contentDescription ="",
                tint = PrimaryColor
            )
        },
        trailingIcon = {
            if(hasSuffix && suffixIcon!= null)
              IconButton(onClick = onClick) {
                  Image(painter = suffixIcon, contentDescription ="" )
              }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = TextColor,
            unfocusedBorderColor = InputFieldColor
        ),
    )
}

