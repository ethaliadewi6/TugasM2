package com.tifd.tugasm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tifd.tugasm2.ui.theme.TugasM2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasM2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var text by remember { mutableStateOf("") }
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            color = Color(0xFF4682B4),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color(0xFF4682B4))
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Search", color = Color(0xFF4682B4)) },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(0xFF4682B4),
                unfocusedTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                cursorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { text = inputText },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF87CEEB), Color(0xFF4682B4))
                    ),
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text("Cari", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TugasM2Theme {
        MyScreen()
    }
}
