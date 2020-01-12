package mb.mizinkobusters.kitpvp.listener;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

public class PlayerRespawnListener implements Listener {

	JavaPlugin plugin;
	ItemMeta meta;

	public PlayerRespawnListener(KitPvP plugin) {
		this.plugin = plugin;
	}

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP) plugin).kits;

	String prefix = "§7[§dKitPvP§7] ";
	String respawn = "respawn";
	String fast = "fastrespawn";

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

		if (item.getItemMeta().getDisplayName() != null || item.hasItemMeta()) {
			if (player.getWorld().getName().equals("kitpvp")
					&& item.getItemMeta().getDisplayName().equals("§c§lクリックでリスポーン")) {
				if (player.getItemInHand().getType().equals(Material.BONE))
					player.getItemInHand().setAmount(0);
				if (player.hasMetadata("combat")) {
					player.setMetadata(respawn, new FixedMetadataValue(plugin, player));
					player.sendMessage(prefix + "§a5秒後§eにリスポーンします");
					player.sendMessage(prefix + "§cその場から動かないでください...");

					new BukkitRunnable() {
						@Override
						public void run() {
							if (player.hasMetadata(respawn)) {
								player.teleport(
										new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0),
										TeleportCause.PLUGIN);
								player.sendMessage(prefix + "§aリスポーンしました!");
								player.removeMetadata(respawn, plugin);
							}
						}
					}.runTaskLater(plugin, 100);

				} else {
					player.setMetadata(fast, new FixedMetadataValue(plugin, player));
					player.sendMessage(prefix + "§a1秒後§eにリスポーンします");
					player.sendMessage(prefix + "§cその場から動かないでください...");

					new BukkitRunnable() {
						@Override
						public void run() {
							if (player.hasMetadata(fast)) {
								player.teleport(
										new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0),
										TeleportCause.PLUGIN);
								player.sendMessage(prefix + "§aリスポーンしました!");
								player.removeMetadata(fast, plugin);
							}
						}
					}.runTaskLater(plugin, 20);
				}
			}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location from = event.getFrom();
		Location to = event.getTo();

		if (player.getWorld().getName().equals("kitpvp") && player.hasMetadata(respawn)
				|| player.hasMetadata(fast)) {
			// X, Y, Z座標のいずれかで移動が確認されたらリスポーンをキャンセル
			if (Math.abs(from.getX() - to.getX()) >= 1 || Math.abs(from.getY() - to.getY()) >= 1
					|| Math.abs(from.getZ() - to.getZ()) >= 1) {
				player.removeMetadata(respawn, plugin);
				player.removeMetadata(fast, plugin);
				player.sendMessage(prefix + "§c移動したためリスポーンを中断しました");
				bone(player);
			}
		}
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		TeleportCause cause = event.getCause();

		if (player.getWorld().getName().equals("kitpvp") && player.hasMetadata(respawn)
				|| player.hasMetadata(fast)) {
			if (cause.equals(TeleportCause.ENDER_PEARL) || cause.equals(TeleportCause.PLUGIN)) {
				player.removeMetadata(respawn, plugin);
				player.removeMetadata(fast, plugin);
				player.sendMessage(prefix + "§cテレポートしたためリスポーンを中断しました");
				bone(player);
			}
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (player.hasMetadata(respawn))
			player.removeMetadata(respawn, plugin);
		if (player.hasMetadata(fast))
			player.removeMetadata(fast, plugin);
	}
}
