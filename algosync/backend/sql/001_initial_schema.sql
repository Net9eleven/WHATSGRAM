create extension if not exists "pgcrypto";

create table if not exists profiles (
  id uuid primary key references auth.users(id) on delete cascade,
  username text unique not null,
  display_name text,
  bio text,
  avatar_url text,
  created_at timestamptz default now(),
  privacy_settings jsonb default '{}'
);

create table if not exists chats (
  id uuid primary key default gen_random_uuid(),
  is_group boolean default false,
  title text,
  owner_id uuid references profiles(id),
  created_at timestamptz default now(),
  last_message_id uuid
);

create table if not exists chat_members (
  chat_id uuid references chats(id) on delete cascade,
  user_id uuid references profiles(id) on delete cascade,
  role text default 'member',
  joined_at timestamptz default now(),
  primary key (chat_id, user_id)
);

create table if not exists messages (
  id uuid primary key default gen_random_uuid(),
  chat_id uuid references chats(id) on delete cascade,
  sender_id uuid references profiles(id) not null,
  ciphertext bytea not null,
  content_type text,
  media_path text,
  media_meta jsonb default '{}',
  status jsonb default '{}',
  created_at timestamptz default now(),
  expires_at timestamptz,
  edited boolean default false,
  deleted boolean default false
);

create table if not exists user_keys (
  user_id uuid primary key references profiles(id) on delete cascade,
  registration_id int not null,
  identity_key text not null,
  signed_prekey text not null,
  signed_prekey_signature text not null,
  prekeys jsonb not null default '[]'::jsonb,
  updated_at timestamptz default now()
);

create table if not exists posts (
  id uuid primary key default gen_random_uuid(),
  author_id uuid references profiles(id) not null,
  caption text,
  media_paths text[],
  visibility text default 'public',
  created_at timestamptz default now(),
  like_count int default 0,
  comment_count int default 0
);

create table if not exists stories (
  id uuid primary key default gen_random_uuid(),
  author_id uuid references profiles(id) not null,
  media_path text not null,
  created_at timestamptz default now(),
  expires_at timestamptz not null,
  viewers jsonb default '[]'
);

create table if not exists follows (
  follower_id uuid references profiles(id),
  followee_id uuid references profiles(id),
  created_at timestamptz default now(),
  primary key (follower_id, followee_id)
);

create table if not exists blocks (
  user_id uuid references profiles(id),
  blocked_user_id uuid references profiles(id),
  created_at timestamptz default now(),
  primary key (user_id, blocked_user_id)
);
