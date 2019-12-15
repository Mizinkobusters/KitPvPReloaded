package mb.mizinkobusters.kitpvp.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import mb.mizinkobusters.kitpvp.KitPvP;

public class Disband implements CommandExecutor {

	String prefix = "§7[§dKitPvP§7] ";

	JavaPlugin plugin;

	public Disband(KitPvP plugin) {
		this.plugin = plugin;
	}

	Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
	Team black;
	Team dark_blue;
	Team dark_green;
	Team dark_aqua;
	Team dark_red;
	Team dark_purple;
	Team gold;
	Team gray;
	Team dark_gray;
	Team blue;
	Team green;
	Team aqua;
	Team red;
	Team light_purple;
	Team yellow;

	Request request = new Request((KitPvP)plugin);

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage(prefix + " プレイヤーが実行してください");
		}

		int l = args.length;

		switch(l) {
		case 0:
			if(!player.getWorld().getName().equals("kitpvp")) {
				player.sendMessage(prefix + "§cこのコマンドはこのエリアでは使用できません");
			}

			for(Team teams : sb.getTeams()) {
				if(teams.hasEntry(player.getName())) {
					for(OfflinePlayer teammates : teams.getPlayers()) {
						teammates.getPlayer().sendMessage(prefix + "§aチームが解散されました");
						teams.removePlayer(teammates);
					}
				}
			}
			break;
		default:
			break;
		}
		return true;
	}
}
