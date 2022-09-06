package live.shuuyu.astral.gui

import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.percent
import gg.essential.elementa.dsl.provideDelegate


class MainGui : UIBlock() {
    init {
        constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            width = 80.percent
            height = 80.percent
        }
    }

    val title by UIText("Astral").constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 15.percent
        height = 20.percent
    }
}