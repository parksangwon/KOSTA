import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoChat extends JPanel
{
		//panel3
	JPanel controlPanel, inputPanel;
	JButton preButton, exitButton, sendButton,inviteButton;
	JLabel title;
	JTextArea textArea;	//대화창
	JTextField inputField;	 //입력창
	JScrollPane scrollPane;
	//card3
	public KakaoChat()
	{
		controlPanel = new JPanel();
		inputPanel = new JPanel();
		preButton = new JButton("이전");
		inviteButton = new JButton("친구초대");
		exitButton = new JButton("나가기");
		sendButton = new JButton("전송");
		title = new JLabel("      채팅방 이름      ");
		textArea = new JTextArea();
		inputField = new JTextField(20);
		scrollPane = new JScrollPane(textArea);

		setLayout(new BorderLayout());

		controlPanel.add(preButton);
		controlPanel.add(title);
		controlPanel.add(inviteButton);
		controlPanel.add(exitButton);
		inputPanel.add(inputField);
		inputPanel.add(sendButton);

		add("North",controlPanel);
		add("Center",scrollPane);
		add("South",inputPanel);
		
		textArea.setEditable(false);
	}
}
