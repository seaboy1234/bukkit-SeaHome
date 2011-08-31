package com.rakaienguard.seaboy1234.bukkit.SeaHome.Commands;

import java.util.Hashtable;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.rakaienguard.seaboy1234.bukkit.SeaHome.SeaHome;
import com.rakaienguard.seaboy1234.bukkit.SeaHome.WaveLogger;

public class CommandHandler{
	private SeaHome plugin;
	private Map<String, CommandExecutor> commands;
	
	public CommandHandler(SeaHome plugin) {
		this.plugin = plugin;
		commands = new Hashtable<String, CommandExecutor>();
	}
	
	public void HandleCommand(String Command, CommandExecutor ce) {
		try {
			plugin.getCommand(Command).setExecutor(ce);
		}
		catch(NullPointerException e) {
			WaveLogger.error(e);
			return;
		}
		commands.put(Command, ce);
	}
    public boolean dispatch(CommandSender sender, Command command, String label, String[] args) {
        if (!commands.containsKey(label)) {
            return false;
        }

        boolean handled = true;

        CommandExecutor ce = commands.get(label);
        handled = ce.onCommand(sender, command, label, args);

        return handled;
    }
}
