package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.Random;
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

public class Lightning implements Listener {

	/*
	 *
	 * Lightning Kit
	 *
	 */

	JavaPlugin plugin;

	public Lightning(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

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
		Random r = new Random();
		int i = r.nextInt(6);

		if (kits.get(damagee.getUniqueId()).equals("Lightning")) {
			return;
		}

		if (kits.get(damager.getUniqueId()).equals("Lightning") && damager.hasMetadata("combat")
				&& i == 0) {
			Random d = new Random();
			int di = d.nextInt(5);
			damagee.getWorld().strikeLightningEffect(damagee.getLocation());
			damagee.damage(di + 5);

		}

	}

	/*
	 * @EventHandler public void onDamageNotEntity(EntityDamageEvent event) { Player damagee =
	 * (Player) event.getEntity(); DamageCause cause = event.getCause();
	 * 
	 * if (kits.get(damagee.getUniqueId()).equals("Lightning") &&
	 * cause.equals(DamageCause.LIGHTNING)) { event.setCancelled(true); } }
	 */
}
