plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.test"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    implementation("androidx.compose.material3:material3")
    // or Material Design 2
    implementation("androidx.compose.material:material")
    // or skip Material Design and build directly on top of foundational components
    implementation("androidx.compose.foundation:foundation")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //JetPackCompose
    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation ("androidx.compose.ui:ui:1.5.4")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.4")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.4")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.4")

}