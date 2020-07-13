package joe1;
import java.security.SecureRandom;
import java.util.Scanner;

// creates an interesting but mildly complex Craps game

public class Craps
{
	private static final Scanner input = new Scanner(System.in);
	private static final SecureRandom guess = new SecureRandom();
	private enum Status {CONTINUE, WON, LOST};
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	private static double bankBalance = 1000;
	
	public static void main(String[] args)
	{
		int myPt = 0;
		Status gamestat;
		double w = wager();
		int sum = rollDice();
		
		switch(sum)
		{
		case SEVEN:
		case YO_LEVEN:
			gamestat = Status.WON;
			break;
		case SNAKE_EYES:
		case TREY:
		case BOX_CARS:
			gamestat = Status.LOST;
			break;
		default:
			gamestat = Status.CONTINUE;
			myPt = sum;
			System.out.printf("Point is: %d%n", myPt);
			break;
		}
		while (gamestat == Status.CONTINUE)
		{
			sum = rollDice();
			if (sum == myPt)
				gamestat = Status.WON;
			else if (sum == SEVEN)
				gamestat = Status.LOST;
		}
		if (gamestat == Status.WON)
		{	System.out.println("Player wins");
			bankBalance += w;
			System.out.printf("Your remaining balance is: %.2f%n", bankBalance);}
		else
		{	System.out.println("Player loses");
			bankBalance -= w;
			System.out.printf("Your remaining balance is: %.2f%n", bankBalance);}
	}
	
	public static double wager()
	{
		System.out.println("Enter a wager to play (Input an integer):");
		double wager = input.nextDouble();
		if ((wager > bankBalance) && (wager < 0))
			throw new IllegalArgumentException("Enter a valid wager to play: ");
		return wager;
	}
	
	public static int rollDice()
	{
		int die1 = 1 + guess.nextInt(6);
		int die2 = 1 + guess.nextInt(6);
		int sums = die1 + die2;
		
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sums);
		return sums;
	}
}