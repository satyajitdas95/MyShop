package com.satyajit.myshop.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.satyajit.myshop.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashCompleted: () -> Unit) {
    val delayDuration by remember { mutableStateOf(200L) }

    LaunchedEffect(Unit) {
        delay(delayDuration)
        onSplashCompleted.invoke()
    }
    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                fontSize = 34.sp
            )
        }
    }
}


@Preview
@Composable
fun PreviewSplash() {
    SplashScreen({})
}