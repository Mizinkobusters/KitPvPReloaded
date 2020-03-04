package mb.mizinkobusters.kitpvp.gui;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import mb.mizinkobusters.kitpvp.KitPvP;

public class IndicateKits implements Listener {

	JavaPlugin plugin;
	ItemMeta meta;
	String prefix = "§7[§dKitPvP§7] ";

	public IndicateKits(KitPvP plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onGUIClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();

		if (player.getWorld().getName().equals("kitpvp") && inv.getName().endsWith("Kit)")) {
			event.setCancelled(true);
		}
	}

	public Inventory archerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lArcher Kit§7(一般Kit)");

		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.IRON_FENCE);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

		meta = bow.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7弓[無限I]")));
		bow.setItemMeta(meta);

		meta = arrow.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7矢×1")));
		arrow.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革の上着")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, bow);
		gui.setItem(19, arrow);
		gui.setItem(20, gapple);

		return gui;
	}

	public Inventory astronautGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lAstronaut Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.RABBIT_FOOT);
		ItemStack ability2 = new ItemStack(Material.LEATHER_BOOTS);
		ItemStack ability3 = new ItemStack(Material.IRON_BOOTS);

		ItemStack helmet = new ItemStack(Material.GLASS);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7跳躍力上昇III")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7移動速度低下II")));
		ability2.setItemMeta(meta);

		meta = ability3.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7落下ダメージ無効")));
		ability3.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ガラス")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);
		gui.setItem(11, ability3);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory attackerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lAttacker Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack rod = new ItemStack(Material.FISHING_ROD);
		rod.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.IRON_FENCE);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = rod.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7釣り竿×1[耐久10]")));
		rod.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, rod);
		gui.setItem(20, gapple);

		return gui;
	}

	public Inventory berserkerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lBerserker Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.IRON_FENCE);

		ItemStack ability1 = new ItemStack(Material.WOOD_SWORD);
		ItemStack ability2 = new ItemStack(Material.POTION, 1, (short) 8201);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7弱体化I")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(
				new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すと弱体化がかき消され", "§77秒間攻撃力上昇Iが付与される")));
		ability2.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory blizzardGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lBlizzard Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.ICE);

		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§71/7の確率で相手に鈍足IVを3秒間付与して氷漬けにする")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory boxerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lBoxer Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.IRON_FENCE);

		ItemStack helmet = new ItemStack(Material.IRON_FENCE);
		ItemStack chestplate = new ItemStack(Material.IRON_FENCE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_FENCE);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤの剣[ダメージ増加5]")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	// TODO 防具に色つける
	public Inventory cometGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lComet Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.FEATHER);

		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7移動速度上昇III")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革の帽子")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革の上着")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory counterGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lCounter Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.STONE_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.DIAMOND_CHESTPLATE);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7石の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(
				new ArrayList<String>(Arrays.asList("§71/5の確率で受けるダメージを半分にし", "§7受けたダメージを相手にも与える")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory endermanGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lEnderman Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack pearl = new ItemStack(Material.ENDER_PEARL, 2);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.ENDER_PEARL);

		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = pearl.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7エンダーパール×2")));
		pearl.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すとエンダーパールを獲得できる")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ[落下耐性II]")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, pearl);
		gui.setItem(20, gapple);

		return gui;
	}

	public Inventory fishermanGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lFisherman Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack rod = new ItemStack(Material.FISHING_ROD);

		ItemStack ability1 = new ItemStack(Material.RAW_FISH);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		boots.addEnchantment(Enchantment.DEPTH_STRIDER, 1);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7釣り竿をプレイヤーに当てると引き寄せられる")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のブーツ[水中歩行I]")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, rod);

		return gui;
	}

	public Inventory flameGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lFlame Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);

		ItemStack arrow = new ItemStack(Material.ARROW, 10);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.BLAZE_POWDER);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣[火属性I]")));
		sword.setItemMeta(meta);

		meta = bow.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7弓[フレイムI]")));
		sword.setItemMeta(meta);

		meta = arrow.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7矢×10")));
		arrow.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7火炎ダメージ無効")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, bow);
		gui.setItem(20, arrow);

		return gui;
	}

	public Inventory healthboostGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lHealthBoost Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.IRON_FENCE);

		ItemStack ability1 = new ItemStack(Material.REDSTONE);
		ItemStack ability2 = new ItemStack(Material.APPLE);
		ItemStack ability3 = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7初期HPが18になる")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すと最大HPが1ずつ上昇する(最大26)")));
		ability2.setItemMeta(meta);

		meta = ability3.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7このKitでプレイヤー倒しても金のリンゴは獲得できない")));
		ability3.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);
		gui.setItem(11, ability3);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory ironGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lIron Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.IRON_FENCE);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 1);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣[ダメージ増加I]")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート[飛び道具耐性I]")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ[落下耐性I]")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory lightningGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lLightning Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.GOLD_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.DOUBLE_PLANT);
		ItemStack ability2 = new ItemStack(Material.GOLD_CHESTPLATE);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金の剣[ダメージ増加I]")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§71/7の確率でダメージを与えたプレイヤーの真上に", "§7雷を落とす")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7落雷ダメージ無効")));
		ability2.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory madnessGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lMadness Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.FEATHER);
		ItemStack ability2 = new ItemStack(Material.IRON_BOOTS);

		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴを食べると移動速度上昇II30秒間が付与されるが",
				"§7金のリンゴを食べた際の効果は無効化され", "§7体力が減少する", "§7また移動速度が上昇している間は体力が自然回復しない")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(
				Arrays.asList("§7歩くと1/10の確率で体力が1回復する", "§7ただし移動速度が上昇している間は体力は回復しない")));
		ability2.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory minerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lMiner Kit§7(一般Kit)");

		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.BEACON);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

		meta = pickaxe.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのツルハシ")));
		pickaxe.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すと以下のうちいずれかの効果が", "§730秒間付与される",
				"§7・自然回復I", "§7・移動速度上昇I/II", "§7・採掘速度上昇I/II", "§7・耐性I/II", "§7・跳躍力上昇I/II",
				"§7・攻撃力上昇I/II", "§7・なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, pickaxe);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory potionhandlerGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lPotionHandler Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack potion1 = new ItemStack(Material.POTION, 2, (short) 16396);
		ItemStack potion2 = new ItemStack(Material.POTION, 2, (short) 16388);
		ItemStack potion3 = new ItemStack(Material.POTION, 2, (short) 16389);

		ItemStack ability1 = new ItemStack(Material.BREWING_STAND_ITEM);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = potion1.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7負傷のスプラッシュポーション×2")));
		potion1.setItemMeta(meta);

		meta = potion2.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7毒のスプラッシュポーション×2")));
		potion2.setItemMeta(meta);

		meta = potion3.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7治癒のスプラッシュポーション×2")));
		potion3.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すと", "§7毒のスプラッシュポーションを獲得できる")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, potion1);
		gui.setItem(20, potion2);
		gui.setItem(21, potion3);

		return gui;
	}

	public Inventory rabbitGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lRabbit Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.RABBIT_FOOT);
		ItemStack ability2 = new ItemStack(Material.FEATHER);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7跳躍力速度上昇II")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7移動速度上昇II")));
		ability2.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ[落下耐性II]")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory recoverGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lRecover Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.STONE_SWORD);

		ItemStack gapple = new ItemStack(Material.IRON_FENCE);

		ItemStack ability1 = new ItemStack(Material.POTION, 1, (short) 8193);
		ItemStack ability2 = new ItemStack(Material.REDSTONE);
		ItemStack ability3 = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7石の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7プレイヤーを倒すと再生能力Iが15秒間付与される")));
		ability1.setItemMeta(meta);

		meta = ability2.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7HPが5以下のとき1/9の確率で3回復する")));
		ability2.setItemMeta(meta);

		meta = ability3.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7このKitでプレイヤーを倒しても金のリンゴは獲得できない")));
		ability3.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);
		gui.setItem(10, ability2);
		gui.setItem(11, ability3);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory revivalGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lRevival Kit§7(購入Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.IRON_FENCE);

		ItemStack ability1 = new ItemStack(Material.IRON_SWORD);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(
				new ArrayList<String>(Arrays.asList("§7HPが7以下のとき+1", "§7HPが3以下のとき+2与えるダメージが増える")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory slasherGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lSlasher Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);

		ItemStack stick = new ItemStack(Material.STICK);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.IRON_FENCE);

		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤの剣[ダメージ増加III]")));
		sword.setItemMeta(meta);

		meta = stick.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7棒[ノックバックIII]")));
		stick.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7なし")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革の帽子")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のズボン")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, stick);
		gui.setItem(20, gapple);

		return gui;
	}

	public Inventory sniperGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§c§lSniper Kit§7(購入Kit)");

		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.BOW);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

		meta = bow.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7弓[無限I, ダメージ増加I]")));
		bow.setItemMeta(meta);

		meta = arrow.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7矢×1")));
		arrow.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7相手との距離で与えるダメージ量が変化する", "§75m以内: -4ダメージ",
				"§710m以内: -2ダメージ", "§715m以内: +0ダメージ", "§720m以内: +1ダメージ", "§720mより遠いと +2ダメージ")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革の上着")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7革のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, bow);
		gui.setItem(19, arrow);
		gui.setItem(20, gapple);

		return gui;
	}

	public Inventory standardGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lStandard Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.FEATHER);

		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴを食べると", "§730秒間移動速度上昇Iが付与される")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory tankGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§b§lTank Kit§7(一般Kit)");

		ItemStack sword = new ItemStack(Material.WOOD_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);

		ItemStack ability1 = new ItemStack(Material.ANVIL);

		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7木の剣[ダメージ増加I]")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7金のリンゴ×2")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7移動速度低下III")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7ダイヤのブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, gapple);

		return gui;
	}

	public Inventory tapiocamilkteaGUI() {
		Inventory gui = Bukkit.createInventory(null, 27, "§d§lTapiocaMilkTea Kit§7(限定Kit)");

		ItemStack sword = new ItemStack(Material.IRON_SWORD);

		ItemStack milk = new ItemStack(Material.MILK_BUCKET);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);

		ItemStack ability1 = new ItemStack(Material.MILK_BUCKET);

		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);

		meta = sword.getItemMeta();
		meta.setDisplayName("§7武器");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄の剣")));
		sword.setItemMeta(meta);

		meta = gapple.getItemMeta();
		meta.setDisplayName("§7補助");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7牛乳×1")));
		gapple.setItemMeta(meta);

		meta = ability1.getItemMeta();
		meta.setDisplayName("§7特殊");
		meta.setLore(new ArrayList<String>(
				Arrays.asList("§7牛乳(ﾀﾋﾟｵｶﾐﾙｸﾃｨｰ)を飲むと", "§7毒の効果がかき消される", "§7さらに再生能力Iが5秒間付与される")));
		ability1.setItemMeta(meta);

		meta = helmet.getItemMeta();
		meta.setDisplayName("§7頭装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのヘルメット")));
		helmet.setItemMeta(meta);

		meta = chestplate.getItemMeta();
		meta.setDisplayName("§7胴装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7チェーンのチェストプレート")));
		chestplate.setItemMeta(meta);

		meta = leggings.getItemMeta();
		meta.setDisplayName("§7腰装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のレギンス")));
		leggings.setItemMeta(meta);

		meta = boots.getItemMeta();
		meta.setDisplayName("§7足装備");
		meta.setLore(new ArrayList<String>(Arrays.asList("§7鉄のブーツ")));
		boots.setItemMeta(meta);

		gui.setItem(0, helmet);
		gui.setItem(1, chestplate);
		gui.setItem(2, leggings);
		gui.setItem(3, boots);

		gui.setItem(9, ability1);

		gui.setItem(18, sword);
		gui.setItem(19, milk);

		return gui;
	}
}
