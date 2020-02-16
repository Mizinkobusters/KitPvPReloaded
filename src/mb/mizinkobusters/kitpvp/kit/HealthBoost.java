package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class HealthBoost implements Listener {

	/*
	 *
	 * HealthBoost Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public HealthBoost(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("HealthBoost")) {

			if (killer.getMaxHealth() < 26) {
				killer.setMaxHealth(killer.getMaxHealth() + 1);
				killer.setHealth(killer.getMaxHealth());
			}
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

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("HealthBoost")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("HealthBoost")) {
			return;
		}
	}
}
