package mb.mizinkobusters.kitpvp.kit;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Berserker extends Kit {

	/*
	 *
	 * Berserker Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		super.onKill(killer);

		killer.removePotionEffect(PotionEffectType.WEAKNESS);
		killer.addPotionEffect(
				new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 0, 140, false, false));
	}
}
