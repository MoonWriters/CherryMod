package eu.moonwriters.cherrymod.mixin;

import eu.moonwriters.cherrymod.client.CherryModClient;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class ZoomInventoryScroll {
    @Shadow
    public int selectedSlot;
    @Unique
    private int lastSlot = -1;

    @Inject(at = @At("HEAD"), method = "scrollInHotbar")
    private void beforeScrollInHotbar(double scrollAmount, CallbackInfo ci) {
        if (CherryModClient.isZooming()) {
            lastSlot = selectedSlot;
        }
    }

    @Inject(at = @At("TAIL"), method = "scrollInHotbar")
    private void afterScrollInHotbar(double scrollAmount, CallbackInfo ci) {
        if (CherryModClient.isZooming()) {
            if (lastSlot > -1) {
                selectedSlot = lastSlot;
                lastSlot = -1;
            }
        }
    }
}