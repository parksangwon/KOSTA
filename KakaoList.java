import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoList extends JPanel 
{
	JPanel controlPanel, viewPanel;
	JButton enterButton,addChatButton,fListButton;
	JLabel title;
	DefaultListModel listModel;
	JList chatList;
	JScrollPane scrollPane;

	public KakaoList()
	{
		controlPanel = new JPanel();
		viewPanel = new JPanel();
		fListButton = new JButton("ģ�����");
		enterButton = new JButton("����"); 
		addChatButton = new JButton("ä���߰�"); 
		title = new JLabel("         ä	��         ");
		listModel = new DefaultListModel();
		chatList = new JList(listModel);
		scrollPane = new JScrollPane(chatList);
		
		setLayout(new BorderLayout());
		controlPanel.add(enterButton);
		controlPanel.add(title);
		controlPanel.add(fListButton);
		controlPanel.add(addChatButton);

		listModel.addElement("Student");	 listModel.addElement("Teacher");
		listModel.addElement("Driver");	 listModel.addElement("Computer Programmer");
		listModel.addElement("Sales Man");	 listModel.addElement("Musician");
		listModel.addElement("Director");
		
		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add("North",controlPanel);
		add("Center",scrollPane);
	}
}
