package com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.rakaienguard.seaboy1234.bukkit.SeaHome.Home;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.SeaHome;

public class HomeCommand implements CommandExecutor {
	private SeaHome plugin;

	public HomeCommand(SeaHome plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lbl,
			String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(ChatColor.RED + "You must be a player to go home.");
			return true;
		}
		Player p = (Player)cs;
		if(!plugin.ph.Has(p, "GoHome")) {
			p.sendMessage(ChatColor.RED + "You do not have permission to go home.");
			return true;
		}
		if(args.length == 0){
			Home h = plugin.GetHome((Player)cs, p.getWorld().getName());
			World w = p.getWorld();
			if(h == null){
				cs.sendMessage(ChatColor.RED + "You have no home in " + p.getWorld().getName() + ".  Use /sethome to set one.");
				return true;
			}
			p.teleport(new Location(w, h.getX(), h.getY(), h.getZ(), h.getYaw(), h.getPitch()));
			p.sendMessage(ChatColor.GREEN + "You have returned to your home in " + w.getName());
			return true;
		}
		else {
			Home h = plugin.GetHome((Player)cs, args[0]);
			World w = plugin.getServer().getWorld(args[0]);
			if(w == null){
				cs.sendMessage(ChatColor.RED + "No world named " + args[0] + " exists.");
				return true;
			}
			if(h == null){
				cs.sendMessage(ChatColor.RED + "You have no home in " + args[0] + ".  Use /sethome to set one.");
				return true;
			}
			p.teleport(new Location(w, h.getX(), h.getY(), h.getZ(), h.getYaw(), h.getPitch()));
			p.sendMessage(ChatColor.GREEN + "You have returned to your home in " + w.getName());
			return true;
		}
	}
}
