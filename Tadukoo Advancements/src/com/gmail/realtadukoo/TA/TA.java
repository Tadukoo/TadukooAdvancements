package com.gmail.realtadukoo.TA;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class TA extends JavaPlugin{
	
	@Override
	public void onEnable(){
		getLogger().log(Level.INFO, "Tadukoo Advancements signing on!");
		getServer().getPluginManager().registerEvents(new TAListener(this), this);
	}
	
	@Override
	public void onDisable(){
		getLogger().log(Level.INFO, "Tadukoo Advancements out!");
	}
}
