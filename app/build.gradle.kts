plugins {
    alias(libs.plugins.android.application)
}

// Fix for "Could not find or load main class" due to spaces in java.library.path on Windows
// Replace spaces with 8.3 short paths for common Program Files locations
val currentLibPath = System.getProperty("java.library.path") ?: ""
if (currentLibPath.contains(" ")) {
    val fixedPath = currentLibPath
        .replace("C:\\Program Files (x86)", "C:\\PROGRA~2")
        .replace("C:\\Program Files", "C:\\PROGRA~1")
    System.setProperty("java.library.path", fixedPath)
}

android {
    namespace = "com.example.isisgamecollector"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.isisgamecollector"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}