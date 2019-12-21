package mb.mizinkobusters.kitpvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PurchaseGUI implements Listener {

	JavaPlugin plugin;
	String prefix = "§7[§dKitPvP§7] ";

	public PurchaseGUI(KitPvP plugin) {
		this.plugin = plugin;
	}


	public Inventory buygui() {
		Inventory gui = Bukkit.createInventory(null, 6, "§e§lKit購入メニュー");

		return gui;
	}

	DistributeKits distribute = new DistributeKits((KitPvP) plugin);

	@EventHandler
	public void onItemClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (player.getWorld().getName().equals("kitpvp")
				&& item.getItemMeta().getDisplayName().equals("§d§lKitを購入する")
				&& item.getItemMeta().getDisplayName() != null || item.hasItemMeta()) {
			player.openInventory(buygui());
		}
	}

	/*
	 *
	 * @EventHandler public void onGUIClick(InventoryClickEvent event) {
	 * 購入処理は別プラグイン「AdvancedLogPlus」を参照してください }
	 *
	 */
}
