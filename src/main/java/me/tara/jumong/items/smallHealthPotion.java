/*
 * In The Name Of God
 * ========================================
 * [] File Name : smallHealthPotion.java
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

public class smallHealthPotion extends Item {
	public smallHealthPotion() {
		name = "smallHealthPotion";
	}

	@Override
	public void use(Jumong jumong) {
		jumong.setHitPoints(jumong.getHitPoints() + 20);
	}
}
