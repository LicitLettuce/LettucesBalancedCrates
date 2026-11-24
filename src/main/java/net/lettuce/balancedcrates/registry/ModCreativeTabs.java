package net.lettuce.balancedcrates.registry;

import net.lettuce.balancedcrates.BalancedCrates;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BalancedCrates.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BALANCED_CRATES =
            REGISTRY.register("balanced_crates", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.balanced_crates.balanced_crates"))
                    .icon(() -> new ItemStack(ModItems.OAK_CRATE.get()))
                    .displayItems((parameters, output) -> {

                        // Vanilla
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

                        // Atmospheric
                        output.accept(ModItems.ROSEWOOD_CRATE.get());
                        output.accept(ModItems.MORADO_CRATE.get());
                        output.accept(ModItems.YUCCA_CRATE.get());
                        output.accept(ModItems.LAUREL_CRATE.get());
                        output.accept(ModItems.ASPEN_CRATE.get());
                        output.accept(ModItems.KOUSA_CRATE.get());
                        output.accept(ModItems.GRIMWOOD_CRATE.get());

                        // Environmental
                        output.accept(ModItems.WILLOW_CRATE.get());
                        output.accept(ModItems.PINE_CRATE.get());
                        output.accept(ModItems.PLUM_CRATE.get());
                        output.accept(ModItems.WISTERIA_CRATE.get());

                        // Autumnity
                        output.accept(ModItems.MAPLE_CRATE.get());

                        // Upgrade Aquatic
                        output.accept(ModItems.DRIFTWOOD_CRATE.get());
                        output.accept(ModItems.RIVER_CRATE.get());

                        // Caverns & Chasms
                        output.accept(ModItems.CCAZALEA_CRATE.get());

                        // Your existing entries
                        output.accept(ModItems.AZALEA_CRATE.get());
                        output.accept(ModItems.ASHEN_CRATE.get());
                        output.accept(ModItems.TRUMPET_CRATE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
