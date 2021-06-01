import com.google.protobuf.gradle.protoc
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.protobuf") version "0.8.12"
}

android {
    compileSdkVersion(Versions.targetsdk)
    buildToolsVersion(Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "com.mgabor.datastoresampleapp"
        minSdkVersion(Versions.minsdk)
        targetSdkVersion(Versions.targetsdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.Kotlin.stdlib)
    implementation(Libraries.AndroidX.Ktx.core)
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.Ui.material)
    implementation(Libraries.AndroidX.Ui.constraintLayout)
    implementation(Libraries.AndroidX.Navigation.core)
    implementation(Libraries.AndroidX.Navigation.ui)
    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.espressoCore)

    // Hilt
    implementation(Libraries.Hilt.hiltAndroid)
    kapt(Libraries.Hilt.hiltCompiler)

    // DB - Room
    implementation(Libraries.Room.runtime)
    kapt(Libraries.Room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Libraries.Room.roomKtx)

    // Lifecycle
    implementation(Libraries.AndroidX.Lifecycle.lifeCycleExt)
    implementation(Libraries.AndroidX.Lifecycle.viewModel)
    implementation(Libraries.AndroidX.Lifecycle.livedata)

    // Coroutine
    implementation(Libraries.Kotlin.coroutinesAndroid)

    // DataStore
    implementation(Libraries.DataStore.preferences)

    // Protobuf
    implementation(Libraries.DataStore.ProtoBuf.javalite)

    // SharedPreferences
    implementation(Libraries.Common.preferences)
}

protobuf {
    protobuf.protoc {
        artifact = Libraries.DataStore.ProtoBuf.protoc
    }

    protobuf.generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                id("java") {
                    option("lite")
                }
            }
        }
    }
}