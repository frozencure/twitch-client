plugins {
    java
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.serialization") version "1.3.71"
    id("org.jetbrains.dokka") version "1.4.0-rc"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-client-serialization-jvm:1.3.2")
    implementation("io.ktor:ktor-client-core-jvm:1.3.2")
    implementation("io.ktor:ktor-client-apache:1.3.2")
    implementation("io.ktor:ktor-client-auth-jvm:1.3.2")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-properties:0.20.0")
    testImplementation("junit:junit:4.12")
    api("io.ktor:ktor-client-mock:1.3.2")
    api("io.ktor:ktor-client-mock-jvm:1.3.2")
}

fun getSampleFiles(): List<String> {
    val samplesPath = "src/main/kotlin/samples/"
    return File(samplesPath).walk().filter { f -> f.isFile }.map { f -> samplesPath + f.name.toString() }.toList()
}

tasks.dokkaHtml {
    dokkaSourceSets {
        configureEach {
            includes = listOf("readme.md")
            samples = getSampleFiles()
            includeNonPublic = false
            reportUndocumented = false
            skipEmptyPackages = true
            noStdlibLink = false
            noJdkLink = false
            noAndroidSdkLink = true
            skipDeprecated = false
            sourceLink {
                path = "src/main/kotlin"
                url = "https://github.com/frozencure/twitch-client/" +
                        "tree/develop/src/main/kotlin"
                lineSuffix = "#L"
            }
            perPackageOption {
                prefix = "samples"
                suppress = true
            }
        }
    }
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}