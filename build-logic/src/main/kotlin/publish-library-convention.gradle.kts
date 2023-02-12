@file:Suppress("UnstableApiUsage")

import java.util.Properties

plugins {
    id("com.vanniktech.maven.publish")
}

project.version = project.version.toString()

val githubProperties = Properties()
val propsFile = project.rootProject.file("github.properties")
if (propsFile.isFile()) {
    propsFile.inputStream().use { fis -> githubProperties.load(fis) }
} else {
    githubProperties["github_username"] = System.getenv("USERNAME")
    githubProperties["github_password"] = System.getenv("PASSWORD")
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/IlyaPavlovskii/koin-v3-utils")

            credentials {
                username = githubProperties.getProperty("github_username")
                password = githubProperties.getProperty("github_password")
            }
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = project.group.toString(),
        artifactId = project.name,
        version = project.version.toString()
    )

    pom {
        name.set("ipavlovskii-koin-v3-utils")
        description.set("Simple Koin component library that helps to encapsulate module implementation inside the feature module.")
        inceptionYear.set("2023")
        url.set("https://github.com/IlyaPavlovskii/koin-v3-utils")
        licenses {
            license {
                name.set("Apache 2.0 License")
                url.set("https://github.com/IlyaPavlovskii/koin-v3-utils/blob/master/LICENSE.md")
                distribution.set("https://github.com/IlyaPavlovskii/koin-v3-utils/blob/master/LICENSE.md")
            }
        }
        developers {
            developer {
                id.set("Ilia Pavlovskii")
                name.set("Ilia Pavlovskii")
                url.set("trane91666@gmail.com")
            }
        }
        scm {
            url.set("https://github.com/IlyaPavlovskii/koin-v3-utils")
            connection.set("scm:git:github.com/IlyaPavlovskii/koin-v3-utils.git")
            developerConnection.set("scm:git:ssh://github.com/IlyaPavlovskii/koin-v3-utils.git")
        }
    }
}
