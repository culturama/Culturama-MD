package com.example.culturama.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.theme.CulturamaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavHostController) {
    // Variabel untuk menyimpan email dan password
    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sign Up",
                style = TextStyle(fontSize = 40.sp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                value = email.value,
                onValueChange = { email.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)
            ) {
                // Tombol Sign Up dengan logika pendaftaran sederhana
                Button(
                    onClick = {
                        // Logika pendaftaran: tambahkan kode untuk menyimpan email dan password ke server atau penyimpanan lokal
                        val enteredEmail = email.value.text
                        val enteredPassword = password.value.text

                        // Tambahkan logika pendaftaran sesuai kebutuhan Anda
                        // Misalnya, validasi email, password, dan panggilan API pendaftaran
                        if (isValidSignUp(enteredEmail, enteredPassword)) {
                            // Jika pendaftaran berhasil, mungkin navigasikan pengguna ke layar lain
                            // atau tampilkan pesan berhasil
                            // Contoh:
                            // navController.navigate(/* destination */)
                        } else {
                            // Jika pendaftaran gagal, tampilkan pesan kesalahan atau ambil tindakan yang sesuai
                            // Contoh:
                            // showMessage("Pendaftaran gagal. Silakan coba lagi.")
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Sign Up")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            ClickableText(
                text = AnnotatedString("Already have an account? Log in"),
                onClick = {
                    navController.navigate("Login")
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
        }
    }
}

// Fungsi untuk validasi pendaftaran
fun isValidSignUp(email: String, password: String): Boolean {
    // Implementasikan logika validasi pendaftaran sesuai kebutuhan Anda
    // Misalnya, periksa apakah email valid dan password memenuhi persyaratan tertentu
    return email.isNotBlank() && password.length >= 6
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    CulturamaTheme {
        Surface {
            SignUp(navController = rememberNavController())
        }
    }
}