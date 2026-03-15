package aegis.item;

import aegis.Aegis;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup AEGIS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Aegis.MOD_ID, "aegis_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGMA_SHIELD_V2))
                    .displayName(Text.translatable("itemgroup.aegis.aegis_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGMA_SHIELD_V2);
                    })


                    .build());
    public static void registerItemGroups() {

    }
}
