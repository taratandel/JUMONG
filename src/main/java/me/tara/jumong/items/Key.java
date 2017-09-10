/*
 * In The Name Of God
 * ========================================
 * [] File Name : Key.java
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

import java.util.Random;
import me.tara.jumong.Jumong;

/**
 *
 * @author tara Jalalpoor
 */
public class Key extends Item{
    private int number;
    private Random num;
    public Key()
    {
        name ="Key";
        num=new Random();
       
        number=num.nextInt(3);
        switch(number)
        {
            case 0:
                match=0;
                break;
            case 1:
                match=1;
                break;
            case 2:
                match=2;
                break;
            case 3:
                match=3;
                break;
    }
    }
    @Override
    public void use(Jumong jumong)
    {
        
    }
}
