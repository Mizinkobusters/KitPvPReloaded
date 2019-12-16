package mb.mizinkobusters.kitpvp.kit;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class TapiocaMilkTea implements Listener {

	/*
	 *
	 *  TapiocaMilkTea Kit
	 *
	 */

	JavaPlugin plugin;

	public TapiocaMilkTea(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP)plugin).kits;

	@EventHandler
	public void onKill(PlayerDeathEvent event) {
		Player player = event.getEntity();

		if(player.getKiller() != null
				&& player.getKiller().getType().equals(EntityType.PLAYER)) {
			Player killer = player.getKiller();

			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
			killer.getInventory().addItem(new ItemStack(Material.MILK_BUCKET));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if(kits.get(damagee.getUniqueId()).equals("TapiocaMilkTea")) {
			return;
		}

		if(kits.get(damager.getUniqueId()).equals("TapiocaMilkTea")) {
			return;
		}

	}

	public void onEatGapple(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if(kits.get(player.getUniqueId()).equals("TapiocaMilkTea")
				&& item.getType().equals(Material.MILK_BUCKET)) {
			item.setType(Material.COOKED_BEEF);
			player.removePotionEffect(PotionEffectType.POISON);
		}
	}

}
