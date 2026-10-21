package com.zerocore.zerochat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(loading: Boolean, message: String, onFacebookLogin: () -> Unit, onGoogleLogin: () -> Unit) {
    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFF0B211B), Color(0xFF07110F), Color(0xFF050A09)))).padding(28.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            androidx.compose.foundation.Image(painter = painterResource(R.drawable.zerochat_logo), contentDescription = "شعار ZeroChat", modifier = Modifier.size(190.dp))
            Spacer(Modifier.height(14.dp)); Text("ZERO CHAT", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            Spacer(Modifier.height(10.dp)); Text("رسائل مشفّرة بينك وبين من تختار", fontSize = 16.sp, color = Color(0xFF8CE8C8), textAlign = TextAlign.Center)
            Spacer(Modifier.height(30.dp))
            Button(onClick = onFacebookLogin, enabled = !loading, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) { if (loading) CircularProgressIndicator(Modifier.size(20.dp), strokeWidth = 2.dp) else Text("المتابعة باستخدام فيسبوك", fontSize = 16.sp, fontWeight = FontWeight.Bold) }
            Spacer(Modifier.height(12.dp))
            OutlinedButton(onClick = onGoogleLogin, enabled = !loading, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) { if (loading) CircularProgressIndicator(Modifier.size(20.dp), strokeWidth = 2.dp) else Text("المتابعة باستخدام Google / Gmail", fontSize = 16.sp, fontWeight = FontWeight.Bold) }
            if (message.isNotBlank()) { Spacer(Modifier.height(18.dp)); Text(message, color = MaterialTheme.colorScheme.secondary, textAlign = TextAlign.Center) }
            Spacer(Modifier.height(28.dp)); Text("تُشفّر الرسائل قبل إرسالها إلى قاعدة البيانات", color = Color(0xFF7E958C), fontSize = 12.sp)
        }
    }
}
