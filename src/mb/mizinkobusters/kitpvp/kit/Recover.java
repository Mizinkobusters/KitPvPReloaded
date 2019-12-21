package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Recover extends Kit {

	/*
	 *
	 * Recover Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		killer.addPotionEffect(
				new PotionEffect(PotionEffectType.REGENERATION, 300, 0, false, false));
	}

	@Override
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();

		if (kits.get(damagee.getUniqueId()).equals("Recover") && damagee.hasMetadata("combat")
				&& damagee.getHealth() <= 5) {
			Random r = new Random();
			int i = r.nextInt(9);

			switch (i) {
				case 0:
					damagee.setHealth(damagee.getHealth() + 3);
					damagee.playSound(damagee.getLocation(), Sound.LEVEL_UP, 1, 0);
					damagee.sendMessage("§aRecover Success!");
					break;
				default:
					break;
			}
		}

		if (kits.get(damager.getUniqueId()).equals("Recover")) {
			return;
		}
	}
}
