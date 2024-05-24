package eu.moonwriters.cherrymod.client;

import eu.moonwriters.cherrymod.discord.RichPresence;
import eu.moonwriters.cherrymod.keybinds.KeybindsHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

import java.util.Objects;


public class CherryModClient implements ClientModInitializer {
    private static RichPresence presence;

    @Override
    public void onInitializeClient() {
        presence = new RichPresence();
        presence.create();
        presence.update("Main Menu", "");
        MinecraftClient.getInstance().execute(this::changeTitle);
        KeybindsHandler.registerKeybinds();
    }

    private void changeTitle() {
        String type = "";
        if (MinecraftClient.getInstance().getServer() != null) {
            if (MinecraftClient.getInstance().getServer().isSingleplayer()) {
                type = "Singleplayer";
            }
            if (Objects.requireNonNull(MinecraftClient.getInstance().getServer()).isOnlineMode()) {
                type = "Multiplayer";
            }
        }
        MinecraftClient.getInstance().getWindow().setTitle("CherryMod v0.1 indev - " + MinecraftClient.getInstance().getGameVersion() + type);
    }

    public static boolean isZooming() {
        return KeybindsHandler.zoom.isPressed();
    }
}
