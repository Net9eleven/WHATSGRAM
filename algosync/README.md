# WhatsApp + Instagram (Android + Backend Setup)

This bundle includes:
- Android Studio project (Kotlin + Jetpack Compose + Hilt + Room + WorkManager)
- Supabase integration (Auth, PostgREST, Storage, Realtime)
- Signal store scaffolding
- SQL migrations (+ RLS policies)
- Docker Compose for LiveKit (WebRTC SFU) and coturn

## Quickstart (Android)
1. Open in Android Studio.
2. Edit `app/src/main/java/com/yourorg/app/data/remote/SupabaseClientProvider.kt` with your URL & anon key.
3. Build & run on emulator/device (API 33+).

## Quickstart (Supabase)
1. In Supabase SQL editor, run `backend/sql/001_initial_schema.sql` then `backend/sql/002_rls_policies.sql`.
2. Create **Storage** buckets: `private` (no public access) and `public` (optional) for posts.
3. Under Auth → Settings, enable Email auth. Optionally configure 2FA.

## Notes
- Libsignal wiring is scaffolded; complete it before production.
- Do not embed service_role keys in the client.
