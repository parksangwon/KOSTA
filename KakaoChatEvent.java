import java.awt.event.*;

public class KakaoChatEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoChatEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent ae)
	{		
		String jb = ae.getActionCommand();
		String str = cr.chatView.inputField.getText();

		//KakaoChatEvent
		if (jb.equals("이전"))		//뒤로가기
		{
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("나가기"))		//나가기
		{
			// 방 나가는 코드 작성(서버에도 보내야함)
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("전송") || str.length() != 0 )		//글쓰기
		{
			try
			{
				cr.client.getServer().setMessage(cr.client.roomId , str);
				cr.chatView.inputField.setText("");
				cr.chatView.inputField.requestFocus();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

		if (jb.equals("친구초대"))
		{
			cr.card.show(cr.slide, "kakaoInvite");
			// 친구 초대 코드 작성
		}
	}
}