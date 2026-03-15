package aegis.item.custom;

import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;


public class Magma_Shield_V2_Item  extends ShieldItem implements Equipment {
    public Magma_Shield_V2_Item(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.MAGMA_BLOCK) || super.canRepair(stack, ingredient);
    }



}
