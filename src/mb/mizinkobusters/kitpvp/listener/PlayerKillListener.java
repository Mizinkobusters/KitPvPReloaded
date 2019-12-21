package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerKillListener implements Listener {

	JavaPlugin plugin;

	public PlayerKillListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	public HashMap<UUID, String> kits = new HashMap<UUID, String>();

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();
		PlayerInventory inv = player.getInventory();

		if (player.getWorld().getName().equals("kitpvp")) {
			if (player.getKiller() != null
					&& player.getKiller().getType().equals(EntityType.PLAYER)) {
				Player killer = player.getKiller();

				player.sendMessage(
						prefix + "§e" + killer.getName() + " §aの残りHPは§d " + killer.getHealth());
				player.sendMessage(prefix + "§e" + killer.getName() + " §aの使用Kitは§d "
						+ kits.getOrDefault(killer.getUniqueId(), null));

				killer.sendMessage(prefix + "§c" + player.getName() + " §aをキル");
				killer.sendMessage(prefix + "§e" + player.getName() + " §aの使用Kitは§d "
						+ kits.getOrDefault(player.getUniqueId(), null));

				killer.setHealth(killer.getMaxHealth());
			} else if (player.getKiller() != null
					&& player.getKiller().getType().equals(EntityType.ARROW)) {
				Arrow arrow = (Arrow) player.getKiller();
				Player killer = (Player) arrow.getShooter();

				player.sendMessage(
						prefix + "§e" + killer.getName() + " §aの残りHPは§d " + killer.getHealth());
				player.sendMessage(prefix + "§e" + killer.getName() + " §aの使用Kitは§d "
						+ kits.getOrDefault(killer.getUniqueId(), null));

				killer.sendMessage(prefix + "§c" + player.getName() + " §aをキル");
				killer.sendMessage(prefix + "§e" + player.getName() + " §aの使用Kitは§d "
						+ kits.getOrDefault(player.getUniqueId(), null));

				killer.setHealth(killer.getMaxHealth());
			}

			kits.getOrDefault(player.getUniqueId(), null);
			player.removeMetadata("combat", plugin);

			player.spigot().respawn();

			inv.clear();
			for (ItemStack armor : inv.getArmorContents())
				armor.setType(Material.AIR);
			player.setMaxHealth(20.0);
			player.setHealth(20.0);
			for (PotionEffect effect : player.getActivePotionEffects())
				player.removePotionEffect(effect.getType());

		}
	}

}
