package fr.ismania.home.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ismania.home.Main;

public class CommandHome implements CommandExecutor {

	private Main main;
	
	public CommandHome(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cVous devez être un joueur !");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length <= 1) {
			
			if(args.length == 0) {
				
				if(main.getConfig().isSet("users." + p.getUniqueId().toString() + ".home")) {
					
					String home = "";
					
					for(String key : main.getConfig().getConfigurationSection("users." + p.getUniqueId().toString() + ".home").getKeys(false)) {
						
						home += " " + key;
						
					}
					
					p.sendMessage(main.prefix + "§aVos home(s) : §6" + home);
					
				} else {
					
					p.sendMessage(main.prefix + "§cVous n'avez pas de home ! Faite /sethome pour un ajouter un !");
					return true;
					
				}
				
			} else {
				
				if ((main.getConfig().isSet("users." + p.getUniqueId().toString() + ".home." + args[0] + ".world")) && (main.getConfig().isSet("users." + p.getUniqueId().toString() + ".home." + args[0] + ".x")) && (main.getConfig().isSet("users." + p.getUniqueId().toString() + ".home." + args[0] + ".y")) && (main.getConfig().isSet("users." + p.getUniqueId().toString() + ".home." + args[0] + ".z"))) {
					
					Location loc = new Location(main.getServer().getWorld(main.getConfig().getString("users." + p.getUniqueId().toString() + ".home." + args[0] + ".world")), main.getConfig().getDouble("users." + p.getUniqueId().toString() + ".home." + args[0] + ".x"), main.getConfig().getDouble("users." + p.getUniqueId().toString() + ".home." + args[0] + ".y"), main.getConfig().getDouble("users." + p.getUniqueId().toString() + ".home." + args[0] + ".z"));
					loc.setYaw(main.getConfig().getInt("users." + p.getUniqueId().toString() + ".home." + args[0] + ".d"));
					
					p.teleport(loc);
					p.sendMessage(main.prefix + "§aVous êtes a votre home !");
					
				} else {
					p.sendMessage(main.prefix + "§cVous n'avez pas de home nommé : §6" + args[0]);
				}
				
			}
			
		} else {
			p.sendMessage("§c/home");
			p.sendMessage("§c/home <home>");
		}
		
		return true;
	}

}
