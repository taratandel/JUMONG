/*
 * In The Name Of God
 * ========================================
 * [] File Name : stoneBreaker.java
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

public class stoneBreaker extends Item {

	public stoneBreaker() {
		name = "stoneBreaker";
	}

	@Override
	public void use(Jumong jumong) {
		if (jumong.getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
			jumong.getPoint()[Jumong.getX() + 1][Jumong.getY()].setWall(false);

		}
		if (jumong.getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
			jumong.getPoint()[Jumong.getX() - 1][Jumong.getY()].setWall(false);
		}
		if (jumong.getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
			jumong.getPoint()[Jumong.getX()][Jumong.getY() - 1].setWall(false);
		}
		if (jumong.getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
			jumong.getPoint()[Jumong.getX()][Jumong.getY() + 1].setWall(false);
		}
	}

}
