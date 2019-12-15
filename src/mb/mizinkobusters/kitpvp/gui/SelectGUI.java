package mb.mizinkobusters.kitpvp.gui;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import mb.mizinkobusters.kitpvp.KitPvP;

public class SelectGUI implements Listener {

	JavaPlugin plugin;
	ItemMeta meta;
	String prefix = "§7[§dKitPvP§7] ";

	public SelectGUI(KitPvP plugin) {
		this.plugin = plugin;
	}

	DistributeKits distribute = new DistributeKits((KitPvP)plugin);
	IndicateKits indicate = new IndicateKits((KitPvP)plugin);

	public Inventory kitgui() {
		Inventory gui = Bukkit.createInventory(null, 6, "§d§lKit選択メニュー");

		ItemStack archer = new ItemStack(Material.BOW);
		ItemStack astronaut = new ItemStack(Material.GLASS);
		ItemStack attacker = new ItemStack(Material.FISHING_ROD);
		ItemStack berserker = new ItemStack(Material.POTION, 1, (short)8201);
		ItemStack blizzard = new ItemStack(Material.ICE);
		ItemStack boxer = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack comet = new ItemStack(Material.FEATHER);
		ItemStack counter = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack enderman = new ItemStack(Material.ENDER_PEARL);
		ItemStack fisherman = new ItemStack(Material.RAW_FISH);
		ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
		ItemStack healthboost = new ItemStack(Material.GOLDEN_APPLE);
		ItemStack iron = new ItemStack(Material.IRON_INGOT);
		ItemStack lightning = new ItemStack(Material.DOUBLE_PLANT);
		ItemStack madness = new ItemStack(Material.POTION, 1, (short)8204);
		ItemStack miner = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemStack potionhandler = new ItemStack(Material.POTION, 1, (short)16396);
		ItemStack rabbit = new ItemStack(Material.RABBIT_FOOT);
		ItemStack recover = new ItemStack(Material.GHAST_TEAR);
		ItemStack revival = new ItemStack(Material.POTION, 1, (short)8193);
		ItemStack slasher = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack sniper = new ItemStack(Material.LONG_GRASS);
		ItemStack standard = new ItemStack(Material.IRON_SWORD);
		ItemStack tank = new ItemStack(Material.ANVIL);
		ItemStack tapiocamilktea = new ItemStack(Material.MILK_BUCKET);

		ItemStack line1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemStack line2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);

		meta = archer.getItemMeta();
		meta.setDisplayName("§bArcher Kitを選択する");
		archer.setItemMeta(meta);

		meta = astronaut.getItemMeta();
		meta.setDisplayName("§bAstronaut Kitを選択する");
		astronaut.setItemMeta(meta);

		meta = attacker.getItemMeta();
		meta.setDisplayName("§cAttacker Kitを選択する");
		attacker.setItemMeta(meta);

		meta = berserker.getItemMeta();
		meta.setDisplayName("§cBerserker Kitを選択する");
		berserker.setItemMeta(meta);

		meta = blizzard.getItemMeta();
		meta.setDisplayName("§cBlizzard Kitを選択する");
		blizzard.setItemMeta(meta);

		meta = boxer.getItemMeta();
		meta.setDisplayName("§bBoxer Kitを選択する");
		boxer.setItemMeta(meta);

		meta = comet.getItemMeta();
		meta.setDisplayName("§bComet Kitを選択する");
		comet.setItemMeta(meta);

		meta = counter.getItemMeta();
		meta.setDisplayName("§cCounter Kitを選択する");
		counter.setItemMeta(meta);

		meta = enderman.getItemMeta();
		meta.setDisplayName("§cEnderman Kitを選択する");
		enderman.setItemMeta(meta);

		meta = fisherman.getItemMeta();
		meta.setDisplayName("§bFisherman Kitを選択する");
		fisherman.setItemMeta(meta);

		meta = flame.getItemMeta();
		meta.setDisplayName("§bFlame Kitを選択する");
		flame.setItemMeta(meta);

		meta = healthboost.getItemMeta();
		meta.setDisplayName("§cHealthBoost Kitを選択する");
		healthboost.setItemMeta(meta);

