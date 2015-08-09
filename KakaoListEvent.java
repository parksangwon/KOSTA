import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class KakaoListEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoListEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		//KakaoList
		if (jb.equals("입장"))
		{
			// 자신의 방목록중에 하나 선택해서 들가야함
			cr.card.show(cr.slide,"kakaoChat");
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