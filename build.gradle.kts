

buildscript {
    val compose_version by extra("1.1.1")
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.versions.update) apply false
    alias(libs.plugins.version.catalog.update) apply false
    alias(libs.plugins.hilt) apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}
