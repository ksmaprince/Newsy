plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
    id("kotlinx-serialization")
}

android {
    namespace = "hoods.com.newsy"
    compileSdk = 35

    defaultConfig {
        applicationId = "hoods.com.newsy"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "hoods.com.newsy.HiltTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "clear_text_config", "false")
        }
        debug {
            isMinifyEnabled = false
            resValue("string", "clear_text_config", "true")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    testOptions{
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Compose Material Icons Extended
    implementation (libs.androidx.material.icons.extended)

    //Pagination
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime.ktx)

    //Coil
    implementation(libs.coil.compose)

    //Network
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation (libs.kotlinx.serialization.json)

    // dagger Hilt
    implementation(libs.hilt.android)
    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.core.testing)
    ksp(libs.hilt.android.compiler)
    implementation (libs.androidx.hilt.navigation.compose)

    //Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)

    //splash
    implementation (libs.androidx.core.splashscreen)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Dagger Hilt Test
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)
    //Paging Testing
    implementation(libs.androidx.paging.testing)

    //Compose JUnit Test
    testImplementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.androidx.ui.test.junit4)

    //Mockito
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)

    //MockWebServer
    testImplementation(libs.mockwebserver)
    androidTestImplementation(libs.mockwebserver)

    //Robolectric
    testImplementation(libs.robolectric)

    //Coroutine Test
    testImplementation (libs.kotlinx.coroutines.test)

    //Google Truth
    testImplementation(libs.truth)
    androidTestImplementation(libs.truth)
}