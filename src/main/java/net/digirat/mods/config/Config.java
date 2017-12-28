package net.digirat.mods.config;

import org.apache.logging.log4j.Level;

import net.digirat.mods.References;
import net.digirat.mods.proxies.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

	//These values below you can access elsewhere in your mod:
	public static boolean isThisAGoodMod = true;
	public static String yourRealName = "Bob";
	
	//Call this from CommonProxy.preInit(). It will create our config if it doesn't exist yet and read the values if it does exist.
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initDimensionConfig(cfg);
			initGeneralConfig(cfg);						
		} catch (Exception e1) {
			References.logger.log(Level.ERROR, "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(References.CATEGORY_GENERAL, "General Configuration");
		// cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
		isThisAGoodMod = cfg.getBoolean("goodMod", References.CATEGORY_GENERAL, isThisAGoodMod, "Set to false if you don't like this mod");
		yourRealName = cfg.getString("realName", References.CATEGORY_GENERAL, yourRealName, "Set your real name here");
	}
	
	private static void initDimensionConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(References.CATEGORY_DIMENSIONS, "Dimension Configuration");
	}
}
