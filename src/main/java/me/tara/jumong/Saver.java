/*
 * In The Name Of God
 * ========================================
 * [] File Name : Saver.java
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

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Saver implements Serializable {
	private OutputStream output;
	private Point[][] point;
	private ArrayList inventory;
	int x, y;
	Jumong jumong;

	public Saver(Jumong jumong) {
		this.jumong = jumong;
		try {
			output = new FileOutputStream("save.txt");
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.point = jumong.getPoint();
		this.inventory = jumong.getInventory();
		this.x = Jumong.getX();
		this.y = Jumong.getY();


	}

	public void writeMyObject(Object obj) {
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 23; j++) {
				try {
					output.write(point[i][j].enemies.size());
				} catch (IOException ex) {
					Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		try {
			output.write('\n');
		} catch (IOException ex) {
			Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			output.write(x);
		} catch (IOException ex) {
			Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			output.write(y);
		} catch (IOException ex) {
			Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	/**
	 * @return the point
	 */
	public Point[][] getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint() {

		point = jumong.getPoint();
	}

	/**
	 * @return the Inventory
	 */
	public ArrayList getInventory() {
		return inventory;
	}

	/**
	 * @param Inventory the Inventory to set
	 */
	public void setInventory() {
		inventory = jumong.getInventory();
	}
}
