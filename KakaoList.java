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
		fListButton = new JButton("친구목록");
		enterButton = new JButton("입장"); 
		addChatButton = new JButton("채팅추가"); 
		title = new JLabel("         채	팅         ");
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

	// 채팅방을 리스트에 추가하고 화면에 추가한다.
	public void addChatRoom(Room room) {
		roomList.add(room);
		listModel.addElement( room.getRoomId() + "-" + room.getRoomName() );
	}
}
