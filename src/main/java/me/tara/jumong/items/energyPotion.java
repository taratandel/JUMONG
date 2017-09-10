/*
 * In The Name Of God
 * ========================================
 * [] File Name : energyPotion.java
 *
 * [] Creation Date : 26-08-2015
 *
 * [] Created By : tara Tandel (tara.tandel.94@gmail.com)
 * =======================================
*/
/**
 * @author tara Tandel
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tara.jumong.items;

import me.tara.jumong.Jumong;

/**
 *
 * @author TehranPardaz
 */
public class energyPotion extends Item{
    public energyPotion()
    {
        name ="energyPotion";
    }
    @Override
    public void use(Jumong jumong)
    {
        jumong.setEnergy(jumong.getEnergy() + 10);
    }
}
