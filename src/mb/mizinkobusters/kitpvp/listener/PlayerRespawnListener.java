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

	HashMap<UUID, String> kits = new PlayerKillListener((KitPvP)plugin).kits;

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

		if(player.getWorld().getName().equals("kitpvp")
			&& item.getItemMeta().getDisplayName().equals("§c§lクリックでリスポーン")
			&& item.getItemMeta().getDisplayName() != null || item.hasItemMeta()) {
			if(player.getItemInHand().getType().equals(Material.BONE)) player.getItemInHand().setAmount(0);
			if(player.hasMetadata("combat")) {
				player.setMetadata("respawn", new FixedMetadataValue(plugin, player));
				player.sendMessage(prefix + "§a5秒後§eにリスポーンします");
				player.sendMessage(prefix + "§cその場から動かないでください...");

				new BukkitRunnable() {
					@Override
					public void run() {
						if(player.hasMetadata("respawn")) {
							player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
							player.sendMessage(prefix + "§aリスポーンしました!");
						}
					}
				}.runTaskLater(plugin, 100);

			} else {
				player.setMetadata("fastrespawn", new FixedMetadataValue(plugin, player));
				player.sendMessage(prefix + "§a1秒後§eにリスポーンします");
				player.sendMessage(prefix + "§cその場から動かないでください...");

				new BukkitRunnable() {
					@Override
					public void run() {
						if(player.hasMetadata("fastrespawn")) {
							player.teleport(new Location(player.getWorld(), 0.5, 7.0, 0.5, 0, 0));
							player.sendMessage(prefix + "§aリスポーンしました!");
						}
					}
				}.runTaskLater(plugin, 20);
			}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		//PlayerInventory inv = player.getInventory();
		Location from = event.getFrom();
		Location to = event.getTo();

		if(player.getWorld().getName().equals("kitpvp")) {
			//X, Y, Z座標のいずれかで移動が確認されたらリスポーンをキャンセル
			if(Math.abs(from.getX() - to.getX()) >= 1
					|| Math.abs(from.getY() - to.getY()) >= 1
					|| Math.abs(from.getZ() - to.getZ()) >= 1
					&& player.hasMetadata("respawn")
					|| player.hasMetadata("fastrespawn")) {
				player.removeMetadata("respawn", plugin);
				player.removeMetadata("fastrespawn", plugin);
				player.sendMessage(prefix + "§cリスポーンを中断しました");
				bone(player);
			}
		}
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		TeleportCause cause = event.getCause();

		if(player.getWorld().getName().equals("kitpvp")
				&& cause.equals(TeleportCause.ENDER_PEARL) || cause.equals(TeleportCause.PLUGIN)) {
			player.removeMetadata("respawn", plugin);
			player.removeMetadata("fastrespawn", plugin);
			player.sendMessage(prefix + "§cリスポーンを中断しました");
			bone(player);
		}
	}

}