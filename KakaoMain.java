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
	public JButton minimize;
	public JButton exit;

	//card1
	public KakaoMain()
	{
		logo = new JLabel(new ImageIcon("main.jpg"));
		idLabel = new JLabel("ID : ");
		nameLabel = new JLabel("¿Ã∏ß : ");
		talkNameLabel = new JLabel("¥Î»≠∏Ì : ");
		idField = new JTextField(30);
		nameField = new JTextField(30);
		talkNameField = new JTextField(30);
		enterButton = new JButton("¿‘¿Â«œ±‚");
		minimize = new JButton("_");
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
		add(minimize);
		add(exit); 
	
		enterButton.setBackground(new Color(69,44,42));
		enterButton.setForeground(new Color(255,255,255));
		enterButton.setBorder(null);
		enterButton.setFocusPainted(false);
		//enterButton.setFocusPainted(false);

		logo.setBounds(100,100,150,150);	 
		idLabel.setBounds(50,300,50,30);
		idField.setBounds(100,300,200,40);
		nameLabel.setBounds(50,350,50,30);	 
		nameField.setBounds(100,350,200,40);
		talkNameLabel.setBounds(50,400,50,30);	 
		talkNameField.setBounds(100,400,200,40);	 
		enterButton.setBounds(50,450,250,40);	

		minimize.setBackground(new Color(255,235,51));
		minimize.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,15));
		minimize.setBorder(null);
		minimize.setFocusPainted(false);
		minimize.setBounds(310, 1, 20, 20);
		//minimize.addActionListener(new KakaoSizeEvent(this));

		exit.setBackground(new Color(255,235,51));
		exit.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,12));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setBounds(330,5, 20, 20);
		//exit.addActionListener(new );

		
	}

}
