/*
 * In The Name Of God
 * ========================================
 * [] File Name : smallArrow.java
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

public class smallArrow extends Item {
	public smallArrow() {
		name = "smallArrow";
	}

	@Override
	public void use(Jumong jumong) {
		int w = jumong.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
		jumong.getPoint()[Jumong.getX()][Jumong.getY()].enemies.remove(w - 1);
	}
}
