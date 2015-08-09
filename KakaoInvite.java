import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class KakaoInvite extends JPanel
{
	//panel5
	public JPanel controlPanel;
	public JButton inviteButton,backButton/*, minimize*/, exit;
	public JLabel title, titleTalk, titleKakao;
	public DefaultListModel listModel;
	public JList inviteList;
	public JScrollPane scrollPane;
	public KakaoInvite()
	{
		//card4
		controlPanel = new JPanel();
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		ImageIcon add = new ImageIcon("add.png");
		Image resizedAdd = add.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		inviteButton = new JButton("√ ¥Î«œ±‚", new ImageIcon(resizedAdd)); 
		ImageIcon previous = new ImageIcon("previous.png");
		Image resizedPrevious = previous.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backButton = new JButton("µπæ∆∞°±‚", new ImageIcon(resizedPrevious)); 
		//backButton.setName("µπæ∆∞°±‚");
		title = new JLabel("√ ¥Î∏Ò∑œ");
		listModel = new DefaultListModel();
		inviteList = new JList(listModel);
		scrollPane = new JScrollPane(inviteList);
		//minimize = new JButton("_");
		exit = new JButton("X");

		setLayout(null);
		controlPanel.setLayout(null);
		controlPanel.add(titleKakao);
		controlPanel.add(titleTalk);
		controlPanel.add(inviteButton);
		controlPanel.add(title);
		controlPanel.add(backButton);
		//controlPanel.add(minimize);
		controlPanel.add(exit); 

		scrollPane.setBounds(0, 100, 350, 500);
		title.setBounds(100, 50, 100, 50);
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
		
		inviteButton.setBounds(20, 50, 50, 50);
		inviteButton.setBackground(new Color(69, 44, 42));
		inviteButton.setBorder(null);
		inviteButton.setFocusPainted(false);
		backButton.setBackground(new Color(69, 44, 42));
		backButton.setBounds(280, 50, 50, 50);
		backButton.setBorder(null);
		backButton.setFocusPainted(false);
		
		
		controlPanel.setBounds(0, 0, 350, 100);
		controlPanel.setBackground(new Color(69,44,42));
		
		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));

		/*
		minimize.setBackground(new Color(255,235,51));
		minimize.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,15));
		minimize.setBorder(null);
		minimize.setFocusPainted(false);
		minimize.addActionListener(new KakaoSizeEvent(this));
		*/

		exit.setBackground(new Color(69,44,42));
		exit.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new );

		

		listModel.addElement("f1");	 listModel.addElement("g2");
		listModel.addElement("f2");	 listModel.addElement("g3 g3");
		listModel.addElement("f4");	 listModel.addElement("g4");
		listModel.addElement("g5");
		
		inviteList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		add("North",controlPanel);
		add("Center",scrollPane);
	}
}
