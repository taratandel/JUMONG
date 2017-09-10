/*
 * In The Name Of God
 * ========================================
 * [] File Name : Panel1.java
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

public class Panel1 extends JPanel {

	BufferedImage hero;
	BufferedImage wall;
	private Jumong j;

	public Panel1(Jumong j) {
		j = new Jumong();
		this.j = j;
		try {
			hero = ImageIO.read(ClassLoader.getSystemResourceAsStream("hero.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			wall = ImageIO.read(ClassLoader.getSystemResourceAsStream("wall.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, 720, 720);
		for (int i = 0; i < 23; i++) {
			for (int jar = 0; jar < 23; jar++) {
				g.setColor(Color.GRAY);
				g.fillRect(30 * i, 30 * jar, 29, 29);
			}
		}
		if (Jumong.getX() > 0 && Jumong.getY() > 0 && Jumong.getX() < 22 && Jumong.getY() < 22) {
			g.setColor(Color.WHITE);

			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, Jumong.getY() * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, Jumong.getY() * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, Jumong.getY() * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, Jumong.getY() * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, 30 * (Jumong.getY() - 1), 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}
		}
		if (Jumong.getX() == 0 && Jumong.getY() != 0 && Jumong.getY() != 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
		}
		if (Jumong.getX() == 22 && Jumong.getY() != 0 && Jumong.getY() != 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}

		}
		if (Jumong.getY() == 22 && Jumong.getX() != 0 && Jumong.getX() != 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, (Jumong.getX()) * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29);
			}

		}
		if (Jumong.getY() == 0 && Jumong.getX() != 0 && Jumong.getX() != 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, (Jumong.getX()) * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}

		}
		if (Jumong.getY() == 0 && Jumong.getX() == 0) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}

		}
		if (Jumong.getY() == 22 && Jumong.getX() == 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, (Jumong.getX()) * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29);
			}
		}
		if (Jumong.getY() == 0 && Jumong.getX() == 22) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() - 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				g.drawImage(wall, (Jumong.getX()) * 30, (Jumong.getY() + 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() + 1) * 30, 29, 29);
			}
		}
		if (Jumong.getY() == 22 && Jumong.getX() == 0) {
			g.setColor(Color.WHITE);
			if (getJ().getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				g.drawImage(wall, (Jumong.getX()) * 30, (Jumong.getY() - 1) * 30, 29, 29, null);
			} else {
				g.fillRect(Jumong.getX() * 30, (Jumong.getY() - 1) * 30, 29, 29);
			}
			if (getJ().getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				g.drawImage(wall, (Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29, null);
			} else {
				g.fillRect((Jumong.getX() + 1) * 30, (Jumong.getY()) * 30, 29, 29);
			}
		}


		g.drawImage(hero, 30 * Jumong.getX(), 30 * Jumong.getY(), 30, 30, null);
	}

	/**
	 * @return the jumong
	 */
	public Jumong getJ() {
		return j;
	}

	/**
	 * @param j the jumong to set
	 */
	public void setJ(Jumong j) {
		this.j = j;
	}

}
    

