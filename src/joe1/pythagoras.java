package joe1;

import javax.swing.JOptionPane;

public class pythagoras	//Computes pythagorean triples of numbers between 1 to a desired number
{
	public static void main(String[] args)
	{	//prompts for an entry
		String xa = JOptionPane.showInputDialog("Enter upper limit of hypothenus of Pythagorean triple to be displayed:"); 
		int lim = Integer.parseInt(xa);		//sets limit
		
		System.out.println("Opposite  Adjacent  Hypotenuse");
		
		for (int opp = 1; opp < lim; opp++)	//tests the integer combinations
			for (int adj = 1; adj < lim; adj++)
				for (int hyp = 1; hyp < lim; hyp++)
					if (hypCheck(opp, adj, hyp) == true)//calls the pythagorean test function
						System.out.printf("%5d%10d%10d%n", opp, adj, hyp);
	}
	
	public static boolean hypCheck(int a, int b, int c)//pythagorean test function
	{
		int aa = (int) Math.pow(a, 2);
		int bb = (int) Math.pow(b, 2);
		int cc = aa + bb;//computes the sum of squares of opposite and adjacent
		if (Math.sqrt(cc) == c)//checks if the square root of earlier sum equals an integer
			return true;
		else
			return false;
	}
}