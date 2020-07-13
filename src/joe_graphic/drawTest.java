package joe_graphic;
import javax.swing.JFrame;

//implements class draw

public class drawTest
{
	public static void main(String[] args)
	{
		draw panel = new draw();
		JFrame app = new JFrame();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(700, 700);
		app.add(panel);
		app.setVisible(true);
	}
}