pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenCentral()
        maven {
            url = uri("https://s3.us-east-2.amazonaws.com/android.telematics.sdk.production/")
        }
    }
}

rootProject.name = "TestApp"
include(":app")
