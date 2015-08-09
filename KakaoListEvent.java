import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class KakaoListEvent implements ActionListener
{
	private KakaoTalk cr;
	private KakaoList kakaoList;
	AddChatRoom makeRoom;

	public KakaoListEvent(KakaoTalk cr)
	{
		this.cr = cr;
		this.kakaoList = cr.chatListView;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		//KakaoList
		if (jb.equals("����"))
		{
			//String roomName = strArr[1];
			//  null�� �ƴϸ� ī�带 ��������ϴµ�.
			cr.card.show(cr.slide,"kakaoSlide");
		}

		if (jb.equals("ģ�����"))
		{
			cr.card.show(cr.slide,"kakaoFriends");
		}
		
		if (jb.equals("ä���߰�"))
		{
			try{
				//�����κ��� ���� ��� ������
				ArrayList<User> users = cr.client.getServer().getClient();
				makeRoom = new AddChatRoom(cr, users); // �ɼǿ� ��Ÿ�� ������� ������

			}catch (Exception re){
					re.printStackTrace();
			}
		}
	}
}