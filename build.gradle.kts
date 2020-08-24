plugins {
    java
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
    id("org.jetbrains.dokka") version "1.4.0-rc"
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.4"
}

repositories {
    jcenter()
    mavenCentral()
}

group = "com.github.frozencure"
version = "0.0.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-client-serialization-jvm:1.4.0")
    implementation("io.ktor:ktor-client-apache:1.4.0")
    implementation("io.ktor:ktor-client-auth-jvm:1.4.0")
    testImplementation("junit:junit:4.13")
    testImplementation("io.ktor:ktor-client-mock-jvm:1.4.0")
}

fun getSampleFiles(): List<String> {
    val samplesPath = "src/main/kotlin/samples/"
    return File(samplesPath).walk().filter { f -> f.isFile }.map { f -> samplesPath + f.name.toString() }.toList()
}

tasks.dokkaHtml {
    dokkaSourceSets {
        configureEach {
            includes = listOf(
                "helix-readme.md",
                "docs/auth-readme.md"
            )
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
                prefix = "samples."
                reportUndocumented = false
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

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    classifier = "javadoc"
    from(tasks.dokkaHtml)
}

val sourcesJar by tasks.creating(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

artifacts {
    add("archives", sourcesJar)
    add("archives", dokkaJar)
}

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val pomUrl = "https://github.com/frozencure/twitch-client"
val pomScmUrl = "https://github.com/frozencure/twitch-client"
val pomIssueUrl = "https://github.com/frozencure/twitch-client/issues"
val pomDesc = "https://github.com/frozencure/twitch-client"

val githubRepository = "frozencure/twitch-client"
val githubReadme = "README.md"

val pomLicenseName = "MIT"
val pomLicenseUrl = "https://opensource.org/licenses/mit-license.php"
val pomLicenseDist = "repo"

val pomDeveloperId = "frozencure"
val pomDeveloperName = "Iancu Verghelet"





publishing {
    publications {
        create<MavenPublication>("twitch-client") {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["java"])

//            artifact(dokkaJar)
            artifact(sourcesJar)

            pom.withXml {
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                    }
                }
            }
        }
    }
}


bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    publish = true

    setPublications("twitch-client")

    pkg.apply {
        repo = "maven"
        name = artifactName
        userOrg = "frozencure"
        githubRepo = githubRepository
        vcsUrl = pomScmUrl
        description =
            "A Twitch API client wrapper written in Kotlin. Compatible with Kotlin/JVM - and Android Studio projects."
        setLabels(
            "kotlin",
            "twitch",
            "twitch-api",
            "ktor-client",
            "twitch-helix",
            "ktor",
            "dokka",
            "client",
            "api",
            "android"
        )
        setLicenses("MIT")
        desc = description
        websiteUrl = pomUrl
        issueTrackerUrl = pomIssueUrl
        githubReleaseNotesFile = githubReadme

        version.apply {
            name = artifactVersion
            desc = pomDesc
            released = "August 22, 2020"
            vcsTag = artifactVersion
        }
    }
}