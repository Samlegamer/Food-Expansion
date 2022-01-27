package lellson.foodexpansion;

import org.apache.logging.log4j.LogManager;

import lellson.foodexpansion.items.BasicFoodItem;
import lellson.foodexpansion.items.ForbiddenFruitItem;
import lellson.foodexpansion.items.LollipopItem;
import lellson.foodexpansion.items.NetherWartSoupItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoodItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> JELLY = ITEMS.register("jelly", () -> new BasicFoodItem(FoodTypes.JELLY));
    public static final RegistryObject<Item> BACON = ITEMS.register("bacon", () -> new BasicFoodItem(FoodTypes.BACON));
    public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new BasicFoodItem(FoodTypes.COOKED_BACON));
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new BasicFoodItem(FoodTypes.FRIED_EGG));
    public static final RegistryObject<Item> BACON_AND_EGG = ITEMS.register("bacon_and_egg", () -> new BasicFoodItem(FoodTypes.BACON_AND_EGG));
    public static final RegistryObject<Item> CARROT_SEED_SOUP = ITEMS.register("carrot_seed_soup", () -> new BasicFoodItem(FoodTypes.CARROT_SEED_SOUP, true));
    public static final RegistryObject<Item> SQUID = ITEMS.register("squid", () -> new BasicFoodItem(FoodTypes.SQUID));
    public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid", () -> new BasicFoodItem(FoodTypes.COOKED_SQUID));
    public static final RegistryObject<Item> COMPRESSED_FLESH = ITEMS.register("compressed_flesh", () -> new BasicFoodItem(FoodTypes.COMPRESSED_FLESH));
    public static final RegistryObject<Item> CHOCOLATE_BAR = ITEMS.register("chocolate_bar", () -> new BasicFoodItem(FoodTypes.CHOCOLATE_BAR));
    public static final RegistryObject<Item> SPIDER_SOUP = ITEMS.register("spider_soup", () -> new BasicFoodItem(FoodTypes.SPIDER_SOUP, true));
    public static final RegistryObject<Item> NETHER_WART_SOUP = ITEMS.register("nether_wart_soup", NetherWartSoupItem::new);
    public static final RegistryObject<Item> CACTUS_FRUIT = ITEMS.register("cactus_fruit", () -> new BasicFoodItem(FoodTypes.CACTUS_FRUIT));
    public static final RegistryObject<Item> HORSE_MEAT = ITEMS.register("horse_meat", () -> new BasicFoodItem(FoodTypes.HORSE_MEAT));
    public static final RegistryObject<Item> COOKED_HORSE_MEAT = ITEMS.register("cooked_horse_meat", () -> new BasicFoodItem(FoodTypes.COOKED_HORSE_MEAT));
    public static final RegistryObject<Item> COOKED_MUSHROOM = ITEMS.register("cooked_mushroom", () -> new BasicFoodItem(FoodTypes.COOKED_MUSHROOM));
    public static final RegistryObject<Item> CARROT_PIE = ITEMS.register("carrot_pie", () -> new BasicFoodItem(FoodTypes.CARROT_PIE));
    public static final RegistryObject<Item> BAT_WING = ITEMS.register("bat_wing", () -> new BasicFoodItem(FoodTypes.BAT_WING));
    public static final RegistryObject<Item> COOKED_BAT_WING = ITEMS.register("cooked_bat_wing", () -> new BasicFoodItem(FoodTypes.COOKED_BAT_WING));
    public static final RegistryObject<Item> BLAZE_CREAM = ITEMS.register("blaze_cream", () -> new BasicFoodItem(FoodTypes.BLAZE_CREAM, true));
    public static final RegistryObject<Item> MELON_SALAD = ITEMS.register("melon_salad", () -> new BasicFoodItem(FoodTypes.MELON_SALAD, true));
    public static final RegistryObject<Item> ROASTED_SEED = ITEMS.register("roasted_seed", () -> new BasicFoodItem(FoodTypes.ROASTED_SEED));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", () -> new Item(new Item.Properties().tab(FoodExpansion.ITEM_GROUP)));
    public static final RegistryObject<Item> WOLF_MEAT = ITEMS.register("wolf_meat", () -> new BasicFoodItem(FoodTypes.WOLF_MEAT));
    public static final RegistryObject<Item> COOKED_WOLF_MEAT = ITEMS.register("cooked_wolf_meat", () -> new BasicFoodItem(FoodTypes.COOKED_WOLF_MEAT));
    public static final RegistryObject<Item> OCELOT_MEAT = ITEMS.register("ocelot_meat", () -> new BasicFoodItem(FoodTypes.OCELOT_MEAT));
    public static final RegistryObject<Item> COOKED_OCELOT_MEAT = ITEMS.register("cooked_ocelot_meat", () -> new BasicFoodItem(FoodTypes.COOKED_OCELOT_MEAT));
    public static final RegistryObject<Item> LOLLIPOP = ITEMS.register("lollipop", LollipopItem::new);
    public static final RegistryObject<Item> BEETROOT_NOODLES = ITEMS.register("beetroot_noodles", () -> new BasicFoodItem(FoodTypes.BEETROOT_NOODLES, true));
    public static final RegistryObject<Item> PARROT_MEAT = ITEMS.register("parrot_meat", () -> new BasicFoodItem(FoodTypes.PARROT_MEAT));
    public static final RegistryObject<Item> COOKED_PARROT_MEAT = ITEMS.register("cooked_parrot_meat", () -> new BasicFoodItem(FoodTypes.COOKED_PARROT_MEAT));
    public static final RegistryObject<Item> LLAMA_MEAT = ITEMS.register("llama_meat", () -> new BasicFoodItem(FoodTypes.LLAMA_MEAT));
    public static final RegistryObject<Item> COOKED_LLAMA_MEAT = ITEMS.register("cooked_llama_meat", () -> new BasicFoodItem(FoodTypes.COOKED_LLAMA_MEAT));
    public static final RegistryObject<Item> POLAR_BEAR_MEAT = ITEMS.register("polar_bear_meat", () -> new BasicFoodItem(FoodTypes.POLAR_BEAR_MEAT));
    public static final RegistryObject<Item> COOKED_POLAR_BEAR_MEAT = ITEMS.register("cooked_polar_bear_meat", () -> new BasicFoodItem(FoodTypes.COOKED_POLAR_BEAR_MEAT));

    //NEW FOOD ITEMS
    public static final RegistryObject<Item> VEGGIE_STEW = ITEMS.register("veggie_stew", () -> new BasicFoodItem(FoodTypes.VEGGIE_STEW, true));
    public static final RegistryObject<Item> BAT_SOUP = ITEMS.register("bat_soup", () -> new BasicFoodItem(FoodTypes.BAT_SOUP, true));
    public static final RegistryObject<Item> GOLDEN_FEAST = ITEMS.register("golden_feast", () -> new BasicFoodItem(FoodTypes.GOLDEN_FEAST));

    public static final RegistryObject<Item> FORBIDDEN_FRUIT = ITEMS.register("forbidden_fruit", () -> new ForbiddenFruitItem(true));
    public static final RegistryObject<Item> STARVING_FRUIT = ITEMS.register("starving_fruit", () -> new ForbiddenFruitItem(false));

    //1.18.1
    public static final RegistryObject<Item> GLOW_SQUID = ITEMS.register("glow_squid", () -> new BasicFoodItem(FoodTypes.GLOW_SQUID));
    public static final RegistryObject<Item> COOKED_GLOW_SQUID = ITEMS.register("cooked_glow_squid", () -> new BasicFoodItem(FoodTypes.GLOW_COOKED_SQUID));
    public static final RegistryObject<Item> GOAT_MEAT = ITEMS.register("goat_meat", () -> new BasicFoodItem(FoodTypes.GOAT_MEAT));
    public static final RegistryObject<Item> COOKED_GOAT_MEAT = ITEMS.register("cooked_goat_meat", () -> new BasicFoodItem(FoodTypes.COOKED_GOAT_MEAT));

    public static void increaseStackSizes()
    {
        for (String s : FoodExpansionConfig.bowlStackSizeItems) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
            if (item != null) {
                LogManager.getLogger(Reference.MODID).info("Food Expansion: Increasing stack of " + s + "...");
                item.maxStackSize = 64;
            } else {
                LogManager.getLogger(Reference.MODID).warn("Food Expansion: Couldn't increase stack size. " + s + " is not a valid item!");
            }
        }
    }
}
