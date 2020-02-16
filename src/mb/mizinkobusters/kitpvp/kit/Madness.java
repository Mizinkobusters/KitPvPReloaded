package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Madness implements Listener {

	/*
	 *
	 * Madness Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Madness(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Madness")) {
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

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Madness")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Madness")) {
			return;
		}
	}

	@EventHandler
	public void onEatGapple(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (kits.getKits().getOrDefault(player.getUniqueId(), null).equals("Madness")
				&& item.getType().equals(Material.GOLDEN_APPLE)) {
			event.setCancelled(true);
			item.setType(Material.APPLE);
			int amount = player.getInventory().getItemInHand().getAmount();

			if (amount > 1)
				player.getInventory().getItemInHand().setAmount(amount - 1);
			else
				player.getInventory().remove(Material.GOLDEN_APPLE);
			player.updateInventory();

			player.removePotionEffect(PotionEffectType.REGENERATION);
			player.removePotionEffect(PotionEffectType.ABSORPTION);
			player.setHealth(player.getHealth() - 3);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1, false, false));
		}
	}

	@EventHandler
	public void onRegene(EntityRegainHealthEvent event) {
		Player player = (Player) event.getEntity();

		if (kits.getKits().getOrDefault(player.getUniqueId(), null).equals("Madness")
				&& player.hasPotionEffect(PotionEffectType.SPEED)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onWalk(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location from = event.getFrom();
		Location to = event.getTo();

		if (Math.abs(from.getBlockX() - to.getBlockX()) >= 1
				|| Math.abs(from.getBlockZ() - to.getBlockZ()) >= 1 && kits.getKits()
						.getOrDefault(player.getUniqueId(), null).equals("Madness")) {
			Random r = new Random();
			int i = r.nextInt(10);
			if (i == 0 && !player.hasPotionEffect(PotionEffectType.SPEED)) {
				if (player.getHealth() < player.getMaxHealth()) {
					player.setHealth(player.getHealth() + 1);
					player.sendMessage("§aHealing Success!");
				}
			}
		}
	}
}
