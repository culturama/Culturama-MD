package com.example.culturama.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun ConfirmResetPasswordScreen(navController: NavHostController, email: String) {
    var confirmationCode by remember { mutableStateOf(TextFieldValue()) }

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
                text = "Konfirmasi Reset Password",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Langkah terakhir! Untuk mengamankan akun Anda, masukkan kode yang baru saja kami kirimkan ke $email",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Kode Konfirmasi") },
                value = confirmationCode,
                onValueChange = { confirmationCode = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Implementasi logika konfirmasi reset password di sini
                    // Validasi kode konfirmasi, dan lakukan tindakan sesuai
                    // Misalnya, tampilkan pesan sukses atau arahkan pengguna ke halaman login
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Konfirmasi")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ConfirmResetPasswordScreenPreview() {
    CulturamaTheme {
        Surface {
            ConfirmResetPasswordScreen(navController = rememberNavController(), email = "user@example.com")
        }
    }
}