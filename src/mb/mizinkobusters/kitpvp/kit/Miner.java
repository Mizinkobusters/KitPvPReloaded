package mb.mizinkobusters.kitpvp.kit;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Miner extends Kit {

	/*
	 *
	 * Miner Kit
	 *
	 */

	@Override
	public void onKill(Player killer) {
		super.onKill(killer);

		Random r = new Random();
		int i = r.nextInt(5);

		switch (i) {
			case 0:
				killer.addPotionEffect(
						new PotionEffect(PotionEffectType.REGENERATION, 400, 0, false, false));
				killer.sendMessage("§8Minig Success!");
				killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
				break;
			case 1:
				Random r1 = new Random();
				int i1 = r1.nextInt(4);

				switch (i1) {
					case 0:
						killer.addPotionEffect(
								new PotionEffect(PotionEffectType.SPEED, 400, 0, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 1:
						killer.addPotionEffect(
								new PotionEffect(PotionEffectType.SPEED, 400, 1, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 2:
						killer.removePotionEffect(PotionEffectType.FAST_DIGGING);
						killer.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400,
								0, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 3:
						killer.removePotionEffect(PotionEffectType.FAST_DIGGING);
						killer.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400,
								1, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
				}
				break;
			case 2:
				Random r2 = new Random();
				int i2 = r2.nextInt(4);

				switch (i2) {
					case 0:
						killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
								400, 0, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 1:
						killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
								400, 1, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 2:
						killer.addPotionEffect(
								new PotionEffect(PotionEffectType.JUMP, 400, 0, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 3:
						killer.addPotionEffect(
								new PotionEffect(PotionEffectType.JUMP, 400, 1, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
				}
				break;
			case 3:
				Random r3 = new Random();
				int i3 = r3.nextInt(2);

				switch (i3) {
					case 0:
						killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
								400, 0, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
					case 1:
						killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
								400, 1, false, false));
						killer.sendMessage("§8Minig Success!");
						killer.playSound(killer.getLocation(), Sound.DIG_STONE, 1, 1);
						break;
				}
				break;
			case 4:
				killer.sendMessage("§8Minig Failed...");
				killer.playSound(killer.getLocation(), Sound.ITEM_BREAK, 1, 1);
				break;
			default:
				break;
		}
	}
}
