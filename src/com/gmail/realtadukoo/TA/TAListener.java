package com.gmail.realtadukoo.TA;

import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class TAListener implements Listener{
	private final Advancement basicDeath;
	
	@SuppressWarnings("deprecation")
	public TAListener(TA plugin){
		basicDeath = plugin.getServer().getAdvancement(new NamespacedKey("tadukoo_advancements:ways_to_die", "many_ways_to_die"));
	}
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerDeath(PlayerDeathEvent e){
		Player player = e.getEntity();
		if(!player.getAdvancementProgress(basicDeath).isDone()){
			player.getAdvancementProgress(basicDeath).awardCriteria("death");
		}
	}
}
