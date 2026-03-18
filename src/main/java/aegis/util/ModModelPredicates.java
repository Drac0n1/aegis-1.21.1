package aegis.util;

import aegis.Aegis;
import aegis.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        // Register predicate: "modid:using"
        ModelPredicateProviderRegistry.register(ModItems.MAGMA_SHIELD_V2, Identifier.of(Aegis.MOD_ID, "blocking"),
                (stack, world, entity, seed) -> {
                    // Returns 1.0 (active) if the item is being used, 0.0 otherwise
                    return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1f : 0f;
                });
    }
}
