package com.zerocore.zerochat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun UsernameSetupScreen(loading: Boolean, message: String, onUsernameChanged: () -> Unit, onSaveUsername: (String) -> Unit) {
    var username by rememberSaveable { mutableStateOf("") }
    val normalizedUsername = username.trim().lowercase(Locale.ROOT)
    val validUsername = Regex("^[a-z0-9_.]{3,24}$").matches(normalizedUsername)
    Column(Modifier.fillMaxSize().background(Color(0xFF07110F)).padding(28.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("اختار اسم المستخدم", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(Modifier.height(12.dp)); Text("الاسم ده هيظهر في بروفايلك ويساعد أصحابك يلاقوك.", color = Color(0xFF9FB1AA), textAlign = TextAlign.Center)
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(value = username, onValueChange = { username = it.lowercase(Locale.ROOT); onUsernameChanged() }, modifier = Modifier.fillMaxWidth(), label = { Text("اسم المستخدم") }, prefix = { Text("@", color = Color(0xFF8CE8C8)) }, singleLine = true, enabled = !loading, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Done), keyboardActions = KeyboardActions(onDone = { if (validUsername && !loading) onSaveUsername(normalizedUsername) }), supportingText = { Text("3–24 حرفاً: a–z أو أرقام أو نقطة أو _") })
        if (message.isNotBlank()) { Spacer(Modifier.height(10.dp)); Text(message, color = MaterialTheme.colorScheme.error, textAlign = TextAlign.Center) }
        Spacer(Modifier.height(20.dp)); Button(onClick = { onSaveUsername(normalizedUsername) }, enabled = validUsername && !loading, modifier = Modifier.fillMaxWidth().height(54.dp), shape = RoundedCornerShape(16.dp)) { if (loading) CircularProgressIndicator(Modifier.size(20.dp), strokeWidth = 2.dp) else Text("حفظ والمتابعة", fontSize = 16.sp, fontWeight = FontWeight.Bold) }
    }
}
