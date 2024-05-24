package eu.moonwriters.cherrymod.mixin;

import eu.moonwriters.cherrymod.client.CherryModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
@Environment(value = EnvType.CLIENT)
public class ZoomScroll {

    @Inject(at = @At("HEAD"), method = "onMouseScroll")
    private void ZoomScrollWheel(long window, double horizontal, double vertical, CallbackInfo ci) {

        if (CherryModClient.isZooming() && MinecraftClient.getInstance().player != null) {
            double beforehorizontal = horizontal;
            if (beforehorizontal < vertical && CherryModClient.isZooming() && MinecraftClient.getInstance().player != null) {
                beforehorizontal = horizontal;
            }
            if (beforehorizontal > vertical && CherryModClient.isZooming() && MinecraftClient.getInstance().player != null) {
                beforehorizontal = horizontal;
            }
        }
    }
}
