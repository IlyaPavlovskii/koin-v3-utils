plugins {
    id("multiplatform-library-convention")
    id("com.vanniktech.maven.publish") version "0.24.0"
}

dependencies {
    commonMainImplementation(libs.koin.core)
}
