package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerHasEntriesListener extends BukkitRunnable implements Listener {

	String prefix = "§7[§dKitPvP§7] ";

	JavaPlugin plugin;

	public PlayerHasEntriesListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
	Player player;

	@Override
	public void run() {
		for (Team teams : sb.getTeams()) {
			if (!teams.hasEntry(player.getName())) {
				player.sendMessage(prefix + "§eチーム申請は破棄されました");
			}
		}
	}
}
