package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class TapiocaMilkTea extends Kit {

	/*
	 *
	 * TapiocaMilkTea Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		super.onKill(killer);

		killer.getInventory().addItem(new ItemStack(Material.MILK_BUCKET));
	}

	@EventHandler
	public void onEatGapple(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (kits.get(player.getUniqueId()).equals("TapiocaMilkTea")
				&& item.getType().equals(Material.MILK_BUCKET)) {
			item.setType(Material.COOKED_BEEF);
			player.removePotionEffect(PotionEffectType.POISON);
		}
	}

}
