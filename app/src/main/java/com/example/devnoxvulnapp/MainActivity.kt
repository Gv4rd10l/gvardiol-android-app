package com.example.devnoxvulnapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import com.example.devnoxvulnapp.ui.theme.DevNoxVulnAppTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.material3.NavigationBarDefaults.containerColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val url = intent?.getStringExtra("url")

        if (url != null && url.startsWith("https://")) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
            finish()
            return
        }
        setContent {
            DevNoxVulnAppTheme {
                Scaffold(modifier = Modifier
                    .padding(bottom = 50.dp)
                    //.fillMaxSize()
                    .background(Color(0xFF232323)),
                    bottomBar = {
                        BottomNavigation (
                            backgroundColor = Color(0xFF000000),
                            contentColor = Color.White
                        ) {
                            BottomNavigationItem(
                                icon = { Icon(Icons.Default.Person, contentDescription = "person") },
                                selected = true,
                                onClick = { /* TODO: handle navigation */ }
                            )
                            BottomNavigationItem(
                                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                                selected = true,
                                onClick = { /* TODO: handle navigation */ }
                            )
                            BottomNavigationItem(
                                icon = { Icon(Icons.Default.Settings, contentDescription = "settings") },
                                selected = true,
                                onClick = { /* TODO: handle navigation */ }
                            )
                        }
                    }
                ) { innerPadding ->
                    welcome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun welcome(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize()
            .clip(RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Welcome to DevNox Vulnerable Bank Application",
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Serif,
                color = Color(0xFF035DE2),
                textAlign = TextAlign.Center
            )
        )
        Image(
            painter = painterResource(R.drawable.devnoxlog),
            contentDescription = "Logo DevNox",
            Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
           text = "DevNox VulnBank is an amazing bank application develop to help you in building your Android Application Penetration Testing skills",
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = Serif,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        var textname by remember { mutableStateOf("") }
        TextField(
            value = textname,
            onValueChange = { textname = it },
            //backgroundColor = Color.White,
            placeholder = { Text(
                "Enter your name",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = Serif,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            ) },
            modifier = Modifier
                .background(Color.Transparent)
                .clip(RoundedCornerShape(15.dp))
                .height(height = 40.dp)
                .width(width = 350.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        var textpass by remember { mutableStateOf("") }
        TextField(
            value = textpass,
            onValueChange = { textpass = it },
            placeholder = { Text(
                "Enter your password",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = Serif,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            ) },
            modifier = Modifier
                .background(Color.Transparent)
                .clip(RoundedCornerShape(15.dp))
                .height(height = 40.dp)
                .width(width = 350.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .height(height = 40.dp)
            .width(width = 350.dp)
        ) {
            Text(text = "Login")
        }
    }
}
