@file:OptIn(ExperimentalAnimationApi::class)

package com.example.composebasics.ui.theme

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationExampleScreen() {
    //VisibilityExample()
    //InfiniteAnimationExample()
    AnimateContent()
}

@Composable
fun VisibilityExample() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(
            visible = isVisible,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            Box(modifier = Modifier.background(Color.Red))
        }

    }
}

@Composable
fun AnimateAnyExample() {
    var isRounded by remember {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isRounded = !isRounded }) {
            Text(text = "Toggle")
        }
        val borderRadius by animateIntAsState(
            targetValue = if (isRounded) 100 else 0,
            animationSpec = tween(durationMillis = 2000)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(Color.Red)
        )

    }
}

@Composable
fun AnimateMultipleValuesExample() {
    var isRounded by remember {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isRounded = !isRounded }) {
            Text(text = "Toggle")
        }
        val borderRadius by animateIntAsState(
            targetValue = if (isRounded) 100 else 0,
            animationSpec = tween(durationMillis = 2000)
        )
        val backgroundColor by animateColorAsState(
            targetValue = if (isRounded) Color.Red else Color.Green,
            animationSpec = tween(durationMillis = 2000)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(backgroundColor)
        )

    }
}

@Composable
fun InfiniteAnimationExample() {
    val transition = rememberInfiniteTransition()
    val color by transition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color)
    )
}

@Composable
fun AnimateContent() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }

        AnimatedContent(
            targetState = 100,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            content = {value->
                if (value == 50)
                    Box(modifier = Modifier.background(Color.Red))
                else
                    Box(modifier = Modifier.background(Color.Green))

            }
        )

    }
}