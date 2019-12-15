package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerLoggingListener implements Listener {

	JavaPlugin plugin;

	public PlayerLoggingListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP)plugin).kits;

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inv = player.getInventory();

		if(player.hasMetadata("combat")) {
			player.removeMetadata("combat", plugin);
			player.sendMessage(prefix + "§c前回ログアウトした場所が戦場だったので死亡扱いとなりました");
		}

		inv.clear();
		for(ItemStack armor : inv.getArmorContents()) armor.setType(Material.AIR);
		player.setMaxHealth(20.0);
		player.setHealth(20.0);
		for(PotionEffect effect : player.getActivePotionEffects()) player.removePotionEffect(effect.getType());

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		kits.put(player.getUniqueId(), null);
	}

}
