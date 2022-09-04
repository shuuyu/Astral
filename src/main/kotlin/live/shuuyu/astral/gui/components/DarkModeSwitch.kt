package live.shuuyu.astral.gui.components

import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIImage
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.provideDelegate

class DarkModeSwitch : UIBlock() {
    val icon by UIImage.ofResourceCached("/astral/DarkModeImage.png").constrain {

    }
}