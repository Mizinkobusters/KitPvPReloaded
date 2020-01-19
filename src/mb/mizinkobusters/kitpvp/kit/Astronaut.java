package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.DistributeKits;

public class Astronaut implements Listener {

	/*
	 *
	 * Astronaut Kit
	 *
	 */

	JavaPlugin plugin;
	DistributeKits kits;

	public Astronaut(KitPvP plugin) {
		this.plugin = plugin;
	}

	public Astronaut(DistributeKits kits) {
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();

		if (player.getKiller() != null && player.getKiller().getType().equals(EntityType.PLAYER)) {
			Player killer = player.getKiller();

			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if (kits.getKits().get(damagee.getUniqueId()).equals("Astronaut")) {
			return;
		}

		if (kits.getKits().get(damager.getUniqueId()).equals("Astronaut")) {
			return;
		}
	}
}
