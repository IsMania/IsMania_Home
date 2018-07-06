package fr.ismania.home.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class HomeLocation {

	private Location loc;
	private World world;
	private String name;
	
	public void setHomeName(String name) {
		this.name = name;
	}
	
	public void setX(double x) {
		this.loc.setX(x);
	}
	
	public void setY(double y) {
		this.loc.setY(y);
	}
	
	public void setZ(double z) {
		this.loc.setZ(z);
	}
	
	public void setWorld(String name) {
		this.world = Bukkit.getWorld(name);
	}
	
	public double getX() {
		return loc.getX();
	}
	
	public double getY() {
		return loc.getY();
	}
	
	public double getZ() {
		return loc.getZ();
	}
	
	public World getWorld() {
		return world;
	}
	
	public String getHomeName() {
		return name;
	}
	
}
