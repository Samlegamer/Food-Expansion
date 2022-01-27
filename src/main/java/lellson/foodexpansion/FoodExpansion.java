package lellson.foodexpansion;

import lellson.foodexpansion.config.ConfigHelper;
import lellson.foodexpansion.config.ConfigHolder;
import lellson.foodexpansion.crafting.conditions.ConfigEnabledCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

@Mod(Reference.MODID)
public class FoodExpansion {
    public static final CreativeModeTab ITEM_GROUP = new FoodExpansionItemGroup();
    public static final Map<Class<?>, Drop> DROP_LIST = new HashMap<>();

    public static FoodExpansion instance;

    public FoodExpansion() {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        FoodBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FoodItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        FoodItems.increaseStackSizes();

        addDrop(FoodExpansionConfig.disableSquidDrop, Squid.class, FoodItems.SQUID.get(), FoodItems.COOKED_SQUID.get(), 2);
        addDrop(FoodExpansionConfig.disableHorseMeatDrop, Horse.class, FoodItems.HORSE_MEAT.get(), FoodItems.COOKED_HORSE_MEAT.get(), 3, true);
        addDrop(FoodExpansionConfig.disableBatWingDrop, Bat.class, FoodItems.BAT_WING.get(), FoodItems.COOKED_BAT_WING.get(), 1);
        addDrop(FoodExpansionConfig.disableWolfMeatDrop, Wolf.class, FoodItems.WOLF_MEAT.get(), FoodItems.COOKED_WOLF_MEAT.get(), 2, true);
        addDrop(FoodExpansionConfig.disableOcelotMeatDrop, Ocelot.class, FoodItems.OCELOT_MEAT.get(), FoodItems.COOKED_OCELOT_MEAT.get(), 1, true);
        addDrop(FoodExpansionConfig.disableParrotMeatDrop, Parrot.class, FoodItems.PARROT_MEAT.get(), FoodItems.COOKED_PARROT_MEAT.get(), 1, true);
        addDrop(FoodExpansionConfig.disableLlamaMeatDrop, Llama.class, FoodItems.LLAMA_MEAT.get(), FoodItems.COOKED_LLAMA_MEAT.get(), 2, true);
        addDrop(FoodExpansionConfig.disablePolarBearMeatDrop, PolarBear.class, FoodItems.POLAR_BEAR_MEAT.get(), FoodItems.COOKED_POLAR_BEAR_MEAT.get(), 3, true);
        addDrop(FoodExpansionConfig.disableGoatMeatDrop, Goat.class, FoodItems.GOAT_MEAT.get(), FoodItems.COOKED_GOAT_MEAT.get(), 1, true);
        addDrop(FoodExpansionConfig.disableGlowSquidDrop, EntityType.GLOW_SQUID.getBaseClass(), FoodItems.GLOW_SQUID.get(), FoodItems.COOKED_GLOW_SQUID.get(), 2);

    }

    private void onClientSetup(final FMLClientSetupEvent event){}

    private void addDrop(boolean cfgDisable, Class<?> entityClass, Item uncooked, Item cooked, int maxDropAmount) {
        addDrop(cfgDisable, entityClass, uncooked, cooked, maxDropAmount, false);
    }

    private void addDrop(boolean cfgDisable, Class<?> entityClass, Item uncooked, Item cooked, int maxDropAmount, boolean alwaysDrop) {
        DROP_LIST.put(entityClass, new Drop(cfgDisable, uncooked, cooked, maxDropAmount, alwaysDrop));
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class FoodRegistry {

        @SubscribeEvent
        public static void onModConfig(final ModConfigEvent event) {
            final ModConfig config = event.getConfig();
            if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
                ConfigHelper.bakeCommon(config);
            }
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            FoodBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(ITEM_GROUP)).setRegistryName(block.getRegistryName()));
            });
        }

        @SubscribeEvent
        public static void registerRecipeSerializers(final RegistryEvent.Register<RecipeSerializer<?>> event) {
            CraftingHelper.register(ConfigEnabledCondition.Serializer.INSTANCE);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeRegistry {

        @SubscribeEvent
        public static void onLivingDrops(final LivingDropsEvent event) {
            if (!event.getEntityLiving().isBaby()) {
                for (Class<?> entityClass : DROP_LIST.keySet()) {
                    if (entityClass.isInstance(event.getEntityLiving())) {
                        ItemEntity item = DROP_LIST.get(entityClass).getDrop(event.getEntityLiving());
                        if (item != null) {
                            event.getDrops().add(item);
                        }
                        break;
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onLivingEntityUseItem(LivingEntityUseItemEvent.Finish event) {
            if (event.getEntityLiving() instanceof Player) {
            	Player player = (Player) event.getEntityLiving();

                if (isBowl(event.getItem().getItem()) && !player.isCreative()) {
                    ItemStack result = event.getResultStack().copy();
                    ItemStack itemStack = event.getItem().copy();
                    itemStack.setCount(itemStack.getCount() - 1);
                    event.setResultStack(itemStack);
                    if (itemStack.isEmpty()) {
                        event.setResultStack(result);
                    } else if (!player.getInventory().add(result.copy())) {
                        player.drop(result, false);
                    }
                }
            }
        }

        private static boolean isBowl(Item item) {
            for (String s : FoodExpansionConfig.bowlStackSizeItems) {
                Item bowl = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));

                if (bowl != null && bowl.equals(item)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static class Drop {
        public boolean cfgDisable, alwaysDrop;
        public Item uncooked, cooked;
        public int maxDropAmount;

        public Drop(boolean cfgDisable, Item uncooked, Item cooked, int maxDropAmount, boolean alwaysDrop) {
            this.cfgDisable = cfgDisable;
            this.uncooked = uncooked;
            this.cooked = cooked;
            this.maxDropAmount = maxDropAmount;
            this.alwaysDrop = alwaysDrop;
        }

        public ItemEntity getDrop(LivingEntity entity) {
            if (!cfgDisable) {
                int count = alwaysDrop ? entity.level.random.nextInt(maxDropAmount) + 1 : entity.level.random.nextInt(maxDropAmount + 1);
                if (count > 0) {
                    return new ItemEntity(entity.level, entity.getX(), entity.getY() + 0.5D, entity.getZ(), new ItemStack(entity.isBlocking() ? cooked : uncooked, count));
                }
            }
            return null;
        }
    }
}
