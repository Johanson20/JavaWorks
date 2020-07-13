package joe_graphic;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JOptionPane;

//creates a class for drawing either beautiful shapes from 2 sets of choices

@SuppressWarnings("serial")
public class drawpane extends JPanel	//inheritance
{
	private int choice;
	
	public drawpane(int userChoice)
	{
		choice = userChoice;
	}
	
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		int n = 30;
		int wid = getWidth();
		int hei = getHeight();
		
		if (choice == 1)
		{	String spec = JOptionPane.showInputDialog("Enter 1 to draw a web\n"
					+ "Enter 2 to draw rectangles");	//prompts user for choice
			int choic = Integer.parseInt(spec);//converts selection to string
					
			switch(choic)
			{	
				case 1:	//draws web-like lines from top-left to bottom-right
				{	for (int i=0; i<=n; i++)
					{	g.drawLine(0, 0, wid*(n-i)/n, hei*i/n);
						g.drawLine(0, hei, wid*(n-i)/n, hei*(n-i)/n);
						g.drawLine(wid, 0, wid*i/n, hei*i/n);
						g.drawLine(wid, hei, wid*i/n, hei*(n-i)/n);
					}
					break;
				}
				default:	//draws rectangle
					for (int i=0; i<=n; i++)
						g.drawRect(wid*i/n, hei*i/n, hei + 10*i, wid+15*i);
					break;
			}
		}	
		else if (choice == 2)
		{	String spec1 = JOptionPane.showInputDialog("Enter 1 to draw ovals\n"
					+ "Enter 2 to draw curves");
		int choic = Integer.parseInt(spec1);
		
		switch(choic)
		{	case 1:		
			{	for (int i=0; i<=n; i++)
				{	g.drawLine(0, hei*i/n, wid*(i+1)/n, hei);
					g.drawLine(wid, hei*(n-i)/n, wid*(n-i)/n, 0);
					g.drawLine(0, hei*(n-i)/n, wid*(1+i)/n, 0);
					g.drawLine(wid, hei*i/n, wid*(n-i)/n, hei);
				}
				break;
			}
			case 2:
				for (int i=0; i<=n; i++)
					g.drawOval(5*i + wid*i/n, 5*i + hei*i/n, hei + 10*i, wid+15*i);
				break;
		}
		}
	}
}