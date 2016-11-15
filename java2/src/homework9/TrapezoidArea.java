package homework9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 遵循MVC模式计算梯形的面积
 * @author lcj
 *
 */
public class TrapezoidArea {
	public static void main(String[] args) {
		new CountArea();
	}
}

class CountArea extends JFrame implements ActionListener{
	Trapezoid t;
	JTextField upperBase,downBase,height;  //视图
	JTextArea showArea; //视图
	JButton button; //控制
	public CountArea() {
		init();
		setTitle("计算梯形的面积");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		upperBase = new JTextField(5);
		downBase = new JTextField(5);
		height = new JTextField(5);
		showArea = new JTextArea(10,15);
		button = new JButton("计算面积");
		JPanel panel = new JPanel();
		panel.add(new JLabel("上底:"));
		panel.add(upperBase);
		panel.add(new JLabel("下底:"));
		panel.add(downBase);
		panel.add(new JLabel("高:"));
		panel.add(height);
		panel.add(button);
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(showArea),BorderLayout.SOUTH);
		button.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double a = Double.parseDouble(upperBase.getText().trim());
			double b = Double.parseDouble(downBase.getText().trim());
			double c = Double.parseDouble(height.getText().trim());
			t.setUpper(a);
			t.setDown(b);
			t.setHeight(c);
			String area = t.getArea();
			showArea.append("梯形"+a+" "+b+" "+c+"的面积");
			showArea.append(area+"\n");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
}


class Trapezoid {
	double upper,down,height;
	public String getArea(){
		double area = (upper+down)*height/2;
		return String.valueOf(area);
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
	public void setDown(double down) {
		this.down = down;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}
