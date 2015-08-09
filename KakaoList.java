import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class KakaoList extends JPanel 
{
	private ArrayList<Room> roomList;

	public JPanel controlPanel;
	public JButton enterButton,addChatButton,fListButton, exit;
	public JLabel title, titleTalk, titleKakao;
	public DefaultListModel listModel;
	public JList chatList;
	public JScrollPane scrollPane;

	public KakaoList()
	{

		roomList = new ArrayList<Room>();
		controlPanel = new JPanel();
		ImageIcon list = new ImageIcon("list.png");
		Image resizedList = list.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		fListButton = new JButton("친구목록", new ImageIcon(resizedList));
		ImageIcon enter = new ImageIcon("enter.png");
		Image resizedEnter = enter.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		enterButton = new JButton("입장",new ImageIcon(resizedEnter)); 
		ImageIcon addChat = new ImageIcon("add.png");
		Image resizedAddChat = addChat.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		addChatButton = new JButton("채팅추가",new ImageIcon(resizedAddChat)); 
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		title = new JLabel("채   팅");
		listModel = new DefaultListModel();
		chatList = new JList(listModel);
		scrollPane = new JScrollPane(chatList);
		exit = new JButton("X");
		
		setLayout(null);
		controlPanel.setLayout(null);
		add(controlPanel);
		controlPanel.add(titleKakao);
		controlPanel.add(titleTalk);
		controlPanel.add(enterButton);
		controlPanel.add(title);
		controlPanel.add(fListButton);
		controlPanel.add(addChatButton);
		controlPanel.add(exit); 

		//controlPanel 색
		controlPanel.setBounds(0, 0, 350, 100);
		controlPanel.setBackground(new Color(69,44,42));
		
		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("맑은 고딕",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("맑은 고딕",Font.BOLD,20));

		enterButton.setBackground(new Color(69,44,42));
		enterButton.setBounds(20, 50, 50, 50);
		enterButton.setBorder(null);
		enterButton.setFocusPainted(false);
		title.setBounds(135, 50, 100, 50);
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		fListButton.setBackground(new Color(69,44,42));
		fListButton.setBounds(230, 50, 50, 50);
		fListButton.setBorder(null);
		fListButton.setFocusPainted(false);
		addChatButton.setBackground(new Color(69,44,42));
		addChatButton.setBounds(280, 50, 50, 50);
		addChatButton.setBorder(null);
		addChatButton.setFocusPainted(false);
		scrollPane.setBounds(0, 100, 350, 500);
		
		exit.setBackground(new Color(69,44,42));
		exit.setFont(new Font("맑은 고딕",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new );
		
		add(scrollPane);

		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}

	// 채팅방을 리스트에 추가하고 화면에 추가한다.
	public void addChatRoom(Room room) {
		roomList.add(room);
		listModel.addElement( room.getRoomId() + "-" + room.getRoomName() );
	}
}
