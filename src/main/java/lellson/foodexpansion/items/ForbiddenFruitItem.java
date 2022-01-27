package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ForbiddenFruitItem extends Item {
    private final boolean beneficial;

    public ForbiddenFruitItem(boolean beneficial) {
        super(new Item.Properties().stacksTo(1).tab(FoodExpansion.ITEM_GROUP));
        this.beneficial = beneficial;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        playerIn.getFoodData().eat(beneficial ? 20 : -20, beneficial ? 20 : -20);
        worldIn.playSound(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5F, worldIn.random.nextFloat() * 0.1F + 0.9F);
        if (!playerIn.isCreative()) {
            item.setCount(item.getCount() - 1);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack)
    {
        return true;
    }
}
