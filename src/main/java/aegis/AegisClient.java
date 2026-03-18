package aegis;

import aegis.event.KeyInputHandeler;
import aegis.networking.ModMessages;
import aegis.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class AegisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandeler.register();
        ModMessages.registerS2CPackets();
        ModModelPredicates.registerModelPredicates();

    }
}
