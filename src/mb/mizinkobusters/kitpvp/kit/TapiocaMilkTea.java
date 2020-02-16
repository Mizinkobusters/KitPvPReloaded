package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class TapiocaMilkTea implements Listener {

	/*
	 *
	 * TapiocaMilkTea Kit
	 *
	 */

	JavaPlugin plugin;
	SelectGUI kits;

	public TapiocaMilkTea(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onKill(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Player killer = player.getKiller();

		if (killer != null
				&& kits.getKits().getOrDefault(killer.getUniqueId(), "").equals("TapiocaMilkTea")) {
			killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = null;
		if (event.getDamager() instanceof Player)
			damager = (Player) event.getDamager();
		else if (event.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getDamager();
			Player shooter = (Player) arrow.getShooter();
			damager = shooter;
		} else
			return;

		if (kits.getKits().getOrDefault(damagee.getUniqueId(), "").equals("TapiocaMilkTea")) {
			return;
		}

		if (kits.getKits().getOrDefault(damager.getUniqueId(), "").equals("TapiocaMilkTea")) {
			return;
		}

	}

	@EventHandler
	public void onDrinkTapioca(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (kits.getKits().getOrDefault(player.getUniqueId(), "").equals("TapiocaMilkTea")
				&& item.getType().equals(Material.MILK_BUCKET)) {
			event.setCancelled(true);
			item.setType(Material.POTION);
			int amount = player.getInventory().getItemInHand().getAmount();

			if (amount > 1)
				player.getInventory().getItemInHand().setAmount(amount - 1);
			else
				player.getInventory().remove(Material.MILK_BUCKET);
			player.updateInventory();
			player.removePotionEffect(PotionEffectType.POISON);
		}
	}
}
