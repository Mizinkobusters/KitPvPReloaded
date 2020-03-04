package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import mb.mizinkobusters.kitpvp.KitPvP;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;

public class PlayerRespawnListener implements Listener {

	JavaPlugin plugin;
	private SelectGUI kits;
	ItemMeta meta;

	HashMap<UUID, Integer> ct = new HashMap<>();

	public PlayerRespawnListener(KitPvP plugin, SelectGUI kits) {
		this.plugin = plugin;
		this.kits = kits;
	}

	String prefix = "§7[§dKitPvP§7] ";

	public void bone(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack respawn = new ItemStack(Material.BONE);
		meta = respawn.getItemMeta();
		meta.setDisplayName("§c§lクリックでリスポーン");
		respawn.setItemMeta(meta);

		inv.addItem(respawn);
	}

	@EventHandler
	public void onClickBone(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if (item == null)
			return;

		if (item.getItemMeta() == null || !item.hasItemMeta())
			return;

		if (!player.getWorld().getName().equals("kitpvp"))
			return;

		if (item.getItemMeta().getDisplayName() == null || !item.getItemMeta().hasDisplayName())
			return;

		if (item.getItemMeta().getDisplayName().equals("§c§lクリックでリスポーン")) {
			int amount = player.getInventory().getItemInHand().getAmount();

			if (amount > 1)
				player.getInventory().getItemInHand().setAmount(amount - 1);
			else
				player.getInventory().remove(Material.BONE);
			player.updateInventory();

			if (!player.hasMetadata("combat")) {
				player.setMetadata("fastrespawn", new FixedMetadataValue(plugin, player));
				player.sendMessage(prefix + "§a1秒後§eにリスポーンします");
				player.sendMessage(prefix + "§cその場から動かないでください...");

				new BukkitRunnable() {
					@Override
					public void run() {
						if (player.hasMetadata("fastrespawn")) {
							player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
							player.sendMessage(prefix + "§aリスポーンしました!");
							player.removeMetadata("fastrespawn", plugin);
							player.removeMetadata("combat", plugin);
							kits.getKits().remove(player.getUniqueId());
							kits.getKits().put(player.getUniqueId(), "");
						} else {
							this.cancel();
						}
					}
				}.runTaskLater(plugin, 20);

			} else {
				player.setMetadata("respawn", new FixedMetadataValue(plugin, player));
				player.sendMessage(prefix + "§a8秒後§eにリスポーンします");
				player.sendMessage(prefix + "§cその場から動かないでください...");
				ct.put(player.getUniqueId(), 0);

				new BukkitRunnable() {
					@Override
					public void run() {
						if (player.hasMetadata("respawn")) {
							int i = ct.getOrDefault(player.getUniqueId(), 0);
							for (i = 0; i <= 8; i++) {
								if (i == 8) {
									player.teleport(
											new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
									player.sendMessage(prefix + "§aリスポーンしました!");
									player.removeMetadata("respawn", plugin);
									player.removeMetadata("combat", plugin);
									kits.getKits().remove(player.getUniqueId());
									kits.getKits().put(player.getUniqueId(), "");
									ct.put(player.getUniqueId(), 0);
								}
							}
						} else {
							this.cancel();
						}
					}
				}.runTaskTimer(plugin, 10, 20);
			}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location from = event.getFrom();
		Location to = event.getTo();

		// X, Y, Z座標のいずれかで移動が確認されたらリスポーンをキャンセル
		if (player.hasMetadata("respawn")) {
			if (player.getWorld().getName().equals("kitpvp")
					&& Math.abs(from.distanceSquared(to)) >= 0.01) {
				player.removeMetadata("respawn", plugin);
				player.removeMetadata("combat", plugin);
				player.sendMessage(prefix + "§c移動したためリスポーンを中断しました");
				bone(player);
			}
		} else if (player.hasMetadata("fastrespawn")) {
			if (player.getWorld().getName().equals("kitpvp")
					&& Math.abs(from.distanceSquared(to)) >= 0.01) {
				player.removeMetadata("respawn", plugin);
				player.removeMetadata("combat", plugin);
				player.sendMessage(prefix + "§c移動したためリスポーンを中断しました");
				bone(player);
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player damagee = (Player) event.getEntity();

		if (damagee.hasMetadata("respawn") || damagee.hasMetadata("fastrespawn")) {
			damagee.removeMetadata("respawn", plugin);
			damagee.removeMetadata("fastrespawn", plugin);
			damagee.sendMessage(prefix + "§cダメージを受けたためリスポーンを中断しました");
			bone(damagee);
		}
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		TeleportCause cause = event.getCause();

		if (!player.hasMetadata("respawn") || !player.hasMetadata("fastrespawn"))
			return;

		if (cause.equals(TeleportCause.ENDER_PEARL) || cause.equals(TeleportCause.UNKNOWN)
				&& player.getWorld().getName().equals("kitpvp")) {
			player.removeMetadata("respawn", plugin);
			player.removeMetadata("fastrespawn", plugin);
			player.sendMessage(prefix + "§cテレポートしたためリスポーンを中断しました");
			bone(player);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (player.hasMetadata("respawn"))
			player.removeMetadata("respawn", plugin);
		if (player.hasMetadata("fastrespawn"))
			player.removeMetadata("fastrespawn", plugin);
	}
}
