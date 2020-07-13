package joe1;

//A work in progress (implemented in Python already)
//creates a seat reservation system for airline flights

import javax.swing.JOptionPane;

public class Airline
{
	private static int select = 0;
	private static int select_2 = 5;
	private static boolean[] seats = new boolean[10];
	
	public static void main(String[] args)
	{
		intro();
	}
	
	public static void intro()
	{
	String entry = JOptionPane.showInputDialog("Please type 1 for First class\n"
		+ "Please type 2 for Economy class");
	int choice = Integer.parseInt(entry);	
	if (choice == 1)
	{	assignSeat(select);
		select++;}
	else
	{	assignSeat(select_2);
		select_2++;}
	}
	
	public static void assignSeat(int choice)
	{
		String makecho;
		int makechoice;
		if (seats[choice] == false)
		{	seats[choice] = true;
			JOptionPane.showMessageDialog(null, "Seat no. " + (choice + 1) + 
					" has been reserved for you!");}
		else
		{	switch (choice)
			{case 1:
				makecho = JOptionPane.showInputDialog("No seats available for "
				+ "Economy class!\nDo you want to be placed in the First class section?"
				+ "\nIf yes, enter 1, else enter 2!");
				makechoice = Integer.parseInt(makecho);
				nextflight(makechoice);
				break;
			case 2:
				makecho = JOptionPane.showInputDialog("No seats available for "
				+ "First class!\nDo you want to be placed in the Economy class section?"
				+ "\nIf yes, enter 2, else enter 1!");
				makechoice = Integer.parseInt(makecho);
				nextflight(makechoice);
				break;	}
		}
		String another = JOptionPane.showInputDialog("Do you want to book another seat?"
				+ "\nIf yes, enter 1!\nIf no, enter 2!");
		int mag = Integer.parseInt(another);
		if (mag == 1)
			intro();
		else
			JOptionPane.showMessageDialog(null, "Thank you!");
	}

	public static void nextflight(int make)
	{
		if (make == 1)
			intro();
		else
			JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours!");
	}
}