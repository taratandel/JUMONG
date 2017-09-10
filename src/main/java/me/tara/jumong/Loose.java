/*
 * In The Name Of God
 * ========================================
 * [] File Name : Loose.java
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

public class Loose extends JPanel {
	BufferedImage gameOver;

	public Loose() {
		try {
			gameOver = ImageIO.read(ClassLoader.getSystemResourceAsStream("why.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Loose.class.getName()).log(Level.SEVERE, null, ex);
		}
		setPreferredSize(new Dimension(400, 500));

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(gameOver, 0, 0, 400, 500, null);
	}


}
