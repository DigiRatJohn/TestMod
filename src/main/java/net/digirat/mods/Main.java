package net.digirat.mods;

import net.digirat.mods.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME, dependencies = "required-after:forge@[14.23.1.2554,)", useMetadata = true)
public class Main
{
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static Main instance;   
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        References.logger = event.getModLog();
        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    	
    }
}
