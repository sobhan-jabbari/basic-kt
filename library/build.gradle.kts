plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    `maven-publish`
}

val appVersionCode: Int by rootProject.extra
val appVersionName: String by rootProject.extra

group = "ir.afraapps"
version = appVersionName


android {
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    lint {
        abortOnError = false
    }
    namespace = "ir.afraapps.kotlin.basic"

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

// test: ./gradlew clean -xtest -xlint assemble publishToMavenLocal
// test: ./gradlew clean -xtest -xlint assemble publishReleasePublicationToMavenLocal


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "ir.afraapps"
                artifactId = "basic-kt"
                version = appVersionName


                pom {
                    name.set(project.name)
                    description.set("The basic tools for kotlin android")
                    url.set("https://github.com/sobhan-jabbari/${project.name}")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("sobhan-jabbari")
                            name.set("Ali Jabbari")
                            email.set("sobhan.jabbari@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com/sobhan-jabbari/${project.name}.git")
                        url.set("https://github.com/sobhan-jabbari/${project.name}")
                    }
                }
            }
        }

    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.appcompat.resources)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.material)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.slidingpanelayout)

    implementation(libs.androidx.room.ktx)
}

