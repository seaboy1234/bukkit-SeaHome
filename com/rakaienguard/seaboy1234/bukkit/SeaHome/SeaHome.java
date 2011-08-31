package com.rakaienguard.seaboy1234.bukkit.SeaHome;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.rakaienguard.seaboy1234.CrossPermissions.PermissionsHandler;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands.CommandHandler;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands.HomeCommand;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands.SetHomeCommand;


public class SeaHome extends JavaPlugin {
	public PluginManager pm;
	public PermissionsHandler ph;
	public CommandHandler ch;

	@Override
	public List<Class<?>> getDatabaseClasses() {
		ArrayList<Class<?>> list = new ArrayList<Class<?>>();
		list.add(Home.class);
		return list;

	}

	public Home GetHome(Player player, String world)
	{
		Home h = getDatabase().find(Home.class).where().ieq("world", world).ieq("player", player.getName()).findUnique();
		return h;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return ch.dispatch(sender, command, label, args);
	}
	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {
		pm = getServer().getPluginManager();
		WaveLogger.Load(this);
		ch = new CommandHandler(this);
		ph = PermissionsHandler.getHandler(this, pm, "SeaHome", "SeaHome.admin");
		SetupDatabase();
		ch.HandleCommand("home", new HomeCommand(this));
		ch.HandleCommand("sethome", new SetHomeCommand(this));
		WaveLogger.info("Enabled.");
	}

	public void SetupDatabase()
	{
		try{
			getDatabase().find(Home.class).findRowCount();
		}catch(Exception e){
			installDDL();
		}
	}
}
