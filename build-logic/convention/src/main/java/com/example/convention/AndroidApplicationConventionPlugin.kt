package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configure.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            //the plugin manager for this plugin aware object.
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

//            extensions.configure<ApplicationExtension> {
//                configureKotlinAndroid(this)
////                defaultConfig. = 33
//            }

            //Android 애플리케이션 Gradle 플러그인 구성요소용 확장입니다.
            //com.android.application 플러그인이 적용될 때의 androidComponents 블록입니다.
            //Android Gradle 플러그인만 com.android.build.api.variant에 인터페이스 인스턴스를 생성해야 합니다.



        }
    }
}