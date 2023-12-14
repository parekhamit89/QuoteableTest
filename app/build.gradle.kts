plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.demo.quoteabletest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.demo.quoteabletest"
        minSdk = 24
        targetSdk = 34
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
        getByName("debug") {
            enableAndroidTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    buildFeatures {
        viewBinding = true
    }
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.md")
        resources.excludes.add("META-INF/LICENSE-notice.md")
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")
    testImplementation("junit:junit:4.12")
    testImplementation("junit:junit:4.12")
    testImplementation("junit:junit:4.12")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
    //for mvvm testing
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
// for Mockito
    implementation("org.mockito:mockito-core:4.0.0")
    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("org.mockito:mockito-inline:3.7.0")
//    implementation("com.nhaarman.mockitokotlin2:mockito-kotlin2:2.2.0")
//mock web server
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
    //coroutine testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

/*
*
*     testImplementation 'org.mockito:mockito-core:2.12.0'
    testImplementation 'junit:junit:4.13.2'
    testImplementation 'org.mockito:mockito-inline:3.7.0'
    testImplementation 'androidx.arch.core:core-testing:2.1.0'
    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.0"
    androidTestImplementation 'org.mockito:mockito-android:2.12.0'

    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
* */

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //Room db dependency
    implementation("androidx.room:room-runtime:2.6.1")
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
//    implementation "androidx.room:room-paging:2.4.1"
    ksp("androidx.room:room-compiler:2.6.1")
}