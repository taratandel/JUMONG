/*
 * In The Name Of God
 * ========================================
 * [] File Name : Panel2.java
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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Panel2 extends JPanel {
	BufferedImage enemy;

	public Panel2(Jumong j) {
		try {
			enemy = ImageIO.read(ClassLoader.getSystemResourceAsStream("enemy.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			enemy = ImageIO.read(ClassLoader.getSystemResourceAsStream("hero.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void paintComponents(Graphics g) {

		g.drawImage(enemy, 1000, 600, 100, 100, null);
	}


}
