plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "br.com.mizaeldouglas.coffe_shop_mobile"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.mizaeldouglas.coffe_shop_mobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation("com.google.android.material:material:1.12.0")
    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    // SQLite
    implementation("androidx.sqlite:sqlite-ktx:2.4.0")

    // Hilt (Dagger)
    implementation("com.google.dagger:hilt-android:2.52")
    implementation(libs.androidx.gridlayout)
    kapt("com.google.dagger:hilt-compiler:2.52")

    // Firebase
    implementation(libs.firebase.firestore)
    implementation("com.google.android.gms:play-services-base:18.5.0")

    // Picasso
    implementation(libs.picasso)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // KTX Fragment
    implementation(libs.androidx.fragment.ktx)

    // AndroidX Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // AndroidX Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}