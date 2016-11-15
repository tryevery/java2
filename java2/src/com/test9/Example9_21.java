package com.test9;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * �������һ������
 * 
 * @author lcj
 *
 */
public class Example9_21 {
	public static void main(String[] args) {
		TreeWin win = new TreeWin();
	}
}

class TreeWin extends JFrame implements TreeSelectionListener {
	JTree tree;
	JTextArea area;

	public TreeWin() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Ʒ");// ���ڵ�
		DefaultMutableTreeNode nodeTV = new DefaultMutableTreeNode("���ӻ���");// ���
		DefaultMutableTreeNode nodePhone = new DefaultMutableTreeNode("�ֻ���");// ���
		DefaultMutableTreeNode tv1 = new DefaultMutableTreeNode(new Goods(
				"�������", 5699));// ���
		DefaultMutableTreeNode tv2 = new DefaultMutableTreeNode(new Goods(
				"��������", 7832));// ���
		DefaultMutableTreeNode phone1 = new DefaultMutableTreeNode(new Goods(
				"ŵ����", 3609));// ���
		DefaultMutableTreeNode phone2 = new DefaultMutableTreeNode(new Goods(
				"����", 2155));// ���
		root.add(nodePhone); //ȷ�����֮��Ĺ�ϵ
		root.add(nodeTV);
		nodeTV.add(tv1);	//ȷ�����֮��Ĺ�ϵ
		nodeTV.add(tv2);
		nodePhone.add(phone1);
		nodePhone.add(phone2);
		tree = new JTree(root); //ʹ��root��Ϊ���ڵ�
		tree.addTreeSelectionListener(this); //���ڼ���������ϵ��¼�
		area = new JTextArea();
		setLayout(new GridLayout(1, 2));
		add(new JScrollPane(tree));
		add(new JScrollPane(area));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(80, 80, 300, 300);
		validate();

	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(node.isLeaf()){
			Goods s = (Goods) node.getUserObject(); //�õ�����д�ŵĶ���
			area.append(s.name + "," + s.price + "Ԫ\n");
		}else area.setText(null);

	}

}

class Goods {
	String name;
	double price;

	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return name;
	}
}
