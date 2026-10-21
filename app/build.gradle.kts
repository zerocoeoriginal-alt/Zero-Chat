plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

val zeroChatReleaseStoreFile = providers.gradleProperty("ZEROCHAT_RELEASE_STORE_FILE").orNull
val zeroChatReleaseStorePassword = providers.gradleProperty("ZEROCHAT_RELEASE_STORE_PASSWORD").orNull
val zeroChatReleaseKeyAlias = providers.gradleProperty("ZEROCHAT_RELEASE_KEY_ALIAS").orNull
val zeroChatReleaseKeyPassword = providers.gradleProperty("ZEROCHAT_RELEASE_KEY_PASSWORD").orNull
val zeroChatReleaseSigningReady = listOf(zeroChatReleaseStoreFile, zeroChatReleaseStorePassword, zeroChatReleaseKeyAlias, zeroChatReleaseKeyPassword).all { !it.isNullOrBlank() }

android {
    namespace = "com.zerocore.zerochat"
    compileSdk { version = release(37) }
    defaultConfig {
        applicationId = "com.zerocore.zerochat"
        minSdk = 26
        targetSdk = 37
        versionCode = 3
        versionName = "1.0.2"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs {
        if (zeroChatReleaseSigningReady) {
            create("release") {
                storeFile = file(zeroChatReleaseStoreFile!!)
                storePassword = zeroChatReleaseStorePassword
                keyAlias = zeroChatReleaseKeyAlias
                keyPassword = zeroChatReleaseKeyPassword
            }
        }
    }
    buildTypes {
        release {
            if (zeroChatReleaseSigningReady) signingConfig = signingConfigs.getByName("release")
            optimization { enable = false }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures { compose = true }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(platform("io.github.jan-tennert.supabase:bom:3.5.0"))
    implementation("io.github.jan-tennert.supabase:auth-kt")
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:realtime-kt")
    implementation("io.ktor:ktor-client-android:3.0.3")
}
