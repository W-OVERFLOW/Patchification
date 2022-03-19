package cc.woverflow.patchification.config

import cc.woverflow.onecore.utils.openScreen
import cc.woverflow.patchification.Patchification
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

object PatchificationConfig : Vigilant(File(Patchification.modDir, "${Patchification.ID}.toml"), Patchification.NAME) {

    @Property(
        type = PropertyType.BUTTON,
        name = "Vigilance Customizer GUI",
        description = "Show the Vigilance Customizer GUI.",
        category = "Vigilance Customizer"
    )
    fun openVigilanceGUI() = VigilanceConfig.openScreen()

    init {
        initialize()
    }
}