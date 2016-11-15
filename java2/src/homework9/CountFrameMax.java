package homework9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * дһ�����㴰���мӼ��˳����ַ���
 * @author lcj
 *
 */
public class CountFrameMax {
	public static void main(String[] args) {
		new MainCountFrameMax();
	}
}

class MainCountFrameMax extends JFrame implements ActionListener {
	
	JTextField number1,number2,number3;
	JButton addButton,subButton,mulButton,divButton;
	
	public MainCountFrameMax() {
		init();
		setTitle("������");
		setVisible(true);
		setBounds(100, 100, 500, 460);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		number1 = new JTextField(5);
		number2 = new JTextField(5);
		number3 = new JTextField(5);
		addButton = new JButton("��");
		subButton = new JButton("��");
		mulButton = new JButton("��");
		divButton = new JButton("��");
		add(number1);
		add(number2);
		add(number3);
		add(addButton,BorderLayout.CENTER);
		add(mulButton,BorderLayout.CENTER);
		add(subButton,BorderLayout.CENTER);
		add(divButton,BorderLayout.CENTER);
		addButton.addActionListener(this);
		mulButton.addActionListener(this);
		subButton.addActionListener(this);
		divButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String regex = "[0-9]+";
		double a = 0,b=0;
		
		if(number1.getText().matches(regex)&&number2.getText().matches(regex)){
			a = Double.parseDouble(number1.getText());
			b = Double.parseDouble(number2.getText());
		}else{
			JOptionPane.showMessageDialog(this, "ֻ����������","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		}
		
		
		if(e.getSource().equals(addButton)){
			number3.setText("���Ϊ:"+(a+b));
		}
		else if(e.getSource().equals(mulButton)){
			number3.setText("���Ϊ:"+(a-b));
		}
		else if(e.getSource().equals(subButton)){
			number3.setText("���Ϊ:"+(a*b));
		}
		else if(e.getSource().equals(divButton)){
			number3.setText("���Ϊ:"+(a/b));
		}
		
	}
	
}