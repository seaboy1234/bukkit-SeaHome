package com.rakaienguard.seaboy1234.bukkit.SeaHome;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.validation.NotNull;

@Entity
@Table(name = "player_homes")
public class Home {
	@Id
	private int id;
	@NotNull
	private double x,y,z;
	@NotNull
	private float pitch,yaw;
	@NotNull
	private String player,world;
	public int getId() {
		return id;
	}
	/**
	 * @return the pitch
	 */
	public float getPitch() {
		return pitch;
	}
	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}
	/**
	 * @return the world
	 */
	public String getWorld() {
		return world;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @return the yaw
	 */
	public float getYaw() {
		return yaw;
	}
	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param pitch the pitch to set
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}
	/**
	 * @param world the world to set
	 */
	public void setWorld(String world) {
		this.world = world;
	}
	/**
	 * @param d the x to set
	 */
	public void setX(double d) {
		x = d;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @param yaw the yaw to set
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}
}
