package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Sniper implements Listener {

	/*
	 *
	 * Sniper Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Sniper(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Sniper")) {
			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = null;
		if (event.getDamager() instanceof Player)
			damager = (Player) event.getDamager();
		else if (event.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getDamager();
			Player shooter = (Player) arrow.getShooter();
			damager = shooter;
		} else
			return;

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Sniper")) {
			return;
		}

		double d = event.getDamage();

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Sniper")) {
			if (damagee.hasMetadata("combat")) {
				if (Math.abs(damager.getLocation().distance(damagee.getLocation())) <= 5) {
					damager.sendMessage("§2Snipe Success! §4-4");
					if (d < 4)
						event.setDamage(0);
					else
						event.setDamage(d - 4);
				} else if (Math.abs(damager.getLocation().distance(damagee.getLocation())) > 5
						&& Math.abs(damager.getLocation().distance(damagee.getLocation())) <= 10) {
					damager.sendMessage("§2Snipe Success! §4-2");
					if (d < 2)
						event.setDamage(0);
					else
						event.setDamage(d - 2);
				} else if (Math.abs(damager.getLocation().distance(damagee.getLocation())) > 10
						&& Math.abs(damager.getLocation().distance(damagee.getLocation())) <= 15) {
					damager.sendMessage("§2Snipe Success! §4+0");
				} else if (Math.abs(damager.getLocation().distance(damagee.getLocation())) > 15
						&& Math.abs(damager.getLocation().distance(damagee.getLocation())) <= 20) {
					damager.sendMessage("§2Snipe Success! §4+1");
					event.setDamage(d + 1);
				} else if (Math.abs(damager.getLocation().distance(damagee.getLocation())) > 20) {
					damager.sendMessage("§2Snipe Success! §4+2");
					event.setDamage(d + 2);
				}
			}
		}
	}
}
