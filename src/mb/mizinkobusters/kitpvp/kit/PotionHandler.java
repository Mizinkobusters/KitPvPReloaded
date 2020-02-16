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

public class PotionHandler implements Listener {

	/*
	 *
	 * PotionHandler Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public PotionHandler(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("PotionHandler")) {
			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
			killer.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 16388));
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
		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("PotionHandler")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("PotionHandler")) {
			return;
		}
	}

}
