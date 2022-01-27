package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NetherWartSoupItem extends BasicFoodItem {

    public NetherWartSoupItem() {
        super(FoodTypes.NETHER_WART_SOUP, true);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
    {
        entityLiving.setSecondsOnFire(5);
        entityLiving.getActiveEffects().removeIf(effect -> !effect.getEffect().isBeneficial());
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
