package fr.m.mbot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements CommandExecutor {
	
	private Main main;
	

	public DiscordCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("§cUsage : /discord [message]");
			return false;
		}
		
		StringBuilder Msg = new StringBuilder();
		
		for(String argument : args) {
			Msg.append(argument + " ");
		}
		
		try {
			JDAManager.getShardManager().getTextChannelById(main.getConfig().getString("ChannelID")).canTalk();
		} catch (Exception e) {
			System.out.println(e);
			sender.sendMessage("§cA problem has arisen");
			return false;
		}
		
		
		JDAManager.getShardManager().getTextChannelById(main.getConfig().getString("ChannelID")).sendMessage(Msg).queue();
		sender.sendMessage("§aThe message was sent !");
		
		return true;
	}

}
