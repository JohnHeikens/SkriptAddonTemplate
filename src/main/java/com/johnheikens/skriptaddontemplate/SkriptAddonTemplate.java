package com.johnheikens.skriptaddontemplate;

import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolManager;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

public final class SkriptAddonTemplate extends JavaPlugin {

	private ProtocolManager protocolManager;
	private static SkriptAddonTemplate instance;
	private SkriptAddon addon;
	@Override
	public void onEnable() {
		instance = this;
		File configFile = new File(getDataFolder(), "config.yml");
		//If newer version was found, update configuration.
		int version = 1;
		if (version != getConfig().getInt("configuration-version", version)) {
			if (configFile.exists())
				configFile.delete();
		}
		saveDefaultConfig();
		try {
			addon = Skript.registerAddon(this)
					.loadClasses("com.johnheikens.skriptaddontemplate", "elements", "listeners")
					.setLanguageFileDirectory("lang");
		} catch (IOException e) {
			e.printStackTrace();
		}
		getLogger().info("[skriptaddontemplate] skriptaddontemplate has been enabled!");
	}

	public ProtocolManager getProtocolManager() {
		return protocolManager;
	}

	public SkriptAddon getAddonInstance() {
		return addon;
	}

	public static SkriptAddonTemplate getInstance() {
		return instance;
	}

}
