import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class KakaoFriends extends JPanel
{
	//panel4
	public JPanel controlPanel;
	public JButton listButton/*, minimize*/, exit;
	public JLabel title, titleTalk, titleKakao;
	public DefaultListModel listModel;
	public JList friendList;
	public JScrollPane scrollPane;
	public KakaoFriends()
	{
		//card4
		controlPanel = new JPanel();
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		ImageIcon list = new ImageIcon("list.png");
		Image resizedList = list.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		listButton = new JButton("¸ñ·Ï",new ImageIcon(resizedList)); 
		title = new JLabel("Ä£±¸¸ñ·Ï");
		listModel = new DefaultListModel();
		friendList = new JList(listModel);
		scrollPane = new JScrollPane(friendList);
		//minimize = new JButton("_");
		exit = new JButton("X");;

		setLayout(null);
		controlPanel.setLayout(null);
		controlPanel.add(title);
		controlPanel.add(titleKakao);
		controlPanel.add(titleTalk);
		controlPanel.add(listButton);
		//controlPanel.add(minimize);
		controlPanel.add(exit); 

		controlPanel.setBounds(0, 0, 350, 100);
		controlPanel.setBackground(new Color(69,44,42));
		
		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));

		title.setBounds(150, 40,	 65, 30);
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		listButton.setBackground(new Color(69,44,42));
		listButton.setBounds(280, 50, 50, 50);
		listButton.setBorder(null);
		scrollPane.setBounds(0, 100, 350, 500);

		/*
		minimize.setBackground(new Color(255,235,51));
		minimize.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		minimize.setBorder(null);
		minimize.setFocusPainted(false);
		minimize.setBounds(310, 1, 20, 20);
		minimize.addActionListener(new KakaoSizeEvent(this));
		*/

		exit.setBackground(new Color(69,44,42));
		exit.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new )

		listModel.addElement("f1");	 listModel.addElement("g2");
		listModel.addElement("f2");	 listModel.addElement("g3 g3");
		listModel.addElement("f4");	 listModel.addElement("g4");
		listModel.addElement("g5");
		
		friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(controlPanel);
		add(scrollPane);
	}

}
