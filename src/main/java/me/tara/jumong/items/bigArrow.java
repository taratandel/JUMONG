/*
 * In The Name Of God
 * ========================================
 * [] File Name : bigArrow.java
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

import java.util.Iterator;

public class bigArrow extends Item {

	public bigArrow() {
		name = "bigArrow";
	}

	@Override
	public void use(Jumong jumong) {
		Iterator it = jumong.getPoint()[Jumong.getX()][Jumong.getY()].enemies.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();

		}
	}
}
