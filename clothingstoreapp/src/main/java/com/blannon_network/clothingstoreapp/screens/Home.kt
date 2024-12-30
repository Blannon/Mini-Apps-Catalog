package com.blannon_network.clothingstoreapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.CircleNotifications
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Textsms
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blannon_network.clothingstoreapp.R
import com.blannon_network.clothingstoreapp.components.BottomNav
import com.blannon_network.clothingstoreapp.components.ChipsRow
import com.blannon_network.clothingstoreapp.components.ItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen () {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "Location",
            textAlign = TextAlign.Start
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                tint = (colorResource(id = R.color.color1)),
                contentDescription = null
            )
           Text(
               "New York, USA",
           )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                tint = (colorResource(id = R.color.color1)),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier,
                imageVector = Icons.Default.CircleNotifications,
                tint = (colorResource(id = R.color.color1)),
                contentDescription = null
            )

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(300.dp),
                value = "",
                onValueChange = {},
                label = { Text("Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            )
            Box(
                modifier = Modifier.size(50.dp)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
                    .background(colorResource(id = R.color.color1))

            ){
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center),
                    imageVector = Icons.Default.FilterList,
                    tint = (colorResource(id = R.color.white)),
                    contentDescription = null
                )
            }

        }

        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .width(350.dp)
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.color2))
        ){
            Row(
                Modifier.padding(top = 10.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    Modifier.padding(start = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        modifier =  Modifier.padding(top = 10.dp),
                        text ="New Collection",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                       modifier =  Modifier.padding(top = 10.dp),
                        text = "Discount 50% for\n the first transaction"
                    )

                    Button(
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp)
                            .padding(top = 10.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color1)),
                    ) {
                        Text(
                            "Shop Now"
                        )
                    }

                }

                Image(
                    modifier = Modifier
                        .padding(top = 17.dp, start = 10.dp),
                    painter = painterResource(R.drawable.fashion4),
                    contentDescription = null,
                )
            }

        }
        var  dotCount = 5
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top =6.dp, start = 130.dp)
        ) {

            repeat(dotCount) { index ->
                Icon(
                    imageVector = Icons.Default.Circle,
                    contentDescription = null,
                    tint = when (index) {
                        2 -> Color(0xFF6A4E23)
                        else -> Color.Gray
                    },
                    modifier = Modifier
                        .padding(4.dp)
                        .size(12.dp)
                )
            }
        }

        Row (
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Categorie",
                textAlign = TextAlign.Start
            )
            Text(
                "See All",
                textAlign = TextAlign.Start,
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ItemCard(imageRes = R.drawable.tshirt, text = "T-Shirt")
            ItemCard(imageRes = R.drawable.pants, text = "Pant")
            ItemCard(imageRes = R.drawable.dress, text = "Dress")
            ItemCard(imageRes = R.drawable.jacket, text = "Jacket")
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Flash Sale",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )
            Text(
                "Closing in 02:12 :58",
                textAlign = TextAlign.End,
            )
        }
        ChipsRow(chipsTexts = listOf("All", "Newest", "Popular", "Man", "Women"))
        Row (
            modifier = Modifier
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(start = 30.dp,end = 10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.fashion5),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(start = 20.dp,end = 10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.fashion6),
                contentDescription = null
            )
        }

        BottomNavigationBar()
    }

}
@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(colorResource(id = R.color.black)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNav(icon = Icons.Outlined.Home, label = "Home", isSelected = true)
        BottomNav(icon = Icons.Outlined.ShoppingBag, label = "Search", isSelected = false)
        BottomNav(icon = Icons.Outlined.Textsms, label = "Favorites", isSelected = false)
        BottomNav(icon = Icons.Outlined.PersonOutline, label = "Profile", isSelected = false)
    }
}