package com.my.test.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.my.test.ui.presentation.providers.FindProviderScreen
import com.my.test.ui.theme.Grey
import com.my.test.ui.theme.LightGrey
import com.my.test.ui.theme.MyTheme
import com.my.test.ui.theme.SourceSansPro
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                AppLayout()
            }
        }
    }
}

@Composable
fun AppLayout() {
    Scaffold(
        topBar = { AppTopBar() },
        backgroundColor = LightGrey,
    ) {
        FindProviderScreen()
    }
}

@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Find a provider",
                fontFamily = SourceSansPro,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = Color.White,
        contentColor = Grey,
    )
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    Scaffold(
        topBar = { AppTopBar() },
        backgroundColor = LightGrey,
    ) {
    }
}
