plugins {
    id("com.github.ben-manes.versions")
    id("mapnote.android.application")
    id("mapnote.android.application.compose")
    id("mapnote.android.hilt")

}

android {
    namespace = "com.example.mapnote"

    defaultConfig {
        applicationId = "com.example.mapnote"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (project(":designsystem"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling.asProvider())
    androidTestImplementation(libs.androidx.compose.ui.testManifest)
    androidTestImplementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.compose.material3.asProvider())
    implementation(libs.accompanist.flowlayout)

    implementation(libs.naver.map.asProvider())
    implementation(libs.naver.map.compose)
    implementation(libs.google.service)
    testImplementation(libs.junit4)

    implementation("com.android.support:appcompat-v7:27.0.0")

    implementation("com.naver.maps:map-sdk:3.16.0") {
        exclude(group = "com.android.support")
    }
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
}
