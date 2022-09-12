package live.shuuyu.astral.gui

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.*
import gg.essential.elementa.effects.OutlineEffect
import live.shuuyu.astral.Astral
import java.awt.Color


class MainGui : WindowScreen(ElementaVersion.V2) {

    val menu = UIBlock(AstralTheme.MainMenuBackground.constraint).constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 25.percent
        height = 25.percent
    } effect OutlineEffect(Color.white, 1f) childOf window

    val header = UIBlock(AstralTheme.HeaderBackground.constraint).constrain {
        width = 100.percent
        height = 20.percent
    } childOf menu
}