package net.digirat.mods.proxies;

import java.io.File;

import net.digirat.mods.Main;
import net.digirat.mods.References;
import net.digirat.mods.blocks.BlinkingBlock;
import net.digirat.mods.blocks.BlinkingTileEntity;
import net.digirat.mods.blocks.DataBlock;
import net.digirat.mods.blocks.DataTileEntity;
import net.digirat.mods.blocks.FirstBlock;
import net.digirat.mods.blocks.ModBlocks;
import net.digirat.mods.blocks.testcontainer.TestContainerBlock;
import net.digirat.mods.blocks.testcontainer.TestContainerTileEntity;
import net.digirat.mods.config.Config;
import net.digirat.mods.items.FirstItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	//Config instance
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "testmod.cfg"));
		Config.readConfig();
	}
	
	public void init(FMLInitializationEvent e) {		
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiProxy());
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new FirstBlock());
		event.getRegistry().register(new DataBlock());
		GameRegistry.registerTileEntity(DataTileEntity.class, References.MODID + "_datablock");
		event.getRegistry().register(new BlinkingBlock());
		GameRegistry.registerTileEntity(BlinkingTileEntity.class, References.MODID + "_blinkingblock");
		event.getRegistry().register(new TestContainerBlock());
		GameRegistry.registerTileEntity(TestContainerTileEntity.class, References.MODID + "_testcontainerblock");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		
		//Items
		event.getRegistry().register(new FirstItem());
		
		//Blocks
		event.getRegistry().register(new ItemBlock(ModBlocks.firstBlock).setRegistryName(ModBlocks.firstBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.dataBlock).setRegistryName(ModBlocks.dataBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.blinkingBlock).setRegistryName(ModBlocks.blinkingBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.testContainerBlock).setRegistryName(ModBlocks.testContainerBlock.getRegistryName()));
	}
	
}
