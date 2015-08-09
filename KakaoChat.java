import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoChat extends JPanel
{
		//panel3
	JPanel controlPanel, inputPanel;
	JButton preButton, exitButton, sendButton,inviteButton/* , minimize*/, exit;
	JLabel title, titleTalk, titleKakao;
	JTextArea textArea;	//´ëÈ­Ã¢
	JTextField inputField;	 //ÀÔ·ÂÃ¢
	JScrollPane scrollPane;

	//card3
	public KakaoChat()
	{
		controlPanel = new JPanel();
		inputPanel = new JPanel();
		titleKakao = new JLabel("Kakao");
		titleTalk = new JLabel("Talk");
		preButton = new JButton("ÀÌÀü");
		inviteButton = new JButton("Ä£±¸ÃÊ´ë");
		exitButton = new JButton("³ª°¡±â");
		sendButton = new JButton("Àü¼Û");
		title = new JLabel("      Ã¤ÆÃ¹æ ÀÌ¸§      ");
		textArea = new JTextArea();
		inputField = new JTextField(20);
		scrollPane = new JScrollPane(textArea);
		//minimize = new JButton("_");
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
		//controlPanel.add(minimize);
		controlPanel.add(exit); 

		titleKakao.setBounds(10 ,3 ,70, 30);
		titleKakao.setForeground(new Color(255,255,255));
		titleKakao.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,20));
		titleTalk.setBounds(65 ,3 ,70, 30);
		titleTalk.setForeground(new Color(255,255,255));
		titleTalk.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));

		preButton.setBounds(305, 30, 45, 45);
		title.setBounds(0, 80, 350, 440);
		inviteButton.setBounds(10, 30, 45, 45);
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
		
		/*
		minimize.setBackground(new Color(147,177,205));
		minimize.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		minimize.setForeground(new Color(255,255,255));
		minimize.setBorder(null);
		minimize.setFocusPainted(false);
		minimize.setBounds(310, 1, 20, 20);
		minimize.addActionListener(new KakaoSizeEvent(this));
		*/
		
		
		exit.setBackground(new Color(147,177,205));
		exit.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,12));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new )

		add(controlPanel);
		add(scrollPane);
		add(inputPanel);
		
		textArea.setEditable(false);
	}
}
