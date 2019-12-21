package mb.mizinkobusters.kitpvp.command;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerHasEntriesListener;

public class Request implements CommandExecutor {

	String prefix = "§7[§dKitPvP§7] ";

	JavaPlugin plugin;

	public Request(KitPvP plugin) {
		this.plugin = plugin;
	}

	Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

	public HashMap<UUID, UUID> send = new HashMap<UUID, UUID>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage(prefix + " プレイヤーが実行してください");
			return true;
		}


		int l = args.length;

		switch (l) {
			case 0:
				player.sendMessage(prefix + "§c引数が不足しています");
				player.sendMessage(prefix + "§c使い方: /request <player>");
				break;
			case 1:
				if (cmd.getName().equalsIgnoreCase("request")) {
					if (Bukkit.getPlayerExact(args[0]).getName() != null
							&& player.getName() != Bukkit.getPlayerExact(args[0]).getName()) {

						for (Team teams : sb.getTeams()) {
							if (teams.getEntries().size() == 0 && !teams.hasEntry(player.getName())
									&& !teams.hasEntry(Bukkit.getPlayerExact(args[0]).getName())) {
								player.sendMessage(
										prefix + "§e§o" + Bukkit.getPlayerExact(args[0]).getName()
												+ " §aにチーム申請を送信しました");
								Bukkit.getPlayerExact(args[0]).getPlayer().sendMessage(
										prefix + "§6§o" + player.getName() + " §aからチーム申請が送信されました");
								Bukkit.getPlayerExact(args[0]).getPlayer()
										.sendMessage(prefix + "§a申請を受諾するには §e/accept §aを実行してください");
								Bukkit.getPlayerExact(args[0]).getPlayer()
										.sendMessage(prefix + "§a申請は20秒後に自動的に破棄されます");

								send.put(Bukkit.getPlayerExact(args[0]).getUniqueId(),
										player.getUniqueId());

								new PlayerHasEntriesListener((KitPvP) plugin).runTaskLater(plugin,
										400);

							} else {
								player.sendMessage(prefix + "§cチーム申請の送信に失敗しました");
							}
						}
					} else {
						player.sendMessage(prefix + "§cチーム申請の送信に失敗しました");
					}
				}
				break;
			default:
				break;
		}
		return true;
	}

}
