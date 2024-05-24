package eu.moonwriters.cherrymod.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindsHandler {
    public static KeyBinding zoom;

    public static void registerKeybinds() {
        zoom = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "keybind.moonwriters.zoom",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.moonwriters.moonwriters"
        ));
    }
}
