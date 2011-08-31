package com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.rakaienguard.seaboy1234.bukkit.SeaHome.Home;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.SeaHome;

public class SetHomeCommand implements CommandExecutor {
	private SeaHome plugin;

	public SetHomeCommand(SeaHome plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lbl,
			String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage(ChatColor.RED + "How can you set your home when you are not a player?  Tell me how so I can add it to the plugin!  Cause I would like to know.");
			return true;
		}
		Player p = (Player)cs;
		if(!plugin.ph.Has(p, "SetHome")){
			p.sendMessage(ChatColor.RED + "You do not have permission to set home.");
			return true;
		}
		Home h = plugin.GetHome(p, p.getWorld().getName());
		if(h != null) {
			h.setX(p.getLocation().getX());
			h.setY(p.getLocation().getY());
			h.setZ(p.getLocation().getZ());
			h.setPitch(p.getLocation().getPitch());
			h.setYaw(p.getLocation().getYaw());
			plugin.getDatabase().save(h);
			p.sendMessage(ChatColor.GREEN + "Your home in " + p.getWorld().getName() + " has been set to your current location.");
			return true;
		}
		else {
			h = new Home();
			h.setX(p.getLocation().getX());
			h.setY(p.getLocation().getY());
			h.setZ(p.getLocation().getZ());
			h.setPitch(p.getLocation().getPitch());
			h.setYaw(p.getLocation().getYaw());
			h.setWorld(p.getWorld().getName());
			h.setPlayer(p.getName());
			plugin.getDatabase().save(h);
			p.sendMessage(ChatColor.GREEN + "Your home in " + p.getWorld().getName() + " has been set to your current location.");
			return true;
		}
	}

}
