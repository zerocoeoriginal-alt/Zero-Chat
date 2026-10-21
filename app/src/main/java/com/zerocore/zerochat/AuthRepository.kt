package com.zerocore.zerochat

import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.Facebook
import io.github.jan.supabase.auth.providers.Google
import io.github.jan.supabase.auth.status.SessionStatus
import kotlinx.coroutines.flow.first

class AuthRepository {
    private val auth = SupabaseManager.client.auth
    suspend fun signInWithFacebook() { auth.signInWith(Facebook) }
    suspend fun signInWithGoogle() { auth.signInWith(Google) }
    suspend fun signOut() { auth.signOut() }
    suspend fun waitForStoredSession() { auth.sessionStatus.first { it !is SessionStatus.Initializing } }
    fun currentUserId(): String? = auth.currentSessionOrNull()?.user?.id
}
