/*
 * In The Name Of God
 * ========================================
 * [] File Name : Shovel.java
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

import javax.swing.*;
import java.awt.*;

public class Shovel extends Item {
	JFrame f;

	public Shovel() {
		name = "Shovel";
		f = new JFrame();
		f.setLayout(new FlowLayout());
	}

	@Override
	public void use(Jumong jumong) {

	}
}
