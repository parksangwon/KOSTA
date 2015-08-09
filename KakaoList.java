import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class KakaoList extends JPanel 
{
	private ArrayList<Room> roomList;

	JPanel controlPanel;
	JButton enterButton,addChatButton,fListButton/*, minimize*/, exit;
	JLabel title, titleTalk, titleKakao;
	DefaultListModel listModel;
	JList chatList;
	JScrollPane scrollPane;

	public KakaoList()
	{

		roomList = new ArrayList<Room>();
		controlPanel = new JPanel();
		ImageIcon list = new ImageIcon("list.png");
		Image resizedList = list.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		fListButton = new JButton("Ä£±¸¸ñ·Ï", new ImageIcon(resizedList));
		ImageIcon enter = new ImageIcon("enter.png");
		Image resizedEnter = enter.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		enterButton = new JButton("ÀÔÀå",new ImageIcon(resizedEnter)); 
		ImageIcon addChat = new ImageIcon("add.png");
		Image resizedAddChat = addChat.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		addChatButton = new JButton("Ã¤ÆÃÃß°¡",new ImageIcon(resizedAddChat)); 
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		title = new JLabel("Ã¤        ÆÃ");
		listModel = new DefaultListModel();
		chatList = new JList(listModel);
		scrollPane = new JScrollPane(chatList);
		//minimize = new JButton("_");
		exit = new JButton("X");;
		
		setLayout(null);
		controlPanel.setLayout(null);
		add(controlPanel);
		controlPanel.add(titleKakao);
		controlPanel.add(titleTalk);
		controlPanel.add(enterButton);
		controlPanel.add(title);
		controlPanel.add(fListButton);
		controlPanel.add(addChatButton);
		//controlPanel.add(minimize);
		controlPanel.add(exit); 

		//controlPanel »ö
		controlPanel.setBounds(0, 0, 350, 100);
		controlPanel.setBackground(new Color(69,44,42));
		
		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));

		enterButton.setBackground(new Color(69,44,42));
		enterButton.setBounds(20, 50, 50, 50);
		enterButton.setBorder(null);
		title.setBounds(100, 50, 100, 50);
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		fListButton.setBackground(new Color(69,44,42));
		fListButton.setBounds(230, 50, 50, 50);
		fListButton.setBorder(null);
		addChatButton.setBackground(new Color(69,44,42));
		addChatButton.setBounds(280, 50, 50, 50);
		addChatButton.setBorder(null);
		scrollPane.setBounds(0, 100, 350, 500);
		//minimize.setBounds(310, 1, 20, 20);

		/*
		enterButton.setBackground(new Color(69,44,42));
		enterButton.setForeground(new Color(255,255,255));
		enterButton.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		enterButton.setBorder(null);
		enterButton.setFocusPainted(false);
		

		fListButton.setBackground(new Color(69,44,42));
		fListButton.setForeground(new Color(255,255,255));
		fListButton.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		fListButton.setBorder(null);
		fListButton.setFocusPainted(false);

		addChatButton.setBackground(new Color(69,44,42));
		addChatButton.setForeground(new Color(255,255,255));
		addChatButton.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		addChatButton.setBorder(null);
		addChatButton.setFocusPainted(false);
		*/

		/*
		minimize.setBackground(new Color(255,235,51));
		minimize.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		minimize.setBorder(null);
		minimize.setFocusPainted(false);
		minimize.addActionListener(new KakaoSizeEvent(this));
		*/

		exit.setBackground(new Color(69,44,42));
		exit.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new );
		
		add(scrollPane);

		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}

	// Ã¤ÆÃ¹æÀ» ¸®½ºÆ®¿¡ Ãß°¡ÇÏ°í È­¸é¿¡ Ãß°¡ÇÑ´Ù.
	public void addChatRoom(Room room) {
		roomList.add(room);
		listModel.addElement( room.getRoomId() + "-" + room.getRoomName() );
	}
}
