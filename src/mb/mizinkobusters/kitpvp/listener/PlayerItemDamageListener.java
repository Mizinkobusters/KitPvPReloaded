package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerItemDamageListener implements Listener {

	JavaPlugin plugin;

	public PlayerItemDamageListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onItemDamage(PlayerItemDamageEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (item == null)
			return;

		if (!player.getWorld().getName().equals("kitpvp"))
			return;


		if (!item.getType().equals(Material.FISHING_ROD)) {
			event.setCancelled(true);
			player.updateInventory();
		}
	}
}
