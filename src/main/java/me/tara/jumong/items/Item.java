/*
 * In The Name Of God
 * ========================================
 * [] File Name : Item.java
 *
 * [] Creation Date : 26-08-2015
 *
 * [] Created By : tara Tandel (tara.tandel.94@gmail.com)
 * =======================================
*/
/**
 * @author tara Tandel
 */
package me.tara.jumong.items;

import me.tara.jumong.Jumong;

public abstract class Item {
	public String name;
	public int match = 0;

	public abstract void use(Jumong jumong);

}