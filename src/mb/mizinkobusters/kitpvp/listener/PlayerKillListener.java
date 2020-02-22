package mb.mizinkobusters.kitpvp.listener;

import java.math.BigDecimal;
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
import org.bukkit.util.Vector;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class PlayerKillListener implements Listener {

	JavaPlugin plugin;
	SelectGUI kits;

	public PlayerKillListener(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();
		PlayerInventory inv = player.getInventory();

		if (player.getWorld().getName().equals("kitpvp")) {
			if (player.getKiller() != null
					&& player.getKiller().getType().equals(EntityType.PLAYER)) {
				Player killer = player.getKiller();

				double killerhp = killer.getHealth();
				BigDecimal bd = new BigDecimal(killerhp);

				player.sendMessage(prefix + "§e" + killer.getName() + " §aの残りHPは§d "
						+ String.format("%.1f", bd));
				player.sendMessage(prefix + "§e" + killer.getName() + " §aの使用Kitは§d "
						+ kits.getKits().getOrDefault(killer.getUniqueId(), null));

				killer.sendMessage(prefix + "§c" + player.getName() + " §aをキル");
				killer.sendMessage(prefix + "§c" + player.getName() + " §aの使用Kitは§d "
						+ kits.getKits().getOrDefault(player.getUniqueId(), null));

				killer.setHealth(killer.getMaxHealth());
			} else if (player.getKiller() != null
					&& player.getKiller().getType().equals(EntityType.ARROW)) {
				Arrow arrow = (Arrow) player.getKiller();
				Player killer = (Player) arrow.getShooter();

				double killerhp = killer.getHealth();
				BigDecimal bd = new BigDecimal(killerhp);

				player.sendMessage(prefix + "§e" + killer.getName() + " §aの残りHPは§d "
						+ String.format("%.1f", bd));
				player.sendMessage(prefix + "§e" + killer.getName() + " §aの使用Kitは§d "
						+ kits.getKits().getOrDefault(killer.getUniqueId(), null));

				killer.sendMessage(prefix + "§c" + player.getName() + " §aをキル");
				killer.sendMessage(prefix + "§e" + player.getName() + " §aの使用Kitは§d "
						+ kits.getKits().getOrDefault(player.getUniqueId(), null));

				killer.setHealth(killer.getMaxHealth());
			}

			kits.getKits().remove(player.getUniqueId());
			kits.getKits().put(player.getUniqueId(), "");
			player.removeMetadata("combat", plugin);
			player.removeMetadata("respawn", plugin);
			player.removeMetadata("fastrespawn", plugin);

			player.setVelocity(new Vector());
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
