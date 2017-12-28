package net.digirat.mods;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;

public class References {
	
	//Mod Strings
	public static final String MODID = "testmod";
	public static final String NAME = "Test Mod";
	public static final String VERSION = "0.0.1";
	
	//Proxy Strings
	public static final String SERVER_PROXY = "net.digirat.mods.proxies.ServerProxy";
	public static final String CLIENT_PROXY = "net.digirat.mods.proxies.ClientProxy";
	public static final String GUI_PROXY = "net.digirat.mods.proxies.GuiProxy";
	
	//Config Stuff
	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_DIMENSIONS = "dimensions";
	
	//Logger Stuff
	public static Logger logger;
}
