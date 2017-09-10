/*
 * In The Name Of God
 * ========================================
 * [] File Name : reviveScroll.java
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

public class reviveScroll extends Item {

	public reviveScroll() {
		name = "reviveScroll";
	}

	@Override
	public void use(Jumong jumong) {
		jumong.setHitPoints(jumong.getHitPoints() + 50);
	}
}
