# 📱 WhatsApp-Instagram Clone (Kotlin + Supabase)

A modern **social + messaging hybrid app** that combines the **real-time encrypted chat of WhatsApp** with the **social feed and stories of Instagram**.

Built with:  
- **Frontend**: Android (Kotlin, Jetpack Compose, MVVM, Hilt)  
- **Backend**: Supabase (Auth, Postgres, Storage, Realtime, RLS)  

---

## ✨ Features

### 🔒 Messaging (WhatsApp-like)
- Real-time 1:1 and group chat  
- Voice & video calls (LiveKit ready)  
- Media sharing (images, videos, audio, docs)  
- Message status: sent ✅, delivered ✅, seen ✅  
- Disappearing messages  
- End-to-end encryption (Signal Protocol planned)  

### 📸 Social Feed (Instagram-like)
- User profiles (bio + profile photo)  
- Posts with captions, likes & comments  
- 24-hour disappearing stories  
- Explore page for public content discovery  
- Follow/unfollow system  

### 🔐 Security & Privacy
- Supabase Auth (email/password, 2FA support)  
- Row-Level Security (RLS) for per-user data protection  
- HTTPS-only communication  
- Block & report users  

### ⚡ Performance
- Supabase real-time subscriptions for instant updates  
- Optimized media handling with caching  
- Offline-first sync with Room + WorkManager  

---

## 🛠️ Project Structure
whatsapp_instagram_final/
├── app/ # Android app source
│ ├── data/ # Repositories (Auth, Message, Post, Story, Follow)
│ ├── ui/ # Jetpack Compose screens
│ ├── di/ # Hilt modules (Supabase, Repos)
│ └── MainActivity.kt
├── backend/ # Supabase schema + RLS policies
│ ├── sql/ # SQL migrations
│ └── docker/ # LiveKit + TURN server configs
└── README.md

---

## 🚀 Getting Started

1. Clone this repo and open in **Android Studio**.  
2. Replace `YOUR_PROJECT_ID` and `YOUR_ANON_KEY` in `SupabaseModule.kt`.  
3. Run `backend/sql/*.sql` in your Supabase project.  
4. Build & run on emulator or device (API 33+).  

---

## 📌 Roadmap
- [ ] Full Signal Protocol encryption  
- [ ] Push notifications (Firebase)  
- [ ] Video filters & story effects  
- [ ] Deployment-ready Docker backend  

---

⚡ *This is an educational open-source project showing how to build a modern mobile app using Kotlin + Supabase.*  


