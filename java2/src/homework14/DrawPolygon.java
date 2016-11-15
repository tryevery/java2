package homework14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 绘制一个五边形
 * @author lcj
 *
 */
public class DrawPolygon  extends JPanel {
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Polygon p = new Polygon();
		p.addPoint(50, 50);
		p.addPoint(100, 50);
		p.addPoint(120, 100);
		p.addPoint(75, 150);
		p.addPoint(40, 100);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(p);
	}
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setSize(400, 400);
		j.add(new DrawPolygon());
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
