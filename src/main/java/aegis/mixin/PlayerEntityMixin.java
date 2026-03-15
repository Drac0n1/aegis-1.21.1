package aegis.mixin;


import aegis.item.ModItems;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@SuppressWarnings("UnreachableCode")
@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Shadow
    @Final
    PlayerInventory inventory;

    @Inject(at = @At(value = "HEAD"), method = "damageShield(F)V")
    private void damageShield(float amount, CallbackInfo callBackInfo) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack activeItem = player.getActiveItem();

        if (activeItem.getItem() instanceof ShieldItem) {
            if (amount >= 3.0F) {
                int i = 1 + MathHelper.floor(amount);
                boolean offHand = player.getActiveHand().equals(Hand.OFF_HAND);
                boolean mainHand = player.getActiveHand().equals(Hand.MAIN_HAND);

                if(offHand){
                    activeItem.damage(i, (LivingEntity) player, EquipmentSlot.OFFHAND);
                } else if (mainHand){
                    activeItem.damage(i, (LivingEntity) player, EquipmentSlot.MAINHAND);
                }

                if (activeItem.isEmpty()) {
                    if (mainHand) {
                        player.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    } else {
                        player.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }

                    activeItem = ItemStack.EMPTY;
                    player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + player.getWorld().random.nextFloat() * 0.4F);
                }
            }

        }
    }
@Mixin(PlayerEntity.class)
public static class ShieldDamage {
    @Inject(method = "disableShield", at = @At("HEAD"))
    public void disableShield(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        player.getItemCooldownManager().set(ModItems.MAGMA_SHIELD_V2, 100);
        player.clearActiveItem();
        player.getWorld().sendEntityStatus(player, EntityStatuses.BREAK_SHIELD);
    }
    }
}