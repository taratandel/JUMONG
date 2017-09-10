/*
 * In The Name Of God
 * ========================================
 * [] File Name : Server.java
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

import javax.swing.*;

public class Server implements Runnable {
	private Jumong jumong;
	private JumongFrame jumongFrame;

	public Server() {
		jumong = new Jumong();
		jumongFrame = new JumongFrame(jumong);
	}

	public static void main(String[] args) {
		new Thread(new Server()).start();
	}

	@Override
	public void run() {
		while (true) {
			if (jumong.getHitPoints() < 0 || jumong.getEnergy() < 0) {
				jumongFrame.dispose();
				JFrame looseFrame = new JFrame();
				looseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Loose loose = new Loose();
				looseFrame.setContentPane(loose);
				looseFrame.setSize(loose.getPreferredSize());
				loose.repaint();
				looseFrame.setVisible(true);
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
