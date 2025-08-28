plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "com.yourorg.app"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.yourorg.app"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "0.1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables { useSupportLibrary = true }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
    debug { }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions { jvmTarget = "17" }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
  packaging {
    resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.13.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
  implementation("androidx.activity:activity-compose:1.9.2")
  implementation("androidx.compose.ui:ui:1.6.8")
  implementation("androidx.compose.material:material:1.6.8")
  implementation("androidx.navigation:navigation-compose:2.8.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

  // Hilt
  implementation("com.google.dagger:hilt-android:2.50")
  kapt("com.google.dagger:hilt-compiler:2.50")
  implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

  // Room
  implementation("androidx.room:room-runtime:2.6.1")
  kapt("androidx.room:room-compiler:2.6.1")
  implementation("androidx.room:room-ktx:2.6.1")

  // WorkManager + Hilt integration
  implementation("androidx.work:work-runtime-ktx:2.9.1")
  implementation("androidx.hilt:hilt-work:1.2.0")
  kapt("androidx.hilt:hilt-compiler:1.2.0")

  // Supabase Kotlin (community)
  implementation("io.github.jan-tennert.supabase:postgrest-kt:2.4.2")
  implementation("io.github.jan-tennert.supabase:gotrue-kt:2.4.2")
  implementation("io.github.jan-tennert.supabase:storage-kt:2.4.2")
  implementation("io.github.jan-tennert.supabase:realtime-kt:2.4.2")
  implementation("io.ktor:ktor-client-okhttp:2.3.12")

  // OkHttp
  implementation("com.squareup.okhttp3:okhttp:4.12.0")

  // Coil
  implementation("io.coil-kt:coil-compose:2.6.0")

  // ExoPlayer (media)
  implementation("com.google.android.exoplayer:exoplayer:2.19.1")

  // Libsignal (placeholder — pin exact version when integrating)
  implementation("org.whispersystems:signal-protocol-java:2.8.1")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.2.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
