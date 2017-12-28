package net.digirat.mods.items;

import net.digirat.mods.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FirstItem extends Item {

	public FirstItem() {
		this.setRegistryName("firstitem"); // The unique name (within your mod) that identifies this item
		this.setUnlocalizedName(References.MODID + ".firstitem"); //  Used for localization (en_us.lang)
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
