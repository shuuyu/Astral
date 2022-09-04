package live.shuuyu.astral

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent

@Mod(
    modid = Astral.MOD_ID,
    name = Astral.MOD_NAME,
    version = Astral.MOD_VERSION,
    acceptedMinecraftVersions = "[1.8.9]",
    clientSideOnly = true,
    modLanguage = "kotlin",
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
object Astral {
    const val MOD_ID = "astral"
    const val MOD_NAME = "Astral"
    const val MOD_VERSION = "0.0.1"

    @Mod.EventHandler
    fun onPostInitiaizer(event: FMLPostInitializationEvent) {

    }
}