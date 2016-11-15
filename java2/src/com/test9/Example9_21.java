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
 * 树组件的一个程序
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
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("商品");// 根节点
		DefaultMutableTreeNode nodeTV = new DefaultMutableTreeNode("电视机类");// 结点
		DefaultMutableTreeNode nodePhone = new DefaultMutableTreeNode("手机类");// 结点
		DefaultMutableTreeNode tv1 = new DefaultMutableTreeNode(new Goods(
				"长虹电视", 5699));// 结点
		DefaultMutableTreeNode tv2 = new DefaultMutableTreeNode(new Goods(
				"海尔电视", 7832));// 结点
		DefaultMutableTreeNode phone1 = new DefaultMutableTreeNode(new Goods(
				"诺基亚", 3609));// 结点
		DefaultMutableTreeNode phone2 = new DefaultMutableTreeNode(new Goods(
				"三星", 2155));// 结点
		root.add(nodePhone); //确定结点之间的关系
		root.add(nodeTV);
		nodeTV.add(tv1);	//确定结点之间的关系
		nodeTV.add(tv2);
		nodePhone.add(phone1);
		nodePhone.add(phone2);
		tree = new JTree(root); //使用root做为根节点
		tree.addTreeSelectionListener(this); //窗口监视树组件上的事件
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
			Goods s = (Goods) node.getUserObject(); //得到结点中存放的对象
			area.append(s.name + "," + s.price + "元\n");
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
