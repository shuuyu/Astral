package live.shuuyu.astral.command

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import live.shuuyu.astral.Astral
import live.shuuyu.astral.gui.MainGui

object AstralCommand : Command("astral") {
    override val commandAliases = setOf(Alias("hud"))

    @DefaultHandler
    fun execCommand() {
        //EssentialAPI.getGuiUtil().openScreen(MainGui.gui())
    }
}