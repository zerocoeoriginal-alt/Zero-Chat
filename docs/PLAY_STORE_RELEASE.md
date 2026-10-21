# ZeroChat — Google Play release checklist

## Project details
- Application ID: `com.zerocore.zerochat`
- Current version is defined in `app/build.gradle.kts`.
- OAuth: Google and Facebook through Supabase Auth.
- Account deletion page: `docs/delete-account.html`.
- Privacy policy draft: `docs/privacy-policy.html`.

## Before publishing
1. Host the privacy policy and account-deletion page on public HTTPS URLs.
2. Add the URLs to Supabase Authentication redirect configuration and Google Play Console.
3. Complete Data safety, store listing, support contact, content rating and reviewer access information.
4. Verify OAuth provider configuration in the Supabase dashboard.
5. Store release signing keys and passwords securely outside the repository. Never commit keystores, credentials or local SDK paths.
6. Test account deletion, sign-in, message delivery, and behavior after losing local app data.

## Known limitations to disclose
- Realtime-only notifications require the app to be running and connected; background push delivery is not configured here.
- Per-installation encryption keys are not synchronized across devices. Losing local key material may make historical messages unreadable.
- This release does not provide forward secrecy.
