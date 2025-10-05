plugins {
    id("java")
}

group = "net.vtraxio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(platform("org.lwjgl:lwjgl-bom:3.3.6"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-assimp")
    implementation("org.lwjgl", "lwjgl-bgfx")
    implementation("org.lwjgl", "lwjgl-glfw")
    implementation("org.lwjgl", "lwjgl-nanovg")
    implementation("org.lwjgl", "lwjgl-nuklear")
    implementation("org.lwjgl", "lwjgl-openal")
    implementation("org.lwjgl", "lwjgl-opengl")
    implementation("org.lwjgl", "lwjgl-par")
    implementation("org.lwjgl", "lwjgl-stb")
    implementation("org.lwjgl", "lwjgl-vulkan")
    implementation ("org.lwjgl", "lwjgl", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-assimp", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-bgfx", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-glfw", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-nanovg", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-nuklear", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-openal", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-opengl", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-par", classifier = "natives-windows")
    implementation ("org.lwjgl", "lwjgl-stb", classifier = "natives-windows")
}

tasks.test {
    useJUnitPlatform()
}