package mb.mizinkobusters.kitpvp;

import java.util.List;
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
import mb.mizinkobusters.kitpvp.listener.ItemDropListener;
import mb.mizinkobusters.kitpvp.listener.PlayerFallOrTeleportToFieldListener;
import mb.mizinkobusters.kitpvp.listener.PlayerHasEntriesListener;
import mb.mizinkobusters.kitpvp.listener.PlayerItemClickListener;
import mb.mizinkobusters.kitpvp.listener.PlayerItemDamageListener;
import mb.mizinkobusters.kitpvp.listener.PlayerKillListener;
import mb.mizinkobusters.kitpvp.listener.PlayerLeaveTeamListener;
import mb.mizinkobusters.kitpvp.listener.PlayerLoggingListener;
import mb.mizinkobusters.kitpvp.listener.PlayerRespawnListener;
import mb.mizinkobusters.kitpvp.listener.ProjectileHitListener;

public class KitPvP extends JavaPlugin implements Listener {

	Scoreboard sb;
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
		String plname = getDescription().getName();
		String ver = getDescription().getVersion();
		List<String> author = getDescription().getAuthors();
		String prefix = "[" + plname + "] ";

		Bukkit.getLogger().info(prefix + "");
		Bukkit.getLogger().info(prefix + plname + "(v." + ver + ") - by" + author);
		Bukkit.getLogger().info(prefix + "This plug-in has started up.");
		Bukkit.getLogger().info(prefix + "Hello players :)");


		SelectGUI select = new SelectGUI(this);
		// RespawnTimer respawnT = new RespawnTimer(this, select);

		// Listener 登録
		Bukkit.getPluginManager().registerEvents(new ItemDropListener(this, select), this);
		Bukkit.getPluginManager()
				.registerEvents(new PlayerFallOrTeleportToFieldListener(this, select), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHasEntriesListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerItemClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerItemDamageListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerKillListener(this, select), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLeaveTeamListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLoggingListener(this, select), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRespawnListener(this, select), this);
		Bukkit.getPluginManager().registerEvents(new ProjectileHitListener(this), this);

		Bukkit.getPluginManager().registerEvents(new DistributeKits(this), this);
		Bukkit.getPluginManager().registerEvents(new IndicateKits(this), this);
		Bukkit.getPluginManager().registerEvents(new PurchaseGUI(this), this);
		Bukkit.getPluginManager().registerEvents(select, this);

		// Kit 登録
		Bukkit.getPluginManager().registerEvents(new Archer(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Astronaut(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Attacker(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Berserker(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Blizzard(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Boxer(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Comet(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Counter(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Enderman(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Fisherman(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Flame(this, select), this);
		Bukkit.getPluginManager().registerEvents(new HealthBoost(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Iron(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Lightning(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Madness(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Miner(this, select), this);
		Bukkit.getPluginManager().registerEvents(new PotionHandler(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Rabbit(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Recover(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Revival(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Slasher(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Sniper(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Standard(this, select), this);
		Bukkit.getPluginManager().registerEvents(new Tank(this, select), this);
		Bukkit.getPluginManager().registerEvents(new TapiocaMilkTea(this, select), this);

		// Command 登録
		Bukkit.getPluginCommand("Accept").setExecutor(new Accept(this));
		Bukkit.getPluginCommand("Disband").setExecutor(new Disband(this));
		Bukkit.getPluginCommand("Request").setExecutor(new Request(this));

		// チーム生成
		sb = Bukkit.getScoreboardManager().getNewScoreboard();

		black = sb.getTeam("black");
		if (black == null) {
			black = createKitPvPTeam("black");
		}

		dark_blue = sb.getTeam("dark_blue");
		if (dark_blue == null) {
			dark_blue = createKitPvPTeam("dark_blue");
		}

		dark_green = sb.getTeam("dark_green");
		if (dark_green == null) {
			dark_green = createKitPvPTeam("dark_green");
		}

		dark_aqua = sb.getTeam("dark_aqua");
		if (dark_aqua == null) {
			dark_aqua = createKitPvPTeam("dark_aqua");
		}

		dark_red = sb.getTeam("dark_red");
		if (dark_red == null) {
			dark_red = createKitPvPTeam("dark_red");
		}

		dark_purple = sb.getTeam("dark_purple");
		if (dark_purple == null) {
			dark_purple = createKitPvPTeam("dark_purple");
		}

		gold = sb.getTeam("gold");
		if (gold == null) {
			gold = createKitPvPTeam("gold");
		}

		gray = sb.getTeam("gray");
		if (gray == null) {
			gray = createKitPvPTeam("gray");
		}

		dark_gray = sb.getTeam("dark_gray");
		if (dark_gray == null) {
			dark_gray = createKitPvPTeam("dark_gray");
		}

		blue = sb.getTeam("blue");
		if (blue == null) {
			blue = createKitPvPTeam("blue");
		}

		green = sb.getTeam("green");
		if (green == null) {
			green = createKitPvPTeam("green");
		}

		aqua = sb.getTeam("aqua");
		if (aqua == null) {
			aqua = createKitPvPTeam("aqua");
		}

		red = sb.getTeam("red");
		if (red == null) {
			red = createKitPvPTeam("red");
		}

		light_purple = sb.getTeam("light_purple");
		if (light_purple == null) {
			light_purple = createKitPvPTeam("light_purple");
		}

		yellow = sb.getTeam("yellow");
		if (yellow == null) {
			yellow = createKitPvPTeam("yellow");
		}

	}

	public void onReload() {
		Bukkit.getLogger().info("This plug-in is reloaded now...");
	}

	public void onDisable() {
		Bukkit.getLogger().info("This plug-in has shut down...");
		Bukkit.getLogger().info("See you next time. ;)");
	}

	public Team createKitPvPTeam(String teamName) {
		Team team = sb.registerNewTeam(teamName);
		team.setAllowFriendlyFire(false);
		team.setCanSeeFriendlyInvisibles(true);
		team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);

		return team;
	}
}
