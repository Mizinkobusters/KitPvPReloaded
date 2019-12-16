package mb.mizinkobusters.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import mb.mizinkobusters.kitpvp.command.Accept;
import mb.mizinkobusters.kitpvp.command.Disband;
import mb.mizinkobusters.kitpvp.command.Request;
import mb.mizinkobusters.kitpvp.gui.DistributeKits;
import mb.mizinkobusters.kitpvp.gui.IndicateKits;
import mb.mizinkobusters.kitpvp.gui.PurchaseGUI;
import mb.mizinkobusters.kitpvp.gui.SelectGUI;
import mb.mizinkobusters.kitpvp.kit.Archer;
import mb.mizinkobusters.kitpvp.kit.Astronaut;
import mb.mizinkobusters.kitpvp.kit.Attacker;
import mb.mizinkobusters.kitpvp.kit.Berserker;
import mb.mizinkobusters.kitpvp.kit.Blizzard;
import mb.mizinkobusters.kitpvp.kit.Boxer;
import mb.mizinkobusters.kitpvp.kit.Comet;
import mb.mizinkobusters.kitpvp.kit.Counter;
import mb.mizinkobusters.kitpvp.kit.Enderman;
import mb.mizinkobusters.kitpvp.kit.Fisherman;
import mb.mizinkobusters.kitpvp.kit.Flame;
import mb.mizinkobusters.kitpvp.kit.HealthBoost;
import mb.mizinkobusters.kitpvp.kit.Iron;
import mb.mizinkobusters.kitpvp.kit.Lightning;
import mb.mizinkobusters.kitpvp.kit.Madness;
import mb.mizinkobusters.kitpvp.kit.Miner;
import mb.mizinkobusters.kitpvp.kit.PotionHandler;
import mb.mizinkobusters.kitpvp.kit.Rabbit;
import mb.mizinkobusters.kitpvp.kit.Recover;
import mb.mizinkobusters.kitpvp.kit.Revival;
import mb.mizinkobusters.kitpvp.kit.Slasher;
import mb.mizinkobusters.kitpvp.kit.Sniper;
import mb.mizinkobusters.kitpvp.kit.Standard;
import mb.mizinkobusters.kitpvp.kit.Tank;
import mb.mizinkobusters.kitpvp.kit.TapiocaMilkTea;
import mb.mizinkobusters.kitpvp.listener.PlayerFallOrTeleportToFieldListener;
import mb.mizinkobusters.kitpvp.listener.PlayerHasEntriesListener;
import mb.mizinkobusters.kitpvp.listener.PlayerItemDamageListener;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;
import mb.mizinkobusters.kitpvp.listener.PlayerLeaveTeamListener;
import mb.mizinkobusters.kitpvp.listener.PlayerLoggingListener;
import mb.mizinkobusters.kitpvp.listener.PlayerRespawnListener;

public class KitPvP extends JavaPlugin implements Listener {

	/*
	 *
	 * This plug-in was made by Mizinkobusters.
	 * Contact me: (Twitter) @Mizinkobusters
	 *
	 */

	Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
	Team black;
	Team dark_blue;
	Team dark_green;
	Team dark_aqua;
	Team dark_red;
	Team dark_purple;
	Team gold;
	Team gray;
	Team dark_gray;
	Team blue;
	Team green;
	Team aqua;
	Team red;
	Team light_purple;
	Team yellow;

