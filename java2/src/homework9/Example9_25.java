package homework9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 利用地九章所学做一个华容道的游戏
 * @author lcj
 *
 */
public class Example9_25 {
	public static void main(String[] args) {
		new Hua_Rong_Road();
	}
}

class Hua_Rong_Road extends JFrame implements MouseListener,KeyListener,ActionListener {
	
	Person person[] = new Person[10];
	JButton left,right,above,below;
	JButton restart = new JButton("重新开始");
	public Hua_Rong_Road() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 500);
		setVisible(true);
		validate();
	}
	
	public void init(){
		setLayout(null);
		add(restart);
		restart.setBounds(100, 320, 120, 35);
		restart.addActionListener(this);
		String name[] = {"曹操","关羽","张","刘","周","黄","兵","兵","兵","兵"};
		for(int i=0;i<name.length;i++){
			person[i] = new Person(i, name[i]);
			person[i].addMouseListener(this);
			person[i].addKeyListener(this);
			add(person[i]);
		}
		
		person[0].setBounds(104, 54, 100, 100);
		person[1].setBounds(104, 154, 100, 50);
		person[2].setBounds(54, 154, 50, 100);
		person[3].setBounds(204, 154, 50, 100);
		person[4].setBounds(54, 54, 50, 100);
		person[5].setBounds(204, 54, 50, 100);
		person[6].setBounds(54, 254, 50, 50);
		person[7].setBounds(204, 254, 50, 50);
		person[8].setBounds(104, 204, 50, 50);
		person[9].setBounds(154, 204, 50, 50);
		person[9].requestFocus();
		left = new JButton();
		right = new JButton();
		above = new JButton();
		below = new JButton();
		add(left);
		add(right);
		add(above);
		add(below);
		left.setBounds(49, 49, 5, 260);
		right.setBounds(254, 49, 5, 260);
		above.setBounds(49, 49, 210, 5);
		below.setBounds(49, 304, 210, 5);
		validate();
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Person man = (Person) e.getSource();
		int x = -1,y=-1;
		x = e.getX();
		y = e.getY();
		int w = man.getBounds().width;
		int h = man.getBounds().height;
		if(y>h/2){
			go(man,below);
		}
		if(y<h/2){
			go(man,above);
		}
		if(x>w/2){
			go(man,right);
		}
		if(x<w/2){
			go(man,left);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new Hua_Rong_Road();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Person man = (Person) e.getSource();
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			go(man,below);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			go(man,above);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			go(man,left);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			go(man,right);
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public void go(Person man,JButton direction){
		boolean move = true;
		Rectangle manRect = man.getBounds();
		int x = man.getBounds().x;
		int y = man.getBounds().y;
		if(direction == below){
			y = y+50;
		}
		if(direction == above){
			y = y-50;
		}
		if(direction == left){
			x = x-50;
		}
		if(direction == right){
			x = x+50;
		}
		manRect.setLocation(x, y);
		Rectangle directionRect = direction.getBounds();
		for(int k=0;k<10;k++){
			Rectangle personRect = person[k].getBounds();
			if((manRect.intersects(personRect)) && (man.num != k)){
				move = false;
			}
		}
		if(manRect.intersects(directionRect)){
			move = false;
		}
		if(move == true){
			man.setLocation(x, y);
		}
	}
	
}



class Person extends JButton implements FocusListener {

	int num;
	Color color = new Color(255,245,170);
	Font font = new Font("宋体", Font.BOLD, 12);
	public Person(int num,String s) {
		super(s);
		setBackground(color);
		setFont(font);
		this.num = num;
		color = getBackground();
		addFocusListener(this);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		setBackground(Color.RED);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		setBackground(color);
	}
	
}