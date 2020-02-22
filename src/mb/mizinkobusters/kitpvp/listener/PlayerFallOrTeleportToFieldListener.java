package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class PlayerFallOrTeleportToFieldListener implements Listener {

	JavaPlugin plugin;
	String prefix = "§7[§dKitPvP§7] ";
	private SelectGUI kits;
	private HashMap<UUID, Long> lastWarned = new HashMap<>();

	public PlayerFallOrTeleportToFieldListener(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Player player = (Player) event.getEntity();
		DamageCause cause = event.getCause();
		Material material = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();

		if (cause.equals(DamageCause.FALL) && material.equals(Material.SPONGE)) {
			if (kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
				event.setCancelled(true);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
				player.setMetadata("combat", new FixedMetadataValue(plugin, player));
			} else {
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
		float pitch = player.getLocation().getPitch();
		float yaw = player.getLocation().getYaw();

		if (action.equals(Action.PHYSICAL)) {

			Block interact = Bukkit.getWorld("kitpvp").getBlockAt(event.getClickedBlock().getX(),
					event.getClickedBlock().getY() - 1, event.getClickedBlock().getZ());

			if (interact.getType().equals(Material.SMOOTH_BRICK)) {
				if (kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
					player.teleport(
							new Location(Bukkit.getWorld("kitpvp"), 41.5, 5.0, 54.5, yaw, pitch),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
					player.setMetadata("combat", new FixedMetadataValue(plugin, player));
				} else {
					if (lastWarned.getOrDefault(player.getUniqueId(), 0L) + 1000L < System
							.currentTimeMillis()) {
						player.sendMessage(prefix + "§cKitを選択してください");
						lastWarned.put(player.getUniqueId(), System.currentTimeMillis());
					}
				}
			}

			if (interact.getType().equals(Material.SANDSTONE)) {
				if (kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
					player.teleport(
							new Location(Bukkit.getWorld("kitpvp"), -63.5, 4.0, 11.5, yaw, pitch),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
					player.setMetadata("combat", new FixedMetadataValue(plugin, player));
				} else {
					if (lastWarned.getOrDefault(player.getUniqueId(), 0L) + 1000L < System
							.currentTimeMillis()) {
						player.sendMessage(prefix + "§cKitを選択してください");
						lastWarned.put(player.getUniqueId(), System.currentTimeMillis());
					}
				}
			}

			if (interact.getType().equals(Material.NETHERRACK)) {
				if (kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
					player.teleport(
							new Location(Bukkit.getWorld("kitpvp"), -11.5, 6.0, -53.5, yaw, pitch),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
					player.setMetadata("combat", new FixedMetadataValue(plugin, player));
				} else {
					if (lastWarned.getOrDefault(player.getUniqueId(), 0L) + 1000L < System
							.currentTimeMillis()) {
						player.sendMessage(prefix + "§cKitを選択してください");
						lastWarned.put(player.getUniqueId(), System.currentTimeMillis());
					}
				}
			}

			if (interact.getType().equals(Material.MYCEL)) {
				if (kits.getKits().getOrDefault(player.getUniqueId(), "").length() > 1) {
					player.teleport(
							new Location(Bukkit.getWorld("kitpvp"), 68.5, 11.0, -14.5, yaw, pitch),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
					player.setMetadata("combat", new FixedMetadataValue(plugin, player));
				} else {
					if (lastWarned.getOrDefault(player.getUniqueId(), 0L) + 1000L < System
							.currentTimeMillis()) {
						player.sendMessage(prefix + "§cKitを選択してください");
						lastWarned.put(player.getUniqueId(), System.currentTimeMillis());
					}
				}
			}
		}
	}
}
