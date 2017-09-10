/*
 * In The Name Of God
 * ========================================
 * [] File Name : Loader.java
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loader {
	InputStream input;
	private Point[][] point;
	private ArrayList inventory;
	int x, y;
	Jumong j;

	public Loader() {
		try {
			input = new FileInputStream("save.txt");
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.point = j.getPoint();
		this.inventory = j.getInventory();
		this.x = Jumong.getX();
		this.y = Jumong.getY();


	}

	public void readMyObject(Object obj) {
	}


}
