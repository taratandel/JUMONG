/*
 * In The Name Of God
 * ========================================
 * [] File Name : Fight.java
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

import me.tara.jumong.items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.*;

public class Fight extends JFrame implements MouseListener, ItemListener, ActionListener {
	private Jumong j;
	private FightPanel panel;
	private JFrame frame;
	private JList<String> s;
	private int select;
	private JButton ok;
	public String weaponsName[] = {"smallArrow", "bigArrow", "fireArrow"};

	public Fight(Jumong j) {
		super("Live Battle");
		ok = new JButton("ok");
		s = new JList<>(weaponsName);
		panel = new FightPanel(j);
		add(panel);
		this.j = j;
		setVisible(false);
		setSize(600, 600);
		setLocation(100, 80);
		panel.repaint();
		addMouseListener(this);
		ok.addActionListener(this);
		doIt();
		setVisible(true);

	}

	private void doIt() {
		for (int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size() - 1; x >= 0; x--) {
			Enemy e = (Enemy) j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.get(x);
			e.setX(x);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
		if (x == 1) {
			if (p.x > 200 && p.x < 300 && p.y > 80 && p.y < 180) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 120);
				frame.setLocation(400, 120);
				select = 0;
				frame.add(s);
				frame.add(ok);
				frame.setVisible(true);
			}
		}
		if (x == 2) {
			if (p.x > 100 && p.x < 200 && p.y > 80 && p.y < 180) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 120);
				frame.setLocation(400, 120);
				frame.add(s);
				select = 1;
				frame.add(ok);
				frame.setVisible(true);
			}
			if (p.x > 200 && p.x < 300 && p.y > 80 && p.y < 180) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 120);
				frame.setLocation(400, 120);
				frame.add(s);
				select = 0;
				frame.add(ok);
				frame.setVisible(true);
			}
		}
		if (x == 3) {
			if ((p.x > 100 && p.x < 200 && p.y > 80 && p.y < 180)) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 120);
				frame.setLocation(400, 120);
				frame.add(s);
				frame.add(ok);
				select = 1;
				frame.setVisible(true);
			} else if ((p.x > 100 && p.x < 200 && p.y > 180 && p.y < 280)) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 140);
				frame.setLocation(400, 120);
				frame.add(s);
				frame.add(ok);
				select = 2;
				frame.setVisible(true);
			} else if ((p.x > 200 && p.x < 300 && p.y > 80 && p.y < 180)) {
				frame = new JFrame();
				frame.setLayout(new FlowLayout());
				frame.setSize(200, 140);
				frame.setLocation(400, 120);
				frame.add(s);
				frame.add(ok);
				select = 0;
				frame.setVisible(true);
			}

		}
	}


	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			int num = 0;
			if (s.getSelectedIndex() == 0) {
				for (int index = j.getInventory().size() - 1; index >= 0; index--) {
					Item i = (Item) j.getInventory().get(index);
					if (i.name.equals("smallArrow")) {
						for (int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size() - 1; x >= 0; x--) {
							Enemy ee = (Enemy) j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.get(x);
							if (ee.getX() == select) {
								j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.remove(x);
								break;
							}
						}
						j.getInventory().remove(index);
						panel.repaint();
						num++;
						doIt();
						break;
					}
				}
				if (num == 0) {
					JOptionPane.showMessageDialog(null, "you don't have smallArrow in your inventory! :(");
				}
			}
			if (s.getSelectedIndex() == 1) {
				for (int index = j.getInventory().size() - 1; index >= 0; index--) {
					Item i = (Item) j.getInventory().get(index);
					if (i.name.equals("bigArrow")) {
						i.use(j);
						num++;
						j.getInventory().remove(index);
						panel.repaint();
						doIt();
						break;
					}
				}
				if (num == 0) {
					JOptionPane.showMessageDialog(null, "you don't have bigArrow in your inventory! :(");
				}
			}
			if (s.getSelectedIndex() == 2) {
				for (int index = j.getInventory().size() - 1; index >= 0; index--) {
					Item i = (Item) j.getInventory().get(index);
					if (i.name.equals("fireArrow")) {
						for (int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size() - 1; x >= 0; x--) {
							Enemy ee = (Enemy) j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.get(x);
							if (ee.getX() == select) {
								j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.remove(x);
							}
						}
						if (Jumong.getX() > 0 && Jumong.getX() < 22 && Jumong.getY() > 0 && Jumong.getY() < 22) {
							j.getPoint()[Jumong.getX() + 1][Jumong.getY()].setWall(false);

							j.getPoint()[Jumong.getX() - 1][Jumong.getY()].setWall(false);

							j.getPoint()[Jumong.getX()][Jumong.getY() - 1].setWall(false);

							j.getPoint()[Jumong.getX()][Jumong.getY() + 1].setWall(false);
						}
						num++;
						j.getInventory().remove(index);
						panel.repaint();
						doIt();
						break;
					}
				}
				if (num == 0) {
					JOptionPane.showMessageDialog(null, "you don't have fireArrow in your inventory! :(");
				}
			}
			frame.dispose();
		}
	}

}
