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
 * ʹ�ö�����ʵ����Ʒ����¼������ʾϵͳ
 * 
 * @author lcj
 *
 */
public class Example15_11 {
	public static void main(String[] args) {
		WindowGoods win = new WindowGoods();
		win.setTitle("��Ʒ��¼������ʾ");
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
	File f = null; // ���������ļ�
	Box baseBox, boxV1, boxV2;
	JTextField name, mount, price; // Ϊgoods�����ṩ����ͼ
	JButton button; // ������
	LinkedList<Goods> list;// ���goods���������

	public InputArea(File f) {
		this.f = f;
		list = new LinkedList<Goods>();
		name = new JTextField(12); //�ı���
		mount = new JTextField(12);
		price = new JTextField(12);
		button = new JButton("¼��"); //��ť
		button.addActionListener(this);//����������
		boxV1 = Box.createVerticalBox(); // ����һ����ֱ�ڷŵĺ���
		boxV1.add(new JLabel("��������"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("������"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("���뵥��"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����¼��"));
		boxV2 = Box.createVerticalBox();
		boxV2.add(name);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(mount);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(price);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(button);
		baseBox = Box.createHorizontalBox(); //����һ��ˮƽ�ĺ���
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
	JMenuBar bar; // �˵���
	JMenu fileMenu; // �˵�
	JMenuItem ¼��, ��ʾ; // �˵���
	JTextArea show;
	InputArea inputMessage;
	JPanel pCenter;
	JTable table;
	Object ���Ԫ[][], ����[] = { "����", "���", "����" };
	CardLayout card;

	public WindowGoods() {
		file = new File("image/���.txt");
		¼�� = new JMenuItem("¼��");
		��ʾ = new JMenuItem("��ʾ");
		bar = new JMenuBar();
		fileMenu = new JMenu("�˵�ѡ��");
		fileMenu.add(¼��);
		fileMenu.add(��ʾ);
		bar.add(fileMenu);
		setJMenuBar(bar);
		¼��.addActionListener(this);
		��ʾ.addActionListener(this);
		inputMessage = new InputArea(file); // ����¼�����
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("¼��", inputMessage);
		add(pCenter, BorderLayout.CENTER);
		setVisible(true);
		setBounds(100, 50, 420, 380);
		validate(); // ˢ�´���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ¼��){
			card.show(pCenter, "¼��");
		}else if(e.getSource() == ��ʾ){
			try {
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream bis = new ObjectInputStream(in);
				LinkedList<Goods> list = (LinkedList<Goods>) bis.readObject();
				in.close();
				bis.close();
				int lenght = list.size();
				���Ԫ = new Object[lenght][3];
				table = new JTable(���Ԫ, ����);
				pCenter.removeAll();
				pCenter.add("¼��",inputMessage);
				pCenter.add("��ʾ", new JScrollPane(table));
				pCenter.validate();
				Iterator<Goods> iterator = list.iterator();
				int i = 0;
				while(iterator.hasNext()){
					Goods ��Ʒ = iterator.next();
					���Ԫ[i][0] = ��Ʒ.getName();
					���Ԫ[i][1] = ��Ʒ.getMount();
					���Ԫ[i][2] = ��Ʒ.getPrice();
					i++;
				}
				table.repaint();
			} catch (Exception e2) {
			}
			card.show(pCenter, "��ʾ");
		}
	}

}
