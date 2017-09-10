/*
 * In The Name Of God
 * ========================================
 * [] File Name : Point.java
 *
 * [] Creation Date : 26-08-2015
 *
 * [] Created By : tara Tandel (tara.tandel.94@gmail.com)
 * =======================================
*/
/**
 * @author tara Tandel
 */
package me.tara.jumong;

import me.tara.jumong.items.*;

import java.util.ArrayList;
import java.util.Random;

public class Point {

	private int x, y, gold;
	public ArrayList<Item> items;
	int rand1, rand2;
	Random random;
	public ArrayList<Enemy> enemies;
	private boolean isWall;
	boolean destination;

	public Point(int x, int y) {
		gold = Math.abs(16 - x) + Math.abs(13 - y);
		isWall = false;
		destination = false;
		this.x = x;
		this.y = y;
		items = new ArrayList<>();
		enemies = new ArrayList<>();
	}


	public void setItem() {
		random = new Random();
		rand1 = random.nextInt(10);
		switch (rand1) {
			case 0:
				items.add(new smallArrow());
				items.add(new Shovel());
				break;
			case 1:
				items.add(new smallHealthPotion());
				items.add(new Hawk());
				break;
			case 2:
				items.add(new bigHealthPotion());
				items.add(new Key());
				break;
			case 3:
				items.add(new bigArrow());
				items.add(new energyPotion());
				break;
			case 4:
				items.add(new smallArrow());
				break;
			case 5:
				items.add(new bigBag());
				items.add(new fireArrow());
				break;
			case 6:
				items.add(new stoneBreaker());
				break;
			case 7:
				items.add(new reviveScroll());
				items.add(new fireArrow());
			case 8:
				items.add(new Chest());
			case 9:
				items.add(new Chest());
			default:
				break;
		}
		rand2 = random.nextInt(10);
		switch (rand2) {
			case 0:
				enemies.add(new Enemy());
				break;
			case 1:
				enemies.add(new Enemy());
				enemies.add(new Enemy());
				break;
			case 3:
				enemies.add(new Enemy());
				enemies.add(new Enemy());
				enemies.add(new Enemy());
				break;
			default:
				break;
		}


	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @return the isWall
	 */
	public boolean isWall() {
		return isWall;
	}

	/**
	 * @param wall the isWall to set
	 */
	public void setWall(boolean wall) {
		this.isWall = wall;
	}
}