	public void onEnable() {

		System.out.println("");
		System.out.println("Name: " + getDescription().getName());
		System.out.println("Version: " + getDescription().getVersion());
		System.out.println("Authors: " + getDescription().getAuthors());
		System.out.println("");
		System.out.println("This plug-in has started up.");
		System.out.println("Hello :)");
		System.out.println("");

		//Listener 登録
		Bukkit.getPluginManager().registerEvents(new PlayerFallOrTeleportToFieldListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHasEntriesListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerItemDamageListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerKillListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLeaveTeamListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLoggingListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRespawnListener(this), this);

		Bukkit.getPluginManager().registerEvents(new DistributeKits(this), this);
		Bukkit.getPluginManager().registerEvents(new IndicateKits(this), this);
		Bukkit.getPluginManager().registerEvents(new PurchaseGUI(this), this);
		Bukkit.getPluginManager().registerEvents(new SelectGUI(this), this);

		//Kit 登録
		Bukkit.getPluginManager().registerEvents(new Archer(this), this);
		Bukkit.getPluginManager().registerEvents(new Astronaut(this), this);
		Bukkit.getPluginManager().registerEvents(new Attacker(this), this);
		Bukkit.getPluginManager().registerEvents(new Berserker(this), this);
		Bukkit.getPluginManager().registerEvents(new Blizzard(this), this);
		Bukkit.getPluginManager().registerEvents(new Boxer(this), this);
		Bukkit.getPluginManager().registerEvents(new Comet(this), this);
		Bukkit.getPluginManager().registerEvents(new Counter(this), this);
		Bukkit.getPluginManager().registerEvents(new Enderman(this), this);
		Bukkit.getPluginManager().registerEvents(new Fisherman(this), this);
		Bukkit.getPluginManager().registerEvents(new Flame(this), this);
		Bukkit.getPluginManager().registerEvents(new HealthBoost(this), this);
		Bukkit.getPluginManager().registerEvents(new Iron(this), this);
		Bukkit.getPluginManager().registerEvents(new Lightning(this), this);
		Bukkit.getPluginManager().registerEvents(new Madness(this), this);
		Bukkit.getPluginManager().registerEvents(new Miner(this), this);
		Bukkit.getPluginManager().registerEvents(new PotionHandler(this), this);
		Bukkit.getPluginManager().registerEvents(new Rabbit(this), this);
		Bukkit.getPluginManager().registerEvents(new Recover(this), this);
		Bukkit.getPluginManager().registerEvents(new Revival(this), this);
		Bukkit.getPluginManager().registerEvents(new Slasher(this), this);
		Bukkit.getPluginManager().registerEvents(new Sniper(this), this);
		Bukkit.getPluginManager().registerEvents(new Standard(this), this);
		Bukkit.getPluginManager().registerEvents(new Tank(this), this);
		Bukkit.getPluginManager().registerEvents(new TapiocaMilkTea(this), this);

		//Command 登録
		Bukkit.getPluginCommand("Accept").setExecutor(new Accept(this));
		Bukkit.getPluginCommand("Disband").setExecutor(new Disband(this));
		Bukkit.getPluginCommand("Request").setExecutor(new Request(this));

		//チーム生成
		black = sb.getTeam("black");
		if(black == null) {
			black = createKitPvPTeam("black");
		}

		dark_blue = sb.getTeam("dark_blue");
		if(dark_blue == null) {
			dark_blue = createKitPvPTeam("dark_blue");
		}

		dark_green = sb.getTeam("dark_green");
		if(dark_green == null) {
			dark_green = createKitPvPTeam("dark_green");
		}

		dark_aqua = sb.getTeam("dark_aqua");
		if(dark_aqua == null) {
			dark_aqua = createKitPvPTeam("dark_aqua");
		}

		dark_red = sb.getTeam("dark_red");
		if(dark_red == null) {
			dark_red = createKitPvPTeam("dark_red");
		}

		dark_purple = sb.getTeam("dark_purple");
		if(dark_purple == null) {
			dark_purple = createKitPvPTeam("dark_purple");
		}

		gold = sb.getTeam("gold");
		if(gold == null) {
			gold = createKitPvPTeam("gold");
		}

		gray = sb.getTeam("gray");
		if(gray == null) {
			gray = createKitPvPTeam("gray");
		}

		dark_gray = sb.getTeam("dark_gray");
		if(dark_gray == null) {
			dark_gray = createKitPvPTeam("dark_gray");
		}

		blue = sb.getTeam("blue");
		if(blue == null) {
			blue = createKitPvPTeam("blue");
		}

		green = sb.getTeam("green");
		if(green == null) {
			green = createKitPvPTeam("green");
		}

		aqua = sb.getTeam("aqua");
		if(aqua == null) {
			aqua = createKitPvPTeam("aqua");
		}

		red = sb.getTeam("red");
		if(red == null) {
			red = createKitPvPTeam("red");
		}

		light_purple = sb.getTeam("light_purple");
		if(light_purple == null) {
			light_purple = createKitPvPTeam("light_purple");
		}

		yellow = sb.getTeam("yellow");
		if(yellow == null) {
			yellow = createKitPvPTeam("yellow");
		}

	}

	public void onReload() {
		System.out.println("");
		System.out.println("This plug-in is reloaded now...");
		System.out.println("");
	}

	public void onDisable() {
		System.out.println("");
		System.out.println("This plug-in has shut down...");
		System.out.println("See you next time.");
		System.out.println("");
	}

	public Team createKitPvPTeam(String teamName) {
		Team team = sb.registerNewTeam(teamName);
		team.setAllowFriendlyFire(false);
		team.setCanSeeFriendlyInvisibles(true);
		team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);

		return team;
	}
}
