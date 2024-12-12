/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.blannon_network.wearosui.presentation

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Stepper
import androidx.wear.compose.material.StepperDefaults
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import androidx.wear.compose.material.ToggleChipDefaults
import androidx.wear.protolayout.material.CircularProgressIndicator
import androidx.wear.tooling.preview.devices.WearDevices
import com.blannon_network.wearosui.R
import com.blannon_network.wearosui.presentation.theme.MiniAppsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearApp("Android")
        }
    }
}

@Composable
fun WearApp(greetingName: String) {
    MiniAppsCatalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
//            TimeText()
//            Greeting(greetingName = greetingName)
            BtnSample()
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}


@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true, name = "Button_Sample")
@Composable
fun BtnSample() {
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row (
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {

                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Decline"
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Decline"
                )
            }
        }

    }
}

@Preview(device = WearDevices.SQUARE, showSystemUi = true, name = "Chip_Sample")
@Composable
fun ChipSample() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Chip(
            onClick = {},
            enabled = true,
            label = {
                Text(
                    text = "Blannon Network",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            secondaryLabel = {
                Text(
                    text = "Call",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },

            icon = {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = null,
                    Modifier
                        .size(ChipDefaults.IconSize)
                        .wrapContentSize(align = Alignment.Center)
                        .align(Alignment.Center)
                )
            },
            colors = ChipDefaults.imageBackgroundChipColors(
                backgroundImagePainter = painterResource(id = R.drawable.img)

            )
        )
    }
}

@Preview(device = WearDevices.RECT, showSystemUi = true, name = "Toggle_ChipSample")
@Composable
fun ToggleChipSample(){
    var checked by remember {
        mutableStateOf(true)
    }

    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ToggleChip(
            label = {
                Text(
                    "Blannon",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            secondaryLabel = {
                Text(
                    "Jetpack",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            checked = checked,
            colors = ToggleChipDefaults.toggleChipColors(
                uncheckedToggleControlColor = ToggleChipDefaults.SwitchUncheckedIconColor
            ),
            toggleControl = {
                Switch(
                    checked = checked,
                    enabled = true,
                    modifier = Modifier.semantics {
                        this.contentDescription =
                            if (checked) "On" else "Off"
                    }
                )
            },
            onCheckedChange = {
                checked = it
            },
            appIcon = {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = null,
                    Modifier
                        .size(24.dp)
                        .wrapContentSize(align = Alignment.Center)
                )
            },
            enabled = true
        )
    }

}

@Preview(showBackground = true, showSystemUi = true, device = WearDevices.RECT, name = "InlineSlider_Sample")
@Composable
fun InlineSlider_Sample(){
    var value by remember {
        mutableFloatStateOf(2.5f)
    }
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        InlineSlider(
            value = value,
            onValueChange = { value = it},
            increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease")},
            valueRange = 2f..6f,
            steps = 5,
            segmented = true
        )
    }
}

@Preview(showBackground = true, device = WearDevices.SMALL_ROUND, showSystemUi = true, name = "Stepper_Sample")
@Composable
fun StepperSample(){
    var value by remember {
        mutableStateOf(5)
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Stepper(
            value = value,
            onValueChange = {value = it},
            increaseIcon = {
                Icon(
                    StepperDefaults.Increase,"Increase"
                )},
            decreaseIcon = {
                Icon(StepperDefaults.Decrease, "Decrease")
            },
            valueProgression = 0..100
        ) {
            Text("Value: $value")
        }
    }
}

@Preview(showBackground = true, device = WearDevices.SQUARE, name = "Card_Sample")
@Composable
fun CardSample() {
    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Card(
            onClick = {},
            Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            contentColor = Color.Yellow,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column (
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(R.drawable.img),
                    "",
                    Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                )
                Text(
                    "Blannon Network",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



