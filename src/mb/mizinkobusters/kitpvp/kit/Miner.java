package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
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
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class Miner implements Listener {

	/*
	 *
	 * Miner Kit
	 *
	 */

	JavaPlugin plugin;

	public Miner(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();

		if (player.getKiller() != null && player.getKiller().getType().equals(EntityType.PLAYER)) {
			Player killer = player.getKiller();

			Random r = new Random();
			int i = r.nextInt(5);

			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));

			switch (i) {
				case 0:
					player.addPotionEffect(
							new PotionEffect(PotionEffectType.REGENERATION, 400, 0, false, false));
					player.sendMessage("§8Minig Success!");
					player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
					break;
				case 1:
					Random r1 = new Random();
					int i1 = r1.nextInt(4);

					switch (i1) {
						case 0:
							player.addPotionEffect(
									new PotionEffect(PotionEffectType.SPEED, 400, 0, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 1:
							player.addPotionEffect(
									new PotionEffect(PotionEffectType.SPEED, 400, 1, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 2:
							player.removePotionEffect(PotionEffectType.FAST_DIGGING);
							player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
									400, 0, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 3:
							player.removePotionEffect(PotionEffectType.FAST_DIGGING);
							player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
									400, 1, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
					}
					break;
				case 2:
					Random r2 = new Random();
					int i2 = r2.nextInt(4);

					switch (i2) {
						case 0:
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.DAMAGE_RESISTANCE, 400, 0, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 1:
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.DAMAGE_RESISTANCE, 400, 1, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 2:
							player.addPotionEffect(
									new PotionEffect(PotionEffectType.JUMP, 400, 0, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 3:
							player.addPotionEffect(
									new PotionEffect(PotionEffectType.JUMP, 400, 1, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
					}
					break;
				case 3:
					Random r3 = new Random();
					int i3 = r3.nextInt(2);

					switch (i3) {
						case 0:
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.INCREASE_DAMAGE, 400, 0, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
						case 1:
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.INCREASE_DAMAGE, 400, 1, false, false));
							player.sendMessage("§8Minig Success!");
							player.playSound(player.getLocation(), Sound.DIG_STONE, 1, 1);
							break;
					}
					break;
				case 4:
					player.sendMessage("§8Minig Failed...");
					player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1, 1);
					break;
				default:
					break;
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if (kits.get(damagee.getUniqueId()).equals("Miner")) {
			return;
		}

		if (kits.get(damager.getUniqueId()).equals("Miner")) {
			return;
		}
	}
}
