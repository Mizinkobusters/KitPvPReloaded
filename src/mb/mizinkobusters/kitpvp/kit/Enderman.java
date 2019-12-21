package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Enderman extends Kit {

	/*
	 *
	 * Enderman Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		super.onKill(killer);

		killer.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
	}
}
