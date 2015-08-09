import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AddChatRoom extends JFrame implements ActionListener
{
	Container ctn;

	Toolkit toolkit;
	Dimension screenSize;

	JPanel inputPanel;
	JPanel bottomPanel;
	JPanel userView;
	JPanel buttonView;

	JLabel roomName;
	JTextField inputRoomName;

	JButton ok;
	JButton cancle;

	String roomId;
	private KakaoTalk cr;

	public AddChatRoom(KakaoTalk cr, ArrayList<User> users){

		this.cr = cr;
		
		ctn = getContentPane();

		toolkit = Toolkit.getDefaultToolkit();
		screenSize = toolkit.getScreenSize();

		inputPanel = new JPanel();
		bottomPanel = new JPanel();
		userView = new JPanel();
		buttonView = new JPanel();

		roomName = new JLabel("�� �̸� : ");
		inputRoomName = new JTextField(10);

		ok = new JButton("Ȯ��");
		cancle = new JButton("���");

		//****************makeGUI
		setSize(200,400);
		setLocation((int)(screenSize.getWidth()/2 - getWidth()/2) , (int)(screenSize.getHeight()/2 - getHeight()/2));
		setBackground(new Color(255,235,51));
		setLayout(new BorderLayout());

		ok.addActionListener(this);
		cancle.addActionListener(this);

		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBackground(new Color(255,235,51));

		//���� ��� ��� 
		userView.setLayout(new GridLayout(users.size(), 1));
		userView.setBackground(new Color(255,235,51));
		for(int i = 0 ; i < users.size() ; i++){
			User user = users.get(i);
			//userView.add(new JLabel(user.getName()));
		}

		// �� �̸� �Է� �ϴ�
		inputPanel.add(roomName);
		inputPanel.add(inputRoomName);
		inputPanel.setBackground(new Color(255,235,51));

		buttonView.add(ok);
		buttonView.add(cancle);
		buttonView.setBackground(new Color(255,235,51));

		bottomPanel.add(inputPanel);
		bottomPanel.add(buttonView,"South");

		add(userView, "Center");
		add(bottomPanel, "South");

		setVisible(true);
		setResizable(false);
		cr.setEnabled(false);
	}

	public void actionPerformed(ActionEvent ae){
		String button = ae.getActionCommand();

		if(button.equals("Ȯ��")){

			try
			{
				ArrayList<String> userIdList = new ArrayList<String>();
				ArrayList<User> users = cr.client.getServer().getClient();
				for(int i = 0 ; i < users.size() ; i++){
					userIdList.add(users.get(i).getName());
				}

				ArrayList<Room> rooms = cr.client.getServer().getRoom();
				if(rooms.size() != 0){
					Room lastRoom = rooms.get(rooms.size()-1);
					roomId = Integer.parseInt(lastRoom.getRoomId())+1+"";
				}else{
					roomId = "1";
				}
				Room room = new Room(roomId, roomName.getName(), userIdList);
				cr.client.getServer().setRoom(room);
				cr.client.roomId = roomId;
				//cr.card.show(cr.slide, "kakaoChatView");

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		} //if

		cr.setEnabled(true);
		setVisible(false); // ����â ȭ�鿡 ������ �ʰ�
		dispose(); // ����â �޸𸮿��� ����
	}
}