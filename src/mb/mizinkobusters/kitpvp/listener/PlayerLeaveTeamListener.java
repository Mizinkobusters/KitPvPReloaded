package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerLeaveTeamListener implements Listener {

	String prefix = "§7[§dKitPvP§7] ";

	JavaPlugin plugin;

	public PlayerLeaveTeamListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		for (Team teams : sb.getTeams()) {
			if (teams.hasPlayer(player)) {
				for (OfflinePlayer teammates : teams.getPlayers()) {
					teammates.getPlayer().sendMessage(prefix + "§aチームが解散されました");
					teams.removePlayer(teammates);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChangeWorld(PlayerChangedWorldEvent event) {
		Player player = event.getPlayer();

		for (Team teams : sb.getTeams()) {
			if (teams.hasPlayer(player)) {
				for (OfflinePlayer teammates : teams.getPlayers()) {
					teammates.getPlayer().sendMessage(prefix + "§aチームが解散されました");
					teams.removePlayer(teammates);
				}
			}
		}
	}
}
