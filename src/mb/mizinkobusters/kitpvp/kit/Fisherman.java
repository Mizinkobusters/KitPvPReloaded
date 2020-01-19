package mb.mizinkobusters.kitpvp.kit;

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

		if (kits.getKits().get(damagee.getUniqueId()).equals("Fisherman")) {
			return;
		}

		if (damager instanceof Player)
			damager = (Player) damager;

		if (damager == null)
			return;

		if (kits.getKits().get(damager.getUniqueId()).equals("Fisherman")) {
			return;
		}

	}

	public void onFish(PlayerFishEvent event) {
		Player player = event.getPlayer();

		if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			event.setCancelled(true);
		} else if (kits.getKits().get(player.getUniqueId()).equals("Fisherman")
				&& event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)
				&& event.getCaught().getType().equals(EntityType.PLAYER)) {
			Player caught = (Player) event.getCaught();
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
