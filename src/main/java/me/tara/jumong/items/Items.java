/*
 * In The Name Of God
 * ========================================
 * [] File Name : Items.java
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

import me.tara.jumong.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class Items {
	public ArrayList<Item> items;
	public ArrayList<Enemy> enemies;
	int rand1, rand2;
	Random random;

	public Items() {
		items = new ArrayList<Item>();
		enemies = new ArrayList<Enemy>();
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
				items.add(new fireArrow());
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
				break;
			case 6:
				items.add(new stoneBreaker());
				break;
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
}
