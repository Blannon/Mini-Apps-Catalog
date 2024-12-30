package com.blannon_network.clothingstoreapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.blannon_network.clothingstoreapp.R

@Composable
fun ItemCard(imageRes: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier,
    ){
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(colorResource(id = R.color.color2))
            .padding(10.dp)
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center),
            painter = painterResource(id = imageRes),
            contentDescription = null
        )
    }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall
        )
    }

}