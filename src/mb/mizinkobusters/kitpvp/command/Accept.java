package mb.mizinkobusters.kitpvp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import mb.mizinkobusters.kitpvp.KitPvP;

public class Accept implements CommandExecutor {

	String prefix = "§7[§dKitPvP§7] ";

	JavaPlugin plugin;

	public Accept(KitPvP plugin) {
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

	Request request = new Request((KitPvP) plugin);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage(prefix + " プレイヤーが実行してください");
		}

		int l = args.length;

		switch (l) {
			case 0:
				if (!player.getWorld().getName().equals("kitpvp")) {
					player.sendMessage(prefix + "§cこのコマンドはこのエリアでは使用できません");
				}
				for (Team teams : sb.getTeams()) {
					if (!teams.hasEntry(player.getName()) && !teams.hasEntry(
							Bukkit.getPlayer(request.send.getOrDefault(player.getUniqueId(), null))
									.getName())) {
						if (teams.getEntries().size() == 0) {

							switch (teams.getName()) {
								case "black":
									black.addEntry(player.getName());
									black.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§0 Black §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§0 Black §aです");
									break;
								case "dark_blue":
									dark_blue.addEntry(player.getName());
									dark_blue.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§1 Dark_Blue §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§1 Dark_Blue §aです");
									break;
								case "dark_green":
									dark_green.addEntry(player.getName());
									dark_green.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§2 Dark_Green §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§2 Dark_Green §aです");
									break;
								case "dark_aqua":
									dark_aqua.addEntry(player.getName());
									dark_aqua.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§3 Dark_Aqua §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§3 Dark_Aqua §aです");
									break;
								case "dark_red":
									dark_red.addEntry(player.getName());
									dark_red.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§4 Dark_Red §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§4 Dark_Red §aです");
									break;
								case "dark_purple":
									dark_purple.addEntry(player.getName());
									dark_purple.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§5 Dark_Purple §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§5 Dark_Purple §aです");
									break;
								case "gold":
									gold.addEntry(player.getName());
									gold.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§6 Gold §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§6 Gold §aです");
									break;
								case "gray":
									gray.addEntry(player.getName());
									gray.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§7 Gray §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§7 Gray §aです");
									break;
								case "dark_gray":
									dark_gray.addEntry(player.getName());
									dark_gray.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§8 Dark_Gray §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§8 Dark_Gray §aです");
									break;
								case "blue":
									blue.addEntry(player.getName());
									blue.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§9 Blue §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§9 Blue §aです");
									break;
								case "green":
									green.addEntry(player.getName());
									green.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§a Green §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§a Green §aです");
									break;
								case "aqua":
									aqua.addEntry(player.getName());
									aqua.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§b Aqua §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§b Aqua §aです");
									break;
								case "red":
									red.addEntry(player.getName());
									red.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§c Red §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§c Red §aです");
									break;
								case "light_purple":
									light_purple.addEntry(player.getName());
									light_purple.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§d Light_Purple §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§d Light_Purple §aです");
									break;
								case "yellow":
									yellow.addEntry(player.getName());
									yellow.addEntry(Bukkit
											.getPlayer(request.send
													.getOrDefault(player.getUniqueId(), null))
											.getName());
									player.sendMessage(
											prefix + "§6§o"
													+ Bukkit.getPlayer(request.send.getOrDefault(
															player.getUniqueId(), null)).getName()
													+ " §aとチームを組みました");
									player.sendMessage(prefix + "§aあなたのチームは§e Yellow §aです");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§6§o" + player.getName()
													+ " §aとチームを組みました");
									Bukkit.getPlayer(
											request.send.getOrDefault(player.getUniqueId(), null))
											.sendMessage(prefix + "§aあなたのチームは§e Yellow §aです");
									break;
							}

							/*
							 * if(black.getEntries().size() == 0) {
							 * black.addEntry(player.getName());
							 * black.addEntry(Bukkit.getPlayer(request.send.getOrDefault(player.
							 * getUniqueId(), null)).getName()); player.sendMessage(prefix + "§6§o"
							 * + Bukkit.getPlayer(request.send.getOrDefault(player.getUniqueId(),
							 * null)).getName() + " §aとチームを組みました"); player.sendMessage(prefix +
							 * "§aあなたのチームは§0 Black §aです");
							 * Bukkit.getPlayer(request.send.getOrDefault(player.getUniqueId(),
							 * null)).sendMessage(prefix + "§6§o" + player.getName() +
							 * " §aとチームを組みました");
							 * Bukkit.getPlayer(request.send.getOrDefault(player.getUniqueId(),
							 * null)).sendMessage(prefix + "§aあなたのチームは§0 Black §aです"); }
							 */

							player.sendMessage(prefix + "§f[Debug] §a正常にチームを組みました");
						} else {
							player.sendMessage(prefix + "§cこれ以上チームを組むことはできません");
						}
					} else {
						player.sendMessage(prefix + "§cこれ以上チームを組むことはできません");
					}
				}
				break;
			default:
				break;
		}

		return true;
	}

}
