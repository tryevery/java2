package homework14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * »æÖÆË«ÇúÏß
 * @author lcj
 *
 */
public class DarwCubicCurve2D extends JPanel{
	public void patin(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		CubicCurve2D curve = new CubicCurve2D.Double(50, 30, 10, 10, 100, 100, 50, 100);
		g2d.setColor(Color.BLACK);
		g2d.draw(curve);
	}
	
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(400, 400);
		win.add(new DarwCubicCurve2D());
	}
}
