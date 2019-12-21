package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Lightning extends Kit {

	/*
	 *
	 * Lightning Kit
	 *
	 */

	@Override
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();
		Random r = new Random();
		int i = r.nextInt(6);

		if (kits.get(damagee.getUniqueId()).equals("Lightning")) {
			return;
		}

		if (kits.get(damager.getUniqueId()).equals("Lightning") && damager.hasMetadata("combat")
				&& i == 0) {
			Random d = new Random();
			int di = d.nextInt(5);
			damagee.getWorld().strikeLightningEffect(damagee.getLocation());
			damagee.damage(di + 5);

		}

	}

	@EventHandler
	public void onDamageNotEntity(EntityDamageEvent event) {
		Player damagee = (Player) event.getEntity();
		DamageCause cause = event.getCause();

		if (kits.get(damagee.getUniqueId()).equals("Lightning")
				&& cause.equals(DamageCause.LIGHTNING)) {
			event.setCancelled(true);

		}
	}

}
