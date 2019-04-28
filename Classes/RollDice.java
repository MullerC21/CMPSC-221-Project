/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

public class RollDice 
{
    public static int roll_dice() 
    {
        int MAX = 6; // Max of the number in rand
	int roll; // total value of both dice
        Random rand = new Random();

	// Computer picks a number between 1 and MAX
	roll = rand.nextInt((MAX - 1) + 1) + 1;

	return roll;
    }
}
