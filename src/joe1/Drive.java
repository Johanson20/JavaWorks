/*This program was written by Johanson Onyegbula*/
package joe1;
import java.util.Scanner;	//imports tool for keyboard inputs
import javax.swing.JOptionPane;	//imports interactive interface

//This is a program that displays a welcome message to a person,
//It also returns remainder of integer division and performs indices
public class Drive
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")	//suppresses any error message
		Scanner input = new Scanner(System.in);	//enables keyboard inputs
		System.out.print("What is your name? ");	//asks for one's name
		String nam = input.nextLine();	//for entering string characters
		System.out.println("Welcome, " + nam + " to Java Programming!");	//displays welcome message
		
		System.out.print("\nInput first number: ");	//asks for first integer	
		int fir = input.nextInt();	//for entering integers only
		System.out.print("Input second number: ");	//asks for second integer
		int fir2 = input.nextInt();	//for entering integers only
		int fir3 = fir % fir2;	//performs integer integer division
		System.out.printf("%nThe remainder after the division of %d by %d = %d%n", fir, fir2, fir3);	//displays remainder when integer is divided by the other
		double f = Math.pow(fir, fir2);	//performs indices
		System.out.printf("%n%d raised to power %d is: %.0f%n", fir, fir2, f);	//displays results of indices
		
		Account joe = new Account();
		JOptionPane.showMessageDialog(null, "I heard that " + joe.acc(nam));
	}
}