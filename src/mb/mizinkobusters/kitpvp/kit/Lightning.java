package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
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
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Lightning implements Listener {

	/*
	 *
	 * Lightning Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Lightning(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
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
		Player damager = null;
		Random r = new Random();
		int i = r.nextInt(6);

		if (kits.getKits().get(damagee.getUniqueId()).equals("Lightning")) {
			return;
		}

		if (damager instanceof Player)
			damager = (Player) damager;

		if (damager == null)
			return;

		if (kits.getKits().get(damager.getUniqueId()).equals("Lightning") && !event.isCancelled()
				&& i == 0) {
			Random d = new Random();
			int di = d.nextInt(5);
			damagee.getWorld().strikeLightningEffect(damagee.getLocation());
			damagee.damage(di + 5);

		}

	}
}
