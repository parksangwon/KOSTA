import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class KakaoListEvent implements ActionListener
{
	private KakaoTalk cr;
	private KakaoList kakaoList;
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
			// �ڽ��� �����߿� �ϳ� �����ؼ� �鰡����
			// ���õ� ä�ù��� ����
			int index = kakaoList.chatList.getSelectedIndex();
			String selectedItem = (String)kakaoList.listModel.getElementAt(index);
			//  ����� ä�ù��� null�̸� ����
			if ( selectedItem == null ) {
				return;
			}
			String[] strArr = selectedItem.split("-");
			String roomId = strArr[0];
			//String roomName = strArr[1];
			//  null�� �ƴϸ� ī�带 ��������ϴµ�.
			cr.card.show(cr.slide,"kakaoSlide");
			KakaoSlide kakaoSlide = cr.chatSlide;
			kakaoSlide.chatCard.show(kakaoSlide.slide, roomId);
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
				AddChatRoom makeRoom = new AddChatRoom(cr, users); // �ɼǿ� ��Ÿ�� ������� ������

			}catch (Exception re){
					re.printStackTrace();
			}
		}
	}
}