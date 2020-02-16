package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
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
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Blizzard")) {
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

		Random r = new Random();
		int i = r.nextInt(7);

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Blizzard")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Blizzard")
				&& damagee.hasMetadata("combat")) {
			if (i == 0) {
				damagee.addPotionEffect(
						new PotionEffect(PotionEffectType.SLOW, 60, 3, false, false));
				damagee.playSound(damagee.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 0);
				damager.playSound(damager.getLocation(), Sound.GLASS, 1, 0);
				damager.sendMessage("§3Freeze Success!");
			}
		}
	}
}
