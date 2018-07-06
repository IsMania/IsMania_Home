package fr.ismania.home;

import org.bukkit.plugin.java.JavaPlugin;

import fr.ismania.home.commands.CommandDelHome;
import fr.ismania.home.commands.CommandHome;
import fr.ismania.home.commands.CommandSetHome;

public class Main extends JavaPlugin {

	public String prefix = "§7[§aIs§2Home§7] ";
	
	@Override
	public void onEnable() {
		
		getLogger().info("Plugin activé.");
	
		saveDefaultConfig();
		
		getCommand("home").setExecutor(new CommandHome(this));
		getCommand("sethome").setExecutor(new CommandSetHome(this));
		getCommand("delhome").setExecutor(new CommandDelHome(this));
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Plugin désactivé.");
		
	}
	
}
