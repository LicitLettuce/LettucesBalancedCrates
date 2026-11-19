package net.lettuce.balancedcrates.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, "balanced_crates");

    public static final Supplier<SoundEvent> CRATE_OPEN = register("block.crate.open");
    public static final Supplier<SoundEvent> CRATE_CLOSE = register("block.crate.close");

    private static Supplier<SoundEvent> register(String name) {
        return SOUNDS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("balanced_crates", name)));
    }
}
