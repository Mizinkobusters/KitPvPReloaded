package mb.mizinkobusters.kitpvp.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;

public class PurchaseGUI implements Listener {

	JavaPlugin plugin;
	String prefix = "§7[§dKitPvP§7] ";

	public PurchaseGUI(KitPvP plugin) {
		this.plugin = plugin;
	}

	ItemMeta meta;

	public Inventory buygui() {
		Inventory gui = Bukkit.createInventory(null, 18, "§e§lKit購入メニュー");

		ItemStack attacker = new ItemStack(Material.FISHING_ROD);
		ItemStack berserker = new ItemStack(Material.POTION, 1, (short) 8201);
		ItemStack blizzard = new ItemStack(Material.ICE);
		ItemStack counter = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack enderman = new ItemStack(Material.ENDER_PEARL);
		ItemStack fisherman = new ItemStack(Material.RAW_FISH);
		ItemStack healthboost = new ItemStack(Material.GOLDEN_APPLE);
		ItemStack madness = new ItemStack(Material.POTION, 1, (short) 8204);
		ItemStack rabbit = new ItemStack(Material.RABBIT_FOOT);
		ItemStack revival = new ItemStack(Material.POTION, 1, (short) 8193);
		ItemStack sniper = new ItemStack(Material.LONG_GRASS, 1, (short) 1);

		meta = attacker.getItemMeta();
		meta.setDisplayName("§eAttacker Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 5500GameCoins")));
		attacker.setItemMeta(meta);

		meta = berserker.getItemMeta();
		meta.setDisplayName("§eBerserker Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 9000GameCoins")));
		berserker.setItemMeta(meta);

		meta = blizzard.getItemMeta();
		meta.setDisplayName("§eBlizzard Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 8000GameCoins")));
		blizzard.setItemMeta(meta);

		meta = counter.getItemMeta();
		meta.setDisplayName("§eCounter Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 8000GameCoins")));
		counter.setItemMeta(meta);

		meta = enderman.getItemMeta();
		meta.setDisplayName("§eEnderman Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 9000GameCoins")));
		enderman.setItemMeta(meta);

		meta = fisherman.getItemMeta();
		meta.setDisplayName("§eFisherman Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 9500GameCoins")));
		fisherman.setItemMeta(meta);

		meta = healthboost.getItemMeta();
		meta.setDisplayName("§eHealthBoost Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 9500GameCoins")));
		healthboost.setItemMeta(meta);

		meta = madness.getItemMeta();
		meta.setDisplayName("§eMadness Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 7000GameCoins")));
		madness.setItemMeta(meta);

		meta = rabbit.getItemMeta();
		meta.setDisplayName("§eRabbit Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 8500GameCoins")));
		rabbit.setItemMeta(meta);

		meta = revival.getItemMeta();
		meta.setDisplayName("§eRevival Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 9000GameCoins")));
		revival.setItemMeta(meta);

		meta = sniper.getItemMeta();
		meta.setDisplayName("§eSniper Kitを選択する");
		meta.setLore(new ArrayList<>(Arrays.asList("§7購入コスト: 7500GameCoins")));
		sniper.setItemMeta(meta);

		gui.setItem(0, attacker);
		gui.setItem(1, berserker);
		gui.setItem(2, blizzard);
		gui.setItem(3, counter);
		gui.setItem(4, enderman);
		gui.setItem(5, fisherman);
		gui.setItem(6, healthboost);
		gui.setItem(7, madness);
		gui.setItem(8, rabbit);
		gui.setItem(9, revival);
		gui.setItem(10, sniper);

		return gui;
	}

	@EventHandler
	public void onItemClick(PlayerInteractEvent event) {
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

		if (item.getItemMeta().getDisplayName().equals("§e§lKitを購入する"))
			player.openInventory(buygui());
	}



	@EventHandler
	public void onGUIClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();

		if (item == null)
			return;

		if (item.getItemMeta() == null || !item.hasItemMeta())
			return;

		if (!player.getWorld().getName().equals("kitpvp"))
			return;

		if (inv.getName().equals("§e§lKit購入メニュー")) {

			event.setCancelled(true);

			UUID uuid = player.getUniqueId();

			Plugin pl = Bukkit.getPluginManager().getPlugin("AdvancedLogPlus");
			File pluginfolder = new File(pl.getDataFolder().getPath());

			File ownfile = new File(pluginfolder + "/users/" + uuid.toString() + ".yml");
			FileConfiguration ownconfig = YamlConfiguration.loadConfiguration(ownfile);

			if (item.getItemMeta().getDisplayName().equals("§cAttacker Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.attacker")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 5500) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 5500);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.attacker server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eBerserker Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.berserker")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 9000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 9000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.berserker server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eBlizzard Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.blizzard")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 8000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 8000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.blizzard server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eCounter Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.counter")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 8000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 8000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.counter server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eEnderman Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.enderman")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 9000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 9000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.enderman server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eFisherman Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.fisherman")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 9500) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 9500);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.fisherman server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eHealthBoost Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.healthboost")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 9500) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 9500);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.healthboost server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eMadness Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.madness")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 7000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 7000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.madness server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eRabbit Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.rabbit")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 8500) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 8500);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.rabbit server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eRevival Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.revival")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 9000) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 9000);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.revival server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}

			if (item.getItemMeta().getDisplayName().equals("§eSniper Kitを選択する")) {
				if (player.hasPermission("mizinkopvp.kit.purchase.sniper")) {
					player.sendMessage(prefix + "§4既にこのKitを購入しています");
					player.closeInventory();
				} else {
					if (ownconfig.getInt("GameCoins") >= 7500) {
						ownconfig.set("GameCoins", ownconfig.getInt("GameCoins") - 7500);
						try {
							ownconfig.save(ownfile);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
								+ player.getName()
								+ " permission set mizinkopvp.kit.purchase.sniper server=pvp");
						player.sendMessage(prefix + "§aKitの購入に成功しました");
						player.closeInventory();
					} else {
						player.sendMessage(prefix + "§4ゲームコインが足りません");
						player.closeInventory();
					}
				}
			}
		}
	}
}
