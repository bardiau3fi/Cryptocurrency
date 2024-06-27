plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.navigationsafeargs)
    id("kotlin-kapt")
    alias(libs.plugins.daggerhiltandroid)



}

android {
    namespace = "com.example.crypto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.crypto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
buildFeatures{
    viewBinding=true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



    //Navigation
    implementation (libs.androidx.navigation.fragment)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)


    //Coroutines
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.core)

// Lifecycle
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    //Dagger Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)

    //Gson
    implementation (libs.gson)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //OkHttp
    implementation (libs.okhttp)
    implementation (libs.logging.interceptor)

    //Coil
    implementation (libs.coil)

     //chart
    implementation (libs.williamchart)

    implementation (libs.jsoup)

}