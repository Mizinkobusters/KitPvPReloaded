package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;

public class Fisherman extends Kit {

	/*
	 *
	 * Fisherman Kit
	 *
	 */

	@EventHandler
	public void onFish(PlayerFishEvent event) {
		Player player = event.getPlayer();

		if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			event.setCancelled(true);
		} else if (kits.get(player.getUniqueId()).equals("Fisherman")
				&& event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)
				&& event.getCaught().getType().equals(EntityType.PLAYER)) {
			Player caught = (Player) event.getCaught();
			caught.teleport(new Location(caught.getWorld(),
					(player.getLocation().getX() + caught.getLocation().getX()) / 2,
					(player.getLocation().getY() + caught.getLocation().getY()) / 2,
					(player.getLocation().getZ() + caught.getLocation().getZ()) / 2));
			player.sendMessage("§bFishing Success!");
			player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
		}
	}

}
