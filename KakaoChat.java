import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoChat extends JPanel
{
	public KakaoTalk kakaoTalk;
	public Room roomInfo;
		//panel3
	public JPanel controlPanel, inputPanel;
	public JButton preButton, exitButton, sendButton,inviteButton, exit;
	public JLabel title, titleTalk, titleKakao;
	public JTextArea textArea;	//대화창
	public JTextField inputField;	 //입력창
	public JScrollPane scrollPane;

	//card3
	public KakaoChat(Room roomInfo)
	{
		this.roomInfo = roomInfo;
		controlPanel = new JPanel();
		inputPanel = new JPanel();
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		preButton = new JButton("이전");
		inviteButton = new JButton("친구초대");
		exitButton = new JButton("나가기");
		sendButton = new JButton("전송");
		title = new JLabel("      채팅방 이름      ");
		textArea = new JTextArea();
		inputField = new JTextField(20);
		scrollPane = new JScrollPane(textArea);
		exit = new JButton("X");;


		setLayout(null);
		controlPanel.setLayout(null);
		inputPanel.setLayout(null);

		controlPanel.add(preButton);
		controlPanel.add(title);
		controlPanel.add(titleKakao);
		controlPanel.add(titleTalk);
		controlPanel.add(inviteButton);
		controlPanel.add(exitButton);
		inputPanel.add(inputField);
		inputPanel.add(sendButton);
		controlPanel.add(exit); 

		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("맑은고딕",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("맑은고딕",Font.BOLD,20));

		preButton.setBounds(305, 30, 45, 45);
		preButton.setBorder(null);
		preButton.setFocusPainted(false);

		title.setBounds(0, 80, 350, 440);

		inviteButton.setBounds(10, 30, 45, 45);
		inviteButton.setBorder(null);
		inviteButton.setFocusPainted(false);

		exitButton.setBounds(270, 3, 40, 20);

		controlPanel.setBounds(0, 0, 350, 80);
		controlPanel.setBackground(new Color(147,177,205));

		scrollPane.setBounds(0, 80, 350, 440);
		textArea.setBackground(new Color(155,186,216));
		textArea.setBorder(null);
		scrollPane.setBorder(null);

		inputPanel.setBounds(0, 520, 350, 80);
		inputField.setBounds(0, 0, 270, 80);
		sendButton.setBounds(270, 0, 80, 80);
		sendButton.setBackground(new Color(255,235,51));
		sendButton.setBorder(null);
		
		exit.setBackground(new Color(147,177,205));
		exit.setFont(new Font("맑은고딕",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new )

		//KakaoChatEvent
		KakaoChatEvent chatEvent = new KakaoChatEvent(kakaoTalk, this, roomInfo);
		this.preButton.addActionListener(chatEvent);
		this.exitButton.addActionListener(chatEvent);
		this.sendButton.addActionListener(chatEvent);
		this.inputField.addActionListener(chatEvent);
		this.inviteButton.addActionListener(chatEvent);

		add(controlPanel);
		add(scrollPane);
		add(inputPanel);
		
		textArea.setEditable(false);
	}
}
