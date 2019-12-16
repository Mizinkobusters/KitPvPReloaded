package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class Fisherman implements Listener {

	/*
	 *
	 *  Fisherman Kit
	 *
	 */

	JavaPlugin plugin;

	public Fisherman(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP)plugin).kits;

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();

		if(player.getKiller() != null
				&& player.getKiller().getType().equals(EntityType.PLAYER)) {
			Player killer = player.getKiller();

			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if(kits.get(damagee.getUniqueId()).equals("Fisherman")) {
			return;
		}

		if(kits.get(damager.getUniqueId()).equals("Fisherman")) {
			return;
		}

	}

	public void onFish(PlayerFishEvent event) {
		Player player = event.getPlayer();

		if(event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			event.setCancelled(true);
		} else if (kits.get(player.getUniqueId()).equals("Fisherman")
				&& event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY) && event.getCaught().getType().equals(EntityType.PLAYER)) {
			Player caught = (Player) event.getCaught();
			caught.teleport(new Location(
					caught.getWorld(),
					(player.getLocation().getX() + caught.getLocation().getX()) / 2,
					(player.getLocation().getY() + caught.getLocation().getY()) / 2,
					(player.getLocation().getZ() + caught.getLocation().getZ()) / 2));
			player.sendMessage("§bFishing Success!");
			player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
		}
	}

}
