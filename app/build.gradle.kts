plugins {
    id("com.android.application")
}

android {
    namespace = "com.cxinventor.file.explorer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cxinventor.file.explorer"
        minSdk = 21
        targetSdk = 34
        versionCode = 278
        versionName = "2.7.8"
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = false
        buildConfig = true
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    // AndroidX ecosystem
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core:1.12.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.documentfile:documentfile:1.0.1")
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("androidx.preference:preference:1.2.1")
    implementation("com.google.android.material:material:1.11.0")

    // Open Source Protocols & UI
    implementation("com.github.mwiede:jsch:0.2.16")
    implementation("me.jahirfiquitiva:libaums:0.8.0")
    implementation("com.davemorrissey.labs:subsampling-scale-image-view-androidx:3.10.0")

    // Shizuku
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
