package live.shuuyu.astral.mixins;

import net.minecraftforge.client.event.GuiScreenEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiScreenEvent.KeyboardInputEvent.class)
public abstract class MixinKeyboard {

}