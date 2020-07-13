package joe_graphic;
import java.awt.Graphics;
import javax.swing.JPanel;
//import java.awt.Color;

//this is a Class that draws a weird kind of concentric rectangles in a GUI

@SuppressWarnings("serial")
public class draw extends JPanel
{
	public void paintComponent(Graphics g)
	{
		int wid = getWidth();
		int hei = getHeight();
		super.paintComponent(g);
		
		/*for (int a = 1; a <= n/2; a++)
		{
			if (a%2 == 1)
				g.setColor(Color.CYAN);
			else
				g.setColor(Color.MAGENTA);
			g.fillOval(wid*a/n, hei*a/n, wid*(n-2*a)/n, hei*(n-2*a)/n);
		}*/
		for (int c = 0; c < wid ; c += 30)
		{	
			g.drawLine(wid/2+c, hei/2-c, wid/2+c, hei/2+c+30);
			g.drawLine(wid/2-c, hei/2-c, wid/2-c, hei/2+c);
			g.drawLine(wid/2-c-30, hei/2+c+30, wid/2+c, hei/2+c+30);
			g.drawLine(wid/2-c-30, hei/2-30-c, wid/2+c+30, hei/2-30-c);
		}
	}
}