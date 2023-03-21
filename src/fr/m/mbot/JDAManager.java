package fr.m.mbot;

import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.ShardManager;

public class JDAManager {
	
	private static ShardManager shardManager = buildShard();

	public static ShardManager getShardManager() {
		return shardManager;
	}
	
	private static ShardManager buildShard() {
		
		try {
			ShardManager shard  = new DefaultShardManager("token");
			shard.addEventListener(new BotListener());
			return shard;
					
					
					/*.setToken()
					.setShardsTotal(1)
					.addEventListeners(new BotListener())
					.build();*/
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
