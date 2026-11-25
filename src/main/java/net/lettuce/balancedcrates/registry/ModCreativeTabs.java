package net.lettuce.balancedcrates.registry;

import net.lettuce.balancedcrates.BalancedCrates;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BalancedCrates.MOD_ID);

    private static void addIfLoaded(CreativeModeTab.Output output, String modId, ItemLike... items) {
        if (!ModList.get().isLoaded(modId))
            return;
        for (ItemLike item : items)
            output.accept(item);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BALANCED_CRATES =
            REGISTRY.register("balanced_crates", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.balanced_crates.balanced_crates"))
                    .icon(() -> new ItemStack(ModItems.OAK_CRATE.get()))
                    .displayItems((parameters, output) -> {

                        output.accept(ModItems.CRATE.get());
                        output.accept(ModItems.OAK_CRATE.get());
                        output.accept(ModItems.SPRUCE_CRATE.get());
                        output.accept(ModItems.BIRCH_CRATE.get());
                        output.accept(ModItems.JUNGLE_CRATE.get());
                        output.accept(ModItems.ACACIA_CRATE.get());
                        output.accept(ModItems.DARK_OAK_CRATE.get());
                        output.accept(ModItems.MANGROVE_CRATE.get());
                        output.accept(ModItems.CHERRY_CRATE.get());
                        output.accept(ModItems.BAMBOO_CRATE.get());
                        output.accept(ModItems.CRIMSON_CRATE.get());
                        output.accept(ModItems.WARPED_CRATE.get());

                        addIfLoaded(output, "quark",
                                ModItems.AZALEA_CRATE.get(),
                                ModItems.ASHEN_CRATE.get(),
                                ModItems.TRUMPET_CRATE.get());

                        addIfLoaded(output, "atmospheric",
                                ModItems.ROSEWOOD_CRATE.get(),
                                ModItems.MORADO_CRATE.get(),
                                ModItems.YUCCA_CRATE.get(),
                                ModItems.LAUREL_CRATE.get(),
                                ModItems.ASPEN_CRATE.get(),
                                ModItems.KOUSA_CRATE.get(),
                                ModItems.GRIMWOOD_CRATE.get());

                        addIfLoaded(output, "environmental",
                                ModItems.WILLOW_CRATE.get(),
                                ModItems.PINE_CRATE.get(),
                                ModItems.PLUM_CRATE.get(),
                                ModItems.WISTERIA_CRATE.get());

                        addIfLoaded(output, "autumnity",
                                ModItems.MAPLE_CRATE.get());

                        addIfLoaded(output, "upgrade_aquatic",
                                ModItems.DRIFTWOOD_CRATE.get(),
                                ModItems.RIVER_CRATE.get());

                        addIfLoaded(output, "caverns_and_chasms",
                                ModItems.CCAZALEA_CRATE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
