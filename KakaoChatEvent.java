import java.awt.event.*;

public class KakaoChatEvent implements ActionListener
{
	private KakaoTalk cr;
	private KakaoChat kakaoChat;
	public Room roomInfo;
	public KakaoChatEvent(KakaoTalk cr, KakaoChat kakaoChat, Room roomInfo)
	{
		this.cr = cr;
		this.kakaoChat = kakaoChat;
		this.roomInfo = roomInfo;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		String str = kakaoChat.inputField.getText();

		//KakaoChatEvent
		if (jb.equals("����"))		//�ڷΰ���
		{
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("������"))		//������
		{
			// �� ������ �ڵ� �ۼ�(�������� ��������)
			cr.chatSlide.delChatRoom(kakaoChat);
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("����") || str.length() != 0 )		//�۾���
		{
			if (str.length()!= 0)
			{
				// ������ �Ѱܼ� �ٸ� �������� �Ѹ��� �ڵ� �ۼ�
				KakaoServerInterface server = cr.client.getServer();
				try {
					server.setMessage( roomInfo.getRoomId(), kakaoChat.inputField.getText() );
					//cr.chatView.textArea.append(cr.chatView.inputField.getText() +"\n");
					kakaoChat.inputField.setText("");
					kakaoChat.inputField.requestFocus();	
				}
				catch ( Exception ee) {
				}
				
			}
		}

		if (jb.equals("ģ���ʴ�"))
		{
			cr.card.show(cr.slide, "kakaoInvite");
			// ģ�� �ʴ� �ڵ� �ۼ�
		}
	}
}