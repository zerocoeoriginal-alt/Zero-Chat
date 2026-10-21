# ZeroChat

ZeroChat is an Android direct-messaging app built with Kotlin, Jetpack Compose, and Supabase Auth/Postgres/Realtime. The app includes Google/Facebook sign-in, public usernames, direct conversations, message encryption utilities, local notifications, profile management, and account-deletion support.

## Repository layout

- `app/` — Android application source and resources.
- `supabase/` — schema setup and SQL migrations.
- `docs/` — privacy policy, account deletion page, and Play Store release checklist.
- `gradle/` — Gradle version catalog and wrapper configuration.

## Local setup

1. Install a compatible JDK and Android SDK.
2. Open the project in Android Studio or build it with Gradle after installing the required Android SDK platform.
3. Configure Google/Facebook OAuth providers in the Supabase dashboard. Do not place OAuth client secrets in the Android source.
4. Review `supabase/SETUP.md` and apply the SQL files to the intended Supabase project.
5. Keep `local.properties`, signing keystores, signing passwords, and other private local configuration out of Git.

The repository does not include generated Gradle/Android build caches or local SDK configuration. Review `docs/PLAY_STORE_RELEASE.md` and the security limitations in `supabase/SETUP.md` before release.
