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
