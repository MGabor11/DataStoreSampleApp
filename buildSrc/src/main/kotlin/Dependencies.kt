object Versions {
    const val minsdk = 23
    const val targetsdk = 30
    const val buildToolsVersion = "30.0.3"

    const val gradle = "4.2.1"

    const val kotlin = "1.5.10"
    const val coroutines = "1.5.0"
    const val lifecycle = "2.3.1"

    const val navigation = "2.3.5"

    const val room = "2.3.0"

    const val dataStore = "1.0.0-beta01"

    const val hilt = "2.35"

    const val junit = "4.13.2"
    const val espresso = "3.3.0"
}

object Libraries {

    object Gradle {
        const val plugin = "com.android.tools.build:gradle:${Versions.gradle}"
    }

    object Kotlin {
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.0.2"
        const val annotations = "androidx.annotation:annotation:1.1.0"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.5.0"
        }

        object Lifecycle {
            const val lifeCycleExt = "androidx.lifecycle:lifecycle-extensions:2.2.0"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        }

        object Ui {
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        }

        object Navigation {
            const val core = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Ui {
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    }

    object DataStore {
        const val preferences = "androidx.datastore:datastore-preferences:${Versions.dataStore}"

        object ProtoBuf {
            const val protoc = "com.google.protobuf:protoc:3.11.0"
            const val javalite = "com.google.protobuf:protobuf-javalite:3.14.0"
        }
    }

    object Hilt {
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Common {
        const val preferences = "androidx.preference:preference-ktx:1.1.1"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:1.1.2"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}
