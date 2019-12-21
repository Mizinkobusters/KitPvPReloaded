package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PlayerFallOrTeleportToFieldListener implements Listener {

	JavaPlugin plugin;

	public PlayerFallOrTeleportToFieldListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Player player = (Player) event.getEntity();
		DamageCause cause = event.getCause();

		if (player.getWorld().getName().equals("kitpvp")) {
			if (cause.equals(DamageCause.FALL) && kits.get(player.getUniqueId()) != null
					&& player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType()
							.equals(Material.SPONGE)) {
				event.setCancelled(true);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else if (cause.equals(DamageCause.FALL) && kits.get(player.getUniqueId()) == null
					&& player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType()
							.equals(Material.SPONGE)) {
				event.setCancelled(true);
				player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
				player.sendMessage(prefix + "§cKitを選択してください");
			}
		}
	}

	@EventHandler
	public void onPlate(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();

		if (player.getWorld().getName().equals("kitpvp")) {
			if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) != null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.GLASS)) {
				player.teleport(new Location(Bukkit.getWorld("kitpvp"), 41.5, 4.0, 54.5),
						TeleportCause.PLUGIN);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) == null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.GLASS)) {
				player.sendMessage(prefix + "§cKitを選択してください");
			}

			if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) != null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.SANDSTONE)) {
				player.teleport(new Location(Bukkit.getWorld("kitpvp"), -63.5, 4.0, 11.5),
						TeleportCause.PLUGIN);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) == null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.SANDSTONE)) {
				player.sendMessage(prefix + "§cKitを選択してください");
			}

			if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) != null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.NETHERRACK)) {
				player.teleport(new Location(Bukkit.getWorld("kitpvp"), -11.5, 6.0, -53.5),
						TeleportCause.PLUGIN);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) == null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.NETHERRACK)) {
				player.sendMessage(prefix + "§cKitを選択してください");
			}

			if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) != null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.MYCEL)) {
				player.teleport(new Location(Bukkit.getWorld("kitpvp"), 68.5, 11.0, -14.5),
						TeleportCause.PLUGIN);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else if (action.equals(Action.PHYSICAL) && kits.get(player.getUniqueId()) == null
					&& Bukkit.getWorld(player.getWorld().getName())
							.getBlockAt(event.getClickedBlock().getX(),
									event.getClickedBlock().getY() - 1,
									event.getClickedBlock().getZ())
							.getType().equals(Material.MYCEL)) {
				player.sendMessage(prefix + "§cKitを選択してください");
			}
		}
	}

}
