package live.shuuyu.astral

import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.*

@Mod(
    modid = Astral.MOD_ID,
    name = Astral.MOD_NAME,
    version = Astral.MOD_VERSION,
    acceptedMinecraftVersions = "[1.8.9]",
    clientSideOnly = true,
    modLanguage = "kotlin",
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
class Astral {
    @Mod.EventHandler
    fun onPreInitializer(event: FMLPreInitializationEvent) {

    }

    @Mod.EventHandler
    fun InitializerEvent(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @Mod.EventHandler
    fun onPostInitiaizer(event: FMLPostInitializationEvent) {

    }

    @Mod.EventHandler
    fun onLoad(event: FMLLoadCompleteEvent) {

    }

    companion object {
        const val MOD_ID = "astral"
        const val MOD_NAME = "Astral"
        const val MOD_VERSION = "0.0.1"

        var displayScreen: GuiScreen? = null
    }
}