		meta = iron.getItemMeta();
		meta.setDisplayName("§bIron Kitを選択する");
		iron.setItemMeta(meta);

		meta = lightning.getItemMeta();
		meta.setDisplayName("§bLightning Kitを選択する");
		lightning.setItemMeta(meta);

		meta = madness.getItemMeta();
		meta.setDisplayName("§cMadness Kitを選択する");
		madness.setItemMeta(meta);

		meta = miner.getItemMeta();
		meta.setDisplayName("§bMiner Kitを選択する");
		miner.setItemMeta(meta);

		meta = potionhandler.getItemMeta();
		meta.setDisplayName("§bPotionHandler Kitを選択する");
		potionhandler.setItemMeta(meta);

		meta = rabbit.getItemMeta();
		meta.setDisplayName("§cRabbit Kitを選択する");
		rabbit.setItemMeta(meta);

		meta = recover.getItemMeta();
		meta.setDisplayName("§bRecover Kitを選択する");
		recover.setItemMeta(meta);

		meta = revival.getItemMeta();
		meta.setDisplayName("§cRevival Kitを選択する");
		revival.setItemMeta(meta);

		meta = slasher.getItemMeta();
		meta.setDisplayName("§bSlasher Kitを選択する");
		slasher.setItemMeta(meta);

		meta = sniper.getItemMeta();
		meta.setDisplayName("§cSniper Kitを選択する");
		sniper.setItemMeta(meta);

		meta = standard.getItemMeta();
		meta.setDisplayName("§bStandard Kitを選択する");
		standard.setItemMeta(meta);

		meta = tank.getItemMeta();
		meta.setDisplayName("§bTank Kitを選択する");
		tank.setItemMeta(meta);

		meta = tapiocamilktea.getItemMeta();
		meta.setDisplayName("§dTapiocaMilkTea Kitを選択する");
		tapiocamilktea.setItemMeta(meta);

		meta = line1.getItemMeta();
		meta.setDisplayName("§7<- §b一般Kit");
		meta.setLore(new ArrayList<String>(Arrays.asList("§c購入Kit §7->")));
		line1.setItemMeta(meta);

		meta = line2.getItemMeta();
		meta.setDisplayName("§7左クリックでKitを選択");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7右クリックでKitの詳細を確認")));
		line2.setItemMeta(meta);

		gui.setItem(0, archer);
		gui.setItem(1, astronaut);
		gui.setItem(2, boxer);
		gui.setItem(3, comet);
		gui.setItem(4, line1);
		gui.setItem(5, attacker);
		gui.setItem(6, blizzard);
		gui.setItem(7, berserker);
		gui.setItem(8, counter);
		gui.setItem(9, fisherman);
		gui.setItem(10, flame);
		gui.setItem(11, iron);
		gui.setItem(12, lightning);
		gui.setItem(13, line1);
		gui.setItem(14, enderman);
		gui.setItem(15, healthboost);
		gui.setItem(16, madness);
		gui.setItem(17, rabbit);
		gui.setItem(18, miner);
		gui.setItem(19, potionhandler);
		gui.setItem(20, recover);
		gui.setItem(21, slasher);
		gui.setItem(22, line1);
		gui.setItem(23, revival);
		gui.setItem(24, sniper);
		gui.setItem(27, standard);
		gui.setItem(28, tank);
		gui.setItem(31, line1);
		gui.setItem(40, line2);
		gui.setItem(49, tapiocamilktea);

