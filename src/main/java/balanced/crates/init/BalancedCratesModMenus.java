
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package balanced.crates.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import balanced.crates.world.inventory.CrateGUIMenu;
import balanced.crates.BalancedCratesMod;

public class BalancedCratesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BalancedCratesMod.MODID);
	public static final RegistryObject<MenuType<CrateGUIMenu>> CRATE_GUI = REGISTRY.register("crate_gui",
			() -> IForgeMenuType.create(CrateGUIMenu::new));
}
