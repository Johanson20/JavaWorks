package joe1;
import java.security.SecureRandom;

//Displays frequency analysis of random ratings

public class rating
{
	public static void main(String[] args)
	{
		SecureRandom guess = new SecureRandom();//creates an object for random number selection
		int freq[] = new int[5];	//creates an array of five integers
		String[] array = {"Awful", "Poor", "Fair", "Tasty", "Excellent"};//string array
		
		for (int a=0; a<20; a++)	//randomly computes rating values
			++freq[guess.nextInt(5)];
		
		System.out.printf("%10s%11s%n%n", "Rating", "Frequency");
		for (int count=0; count<5; count++)
			System.out.printf("%10s\t%d%n", array[count], freq[count]);
	}
}