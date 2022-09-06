import dev.architectury.pack200.java.Pack200Adapter
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("gg.essential.loom") version "0.10.0.+"
    id("dev.architectury.architectury-pack200") version "0.1.3"
    id("io.github.juuxel.loom-quiltflower") version "1.7.3"
    java
}

group = "live.shuuyu"
version = "1.0.0"

quiltflower {
    quiltflowerVersion.set("1.8.1")
}

loom {
    silentMojangMappingsLicense()
    launchConfigs {
        getByName("client") {
            property("elementa.dev", "true")
            property("elementa.debug", "true")
            property("elementa.invalid_usage", "warn")
            property("mixin.debug.verbose", "true")
            property("mixin.debug.export", "true")
            property("mixin.dumpTargetOnFailure", "true")
            property("legacy.debugClassLoading", "true")
            property("legacy.debugClassLoadingSave", "true")
            property("legacy.debugClassLoadingFiner", "true")
            arg("--mixin", "mixins.astral.json")
        }
    }
    runConfigs {
        getByName("client") {
            isIdeConfigGenerated = true
        }
    }
    forge {
        pack200Provider.set(Pack200Adapter())
        mixinConfig("mixins.template.json")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1")
    maven("https://repo.essential.gg/repository/maven-public")
    maven("https://repo.essential.gg/repository/maven-releases")
    maven("https://jitpack.io")
}

val shade: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

val shadeMod: Configuration by configurations.creating {
    configurations.modImplementation.get().extendsFrom(this)
}

dependencies {
    minecraft("com.mojang:minecraft:1.8.9")
    mappings("de.oceanlabs.mcp:mcp_stable:22-1.8.9")
    forge("net.minecraftforge:forge:1.8.9-11.15.1.2318-1.8.9")
    modRuntimeOnly("me.djtheredstoner:DevAuth-forge-legacy:1.1.0")
    shadeMod("gg.essential:loader-launchwrapper:1.1.3")
    implementation("gg.essential:essential-1.8.9-forge:4246+g8be73312c")
    shadeMod("com.github.LlamaLad7:MixinExtras:0.0.12")
    annotationProcessor("com.github.LlamaLad7:MixinExtras:0.0.12")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

tasks {
    jar {
        manifest.attributes(mapOf(
            "ModSide" to "CLIENT",
            "FMLCorePluginContainsFMLMod" to "Yes, yes it does",
            "TweakClass" to "gg.essential.loader.stage0.EssentialSetupTweaker",
            "TweakOrder" to "0",
            "MixinConfigs" to "mixins.astral.json"
        ))
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.contracts.ExperimentalContracts"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.InternalSerializationApi"
        }
    }
}