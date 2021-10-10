dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven ("https://jitpack.io")
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "AndroidUITraining"
include(":app")
