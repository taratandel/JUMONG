/*
 * In The Name Of God
 * ========================================
 * [] File Name : fireArrow.java
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

public class fireArrow extends Item {
	public fireArrow() {
		name = "fireArrow";
	}

	@Override
	public void use(Jumong jumong) {
//      Iterator it=j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.iterator();
//        while(it.hasNext())
//        {
//            it.next();
//            it.remove();
//            break;
//        }

		if (Jumong.getX() > 0 && Jumong.getX() < 22 && Jumong.getY() > 0 && Jumong.getY() < 22) {
			jumong.getPoint()[Jumong.getX() + 1][Jumong.getY()].setWall(false);

			jumong.getPoint()[Jumong.getX() - 1][Jumong.getY()].setWall(false);

			jumong.getPoint()[Jumong.getX()][Jumong.getY() - 1].setWall(false);

			jumong.getPoint()[Jumong.getX()][Jumong.getY() + 1].setWall(false);
		}
	}
}
