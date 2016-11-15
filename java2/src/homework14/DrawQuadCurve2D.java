package homework14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 绘制抛物线的一部分
 * @author lcj
 *
 */
public class DrawQuadCurve2D extends JPanel{
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		QuadCurve2D qu = new QuadCurve2D.Double(50, 30, 10, 65, 50, 100);//分别是端点的坐标,定点坐标,端点坐标
		g2d.setColor(Color.RED);
		g2d.draw(qu);
	}
	
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(400, 400);
		JPanel p = new DrawQuadCurve2D();
		win.add(p);
	}
}
