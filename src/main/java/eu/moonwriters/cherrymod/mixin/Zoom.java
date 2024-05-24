package eu.moonwriters.cherrymod.mixin;


import eu.moonwriters.cherrymod.client.CherryModClient;
import eu.moonwriters.cherrymod.zoom.ZoomMethods;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class Zoom {

    @Inject(at = @At("RETURN"), method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", cancellable = true)
    public void getZoomLevel(CallbackInfoReturnable<Double> callbackInfo) {
        if (CherryModClient.isZooming()) {
            callbackInfo.setReturnValue(30.0);
        }
        if (CherryModClient.isZooming() && !MinecraftClient.getInstance().options.smoothCameraEnabled && ZoomMethods.smoothChecker()) {
            MinecraftClient.getInstance().options.smoothCameraEnabled = true;
        }
        if ((!CherryModClient.isZooming() && MinecraftClient.getInstance().options.smoothCameraEnabled)
                || !ZoomMethods.smoothChecker()) {
            MinecraftClient.getInstance().options.smoothCameraEnabled = false;
        }
    }
}
