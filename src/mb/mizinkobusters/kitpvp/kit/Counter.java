package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class Counter implements Listener {

	/*
	 *
	 * Counter Kit
	 *
	 */

	JavaPlugin plugin;

	public Counter(KitPvP plugin) {
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

		DamageCause cause = event.getCause();
		double d = event.getDamage();
		Random r = new Random();
		int i = r.nextInt(5);

		if (cause.equals(DamageCause.ENTITY_ATTACK) && damager != null) {
			if (kits.get(damagee.getUniqueId()).equals("Counter")
					&& damagee.hasMetadata("combat")) {

				switch (i) {
					case 1:
						event.setDamage(d / 2);
						damager.damage(d / 2);
						damagee.playSound(damagee.getLocation(), Sound.ANVIL_LAND, 1, 1);
						damagee.sendMessage("§aCounter Success!");
						break;
					default:
						break;
				}

			}
		} else if (cause.equals(DamageCause.PROJECTILE)
				&& damager.getType().equals(EntityType.ARROW)) {
			Arrow arrow = (Arrow) damager;
			Player shooter = (Player) arrow.getShooter();
			if (kits.get(shooter.getUniqueId()).equals("Counter")
					&& shooter.hasMetadata("combat")) {

				switch (i) {
					case 1:
						event.setDamage(d / 2);
						shooter.damage(d / 2);
						damagee.playSound(damagee.getLocation(), Sound.ANVIL_LAND, 1, 1);
						damagee.sendMessage("§aCounter Success!");
						break;
					default:
						break;
				}
			}
		}

		if (kits.get(damager.getUniqueId()).equals("Counter")) {
			return;
		}
	}
}
