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
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;

public class Berserker implements Listener {

	/*
	 *
	 *  Berserker Kit
	 *
	 */

	JavaPlugin plugin;

	public Berserker(KitPvP plugin) {
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

			killer.removePotionEffect(PotionEffectType.WEAKNESS);
			killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 140, false, false));
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if(kits.get(damagee.getUniqueId()).equals("Berserker")) {
			return;
		}

		if(kits.get(damager.getUniqueId()).equals("Berserker")) {
			return;
		}
	}

}
