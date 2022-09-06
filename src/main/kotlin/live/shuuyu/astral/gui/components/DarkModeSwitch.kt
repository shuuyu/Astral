package live.shuuyu.astral.gui.components

import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIImage
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.percent
import gg.essential.elementa.dsl.provideDelegate

class DarkModeSwitch : UIBlock() {
    val icon by UIImage.ofResourceCached("/astral/DarkModeImage.png").constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 50.percent
        height = 50.percent
    } childOf this

    val lightModeIcon by UIImage.ofResourceCached("/astral/DarkModeImage.png").constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        width = 50.percent
        height = 50.percent
    } childOf this
}