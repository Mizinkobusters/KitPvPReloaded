package mb.mizinkobusters.kitpvp.listener;

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
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.DistributeKits;

public class PlayerFallOrTeleportToFieldListener implements Listener {

	JavaPlugin plugin;

	public PlayerFallOrTeleportToFieldListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	private DistributeKits kits;

	public PlayerFallOrTeleportToFieldListener(DistributeKits kits) {
		this.kits = kits;
	}

	String prefix = "§7[§dKitPvP§7] ";

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Player player = (Player) event.getEntity();
		DamageCause cause = event.getCause();
		Material material = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();

		if (player.getWorld().getName().equals("kitpvp") && cause.equals(DamageCause.FALL)
				&& material.equals(Material.SPONGE)) {
			if (kits.getKits().containsKey(player.getUniqueId())) {
				event.setCancelled(true);
				player.addPotionEffect(
						new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3, false, false));
			} else {
				event.setCancelled(true);
				player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
				player.sendMessage(prefix + "§cKitを選択してください");
				player.sendMessage(
						"現在セットされている値は" + kits.getKits().getOrDefault(player.getUniqueId(), null));
			}
		}
	}

	@EventHandler
	public void onPlate(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();

		if (player.getWorld().getName().equals("kitpvp") && action.equals(Action.PHYSICAL)) {
			if (Bukkit.getWorld(player.getWorld().getName())
					.getBlockAt(event.getClickedBlock().getX(), event.getClickedBlock().getY() - 1,
							event.getClickedBlock().getZ())
					.getType().equals(Material.GRASS)) {
				if (kits.getKits().containsKey(player.getUniqueId())) {
					player.teleport(new Location(Bukkit.getWorld("kitpvp"), 41.5, 4.0, 54.5),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
				} else {
					player.sendMessage(prefix + "§cKitを選択してください");
					player.sendMessage("現在セットされている値は"
							+ kits.getKits().getOrDefault(player.getUniqueId(), null));
				}
			}

			if (Bukkit.getWorld(player.getWorld().getName())
					.getBlockAt(event.getClickedBlock().getX(), event.getClickedBlock().getY() - 1,
							event.getClickedBlock().getZ())
					.getType().equals(Material.SANDSTONE)) {
				if (kits.getKits().containsKey(player.getUniqueId())) {
					player.teleport(new Location(Bukkit.getWorld("kitpvp"), -63.5, 4.0, 11.5),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
				} else {
					player.sendMessage(prefix + "§cKitを選択してください");
				}
			}

			if (Bukkit.getWorld(player.getWorld().getName())
					.getBlockAt(event.getClickedBlock().getX(), event.getClickedBlock().getY() - 1,
							event.getClickedBlock().getZ())
					.getType().equals(Material.NETHERRACK)) {
				if (kits.getKits().containsKey(player.getUniqueId())) {
					player.teleport(new Location(Bukkit.getWorld("kitpvp"), -11.5, 6.0, -53.5),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
				} else {
					player.sendMessage(prefix + "§cKitを選択してください");
				}
			}

			if (Bukkit.getWorld(player.getWorld().getName())
					.getBlockAt(event.getClickedBlock().getX(), event.getClickedBlock().getY() - 1,
							event.getClickedBlock().getZ())
					.getType().equals(Material.MYCEL)) {
				if (kits.getKits().containsKey(player.getUniqueId())) {
					player.teleport(new Location(Bukkit.getWorld("kitpvp"), 68.5, 11.0, -14.5),
							TeleportCause.PLUGIN);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60,
							3, false, false));
				} else {
					player.sendMessage(prefix + "§cKitを選択してください");
				}
			}
		}
	}
}
