package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Standard implements Listener {

	/*
	 *
	 * Standard Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Standard(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Standard")) {
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

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Standard")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Standard")) {
			return;
		}
	}

	@EventHandler
	public void onEatGapple(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (kits.getKits().getOrDefault(player.getUniqueId(), null).equals("Standard")
				&& item.getType().equals(Material.GOLDEN_APPLE)) {
			if (player.hasPotionEffect(PotionEffectType.SPEED)) {
				player.removePotionEffect(PotionEffectType.SPEED);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.SPEED, 600, 0, false, false));
			} else {
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.SPEED, 600, 0, false, false));
			}
		}
	}
}
