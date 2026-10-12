
package com.example.meow_cinthya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meow_cinthya.ui.theme.Meow_CinthyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Meow_CinthyaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color(0xFFB7A3E3))
                    ) {
                        Navbar()
                        MeowContent(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Navbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFF8C56D4)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Cat Story",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun MeowContent(modifier: Modifier = Modifier) {
    var tahap by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFB7A3E3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (tahap) {
            1 -> {
                Image(
                    painter = painterResource(
                        R.drawable.kucing_hamil_dan_bayangan_anak_kucing
                    ),
                    contentDescription = "Kucing hamil",
                    modifier = Modifier
                        .size(250.dp)
                        .clickable { tahap = 2 }
                )

                Text(
                    text = "Kucing ini hamil dan ingin melahirkan, klik untuk membantunya melahirkan",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(20.dp)
                )
            }

            2 -> {
                Image(
                    painter = painterResource(
                        R.drawable.anak_kucing_mengantuk_di_lavender
                    ),
                    contentDescription = "Anak kucing baru lahir",
                    modifier = Modifier
                        .size(250.dp)
                        .clickable { tahap = 3 }
                )

                Text(
                    text = "Bagus! Anaknya sudah lahir, klik kucingnya untuk memberinya susu",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(20.dp)
                )
            }

            3 -> {
                Image(
                    painter = painterResource(
                        R.drawable.anak_kucing_kawaii_di_latar_lavender
                    ),
                    contentDescription = "Anak kucing sudah besar",
                    modifier = Modifier
                        .size(250.dp)
                        .clickable { tahap = 4 }
                )

                Text(
                    text = "Wow kini anak kucing sudah besar, klik untuk membantunya mencari pasangan",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(20.dp)
                )
            }

            4 -> {
                Image(
                    painter = painterResource(
                        R.drawable.kucing_pengantin_pastel_menggemaskan
                    ),
                    contentDescription = "Kucing menikah",
                    modifier = Modifier
                        .size(250.dp)
                        .clickable { tahap = 1 }
                )

                Text(
                    text = "Yeyy! Kucing kita sudah menikah, klik untuk melanjutkan kisah cinta mereka dan memulai keluarga kecil yang baru!",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeowPreview() {
    Meow_CinthyaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFB7A3E3))
        ) {
            Navbar()
            MeowContent(
                modifier = Modifier.weight(1f)
            )
        }
    }
}
