package aegis.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandeler {
    public static final String KEY_CATEGORY_AEGIS = "key.category.aegis.aegis_shields";
    public static final String KEY_MAGMA_RELEASE = "key.aegis.magma_release";

    public static KeyBinding magmareleasekey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if(magmareleasekey.wasPressed()) {

                //this happens when keybind is pressed
                assert minecraftClient.player != null;
                minecraftClient.player.sendMessage(Text.of("Key pressed"));

            }
        });
    }

    public static void register() {
        magmareleasekey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MAGMA_RELEASE,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                KEY_CATEGORY_AEGIS
        ));


        registerKeyInputs();

    }





}
