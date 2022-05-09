package cc.woverflow.patchification.mixin;

import cc.woverflow.patchification.config.VigilanceConfig;
import gg.essential.elementa.WindowScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreen.class)
public class GuiScreenMixin {
    @Shadow public Minecraft mc;

    @Inject(method = "drawWorldBackground", at = @At("HEAD"), cancellable = true)
    private void onDrawWorldBackground(int tint, CallbackInfo ci) {
        if (mc.currentScreen instanceof WindowScreen && VigilanceConfig.INSTANCE.getDisableBackground()) {
            ci.cancel();
        }
    }
}
