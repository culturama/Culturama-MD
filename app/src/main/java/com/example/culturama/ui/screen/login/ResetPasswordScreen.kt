package com.example.culturama.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun ResetPasswordScreen(navController: NavController) {
    var newPassword by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var isPasswordMatch by remember { mutableStateOf(false) }
    var showMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "RESET PASSWORD",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            value = newPassword.text,
            onValueChange = { newPassword = TextFieldValue(it) },
            label = { Text(text = "New Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            value = confirmPassword.text,
            onValueChange = {
                confirmPassword = TextFieldValue(it)
                isPasswordMatch = newPassword.text == it
            },
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            isError = !isPasswordMatch
        )

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedButton(
            onClick = {
                if (isPasswordMatch) {
                    showMessage = "Password berhasil diubah"
                } else {
                    showMessage = "Password tidak sama"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Submit")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        showMessage?.let { message ->
            Text(
                text = message,
                color = if (isPasswordMatch) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ResetPasswordScreenPreview() {
    CulturamaTheme {
        ResetPasswordScreen(navController = rememberNavController())
    }
}
