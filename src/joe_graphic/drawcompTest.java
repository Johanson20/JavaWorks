package joe_graphic;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//drawpane class implemented here

public class drawcompTest
{
	public static void main(String[] args)
	{
		String cho = JOptionPane.showInputDialog("Enter 1 to draw from the family of"
				+ " straight lines\nEnter 2 to draw from the family of arcs");
		int choice = Integer.parseInt(cho);
		drawpane drawer = new drawpane(choice);
		JFrame app = new JFrame();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(drawer);
		app.setSize(1000, 600);
		app.setVisible(true);
	}
}