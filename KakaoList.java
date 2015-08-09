import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoList extends JPanel 
{
	private ArrayList<Room> roomList;

	JPanel controlPanel, viewPanel;
	JButton enterButton,addChatButton,fListButton;
	JLabel title;
	DefaultListModel listModel;
	JList chatList;
	JScrollPane scrollPane;

	public KakaoList()
	{

		roomList = new ArrayList<Room>();
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

		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add("North",controlPanel);
		add("Center",scrollPane);
		
	}

	// ä�ù��� ����Ʈ�� �߰��ϰ� ȭ�鿡 �߰��Ѵ�.
	public void addChatRoom(Room room) {
		roomList.add(room);
		listModel.addElement( room.getRoomId() + "-" + room.getRoomName() );
	}
}
