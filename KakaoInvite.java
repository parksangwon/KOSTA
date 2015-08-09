import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoInvite extends JPanel
{
	//panel5
	JPanel controlPanel, viewPanel;
	JButton inviteButton,backButton;
	JLabel title;
	DefaultListModel listModel;
	JList inviteList;
	JScrollPane scrollPane;
	public KakaoInvite()
	{
		//card4
		controlPanel = new JPanel();
		viewPanel = new JPanel();
		inviteButton = new JButton("초대하기"); 
		backButton = new JButton("돌아가기"); 
		title = new JLabel("         초대목록         ");
		listModel = new DefaultListModel();
		inviteList = new JList(listModel);
		scrollPane = new JScrollPane(inviteList);

		setLayout(new BorderLayout());
		controlPanel.add(inviteButton);
		controlPanel.add(title);
		controlPanel.add(backButton);

		listModel.addElement("f1");	 listModel.addElement("g2");
		listModel.addElement("f2");	 listModel.addElement("g3 g3");
		listModel.addElement("f4");	 listModel.addElement("g4");
		listModel.addElement("g5");
		
		inviteList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		add("North",controlPanel);
		add("Center",scrollPane);
	}
}
