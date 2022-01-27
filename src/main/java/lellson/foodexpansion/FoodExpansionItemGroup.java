package lellson.foodexpansion;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class FoodExpansionItemGroup extends CreativeModeTab {

    public FoodExpansionItemGroup() {
        super("foodexpansion_tab");
    }

    @Nonnull
	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack(FoodItems.BACON_AND_EGG.get());
	}
}
