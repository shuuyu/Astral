package live.shuuyu.astral.gui

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.MaxConstraint
import gg.essential.elementa.dsl.*


class MainGui : UIBlock(AstralTheme.MainMenuBackground.constraint) {
    init {
        constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            width = 80.percent
            height = 80.percent
        }
    }

    val header = UIBlock(AstralTheme.HeaderBackground.constraint).constrain {
        width = 100.percent
        height = 20.percent
    } childOf this
}