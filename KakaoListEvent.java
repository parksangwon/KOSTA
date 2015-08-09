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
		if (jb.equals("입장"))
		{
			// 자신의 방목록중에 하나 선택해서 들가야함
			// 선택된 채팅방을 추출
			int index = kakaoList.chatList.getSelectedIndex();
			String selectedItem = (String)kakaoList.listModel.getElementAt(index);
			//  추출된 채팅방이 null이면 리턴
			if ( selectedItem == null ) {
				return;
			}
			String[] strArr = selectedItem.split("-");
			String roomId = strArr[0];
			//String roomName = strArr[1];
			//  null이 아니면 카드를 보여줘야하는데.
			cr.card.show(cr.slide,"kakaoSlide");
			KakaoSlide kakaoSlide = cr.chatSlide;
			kakaoSlide.chatCard.show(kakaoSlide.slide, roomId);
		}

		if (jb.equals("친구목록"))
		{
			cr.card.show(cr.slide,"kakaoFriends");
		}
		
		if (jb.equals("채팅추가"))
		{
			try{
				// 서버로부터 유저 목록 가져옴
				ArrayList<User> users = cr.client.getServer().getClient();

				String[] buttons = {"확인","취소"}; //옵션에 들어갈 버튼
				AddChatRoom makeRoom = new AddChatRoom(users); // 옵션에 나타날 객체
				int result = JOptionPane.showOptionDialog(cr, makeRoom,"채팅추가", 0, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);

				if(result == 0){ // 확인 버튼
				
				
				}	

			}catch (Exception re){
					re.printStackTrace();
			}
		}
	}
}