package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blizzard extends Kit {

	/*
	 *
	 * Blizzard Kit
	 *
	 */

	@Override
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();
		Random r = new Random();
		int i = r.nextInt(7);

		if (kits.get(damagee.getUniqueId()).equals("Blizzard")) {
			return;
		}

		if (kits.get(damager.getUniqueId()).equals("Blizzard") && damager.hasMetadata("combat")) {

			switch (i) {
				case 0:
					damagee.addPotionEffect(
							new PotionEffect(PotionEffectType.SLOW, 60, 3, false, false));
					damagee.playSound(damagee.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 0);
					damager.playSound(damager.getLocation(), Sound.GLASS, 1, 0);
					damager.sendMessage("§3Freeze Success!");
					break;
				default:
					break;
			}
		}
	}

}
