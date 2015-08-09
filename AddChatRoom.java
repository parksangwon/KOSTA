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

		roomName = new JLabel("방 이름 : ");
		inputRoomName = new JTextField(10);

		ok = new JButton("확인");
		cancle = new JButton("취소");

		//****************makeGUI
		setSize(200,400);
		setLocation((int)(screenSize.getWidth()/2 - getWidth()/2) , (int)(screenSize.getHeight()/2 - getHeight()/2));
		setBackground(new Color(255,235,51));
		setLayout(new BorderLayout());

		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBackground(new Color(255,235,51));

		//유저 목록 상단 
		userView.setLayout(new GridLayout(users.size(), 1));
		userView.setBackground(new Color(255,235,51));
		for(int i = 0 ; i < users.size() ; i++){
			User user = users.get(i);
			//userView.add(new JLabel(user.getName()));
		}

		// 방 이름 입력 하단
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
		//cr.setEnabled(false);
	}

	public void actionPerformed(ActionEvent ae){
		String button = ae.getActionCommand();

		if(button.equals("확인")){

			ArrayList<String> userIdList = new ArrayList<String>();
			userIdList.add("zz");
			userIdList.add("aa");
			try
			{
				cr.client.getServer().setRoom("r1", roomName.getName(), userIdList);
				Room room = new Room("r1", roomName.getName(), userIdList);
				cr.chatSlide.addChatRoom(room);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}