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
 * ��ѭMVCģʽ�������ε����
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
	JTextField upperBase,downBase,height;  //��ͼ
	JTextArea showArea; //��ͼ
	JButton button; //����
	public CountArea() {
		init();
		setTitle("�������ε����");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		upperBase = new JTextField(5);
		downBase = new JTextField(5);
		height = new JTextField(5);
		showArea = new JTextArea(10,15);
		button = new JButton("�������");
		JPanel panel = new JPanel();
		panel.add(new JLabel("�ϵ�:"));
		panel.add(upperBase);
		panel.add(new JLabel("�µ�:"));
		panel.add(downBase);
		panel.add(new JLabel("��:"));
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
			showArea.append("����"+a+" "+b+" "+c+"�����");
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
