plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.aocheretyabyi.wordmeaningexampleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aocheretyabyi.wordmeaningexampleapp"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.androidx_core)
    implementation(Dependencies.androidx_lifecycle_runtime)
    implementation(Dependencies.androidx_lifecycle_vm)
    implementation(Dependencies.androidx_activity_compose)
    implementation(platform(Dependencies.composeBOM))
    implementation(Dependencies.compose_ui)
    implementation(Dependencies.compose_ui_graphic)
    implementation(Dependencies.compose_tooling_preview)
    implementation(Dependencies.compose_material3)
    implementation(Dependencies.hilt)
    kapt(Dependencies.hilt_compiler)
    implementation(Dependencies.hilt_nav_compose)
    implementation(Dependencies.compose_viewmodel)
    implementation(Dependencies.compose_navigation)
    implementation(Dependencies.kotlin_coroutines)
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(project(":domain"))
    implementation(project(":di"))
}

kapt {
    correctErrorTypes = true
}
