import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.serialization") version "1.7.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("dev.architectury.loom") version "1.0-SNAPSHOT"
    id("io.github.juuxel.loom-quiltflower") version "1.8.0"
    id("com.modrinth.minotaur") version "2.5.0"
    java
}

group = "live.shuuyu.astral"
version = "1.0.0"
description = "A modern and useful Minecraft mod designed around the HUD."

quiltflower {
    quiltflowerVersion.set("1.9.0")
}

loom {
    silentMojangMappingsLicense()
    runConfigs {
        getByName("client") {
            isIdeConfigGenerated = true
        }
    }
}

repositories {
    mavenCentral()
}

val shade: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

val shadeMod: Configuration by configurations.creating {
    configurations.modImplementation.get().extendsFrom(this)
}

dependencies {
    minecraft("com.mojang:minecraft:1.19.3")
    mappings("net.fabricmc:yarn:1.19.3+build.3:v2")
    shadeMod("net.fabricmc.fabric-api:fabric-api:0.69.1+1.19.3")
    shadeMod("net.fabricmc:fabric-loader:0.14.11")
    shadeMod("net.fabricmc:fabric-language-kotlin:1.8.7+kotlin.1.7.22")
}

tasks {
    processResources {
        inputs.property("group", project.group)
        inputs.property("name", project.name)
        inputs.property("version", project.version)
        inputs.property("description", project.description)

        filesMatching(listOf("fabric.mod.json", "quilt.mod.json")) {
            expand(
                "group" to project.group,
                "name" to project.name,
                "version" to project.version,
                "description" to project.description
            )
        }
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
        }
    }
}

modrinth {
    loaders.set(listOf("fabric", "quilt"))
}