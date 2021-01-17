plugins {
    kotlin("multiplatform") version "1.4.10"
}

group = "me.coditive"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    commonMainImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
    commonMainImplementation("junit:junit:4.12")
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }
}
