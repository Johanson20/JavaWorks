package joe1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class enu1	//computes prime numbers between 1 and any integer, n
{
	public static void primeNumber(int number)
	{
		List<Integer> primeNumbers = new ArrayList<Integer>();//creates an integer list
		
		int factors = 0;
		for (int i=1; i <= number; i++)//loops through numbers
		{	
			for (int j=1; j<=i; j++)//tests for factors
			{
				if (i%j == 0)
				{
					factors = factors + 1;
				}
			}
			if (factors == 2)//adds prime numbers, i.e. those with just two factors
			{
				primeNumbers.add(i);
			}
			factors = 0;
		}
		for(int i=0; i<primeNumbers.size(); i++)
		{
			System.out.println(primeNumbers.get(i));	//displays the prime numbers
		}
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Select upper limit for the greatest prime number to be displayed: ");
		int upperLimit = input.nextInt();
		
		System.out.printf("%nPrime numbers between 1 to %d%n", upperLimit);
		primeNumber(upperLimit);
	}	
}