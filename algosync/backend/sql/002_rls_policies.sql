alter table profiles enable row level security;
alter table messages enable row level security;
alter table chats enable row level security;
alter table chat_members enable row level security;
alter table user_keys enable row level security;
alter table posts enable row level security;
alter table stories enable row level security;
alter table follows enable row level security;
alter table blocks enable row level security;

create policy profiles_select on profiles for select using ( true );
create policy profiles_update_self on profiles for update using (auth.uid() = id);
create policy profiles_insert_self on profiles for insert with check (auth.uid() = id);

create policy messages_members_select on messages for select using (
  exists (select 1 from chat_members cm where cm.chat_id = messages.chat_id and cm.user_id = auth.uid())
);
create policy messages_insert_sender on messages for insert with check (
  exists (select 1 from chat_members cm where cm.chat_id = messages.chat_id and cm.user_id = auth.uid())
);

create policy chats_member_select on chats for select using (
  exists (select 1 from chat_members cm where cm.chat_id = chats.id and cm.user_id = auth.uid())
);

create policy user_keys_read on user_keys for select using (true);
create policy user_keys_upsert on user_keys for insert with check (user_id = auth.uid());
create policy user_keys_update on user_keys for update using (user_id = auth.uid());

create policy posts_read_public_following on posts for select using (
  visibility = 'public' or author_id = auth.uid()
);
create policy posts_insert_owner on posts for insert with check (author_id = auth.uid());
create policy posts_update_owner on posts for update using (author_id = auth.uid());
