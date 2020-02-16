package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class ItemDropListener implements Listener {

	JavaPlugin plugin;
	private SelectGUI kits;

	public ItemDropListener(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();

		if (player.getWorld().getName().equals("kitpvp")
				&& kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		SlotType type = event.getSlotType();


		if (player.getWorld().getName().equals("kitpvp")
				&& kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1
				&& type.equals(SlotType.ARMOR)) {
			ItemStack item = event.getCurrentItem();
			if (item != null) {
				event.setCancelled(true);
			}
		}
	}
}
