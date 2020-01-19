package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Blizzard implements Listener {

	/*
	 *
	 * Blizzard Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Blizzard(KitPvP plugin, SelectGUI kits) {
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
		int i = r.nextInt(7);

		if (kits.getKits().get(damagee.getUniqueId()).equals("Blizzard")) {
			return;
		}

		if (damager instanceof Player)
			damager = (Player) damager;

		if (damager == null)
			return;

		if (kits.getKits().get(damager.getUniqueId()).equals("Blizzard") && !event.isCancelled()) {

			switch (i) {
				case 0:
					damagee.addPotionEffect(
							new PotionEffect(PotionEffectType.SLOW, 60, 3, false, false));
					damagee.playSound(damagee.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 0);
					damager.playSound(damager.getLocation(), Sound.GLASS, 1, 0);
					damager.sendMessage("§3Freeze Success!");
					break;
				default:
					break;
			}
		}
	}

}
