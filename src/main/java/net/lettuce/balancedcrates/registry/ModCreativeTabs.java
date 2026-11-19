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
                        output.accept(ModItems.PALE_OAK_CRATE.get());
                        output.accept(ModItems.CRIMSON_CRATE.get());
                        output.accept(ModItems.WARPED_CRATE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
