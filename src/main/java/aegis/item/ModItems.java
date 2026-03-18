package aegis.item;

import aegis.Aegis;
import aegis.item.custom.Magma_Shield_V2_Item;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {


    public static final Item MAGMA_SHIELD_V2 = registerItem("magma_shield_v2", new Magma_Shield_V2_Item(new Item.Settings().maxDamage(1500)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Aegis.MOD_ID, name), item);
    }

    public static void registerModItems () {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(MAGMA_SHIELD_V2);

        });
    }
}
