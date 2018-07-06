package fr.ismania.home.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ismania.home.Main;

public class CommandDelHome implements CommandExecutor {

	private Main main;
	
	public CommandDelHome(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {

			Player player = (Player)sender;

			if(args.length != 1) {
				player.sendMessage("§c/delhome <nom>");
			} else {

				if ((main.getConfig().isSet("users." + player.getUniqueId().toString() + ".home." + args[0] + ".world")) && (main.getConfig().isSet("users." + player.getUniqueId().toString() + ".home." + args[0] + ".x")) && (main.getConfig().isSet("users." + player.getUniqueId().toString() + ".home." + args[0] + ".y")) && (main.getConfig().isSet("users." + player.getUniqueId().toString() + ".home." + args[0] + ".z"))) {

					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0] + ".d", null);
					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0] + ".z", null);
					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0] + ".y", null);
					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0] + ".x", null);
					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0] + ".world", null);
					main.getConfig().set("users." + player.getUniqueId().toString() + ".home." + args[0], null);

					main.saveConfig();

					player.sendMessage(main.prefix + "§aVous avez supprimer le home : " + args[0]);

				} else {
					player.sendMessage("§cVous n'avez pas de home nommé : §6" + args[0]);
				}

			}

		}

		return true;

	}

}
