package fr.m.mbot;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.dv8tion.jda.api.entities.Activity;

public class BukkitListener implements Listener {
	private Main main;
	
	public BukkitListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	 public void PlayerJoin(PlayerJoinEvent event) {
		JDAManager.getShardManager().setActivity(Activity.listening(Bukkit.getOnlinePlayers().size() + "/"+ Bukkit.getMaxPlayers() +" joueurs"));
		
		
	}
	
	
	@EventHandler
	public void PlayerLeft(PlayerQuitEvent event) {
		JDAManager.getShardManager().setActivity(Activity.listening(Bukkit.getOnlinePlayers().size()-1 + "/"+ Bukkit.getMaxPlayers() +" joueurs"));
	}
}
