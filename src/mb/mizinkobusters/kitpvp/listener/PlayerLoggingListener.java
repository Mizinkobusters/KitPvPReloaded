package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class PlayerLoggingListener implements Listener {

	JavaPlugin plugin;
	private SelectGUI kits;

	public PlayerLoggingListener(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inv = player.getInventory();

		if (kits.getKits().containsKey(player.getUniqueId())) {
			kits.getKits().put(player.getUniqueId(), null);
			player.sendMessage(prefix + "§c前回ログアウトした場所が戦場だったので死亡扱いとなりました");
		}

		inv.clear();
		for (ItemStack armor : inv.getArmorContents())
			armor.setType(Material.AIR);
		player.setMaxHealth(20.0);
		player.setHealth(20.0);
		for (PotionEffect effect : player.getActivePotionEffects())
			player.removePotionEffect(effect.getType());
	}
}
