package joe1;
import javax.swing.JOptionPane;

//run the program to see the instructions yourself - its often used in Surveying

public class SurveyBackComputations
{
	public static void main(String[] args)
	{
		double N1, E1, N2, E2, brg, bearing, distance, deltaN, deltaE;
		JOptionPane.showMessageDialog(null, "This program computes the distance and "
				+ "bearing between two points when their coordinates are entered.");
		JOptionPane.showMessageDialog(null, "Northing is the change along the y axis and "
				+ "Easting is the change along the x axis.");
		
		String n1 = JOptionPane.showInputDialog("First Point\nEnter Northing"
				+ " of first point:");
		String e1 = JOptionPane.showInputDialog("Enter Easting of first point:");
		String n2 = JOptionPane.showInputDialog("SecondPoint\nEnter Northing "
				+ "of second point:");
		String e2 = JOptionPane.showInputDialog("Enter Easting of second point:");
		
		N1 = Double.parseDouble(n1);
		E1 = Double.parseDouble(e1);
		N2 = Double.parseDouble(n2);
		E2 = Double.parseDouble(e2);
		
		//calculates the euclidean distance
		distance = Math.sqrt(Math.pow(N1, 2) + Math.pow(N2, 2));
		deltaN = N2 - N1;
		deltaE = E2 - E1;
		
		//computes the bearing and converts from radians to degrees
		brg = Math.toDegrees(Math.atan2(deltaN, deltaE));
		//specifies bearing at correct quadrant
		if (brg < 0)
			bearing = 360 + brg;
		else
			bearing = brg;
		
		String aa = String.format("Distance between both points is: %.2fm", distance);
		String bb = String.format("Bearing from Points 1 to 2 is: %.2f degrees", bearing);
		JOptionPane.showMessageDialog(null, aa);
		JOptionPane.showMessageDialog(null, bb);
	}
}