plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.github.ben-manes.versions")
    id("dagger.hilt.android.plugin")
    id("nowinandroid.android.library.compose")
}

android {
    namespace = "com.example.mapnote"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mapnote"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.3.1"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling.asProvider())
    androidTestImplementation(libs.androidx.compose.ui.testManifest)
    androidTestImplementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.compose.material3.asProvider())
    implementation(libs.accompanist.flowlayout)
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)

    implementation(libs.naver.map.asProvider())
    implementation(libs.naver.map.compose)
    implementation(libs.google.service)
    testImplementation(libs.junit4)

    implementation("com.android.support:appcompat-v7:27.0.0")

    implementation("com.naver.maps:map-sdk:3.16.0") {
        exclude(group = "com.android.support")
    }
}
