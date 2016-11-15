package homework9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 在一个窗口中输入数字，在另一个窗口中求和
 * @author lcj
 *
 */
public class CountFrame {
	public static void main(String[] args) {
		new MainCountFrame();
	}
}

class MainCountFrame extends JFrame implements DocumentListener {
	
	JTextArea textArea,showArea;
	public MainCountFrame() {
		init();
		setTitle("计算");
		setLayout(new FlowLayout());
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	void init(){
		textArea = new JTextArea(5,15);
		showArea = new JTextArea(5,15);
		add(new JScrollPane(textArea),BorderLayout.WEST);
		add(new JScrollPane(showArea),BorderLayout.EAST);
		textArea.getDocument().addDocumentListener(this);
		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		String str = textArea.getText();
		double sum = 0;
		Scanner s = new Scanner(str);
		showArea.setText(null);
		while(s.hasNext()){
				sum += s.nextDouble();
		}
		showArea.append("sum="+sum);
			
	}

}
