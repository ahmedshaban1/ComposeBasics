package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.ListScreen
import com.example.composebasics.ui.theme.AnimationExampleScreen
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import com.example.composebasics.ui.theme.Purple200
import com.example.composebasics.ui.theme.mvvm.navigation.MyAppNavHost
import com.example.composebasics.ui.theme.mvvm.presentation.NotesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                //ListScreen()
               // MyAppNavHost()
                AnimationExampleScreen()
            }
        }
    }
}

@Composable
fun SayHi() {
    Text(
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.Red), text = "test",
         style = MaterialTheme.typography.body1
    )
}

@Composable
fun List() {
    Row(Modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween) {
        SayHi()
        SayHi()
        SayHi()
        SayHi()
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSayhI() {
    ComposeBasicsTheme {
        ClickMe()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeBasicsTheme {
//        Text(text = "Hello")
//    }
//}
//@Composable
//fun HomeScreen() {
//    Scaffold { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(10.dp)
//                .fillMaxSize(),
//
//            ) {
//            Greeting(name = "Truecaller")
//            ClickMe()
//            Image(
//                modifier = Modifier.fillMaxSize(.4f),
//                painter = painterResource(id = R.drawable.ic_launcher_background),
//                contentDescription = "",
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String) {
//    Text(
//        text = "Hello $name!",
//        style = TextStyle(
//            color = Purple200,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
//    )
//}
//
@Composable
fun ClickMe() {
    Image(
        modifier = Modifier.fillMaxSize(.4f),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeBasicsTheme {
//        //HomeScreen()
//    }
//}