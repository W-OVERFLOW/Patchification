package cc.woverflow.patchification

import cc.woverflow.onecore.utils.command
import cc.woverflow.onecore.utils.openScreen
import cc.woverflow.patchification.config.PatchificationConfig
import cc.woverflow.patchification.config.VigilanceConfig
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import java.io.File

@Mod(
    modid = Patchification.ID,
    name = Patchification.NAME,
    version = Patchification.VER,
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
object Patchification {

    const val NAME = "@NAME@"
    const val VER = "@VER@"
    const val ID = "@ID@"

    val modDir = File(File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME)

    @Mod.EventHandler
    fun onFMLPreInitialization(event: FMLPreInitializationEvent) {
        if (!modDir.exists()) modDir.mkdirs()
    }

    @Mod.EventHandler
    fun onInitialization(event: FMLInitializationEvent) {
        PatchificationConfig.preload()
        command(ID) {
            main {
                PatchificationConfig.openScreen()
            }
        }
        command("vigilance", aliases = arrayListOf("vigilant")) {
            main {
                VigilanceConfig.openScreen()
            }
        }
    }
}
