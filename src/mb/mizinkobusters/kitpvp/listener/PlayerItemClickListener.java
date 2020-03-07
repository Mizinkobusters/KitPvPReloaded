package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerItemClickListener implements Listener {

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onItemClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		Action action = event.getAction();

		if (item == null)
			return;

		if (item.getItemMeta() == null || !item.hasItemMeta())
			return;

		if (item.getItemMeta().getDisplayName() == null || !item.getItemMeta().hasDisplayName())
			return;

		if (item.getItemMeta().getDisplayName().equals("§c§l観戦モード")) {
			if (player.getGameMode().equals(GameMode.SPECTATOR)) {
				if (action.equals(Action.LEFT_CLICK_AIR)
						|| action.equals(Action.LEFT_CLICK_BLOCK)) {
					player.teleport(new Location(Bukkit.getWorld("kitpvp"), 0.5, 13.0, 0.5, 0, 0));
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(prefix + "§e観戦モードを解除しました");
				}
			} else {
				player.teleport(new Location(Bukkit.getWorld("kitpvp"), 0.5, 13.0, 0.5, 0, 0));
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(prefix + "§a観戦モードになりました");
				player.sendMessage(prefix + "§a左クリック§7で解除できます");
			}
		}
	}
}
