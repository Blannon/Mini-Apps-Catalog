package com.blannon_network.otp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.blannon_network.otp.ui.theme.MiniAppsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniAppsCatalogTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black
                ) { innerPadding ->

                    val viewModel = viewModel<OtpViewModel>()
                    val  state by viewModel.state.collectAsStateWithLifecycle()
                    val focusRequesters = remember {
                        List(4) { FocusRequester()}
                    }

                    val focusManager = LocalFocusManager.current
                    val keyBoardManager = LocalSoftwareKeyboardController.current

                    LaunchedEffect(state.isFocusedIndex) {
                        state.isFocusedIndex?.let { index ->
                            focusRequesters.getOrNull(index)?.requestFocus()
                        }
                    }

                    LaunchedEffect(state.code, keyBoardManager) {
                        val EnteredAllNumbers = state.code.none {it == null}

                        if (EnteredAllNumbers){
                            focusRequesters.forEach{
                                it.freeFocus()
                            }
                            focusManager.clearFocus()
                            keyBoardManager?.hide()
                        }
                    }
                   OtpScreen(
                       state = state,
                       focusRequesters,
                       onAction = {action ->
                           when(action){
                               is OtpAction.OnEnterNumber -> {
                                   if (action.number != null){
                                       focusRequesters[action.index].freeFocus()
                                   }
                               }else -> Unit
                           }
                           viewModel.onAction(action)
                       },
                       modifier = Modifier
                           .padding(innerPadding)
                           .consumeWindowInsets(innerPadding)

                   )
                }
            }
        }
    }
}
