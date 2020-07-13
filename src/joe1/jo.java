package joe1;
// Calculates from first principle, e raised to a power n,
// where e is the base of natural logarithm
//Afterwards a class financeTest is instantiated (object) and manipulated

import javax.swing.JOptionPane;

public class jo	//computes power of e to any number using series expansion of e
{
	public static void main(String[] args)
	{
		double x, v, tot = 0, van, n = 100, va;
		
		String xa = JOptionPane.showInputDialog("Enter value of x:");//prompts
		x = Double.parseDouble(xa);//converts entry to double
		
		for (int c = 0; c <= n; c++)//truncates series expansion at n equals 100
		{	van = Math.pow(x, c);	//computes power
			v = factorial(c);	//calls the factorial function
			va = (double)van/v;
			tot += va;	//sums up the series
		}
		System.out.printf("e^%.0f\t=\t%.10f%n", x, tot);	//outputs result
		System.out.println();
		System.out.println("Testing the object oriented class - 1, 2, ...");
		
		financeTest sample = new financeTest("Johanson Onyegbula", 21, 20000, 0);
		System.out.printf("%s", sample.toString());
		sample.setName("Njideka");
		sample.setSalary(40000);
		sample.setBonus(14850);
		sample.setId(7);
		System.out.printf("%s%n", sample.toString());
	}
	
	public static double factorial(int x)	//computes factorial of an integer
	{
		double total = 1;
		switch (x)
		{
			case 0:
				total = 1;
				break;
			default:
				for (int p = x; p > 0; p--)
				total *= (double) p;
				break;
		}
		return total;
	}
}