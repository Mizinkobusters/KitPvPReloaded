package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class Recover implements Listener {

	/*
	 *
	 * Recover Kit
	 *
	 */

	JavaPlugin plugin;

	public Recover(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();

		if (player.getKiller() != null && player.getKiller().getType().equals(EntityType.PLAYER)) {
			Player killer = player.getKiller();

			killer.addPotionEffect(
					new PotionEffect(PotionEffectType.REGENERATION, 300, 0, false, false));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if (kits.get(damagee.getUniqueId()).equals("Recover") && damagee.hasMetadata("combat")
				&& damagee.getHealth() <= 5) {
			Random r = new Random();
			int i = r.nextInt(9);

			switch (i) {
				case 0:
					damagee.setHealth(damagee.getHealth() + 3);
					damagee.playSound(damagee.getLocation(), Sound.LEVEL_UP, 1, 0);
					damagee.sendMessage("§aRecover Success!");
					break;
				default:
					break;
			}
		}

		if (kits.get(damager.getUniqueId()).equals("Recover")) {
			return;
		}
	}
}
