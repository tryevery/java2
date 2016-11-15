package homework15;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 使用对象流实现商品库存的录入与显示系统
 * 
 * @author lcj
 *
 */
public class Example15_11 {
	public static void main(String[] args) {
		WindowGoods win = new WindowGoods();
		win.setTitle("商品的录入与显示");
	}
}

class Goods implements Serializable {
	String name, mount, price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMount() {
		return mount;
	}

	public void setMount(String mount) {
		this.mount = mount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}

class InputArea extends JPanel implements ActionListener {
	File f = null; // 存放链表的文件
	Box baseBox, boxV1, boxV2;
	JTextField name, mount, price; // 为goods对象提供的视图
	JButton button; // 控制器
	LinkedList<Goods> list;// 存放goods对象的链表

	public InputArea(File f) {
		this.f = f;
		list = new LinkedList<Goods>();
		name = new JTextField(12); //文本框
		mount = new JTextField(12);
		price = new JTextField(12);
		button = new JButton("录入"); //按钮
		button.addActionListener(this);//动作监听器
		boxV1 = Box.createVerticalBox(); // 创建一个垂直摆放的盒子
		boxV1.add(new JLabel("输入名称"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("输入库存"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("输入单价"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("单击录入"));
		boxV2 = Box.createVerticalBox();
		boxV2.add(name);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(mount);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(price);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(button);
		baseBox = Box.createHorizontalBox(); //创建一个水平的盒子
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10)); 
		baseBox.add(boxV2);
		add(baseBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (f.exists()) {
			try {
				FileInputStream in = new FileInputStream(f);
				ObjectInputStream bis = new ObjectInputStream(in);
				list = (LinkedList<Goods>) bis.readObject();
				in.close();
				bis.close();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setMount(mount.getText());
				goods.setPrice(price.getText());
				list.add(goods);
				FileOutputStream out = new FileOutputStream(f);
				ObjectOutputStream bos = new ObjectOutputStream(out);
				bos.writeObject(list);
				out.close();
			} catch (Exception e2) {
			}
		} else {
			try {
				f.createNewFile();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setMount(mount.getText());
				goods.setPrice(price.getText());
				list.add(goods);
				FileOutputStream out = new FileOutputStream(f);
				ObjectOutputStream bos = new ObjectOutputStream(out);
				bos.writeObject(list);
				out.close();
			} catch (Exception e2) {
			}
		}

	}

}

class WindowGoods extends JFrame implements ActionListener {
	File file = null;
	JMenuBar bar; // 菜单条
	JMenu fileMenu; // 菜单
	JMenuItem 录入, 显示; // 菜单项
	JTextArea show;
	InputArea inputMessage;
	JPanel pCenter;
	JTable table;
	Object 表格单元[][], 列名[] = { "名称", "库存", "单价" };
	CardLayout card;

	public WindowGoods() {
		file = new File("image/库存.txt");
		录入 = new JMenuItem("录入");
		显示 = new JMenuItem("显示");
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(录入);
		fileMenu.add(显示);
		bar.add(fileMenu);
		setJMenuBar(bar);
		录入.addActionListener(this);
		显示.addActionListener(this);
		inputMessage = new InputArea(file); // 创建录入界面
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("录入", inputMessage);
		add(pCenter, BorderLayout.CENTER);
		setVisible(true);
		setBounds(100, 50, 420, 380);
		validate(); // 刷新窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == 录入){
			card.show(pCenter, "录入");
		}else if(e.getSource() == 显示){
			try {
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream bis = new ObjectInputStream(in);
				LinkedList<Goods> list = (LinkedList<Goods>) bis.readObject();
				in.close();
				bis.close();
				int lenght = list.size();
				表格单元 = new Object[lenght][3];
				table = new JTable(表格单元, 列名);
				pCenter.removeAll();
				pCenter.add("录入",inputMessage);
				pCenter.add("显示", new JScrollPane(table));
				pCenter.validate();
				Iterator<Goods> iterator = list.iterator();
				int i = 0;
				while(iterator.hasNext()){
					Goods 商品 = iterator.next();
					表格单元[i][0] = 商品.getName();
					表格单元[i][1] = 商品.getMount();
					表格单元[i][2] = 商品.getPrice();
					i++;
				}
				table.repaint();
			} catch (Exception e2) {
			}
			card.show(pCenter, "显示");
		}
	}

}
