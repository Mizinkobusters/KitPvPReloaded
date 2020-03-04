package mb.mizinkobusters.kitpvp.listener;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BlockIterator;
import mb.mizinkobusters.kitpvp.KitPvP;

public class ProjectileHitListener implements Listener {

	JavaPlugin plugin;

	public ProjectileHitListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onHit(ProjectileHitEvent event) {
		Projectile projectile = event.getEntity();

		if (!(projectile instanceof Arrow))
			return;

		Arrow arrow = (Arrow) projectile;
		// Player player = (Player) arrow.getShooter();
		World world = arrow.getWorld();
		if (!arrow.getWorld().getName().equals("kitpvp"))
			return;

		BlockIterator bi = new BlockIterator(world, arrow.getLocation().toVector(),
				arrow.getVelocity().normalize(), 0, 4);
		Block hit = null;

		while (bi.hasNext()) {
			hit = bi.next();
			if (hit.getLocation().getBlock() != null) {
				arrow.remove();
				break;
			}
		}
	}
}
