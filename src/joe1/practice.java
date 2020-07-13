package joe1;
//Just some Hackerrank practice programs here


/*import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
*/

public class practice
{
	static int[] arr1 = {70, 1, 14, 17, 11, 12, 3};
	
	public static void main(String[] args)
	{
	isFactor(18, arr1);
	}
	
	public static void isFactor(int no, int[] arr)
	{
		int total = 0;
		int totall = 0;
		int tot = 1;
		while (tot < arr.length)	{
		for (int i=0; i<arr.length; i++)
		{
			total = arr[i];
			totall = total;
			if (total == no)
			{	System.out.println("Factors found!");
				System.out.println(arr[i]);
				break;		}
			else if (total < no) 
			{
				for (int j=1; j<arr.length; j++)	
				{	tot++;
					for (int k=j; k<arr.length; k++)
					{	if (i != k)
						{	total += arr[k];
							if (total > no)
							{	total = totall;
								continue;	}
							else if (total == no)
							{	System.out.println("Factors found!");
								System.out.println(arr[i]);
								break;		}
						}
					}
				}
			}
			total = 0;
		}
	}

		
	
	
	
    /*
     * Complete the 'restock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY itemCount
     *  2. INTEGER target
    
	//ArrayList<Integer> li = new ArrayList<>();
	public static int minPrice(List<List<Integer>> cost)
	{
		int total = 0;
	    List<Integer> a, b, c;
		// Write your code here
		a = cost.get(0);
		b = cost.get(1);
		c = cost.get(2);
		int mini = 0;
		int id = 0;
		
		for (int i=0; i<2; i++)
		{	
			mini = Math.min(a.get(i), a.get(i+1));
			if (a.get(i) == mini)
				id = i;
			else
				id = 2;
		}
		total += mini;
		mini = 0;
		
		for (int i=0; i<2; i++)
		{	
			if (i == id)
				i++;
			mini = Math.min(b.get(i), b.get(i+1));
			if (b.get(i) == mini)
				id = i;
			else
				id = 2;
		}
		total += mini;
		mini = 0;
		
		for (int i=0; i<2; i++)
		{	
			if (i == id)
				i++;
			mini = Math.min(b.get(i), b.get(i+1));
			if (b.get(i) == mini)
				id = i;
			else
				id = 2;
		}
		total += mini;
		mini = 0;
		
		
		int rem = 0;
        for (int i=0; i<calCounts.size(); i++)
        {
            if (calCounts(i) > requiredCals)
                i++;
            else if (calCounts(i) == requiredCals)
                pa = true;
            else
            {   rem = requiredCals - calCounts(i);
                calCounts. .remove(i);
            }
        }*/
	}
}