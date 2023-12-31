package com.example.culturama.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }

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
                text = "Reset Password",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                value = email,
                onValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Implementasi logika reset password di sini
                    // Kirim permintaan reset password ke email pengguna
                    // Tambahkan logika untuk menangani respons atau error dari server/email provider
                    // Anda dapat menggunakan library untuk mengirim email atau API reset password
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Reset Password")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ResetPasswordScreenPreview() {
    CulturamaTheme {
        Surface {
            ResetPasswordScreen(navController = rememberNavController())
        }
    }
}