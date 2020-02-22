package mb.mizinkobusters.kitpvp.timer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class FastRespawnTimer extends BukkitRunnable {

	JavaPlugin plugin;
	private SelectGUI kits;
	private Player player;
	String prefix = "§7[§dKitPvP§7] ";

	public FastRespawnTimer(KitPvP plugin, SelectGUI kits, Player player) {
		this.plugin = plugin;
		this.kits = kits;
		this.player = player;
	}

	public void run() {
		if (player.hasMetadata("fastrespawn")) {
			player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
			player.sendMessage(prefix + "§aリスポーンしました!");
			player.removeMetadata("fastrespawn", plugin);
			player.removeMetadata("combat", plugin);
			kits.getKits().remove(player.getUniqueId());
			kits.getKits().put(player.getUniqueId(), "");
		} else {
			this.cancel();
		}
	}

}
