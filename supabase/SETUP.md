# ZeroChat Supabase setup

ZeroChat uses Supabase Auth, Postgres and Realtime. Review `setup.sql` and the focused migration files before applying them to the intended project.

## OAuth providers

Enable Google and Facebook under Supabase Dashboard → Authentication → Sign In / Providers. Configure each provider's OAuth credentials in the dashboard; do not put provider client secrets in Android source code.

Supabase OAuth callback URL:

`https://YOUR_PROJECT_REF.supabase.co/auth/v1/callback`

Allow the Android callback `zerochat://login-callback` under Authentication → URL Configuration → Redirect URLs.

## Realtime

The app listens for new rows in `public.messages`. Add the table to the `supabase_realtime` publication and verify row-level security restricts results to participants in each conversation. Realtime notifications only work while the app is running and connected; reliable background push needs a separate push delivery service.

## Encryption limitations

Private device keys must remain local and must never be committed. The current design uses per-installation keys; losing app data or changing devices may prevent access to older messages. This release does not provide forward secrecy or multi-device key synchronization.

## Account deletion

The app uses an authenticated self-service deletion RPC. Host `docs/delete-account.html` and `docs/privacy-policy.html` on HTTPS before release, then configure their URLs in Supabase and the Play Console. Verify the SQL deletion behavior against a non-production environment before applying it to a live project.
