package fr.ismania.home.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ismania.home.Main;

public class CommandSetHome implements CommandExecutor {

	private Main main;
	private List<String> hm = new ArrayList<String>();

	public CommandSetHome(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player player = (Player)sender;
		Location loc = player.getLocation();

		if(!(sender instanceof Player)) {
			sender.sendMessage("§cVous devez être un joueur !");
			return true;
		} else {

			if(args.length == 0) {

				player.sendMessage("§c/sethome <name>");
				return true;

			}

			hm.clear();

			if(main.getConfig().isSet("users." + player.getUniqueId().toString() + ".home")) {

				for(String key : main.getConfig().getConfigurationSection("users." + player.getUniqueId().toString() + ".home").getKeys(false)) {
					hm.add(key);
				}

			}

			if(hm.size() >= 5) {

				player.sendMessage("§cVous ne pouvez pas avoir plus que 5 homes !");

			} else {

				if (args.length == 1) {

					setHome(player, args[0], loc);

				} else {
					sender.sendMessage("§c/sethome <name>");
				}

			}

		}

		main.saveConfig();
		
		return true;
	}

	public void setHome(Player player, String args, Location loc) {

		main.getConfig().set("users." + player.getUniqueId().toString() + ".name", player.getName());
		main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args + ".world", loc.getWorld().getName());
		main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args + ".x", Double.valueOf(loc.getX()));
		main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args + ".y", Double.valueOf(loc.getY()));
		main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args + ".z", Double.valueOf(loc.getZ()));
		main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args + ".d", Float.valueOf(loc.getYaw()));
		
		player.sendMessage(main.prefix + "§aLe home à été mis avec succès !");
		
		main.saveConfig();

	}

}
