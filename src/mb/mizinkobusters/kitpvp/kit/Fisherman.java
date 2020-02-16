package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class Fisherman implements Listener {

	/*
	 *
	 * Fisherman Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public Fisherman(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("Fisherman")) {
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

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("Fisherman")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("Fisherman")) {
			return;
		}

	}

	@EventHandler
	public void onFish(PlayerFishEvent event) {
		Player player = event.getPlayer();

		if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			event.setCancelled(true);
		} else if (kits.getKits().get(player.getUniqueId()).equals("Fisherman")
				&& event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)
				&& event.getCaught().getType().equals(EntityType.PLAYER)) {
			Player caught = (Player) event.getCaught();
			if (caught.hasMetadata("combat")) {
				caught.teleport(
						new Location(caught.getWorld(),
								(player.getLocation().getX() + caught.getLocation().getX()) / 2,
								(player.getLocation().getY() + caught.getLocation().getY()) / 2,
								(player.getLocation().getZ() + caught.getLocation().getZ()) / 2),
						TeleportCause.UNKNOWN);
				player.sendMessage("§bFishing Success!");
				player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
			}
		}
	}
}
