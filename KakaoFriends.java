import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoFriends extends JPanel
{
	//panel4
	JPanel controlPanel, viewPanel;
	JButton listButton;
	JLabel title;
	DefaultListModel listModel;
	JList friendList;
	JScrollPane scrollPane;
	public KakaoFriends()
	{
		//card4
		controlPanel = new JPanel();
		viewPanel = new JPanel();
		listButton = new JButton("格废"); 
		title = new JLabel("         模备格废         ");
		listModel = new DefaultListModel();
		friendList = new JList(listModel);
		scrollPane = new JScrollPane(friendList);

		setLayout(new BorderLayout());
		controlPanel.add(title);
		controlPanel.add(listButton);

		listModel.addElement("f1");	 listModel.addElement("g2");
		listModel.addElement("f2");	 listModel.addElement("g3 g3");
		listModel.addElement("f4");	 listModel.addElement("g4");
		listModel.addElement("g5");
		
		friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add("North",controlPanel);
		add("Center",scrollPane);
	}

}
