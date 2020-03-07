package mb.mizinkobusters.kitpvp.gui;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import mb.mizinkobusters.kitpvp.KitPvP;

public class DistributeKits implements Listener {

	JavaPlugin plugin;

	public DistributeKits(KitPvP plugin) {
		this.plugin = plugin;
	}

	ItemMeta meta;
	LeatherArmorMeta lmeta;

	public void bone(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack respawn = new ItemStack(Material.BONE);
		meta = respawn.getItemMeta();
		meta.setDisplayName("§c§lクリックでリスポーン");
		respawn.setItemMeta(meta);

		inv.addItem(respawn);
	}

	public void archer(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

		inv.addItem(bow);
		inv.addItem(new ItemStack(Material.ARROW));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.LEATHER_BOOTS));
	}

	public void astronaut(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.ARROW));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.GLASS));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));

		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2, false, false));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 1, false, false));
	}

	public void attacker(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack rod = new ItemStack(Material.FISHING_ROD);
		rod.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(rod);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));
	}

	public void berserker(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));

		player.addPotionEffect(
				new PotionEffect(PotionEffectType.WEAKNESS, 1000000, 0, false, false));
	}

	public void blizzard(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	}

	public void boxer(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		inv.addItem(sword);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
	}

	public void comet(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		helmet.addEnchantment(Enchantment.DURABILITY, 1);
		lmeta = (LeatherArmorMeta) helmet.getItemMeta();
		lmeta.setColor(Color.AQUA);
		helmet.setItemMeta(lmeta);

		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		chestplate.addEnchantment(Enchantment.DURABILITY, 1);
		lmeta = (LeatherArmorMeta) helmet.getItemMeta();
		lmeta.setColor(Color.AQUA);
		chestplate.setItemMeta(lmeta);

		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		leggings.addEnchantment(Enchantment.DURABILITY, 1);
		lmeta = (LeatherArmorMeta) helmet.getItemMeta();
		lmeta.setColor(Color.AQUA);
		leggings.setItemMeta(lmeta);

		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		boots.addEnchantment(Enchantment.DURABILITY, 1);

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(helmet);
		inv.setChestplate(chestplate);
		inv.setLeggings(leggings);
		inv.setBoots(boots);

		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 2, false, false));
	}

	public void counter(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.STONE_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	}

	public void enderman(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.ENDER_PEARL, 2));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(boots);
	}

	public void fisherman(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.FISHING_ROD));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(new ItemStack(Material.LEATHER_BOOTS));
	}

	public void flame(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);

		inv.addItem(sword);
		inv.addItem(bow);
		inv.addItem(new ItemStack(Material.ARROW, 10));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));

		player.addPotionEffect(
				new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 3, false, false));
	}

	public void healthboost(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.STONE_SWORD));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));

		player.setMaxHealth(18.0);
	}

	public void iron(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 1);

		inv.addItem(sword);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(chestplate);
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(boots);
	}

	public void lightning(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.GOLD_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

		inv.addItem(sword);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		inv.setBoots(new ItemStack(Material.GOLD_BOOTS));
	}

	public void madness(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));
	}

	public void miner(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.DIAMOND_PICKAXE));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(new ItemStack(Material.LEATHER_BOOTS));

		player.addPotionEffect(
				new PotionEffect(PotionEffectType.FAST_DIGGING, 1000000, 1, false, false));
	}

	public void potionhandler(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.POTION, 2, (short) 16396)); // 負傷
		inv.addItem(new ItemStack(Material.POTION, 2, (short) 16388)); // 毒
		inv.addItem(new ItemStack(Material.POTION, 2, (short) 16389)); // 治癒
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	public void rabbit(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(boots);

		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1, false, false));
		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 1, false, false));
	}

	public void recover(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.STONE_SWORD));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	}

	public void revival(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));
	}

	public void slasher(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		ItemStack stick = new ItemStack(Material.STICK);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);

		inv.addItem(sword);
		inv.addItem(stick);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
		bone(player);

		inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	public void sniper(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

		inv.addItem(bow);
		inv.addItem(new ItemStack(Material.ARROW));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		inv.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	public void standard(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE));
		bone(player);

		inv.setHelmet(new ItemStack(Material.IRON_HELMET));
		inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));
	}

	public void tank(Player player) {
		PlayerInventory inv = player.getInventory();

		ItemStack sword = new ItemStack(Material.WOOD_SWORD);

		inv.addItem(sword);
		inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
		bone(player);

		inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));

		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 2, false, false));
	}

	public void tapiocamilktea(Player player) {
		PlayerInventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.IRON_SWORD));
		inv.addItem(new ItemStack(Material.MILK_BUCKET));
		bone(player);

		inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		inv.setBoots(new ItemStack(Material.IRON_BOOTS));
	}
}
