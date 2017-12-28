package net.digirat.mods.blocks;

import net.digirat.mods.blocks.*;
import net.digirat.mods.blocks.testcontainer.TestContainerBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	@GameRegistry.ObjectHolder("testmod:firstblock")
	public static FirstBlock firstBlock;
	
	@GameRegistry.ObjectHolder("testmod:datablock")
	public static DataBlock dataBlock;
	
	@GameRegistry.ObjectHolder("testmod:blinkingblock")
	public static BlinkingBlock blinkingBlock;
	
	@GameRegistry.ObjectHolder("testmod:testcontainerblock")
	public static TestContainerBlock testContainerBlock;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		firstBlock.initModel();
		dataBlock.initModel();
		blinkingBlock.initModel();
		testContainerBlock.initModel();
	}
}
