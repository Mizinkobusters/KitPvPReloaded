package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PotionHandler extends Kit {

	/*
	 *
	 * PotionHandler Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		super.onKill(killer);

		killer.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 16388));
	}
}
