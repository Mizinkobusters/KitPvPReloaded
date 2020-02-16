package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Counter implements Listener {

	/*
	 *
	 * Counter Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Counter(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Counter")) {
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

		DamageCause cause = event.getCause();
		double d = event.getDamage();
		Random r = new Random();
		int i = r.nextInt(5);

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Counter")) {
			if (cause.equals(DamageCause.ENTITY_ATTACK)) {
				if (i == 0 && damager.hasMetadata("combat")) {
					event.setDamage(d / 2);
					damager.damage(d / 2);
					damagee.playSound(damagee.getLocation(), Sound.ANVIL_LAND, 1, 1);
					damagee.sendMessage("§aCounter Success!");
				}
			} else if (cause.equals(DamageCause.PROJECTILE)
					&& damager.getType().equals(EntityType.ARROW)) {
				Arrow arrow = (Arrow) damager;
				Player shooter = (Player) arrow.getShooter();

				if (i == 0 && damager.hasMetadata("combat")) {
					event.setDamage(d / 2);
					shooter.damage(d / 2);
					damagee.playSound(damagee.getLocation(), Sound.ANVIL_LAND, 1, 1);
					damagee.sendMessage("§aCounter Success!");
				}
			}
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Counter")) {
			return;
		}
	}
}
