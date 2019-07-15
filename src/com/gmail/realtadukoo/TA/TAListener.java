package com.gmail.realtadukoo.TA;

import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class TAListener implements Listener{
	private final Advancement takingInventory;
	private final Advancement basicDeath;
	
	@SuppressWarnings("deprecation")
	public TAListener(TA plugin){
		takingInventory = plugin.getServer().getAdvancement(new NamespacedKey("minecraft:story", "root"));
		basicDeath = plugin.getServer().getAdvancement(new NamespacedKey("tadukoo_advancements:ways_to_die", "many_ways_to_die"));
	}
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerOpenInventory(InventoryOpenEvent e){
		Player player = (Player) e.getPlayer();
		if(!player.getAdvancementProgress(takingInventory).isDone()){
			player.getAdvancementProgress(takingInventory).awardCriteria("open_inventory");
		}
	}
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerDeath(PlayerDeathEvent e){
		Player player = e.getEntity();
		if(!player.getAdvancementProgress(basicDeath).isDone()){
			player.getAdvancementProgress(basicDeath).awardCriteria("death");
		}
	}
}
