package fr.m.mbot;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main extends JavaPlugin {
	
	private JDA jda;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		jda = JDAManager.buildJDA(getConfig().getString("Token"));
		jda.getPresence().setActivity(Activity.listening(Bukkit.getOnlinePlayers().size() + "/"+ Bukkit.getMaxPlayers() +" joueurs"));
		getCommand("discord").setExecutor(new DiscordCommand(this));
		getCommand("discordReload").setExecutor(new RlCommand());
		Bukkit.getPluginManager().registerEvents(new BukkitListener(this), this);
		
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}
	
	
	public JDA getJDA() {
		return jda;
	}
	
	public class RlCommand implements CommandExecutor {

		@Override
		public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
			reloadConfig();
			sender.sendMessage("§aConfig.yml Reload !");
			return true;
		}
	}

}