		return gui;
	}

	@EventHandler
	public void onItemClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();

		if(player.getWorld().getName().equals("kitpvp")
				&& item.getItemMeta().getDisplayName().equals("§d§lKit選択メニューを開く")
				&& item.getItemMeta().getDisplayName() != null || item.hasItemMeta()) {
			player.openInventory(kitgui());
		}
	}

	@EventHandler
	public void onGUIClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		InventoryAction action = event.getAction();

		if(item.getItemMeta().getDisplayName() != null || item.hasItemMeta()) return;
		if(player.getWorld().getName().equals("kitpvp")
				&& inv.getName().equals("§d§lKit選択メニュー")) {

			event.setCancelled(true);

			if(item.getItemMeta().getDisplayName().equals("§bArcher Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.archer(player);
				player.sendMessage(prefix + "§bArcher Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bArcher Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.archerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bAstronaut Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.astronaut(player);
				player.sendMessage(prefix + "§bAstronaut Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bAstronaut Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.astronautGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cAttacker Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.attacker")) {
					distribute.attacker(player);
					player.sendMessage(prefix + "§cAttacker Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cAttacker Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.attackerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cBerserker Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.berserker")) {
					distribute.berserker(player);
					player.sendMessage(prefix + "§cBerserker Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cBerserker Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.berserkerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cBlizzard Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.blizzard")) {
					distribute.blizzard(player);
					player.sendMessage(prefix + "§cBlizzard Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cBlizzard Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.blizzardGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bBoxer Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.boxer(player);
				player.sendMessage(prefix + "§bBoxer Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bboxer Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.boxerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bComet Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.comet(player);
				player.sendMessage(prefix + "§bComet Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bComet Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.cometGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cCounter Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.counter")) {
					distribute.counter(player);
					player.sendMessage(prefix + "§cCounter Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cCounter Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.counterGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cEnderman Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.enderman")) {
					distribute.enderman(player);
					player.sendMessage(prefix + "§cEnderman Kit を選択しました!");
					player.sendMessage(prefix + "§dこのKitを使ってガラスの壁に登らないでください");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cEnderman Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.endermanGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bFisherman Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.fisherman(player);
				player.sendMessage(prefix + "§bFisherman Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bFisherman Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.fishermanGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bFlame Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.flame(player);
				player.sendMessage(prefix + "§bFlame Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bFlame Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.flameGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cHealthBoost Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.healthboost")) {
					distribute.healthboost(player);
					player.sendMessage(prefix + "§cHealthBoost Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cHealthBoost Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.healthboostGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bIron Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.iron(player);
				player.sendMessage(prefix + "§bIron Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bIron Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.ironGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bLightning Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.lightning(player);
				player.sendMessage(prefix + "§bLightning Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bLightning Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.lightningGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cMadness Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.madness")) {
					distribute.madness(player);
					player.sendMessage(prefix + "§cMadness Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cMadness Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.madnessGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bMiner Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.miner(player);
				player.sendMessage(prefix + "§bMiner Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bMiner Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.minerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bPotionHandler Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.potionhandler(player);
				player.sendMessage(prefix + "§bPotionHandler Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bPotionHandler Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.potionhandlerGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cRabbit Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.rabbit")) {
					distribute.rabbit(player);
					player.sendMessage(prefix + "§cRabbit Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cRabbit Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.rabbitGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bRecover Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.recover(player);
				player.sendMessage(prefix + "§bRecover Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bRecover Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.recoverGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cRevival Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.revival")) {
					distribute.revival(player);
					player.sendMessage(prefix + "§cRevival Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cRevival Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.revivalGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bSlasher Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.slasher(player);
				player.sendMessage(prefix + "§bSlasher Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bSlasher Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.slasherGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§cSniper Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.purchase.sniper")) {
					distribute.sniper(player);
					player.sendMessage(prefix + "§cSniper Kit を選択しました!");
				} else {
					player.closeInventory();
					player.sendMessage(prefix + "§cKitを購入してください");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§cSniper Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.sniperGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bStandard Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.standard(player);
				player.sendMessage(prefix + "§bStandard Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bStandard Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.standardGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§bTank Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				distribute.tank(player);
				player.sendMessage(prefix + "§bTank Kit を選択しました!");
			} else 	if(item.getItemMeta().getDisplayName().equals("§bTank Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.tankGUI());
			}

			if(item.getItemMeta().getDisplayName().equals("§dTapiocaMilkTea Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_ALL)) {
				if(player.hasPermission("mizinkopvp.kit.vote.tapiocamilktea")) {
					distribute.tapiocamilktea(player);
					player.sendMessage(prefix + "§dTapiocaMilkTea Kit を選択しました!");
				} else {
					player.sendMessage(prefix + "§cこのKitはJMSで投票をすると使用可能です!");
					player.sendMessage(prefix + "§a投票(JMS): https://minecraft.jp/servers/azisaba.net");
				}
			} else 	if(item.getItemMeta().getDisplayName().equals("§dTapiocaMilkTea Kitを選択する")
					&& action.equals(InventoryAction.PICKUP_HALF)) {
				player.openInventory(indicate.tapiocamilkteaGUI());
			}
		}
	}
}