package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.entity.Player;

public class HealthBoost extends Kit {

	/*
	 *
	 * HealthBoost Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		if (killer.getMaxHealth() < 26) {
			killer.setMaxHealth(killer.getMaxHealth() + 1);
			killer.setHealth(killer.getMaxHealth());
		}
	}
}
