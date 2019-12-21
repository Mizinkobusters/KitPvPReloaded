package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.UUID;
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
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public abstract class Kit implements Listener {

	/*
	 *
	 * Default Kit
	 *
	 */

	protected JavaPlugin plugin;
	protected String kitName;
	protected HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

	protected Kit() {
		this.plugin = KitPvP.getInstance();
		this.kitName = getClass().getSimpleName();
	}

	protected Kit(String kitName) {
		this.plugin = KitPvP.getInstance();
		this.kitName = kitName;
	}



	protected void onKill(Player killer) {
		killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
	}

	@EventHandler
	protected void onPlayerDeathEvent(PlayerDeathEvent event) {
		Player killer = event.getEntity().getKiller();

		if (killer != null && killer.getType().equals(EntityType.PLAYER)
				&& kits.get(killer.getUniqueId()).equals(kitName)) {

			onKill(killer);
		}
	}

	@EventHandler
	protected void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if (kits.get(damagee.getUniqueId()).equals(kitName)) {
			return;
		}

		if (kits.get(damager.getUniqueId()).equals(kitName)) {
			return;
		}
	}
}
