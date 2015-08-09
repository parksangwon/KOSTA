import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoMain extends JPanel
{
	public JLabel idLabel, nameLabel, talkNameLabel;
	public JTextField idField, nameField, talkNameField;
	public JButton enterButton;
	public JLabel logo;
	public JButton exit;

	//card1
	public KakaoMain()
	{
		logo = new JLabel(new ImageIcon("main.jpg"));
		idLabel = new JLabel("ID : ");
		nameLabel = new JLabel("이름 : ");
		talkNameLabel = new JLabel("대화명 : ");
		idField = new JTextField(30);
		nameField = new JTextField(30);
		talkNameField = new JTextField(30);
		enterButton = new JButton("입장하기");
		exit = new JButton("X");
		

		//card1
		setLayout(null);
		setBackground(new Color(255,235,51));
		add(logo);
		add(idLabel);
		add(nameLabel);
		add(nameField);
		add(idField);
		add(talkNameLabel);
		add(talkNameField);
		add(enterButton);
		add(exit); 
	
		enterButton.setBackground(new Color(69,44,42));
		enterButton.setForeground(new Color(255,255,255));
		enterButton.setBorder(null);
		enterButton.setFocusPainted(false);

		logo.setBounds(100,100,150,150);	 
		idLabel.setBounds(50,300,50,30);
		idField.setBounds(100,300,200,40);
		nameLabel.setBounds(50,350,50,30);	 
		nameField.setBounds(100,350,200,40);
		talkNameLabel.setBounds(50,400,50,30);	 
		talkNameField.setBounds(100,400,200,40);	 
		enterButton.setBounds(50,450,250,40);	

		exit.setBackground(new Color(255,235,51));
		exit.setFont(new Font("맑은 고딕",Font.BOLD,12));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new );
	}
}
