/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RollDice 
{
    public static void main(String[] args) 
    {
        int roll; // Roll value
	int win_cond2; // win condition 2
        Random rand = new Random();

	//instructions(); // Displays the instructions for the game

	try { System.in.read();} 
        catch (IOException ex) { Logger.getLogger(RollDice.class.getName()).log(Level.SEVERE, null, ex); }

	roll = roll_dice();

	System.out.println("Your roll is " + roll);

	if (roll == 7 || roll == 11) // checks for the first win condition
	{
		System.out.println("Congradulations! You won!");
	}
	else if (roll == 2 || roll == 3 || roll == 12) // checks for the first loss condition
	{
		System.out.println("Sorry! You lost!");
	}
	else
	{
		win_cond2 = roll; // sets the second win condition to the value needed

		// used to have the user roll again if the game isn't over
		do
		{
			System.out.println("Please roll again.");

                        try { System.in.read();} 
                        catch (IOException ex) { Logger.getLogger(RollDice.class.getName()).log(Level.SEVERE, null, ex); }

			roll = roll_dice();

			System.out.println("Your roll is " + roll);

			if (roll == win_cond2) // checks for the second win condition
			{
				System.out.println("Wow! You won the hard way!");
			}
			else if (roll == 7) // checks for the second loss condition
			{
				System.out.println("Sorry! You lost!");
			}
                } while (roll != 7 && roll != win_cond2);
            }

            System.out.println("Restart the program to play again!");
            
    }

    private static int roll_dice() 
    {
        int MAX = 6; // Max of the number in rand
	int die1, die2; // roll values
	int roll; // total value of both dice
        Random rand = new Random();

	// Computer picks a number between 1 and MAX
	die1 = rand.nextInt((MAX - 1) + 1) + 1;
        die2 = rand.nextInt((MAX - 1) + 1) + 1;

	roll = die1 + die2; // sum of the two dice

	return roll;
    }
    
}
