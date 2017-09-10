/*
 * In The Name Of God
 * ========================================
 * [] File Name : bigBag.java
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

public class bigBag extends Item {

	public bigBag() {
		name = "bigBag";
	}

	@Override
	public void use(Jumong jumong) {
		jumong.setCap(jumong.getCap() + 10);
	}
}
