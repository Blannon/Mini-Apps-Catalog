package com.blannon_network.clothingstoreapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blannon_network.clothingstoreapp.R

@Composable
fun OnboardingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (modifier = Modifier
            .padding(20.dp)
            .size(400.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(400.dp)
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(100.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.fashion1),
                contentDescription = "Logo",
            )


            Column(
                modifier = Modifier
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .width(250.dp)
                        .height(200.dp)
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(100.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.fashion2),
                    contentDescription = "Logo",
                )
                Image(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.fashion3),
                    contentDescription = null
                )
            }
        }
        Column {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(Color.Black)){
                        append("     The")
                    }
                    withStyle(
                        style = SpanStyle((colorResource(id = R.color.color1)))){
                        append("Fashion App")
                    }
                    withStyle(
                        style = SpanStyle(Color.Black)){
                        append("That\n Makes You Look Your Best")

                    }
                },
                style = TextStyle(
                    fontSize = 30.sp,
                ),
                modifier = Modifier.
            align(Alignment.CenterHorizontally)
            )

            Text(
                "   Define your style, redefine your world.\n   Shop the latest trends now",
                textAlign = TextAlign.Start
            )

        }

        Button(
            modifier = Modifier
                .width(350.dp)
                .height(70.dp)
                .padding(top = 20.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color1)),
            onClick = {
                navController.navigate("home")
            }
        ) {
            Text(
                "Let's Get Started",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(Color.Black)){
                    append("Already have an account?")
                }
                withStyle(
                    style = SpanStyle((colorResource(id = R.color.color1)),
                        textDecoration = TextDecoration.Underline)
                ){
                    append(" Sign In")
                } },
            modifier = Modifier
                .padding(top = 10.dp),
            fontSize = 20.sp,
            )
    }



}