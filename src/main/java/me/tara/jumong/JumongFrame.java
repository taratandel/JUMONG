/*
 * In The Name Of God
 * ========================================
 * [] File Name : Frame.java
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

import me.tara.jumong.items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Random;

public final class JumongFrame extends JFrame implements KeyListener, ActionListener, MouseListener, ItemListener {
	private static int round;

	/**
	 * @return the round
	 */
	public static int getRound() {
		return round;
	}

	/**
	 * @param aRound the round to set
	 */
	public static void setRound(int aRound) {
		round = aRound;
	}

	Panel1 p;
	Jumong j;
	JPanel panel2, panel3, panel4;
	Panel2 panel5;
	JButton shovel, bhp, shp, ep, sa, fa, ba, sb, hawk, bb, k, c, r;
	JButton inventory, unlock, status, live, co;
	JRadioButton lhawk, lshovel, lbhp, lshp, lep, lfa, lba, lsb, lbb, lsa, lk, lc, lr;
	JLabel t, gold;
	JButton drop, use, save, load;
	ButtonGroup rg;
	JFrame f;
	int m, enemyNumber = 0;
	public JComboBox<String> salam, sal;
	public String s[] = {"Items", "smallHealthPotion", "bigHealthPotion", "Hawk", "Shovel", "energyPotion", "reviveScroll", "bigBag"};
	public String saa[] = {"Items", "smallHealthPotion", "bigHealthPotion", "Hawk", "Shovel", "energyPotion", "reviveScroll", "bigBag", "smallArrow", "bigArrow", "fireArrow", "Key"};

	public JumongFrame(Jumong ja) {

		setVisible(false);
		j = ja;
		salam = new JComboBox<>(s);
		sal = new JComboBox<>(saa);
		salam.addItemListener(
			new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					int num = 0;
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (salam.getSelectedIndex() == 1) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("smallHealthPotion")) {
									num++;
									i.use(j);
									JOptionPane.showMessageDialog(null, "heals for 20 hit points:)");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}

						if (salam.getSelectedIndex() == 2) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("bigHealthPotion")) {
									num++;
									i.use(j);
									it.remove();
									JOptionPane.showMessageDialog(null, "heals for 50 hit points");
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (salam.getSelectedIndex() == 3) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("Hawk")) {
									num++;
									i.use(j);
									JOptionPane.showMessageDialog(null, "heals for 20 hit points:)");
									it.remove();
									setRound(getRound() + 1);

									break;

								}
							}
						}
						if (salam.getSelectedIndex() == 4) {
							String sx, sy;
							int x, y;
							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("Shovel")) {
									num++;
									sx = JOptionPane.showInputDialog("enter the x of your destination");
									sy = JOptionPane.showInputDialog("enter the y of your destination");
									x = Integer.parseInt(sx);
									y = Integer.parseInt(sy);

									if (!j.getPoint()[x][y].isWall()) {
										Jumong.setX(x);
										Jumong.setY(y);
										p.repaint();
										JOptionPane.showMessageDialog(null, "you are at (" + x + "," + y + ")");
										setRound(getRound() + 1);

									}
									it.remove();
									break;
								}
							}
						}
						if (salam.getSelectedIndex() == 5) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("energyPotion")) {
									num++;
									i.use(j);
									JOptionPane.showMessageDialog(null, "refills 10 energy points:)");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (salam.getSelectedIndex() == 6) {

							Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("reviveScroll")) {
									num++;
									i.use(j);
									JOptionPane.showMessageDialog(null, "heals for 50 hit points:)");
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (salam.getSelectedIndex() == 7) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("bigBag")) {
									num++;
									i.use(j);
									JOptionPane.showMessageDialog(null, "the capacity of inventory increased by 10:)");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}

						if (num == 0 && salam.getSelectedIndex() != 0) {
							JOptionPane.showMessageDialog(null, "you don't have this item");
						}

					}
					if (getRound() == 2) {
						smartEnemies();
						setRound(0);
					}
				}
			}
		);
		sal.addItemListener(
			new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					int num = 0;
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (sal.getSelectedIndex() == 1) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("smallHealthPotion")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new smallHealthPotion());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									setPanel2();
									panel4.repaint();
									setRound(getRound() + 1);
									it.remove();
									break;
								}
							}
						}

						if (sal.getSelectedIndex() == 2) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("bigHealthPotion")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new bigHealthPotion());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 3) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("Hawk")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new Hawk());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;

								}
							}
						}
						if (sal.getSelectedIndex() == 4) {
							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("Shovel")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new Shovel());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 5) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("energyPotion")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new energyPotion());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 6) {

							Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("reviveScroll")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new reviveScroll());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 7) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("bigBag")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new bigBag());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 8) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("smallArrow")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new smallArrow());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 9) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("bigArrow")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new bigArrow());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 10) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("fireArrow")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new fireArrow());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}
						if (sal.getSelectedIndex() == 11) {

							Iterator it = j.inventory.iterator();
							while (it.hasNext()) {
								Item i = (Item) it.next();
								if (i.name.equals("Key")) {
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.add(new Key());
									JOptionPane.showMessageDialog(null, "you droped the Item");
									it.remove();
									setRound(getRound() + 1);
									break;
								}
							}
						}

						if (num == 0 && sal.getSelectedIndex() != 0) {
							JOptionPane.showMessageDialog(null, "you don't have this item in your inventory!");
						}

					}
					setPanel2();
					panel4.repaint();
					if (getRound() == 2) {
						smartEnemies();
						setRound(0);
					}
				}
			}
		);
		gold = new JLabel();
		salam.setFocusable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1500, 720);
		setLayout(new GridLayout(1, 2, 1, 1));
		p = new Panel1(j);
		panel4 = new JPanel(new GridLayout(3, 1));
		panel3 = new JPanel();
		panel5 = new Panel2(j);
		panel2 = new JPanel();
		panel2.setBackground(Color.YELLOW);
		panel3.setBackground(Color.GREEN);
		panel4.add(panel2);
		panel4.add(panel3);
		panel4.add(panel5);

		live = new JButton("LiveBattle");
		save = new JButton("Save");
		load = new JButton("Load");
		save.setBackground(Color.yellow);
		load.setBackground(Color.yellow);
		co = new JButton("automatically");
		drop = new JButton("drop");
		use = new JButton("use");
		use.setFocusable(false);
		drop.setFocusable(false);
		shovel = new JButton("pick shovel");
		k = new JButton("pick Key");
		c = new JButton("Chest");
		unlock = new JButton("Unlock");
		status = new JButton("Status");
		r = new JButton("pick reviveScroll");
		bhp = new JButton("pick bigHealthPotion");
		shp = new JButton("pick smallHealthPotion");
		ep = new JButton("pick energyPotion");
		sa = new JButton("pick smallArrow");
		fa = new JButton("pick fireArrow");
		ba = new JButton("pick bigArrow");
		sb = new JButton("pick stoneBreaker");
		bb = new JButton("pick bigBag");
		hawk = new JButton("pick Hawk");
		inventory = new JButton("inventory");
		lshovel = new JRadioButton("Shovel", false);
		lshovel.setSize(200, 30);
		lbhp = new JRadioButton("bigHealthPotion", false);
		lbhp.setSize(200, 30);
		lshp = new JRadioButton("smallHealthPotion", false);
		lshp.setSize(200, 30);
		lk = new JRadioButton("Key", false);
		lk.setSize(100, 30);
		lc = new JRadioButton("Chest", false);
		lc.setSize(100, 30);
		lr = new JRadioButton("reviveScroll", false);
		lr.setSize(150, 30);

		lep = new JRadioButton("energyPotion", false);
		lep.setSize(150, 30);
		lsa = new JRadioButton("smallArrow", false);
		lsa.setSize(200, 30);
		lfa = new JRadioButton("fireArrow", false);
		lfa.setSize(200, 30);
		lba = new JRadioButton("bigArrow", false);
		lba.setSize(200, 30);
		lsb = new JRadioButton("stoneBreaker", false);
		lsb.setSize(200, 30);
		lbb = new JRadioButton("bigBag", false);
		lbb.setSize(200, 30);
		lhawk = new JRadioButton("Hawk", false);
		lhawk.setSize(200, 30);
		unlock.setBackground(Color.yellow);
		t = new JLabel();
		//t.setIcon(enemy);
		co.setBackground(Color.yellow);
		live.setBackground(Color.YELLOW);
		panel5.setBackground(Color.pink);
		p.add(save);
		p.add(load);
		add(p);
		setPanel2();
		setPanel5();
		setpanel3();
		setResizable(false);
		this.addKeyListener(this);
		sa.addActionListener(this);
		fa.addActionListener(this);
		ba.addActionListener(this);
		shp.addActionListener(this);
		bhp.addActionListener(this);
		ep.addActionListener(this);
		shovel.addActionListener(this);
		hawk.addActionListener(this);
		bb.addActionListener(this);
		sb.addActionListener(this);
		k.addActionListener(this);
		c.addActionListener(this);
		r.addActionListener(this);
		inventory.addActionListener(this);
		use.addActionListener(this);
		drop.addActionListener(this);
		status.addActionListener(this);
		unlock.addActionListener(this);
		status.setFocusable(false);
		unlock.setFocusable(false);
		save.setFocusable(false);
		load.setFocusable(false);
		co.addActionListener(this);
		live.addActionListener(this);
		co.setFocusable(false);
		live.setFocusable(false);
		save.setFocusable(false);
		load.setFocusable(false);
		rg = new ButtonGroup();
		add(panel4);
		setVisible(true);
	}

	//------------------------------------------enemy moves---------------------------------------------------------------
	//
	public void smartEnemies() {
		double hey;
		Random rand = new Random();
		int i = 0, ja = 0, ma = 0, n = 0;

		for (int x = 1; x < 22; x++) {
			for (int y = 1; y < 22; y++) {
				for (int index = j.getPoint()[x][y].enemies.size() - 1; index >= 0; index--) {
					if (Jumong.getX() - x != 0 && Jumong.getY() - y != 0) {
						hey = (int) Math.atan((Jumong.getY() - y) / (Jumong.getX() - x));
						if (hey > 0 && hey < Math.PI / 4) {
							i = 1;
							ja = 0;
							ma = 0;
							n = -1;
						}
						if (hey > Math.PI / 4 && hey < Math.PI / 2) {
							i = 0;
							ja = -1;
							ma = 1;
							n = 0;
						}
						if (hey > Math.PI / 2 && hey < 3 * Math.PI / 4) {
							i = 0;
							ja = -1;
							ma = -1;
							n = 0;
						}
						if (hey > 3 * Math.PI / 4 && hey < Math.PI) {
							i = -1;
							ja = 0;
							ma = 0;
							n = -1;
						}
						if (hey > Math.PI && hey < 5 * Math.PI / 4) {
							i = -1;
							ja = 0;
							ma = 0;
							n = 1;
						}
						if (hey > 5 * Math.PI / 4 && hey < 3 * Math.PI / 2) {
							i = 0;
							ja = 1;
							ma = -1;
							n = 0;
						}
						if (hey > 3 * Math.PI / 2 && hey < 7 * Math.PI / 4) {
							i = 0;
							ja = 1;
							ma = 1;
							n = 0;
						}
						if (hey > 7 * Math.PI / 4 && hey < 2 * Math.PI) {
							i = 1;
							ja = 0;
							ma = 0;
							n = 1;
						}

						if (!j.getPoint()[x + i][y + ja].isWall() && j.getPoint()[x + i][y + ja].enemies.size() < 3) {
							j.getPoint()[x + i][y + ja].enemies.add(new Enemy());
						} else if (!j.getPoint()[x + ma][y + n].isWall() && j.getPoint()[x + ma][y + n].enemies.size() < 3) {
							j.getPoint()[x + ma][y + n].enemies.add(new Enemy());
						} else if (!j.getPoint()[x - i][y - ja].isWall() && j.getPoint()[x - i][y - ja].enemies.size() < 3) {
							j.getPoint()[x - i][y - ja].enemies.add(new Enemy());
						} else if (!j.getPoint()[x - ma][y - n].isWall() && j.getPoint()[x - ma][y - n].enemies.size() < 3) {
							j.getPoint()[x - ma][y - n].enemies.add(new Enemy());
						}
						j.getPoint()[x][y].enemies.remove(index);
					}
					if (x - Jumong.getX() == 0) {
						if (Jumong.getY() - y > 0) {
							if (!j.getPoint()[x][y + 1].isWall() && j.getPoint()[x][y + 1].enemies.size() < 3) {
								j.getPoint()[x][y + 1].enemies.add(new Enemy());
							}
						} else if (Jumong.getY() - y < 0) {
							if (!j.getPoint()[x][y - 1].isWall() && j.getPoint()[x][y - 1].enemies.size() < 3) {
								j.getPoint()[x][y - 1].enemies.add(new Enemy());
							}
						}
					}
					if (y - Jumong.getY() == 0) {
						if (Jumong.getX() - x > 0) {
							if (!j.getPoint()[x + 1][y].isWall() && j.getPoint()[x + 1][y].enemies.size() < 3) {
								j.getPoint()[x + 1][y].enemies.add(new Enemy());
							}
						} else if (Jumong.getX() - x < 0) {
							if (!j.getPoint()[x - 1][y].isWall() && j.getPoint()[x - 1][y].enemies.size() < 3) {
								j.getPoint()[x - 1][y].enemies.add(new Enemy());
							}
						}
					}
				}
			}
		}
		setPanel5();
		panel4.repaint();
	}

	//------------------------------------------set panel3---------------------------------------------------------------
	public void setpanel3() {
		panel3.removeAll();
		panel3.revalidate();
		panel3.add(save);
		panel3.add(load);
	}

	//------------------------------------------set Panel2------------------------------------------------------------------
	public void setPanel2() {

		panel2.removeAll();
		panel2.revalidate();
		panel2.setLayout(new FlowLayout());
		Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
		while (it.hasNext()) {
			Item i = (Item) it.next();
			if (i.name.equals("Shovel")) {
				shovel.setFocusable(false);
				panel2.add(shovel);

			}
			if (i.name.equals("Hawk")) {
				hawk.setFocusable(false);
				panel2.add(hawk);

			}
			if (i.name.equals("bigHealthPotion")) {
				bhp.setFocusable(false);
				panel2.add(bhp);

			}
			if (i.name.equals("smallHealthPotion")) {
				shp.setFocusable(false);
				panel2.add(shp);

			}
			if (i.name.equals("smallArrow")) {
				sa.setFocusable(false);
				panel2.add(sa);

			}
			if (i.name.equals("bigArrow")) {
				ba.setFocusable(false);
				panel2.add(ba);

			}
			if (i.name.equals("energyPotion")) {
				ep.setFocusable(false);
				panel2.add(ep);

			}
			if (i.name.equals("bigBag")) {
				bb.setFocusable(false);
				panel2.add(bb);

			}
			if (i.name.equals("Key")) {
				k.setFocusable(false);
				panel2.add(k);

			}
			if (i.name.equals("reviveScroll")) {
				r.setFocusable(false);
				panel2.add(r);

			}
			if (i.name.equals("fireArrow")) {
				fa.setFocusable(false);
				panel2.add(fa);

			}
			if (i.name.equals("Chest")) {
				c.setFocusable(false);
				panel2.add(c);
				panel4.repaint();
				panel3.add(unlock);
				m = i.match;
				System.out.println("" + m);
				panel4.repaint();

			}
		}
		panel2.repaint();
		panel2.add(drop);
		panel2.add(use);
		panel2.add(status);
		panel2.repaint();
		inventory.setFocusable(false);
		panel2.add(inventory);


	}

	//--------------------------------------------set panel3-------------------------------------------------------------------
	public void setPanel3() {
		f = new JFrame();
		f.setSize(400, 300);
		f.setLocation(900, 200);
		f.setResizable(false);
		f.setLayout(new FlowLayout());

		int shoveln = 0, hawkn = 0, bhpn = 0, shpn = 0, san = 0, ban = 0, fan = 0, sbn = 0, epn = 0, bbn = 0, kn = 0, rn = 0;

		for (Object o : j.getInventory()) {
			Item i = (Item) o;
			if (i.name.equals("Shovel")) {
				shoveln++;


			}
			if (i.name.equals("Hawk")) {
				hawkn++;


			}
			if (i.name.equals("bigHealthPotion")) {
				bhpn++;

			}
			if (i.name.equals("smallHealthPotion")) {
				shpn++;

			}
			if (i.name.equals("smallArrow")) {
				san++;

			}
			if (i.name.equals("bigArrow")) {
				ban++;

			}

			if (i.name.equals("fireArrow")) {
				fan++;

			}
			if (i.name.equals("stonebreaker")) {
				sbn++;
			}
			if (i.name.equals("energyPotion")) {
				epn++;
			}
			if (i.name.equals("Key")) {
				kn++;
			}
			if (i.name.equals("reviveScroll")) {
				rn++;
			}
			if (i.name.equals("bigBag")) {
				bbn++;
			}
		}
		if (san > 0) {
			lsa.setText("smallArrow : " + san);
			lsa.setFocusable(false);
			f.add(lsa);
			rg.add(lsa);

		}
		if (hawkn > 0) {
			lhawk.setText("Hawk : " + hawkn);
			lhawk.setFocusable(false);
			f.add(lhawk);
			rg.add(lhawk);
		}
		if (shoveln > 0) {
			lshovel.setText("shovel : " + shoveln);
			lshovel.setFocusable(false);
			f.add(lshovel);
			rg.add(lshovel);
		}
		if (fan > 0) {
			lfa.setText("fireArrow : " + fan);
			lfa.setFocusable(false);
			f.add(lfa);
			rg.add(lfa);
		}
		if (ban > 0) {
			lba.setText("bigArrow : " + ban);
			lba.setFocusable(false);
			f.add(lba);
			rg.add(lba);
		}
		if (shpn > 0) {
			lshp.setText("smallHealthPotion : " + shpn);
			lshp.setFocusable(false);
			f.add(lshp);
			rg.add(lshp);
		}
		if (bhpn > 0) {
			lbhp.setText("bigHealthPotion : " + bhpn);
			lbhp.setFocusable(false);
			f.add(lbhp);
			rg.add(lbhp);
		}
		if (ban > 0) {
			lba.setText("bigArrow : " + ban);
			lba.setFocusable(false);
			f.add(lba);
			rg.add(lba);
		}
		if (bbn > 0) {
			lbb.setText("bigBag : " + bbn);
			lbb.setFocusable(false);
			f.add(lbb);
			rg.add(lbb);
		}
		if (sbn > 0) {
			lsb.setText("stoneBreaker : " + sbn);
			lsb.setFocusable(false);
			f.add(lsb);
			rg.add(lsb);
		}
		if (epn > 0) {
			lep.setText("energyPotion : " + epn);
			lep.setFocusable(false);
			f.add(lep);
			rg.add(lep);
		}
		if (kn > 0) {
			lk.setText("Key : " + kn);
			lk.setFocusable(false);
			f.add(lk);
			rg.add(lk);
		}
		if (rn > 0) {
			lr.setText("reviveScroll : " + rn);
			lr.setFocusable(false);
			f.add(lr);
			rg.add(lr);
		}
		f.setVisible(true);
		panel3.repaint();
	}

	//---------------------------------------------set Panel5------------------------------------------------------------------
	public void setPanel5() {
		int num = 0;
		panel5.removeAll();
		panel5.revalidate();

		int number = 0;
		Iterator iti = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.iterator();
		number = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
		Iterator it = j.inventory.iterator();
		while (it.hasNext()) {
			Item i = (Item) it.next();
			if (i.name.equals("smallArrow")) {
				num++;
			}
		}
		if (number > 0 && num >= number) {
			panel5.add(co);
			panel5.add(live);
		} else if (number > 0 && num < number) {
			panel5.add(live);
		}
		enemyNumber = number;
		t.setSize(500, 500);
		gold.setText("gold : " + j.getPoint()[Jumong.getX()][Jumong.getY()].getGold());
		t.setText("enemies: " + number);
		t.setFocusable(false);
		gold.setFocusable(false);
		panel5.add(t);
		panel5.add(gold);
		panel5.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	//------------------------------move---------------------------------------------------------
	//
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Jumong.getX() > 0 && !j.getPoint()[Jumong.getX() - 1][Jumong.getY()].isWall()) {

				Jumong.setX(Jumong.getX() - 1);
				p.repaint();
				setpanel3();
				setPanel2();
				setPanel5();
				j.setEnergy(j.getEnergy() - 1);
				panel4.repaint();
				setRound(getRound() + 1);
				int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
				j.setHitPoints(j.getHitPoints() - 10 * x);
				Jumong.setGold(Jumong.getGold() + j.getPoint()[Jumong.getX()][Jumong.getY()].getGold());

			}

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (Jumong.getX() < 22 && !j.getPoint()[Jumong.getX() + 1][Jumong.getY()].isWall()) {
				Jumong.setX(Jumong.getX() + 1);
				p.repaint();
				setpanel3();
				setPanel2();
				setPanel5();
				j.setEnergy(j.getEnergy() - 1);
				panel4.repaint();
				setRound(getRound() + 1);
				int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
				j.setHitPoints(j.getHitPoints() - 10 * x);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (Jumong.getY() > 0 && !j.getPoint()[Jumong.getX()][Jumong.getY() - 1].isWall()) {
				Jumong.setY(Jumong.getY() - 1);
				p.repaint();
				setpanel3();
				setPanel2();
				setPanel5();
				j.setEnergy(j.getEnergy() - 1);
				panel4.repaint();
				setRound(getRound() + 1);
				int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
				j.setHitPoints(j.getHitPoints() - 10 * x);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (Jumong.getY() < 22 && !j.getPoint()[Jumong.getX()][Jumong.getY() + 1].isWall()) {
				Jumong.setY(Jumong.getY() + 1);
				p.repaint();
				setpanel3();
				setPanel2();
				setPanel5();
				j.setEnergy(j.getEnergy() - 1);
				panel4.repaint();
				setRound(getRound() + 1);
				int x = j.getPoint()[Jumong.getX()][Jumong.getY()].enemies.size();
				j.setHitPoints(j.getHitPoints() - 10 * x);
			}
		}

		if (getRound() == 2) {
			smartEnemies();
			setRound(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	//-----------------------------------------------commands----------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sa) {

			panel2.remove(sa);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("smallArrow")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new smallArrow());
		}
		if (e.getSource() == shp) {
			panel2.remove(shp);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("smallHealthPotion")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new smallHealthPotion());
		}
		if (e.getSource() == bhp) {
			panel2.remove(bhp);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("bigHealthPotion")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new bigHealthPotion());
		}
		if (e.getSource() == ba) {
			panel2.remove(ba);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("bigArrow")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new bigArrow());
		}
		if (e.getSource() == fa) {
			panel2.remove(fa);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("fireArrow")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new fireArrow());
		}
		if (e.getSource() == hawk) {
			panel2.remove(hawk);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("Hawk")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new Hawk());
		}
		if (e.getSource() == shovel) {
			panel2.remove(shovel);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("Shovel")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new Shovel());
		}
		if (e.getSource() == ep) {
			panel2.remove(ep);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("energyPotion")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new energyPotion());
		}
		if (e.getSource() == sb) {
			panel2.remove(sb);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("stoneBreaker")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new stoneBreaker());
		}
		if (e.getSource() == bb) {
			panel2.remove(bb);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("bigBag")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new bigBag());
		}
		if (e.getSource() == k) {
			panel2.remove(k);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("Key")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new Key());
		}
		if (e.getSource() == r) {
			panel2.remove(r);
			Iterator it = j.getPoint()[Jumong.getX()][Jumong.getY()].items.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("reviveScroll")) {
					it.remove();
					setRound(getRound() + 1);
					break;
				}
			}

			j.getInventory().add(new reviveScroll());
		}
		if (e.getSource() == inventory) {
			setPanel3();
			setPanel2();
			setPanel5();
			setpanel3();
			setRound(getRound() + 1);
			panel4.repaint();
		}
		if (e.getSource() == use) {
			JFrame frame = new JFrame();
			frame.setSize(300, 70);
			frame.setLocation(1000, 100);
			frame.add(salam);
			salam.setSelectedIndex(0);
			frame.setVisible(true);
		}
		if (e.getSource() == drop) {
			JFrame frame = new JFrame();
			frame.setSize(300, 70);
			frame.setLocation(1000, 100);
			frame.add(sal);
			sal.setSelectedIndex(0);
			frame.setVisible(true);
		}
		if (e.getSource() == unlock) {
			int num = 0, number = 0;
			Iterator it = j.inventory.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("Key")) {
					number++;
					if (i.match == m) {
						synchronized (j.getPoint()[Jumong.getX()][Jumong.getY()].items) {
							for (int index = j.getPoint()[Jumong.getX()][Jumong.getY()].items.size() - 1; index >= 0; index--) {
								Item ii = j.getPoint()[Jumong.getX()][Jumong.getY()].items.get(index);
								if (ii.name.equals("Chest")) {
									JOptionPane.showMessageDialog(null, "your Chest has been unlocked!:)");
									ii.use(j);
									num++;
									j.getPoint()[Jumong.getX()][Jumong.getY()].items.remove(index);
									panel3.remove(unlock);
									setPanel2();
									panel4.repaint();
									setRound(getRound() + 1);
									break;
								}

							}
							it.remove();
							break;
						}
					}
				}
			}
			if (num == 0 && number != 0) {
				JOptionPane.showMessageDialog(null, "all your keys weren't suitable for the chest!:(");
			} else if (number == 0) {
				JOptionPane.showMessageDialog(null, "you don't have key in your inventory!");
			}

		}
		if (e.getSource() == status) {
			JOptionPane.showMessageDialog(null, "you have " + j.getEnergy() + " and " + j.getHitPoints() + "hit points");
			setRound(getRound() + 1);
		}
		if (e.getSource() == co) {
			Iterator it = j.inventory.iterator();
			while (it.hasNext()) {
				Item i = (Item) it.next();
				if (i.name.equals("smallArrow") && enemyNumber > 0) {
					enemyNumber--;
					i.use(j);
					it.remove();
				}
			}

			setPanel5();
			panel4.repaint();
		}
		if (e.getSource() == live) {
			Fight fight = new Fight(j);
			setPanel5();
			panel4.repaint();
			p.setJ(j);
			p.repaint();


		}
		if (e.getSource() == save) {
			Saver save = new Saver(j);
		}
		if (e.getSource() == load) {

		}
		setPanel2();
		setPanel5();
		panel4.repaint();
		if (getRound() == 2) {
			smartEnemies();
			setRound(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
}
