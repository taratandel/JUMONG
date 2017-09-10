/*
 * In The Name Of God
 * ========================================
 * [] File Name : Pfight.java
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


public class FightPanel extends JPanel {
	BufferedImage enemy;
	BufferedImage hero;
	Jumong j;

	FightPanel(Jumong j) {

		this.j = j;
		try {
			enemy = ImageIO.read(ClassLoader.getSystemResourceAsStream("enemy.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(FightPanel.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			hero = ImageIO.read(ClassLoader.getSystemResourceAsStream("hero.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(FightPanel.class.getName()).log(Level.SEVERE, null, ex);
		}
		setSize(600, 600);

		setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		for (int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size() - 1; x >= 0; x--) {
			Enemy e = (Enemy) j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.get(x);
			if (e.getX() == 0) {
				g.drawImage(enemy, 200, 80, 100, 100, null);
			}
			if (e.getX() == 1) {
				g.drawImage(enemy, 100, 80, 100, 100, null);
			}
			if (e.getX() == 2) {
				g.drawImage(enemy, 100, 180, 100, 100, null);
			}
		}
		g.drawImage(hero, 400, 400, 100, 100, null);
	}
}
