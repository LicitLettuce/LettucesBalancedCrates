package net.lettuce.balancedcrates.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public final class CrateVariants {
    private static final String OPEN_PREFIX = "open_";

    private static Map<Block, Block> closedToOpen;
    private static Map<Block, Block> openToClosed;

    private CrateVariants() {}

    public static Block openVersionOf(Block closed) {
        ensureBuilt();
        return closedToOpen.get(closed);
    }

    public static Block closedVersionOf(Block open) {
        ensureBuilt();
        return openToClosed.get(open);
    }

    private static synchronized void ensureBuilt() {
        if (closedToOpen != null)
            return;

        Map<String, Block> byName = new HashMap<>();
        for (Block block : ModBlocks.allCrates())
            byName.put(BuiltInRegistries.BLOCK.getKey(block).getPath(), block);

        Map<Block, Block> toOpen = new HashMap<>();
        Map<Block, Block> toClosed = new HashMap<>();
        for (Map.Entry<String, Block> entry : byName.entrySet()) {
            String name = entry.getKey();
            if (!name.startsWith(OPEN_PREFIX))
                continue;
            Block closed = byName.get(name.substring(OPEN_PREFIX.length()));
            if (closed == null)
                throw new IllegalStateException("Open crate '" + name + "' has no closed counterpart");
            toOpen.put(closed, entry.getValue());
            toClosed.put(entry.getValue(), closed);
        }

        openToClosed = Map.copyOf(toClosed);
        closedToOpen = Map.copyOf(toOpen);
    }
}