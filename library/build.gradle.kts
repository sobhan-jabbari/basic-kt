plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

val appVersionCode: Int by rootProject.extra
val appVersionName: String by rootProject.extra

group = "ir.afraapps"
version = appVersionName


android {
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        vectorDrawables.useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        abortOnError = false
    }
    namespace = "ir.afraapps.kotlin.basic"

}

// test: ./gradlew clean -xtest -xlint assemble publishToMavenLocal

// afterEvaluate {
publishing {
    publications {
        // Creates a Maven publication called "release".
        create<MavenPublication>("release") {
            groupId = project.group as String
            artifactId = project.name
            version = project.version as String

            afterEvaluate {
                from(components["release"])
            }

            /*pom {
            name = project.name
            description = 'The basic tools for kotlin android'
            url = "https://github.com/sobhan-jabbari/${project.name}"

            licenses {
                license {
                    name = 'The Apache License, Version 2.0'
                    url = 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                }
            }
            developers {
                developer {
                    id = 'sobhan-jabbari'
                    name = 'Ali Jabbari'
                    email = 'sobhan.jabbari@gmail.com'
                }
            }
            scm {
                connection = "scm:git:github.com/sobhan-jabbari/${project.name}.git"
                url = "https://github.com/sobhan-jabbari/${project.name}"
            }
        }*/
        }
    }
}
// }


dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    // implementation 'org.jetbrains.anko:anko-sdk25:0.10.8'

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.appcompat:appcompat-resources:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.paging:paging-runtime-ktx:3.2.0")
    implementation("androidx.slidingpanelayout:slidingpanelayout:1.2.0")

    val room_version = "2.5.2"
    implementation("androidx.room:room-ktx:$room_version")

}

