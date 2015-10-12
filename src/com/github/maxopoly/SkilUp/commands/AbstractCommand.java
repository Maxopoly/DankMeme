package com.github.maxopoly.SkilUp.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.github.maxopoly.SkilUp.SkilUp;

public abstract class AbstractCommand {
	protected final SkilUp plugin;
	protected final String name;

	public AbstractCommand(SkilUp instance, String commandName) {
		plugin = instance;
		name = commandName;
	}

	public abstract boolean onCommand(CommandSender sender, List<String> args);

	public boolean onConsoleCommand(CommandSender sender, List<String> args) {
		return onCommand(sender, args);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		try {
			return plugin.getCommand("em " + name).getDescription();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public String getUsage() {
		try {
			return plugin.getCommand("em " + name).getUsage();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public String getPermission() {
		try {
			return plugin.getCommand("em " + name).getPermission();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public List<String> getAliases() {
		try {
			return plugin.getCommand("em " + name).getAliases();
		} catch (NullPointerException e) {
			return null;
		}
	}
}