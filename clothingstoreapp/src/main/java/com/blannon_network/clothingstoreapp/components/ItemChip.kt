package com.blannon_network.clothingstoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.blannon_network.clothingstoreapp.R

@Composable
fun Chip(
    text: String,
    isHighlighted: Boolean = false,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = colorResource(id = R.color.color2)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isHighlighted) Color(0xFFA52A2A) else Color.Black,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
@Composable
fun ChipsRow(
    chipsTexts: List<String>
) {
    if (chipsTexts.size != 5) {
        throw IllegalArgumentException("ChipsRow requires exactly 4 chip texts")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        chipsTexts.forEachIndexed { index, text ->
            Chip(
                text = text,
                isHighlighted = (index == 1),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

