plugins {
    `kotlin-dsl`
}

group = "com.example.mapnote.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}
gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "mapnote.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "mapnote.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "mapnote.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidApplication") {
            id = "mapnote.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "mapnote.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}
