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
		if (jb.equals("����"))		//�ڷΰ���
		{
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("������"))		//������
		{
			// �� ������ �ڵ� �ۼ�(�������� ��������)
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("����") || str.length() != 0 )		//�۾���
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

		if (jb.equals("ģ���ʴ�"))
		{
			cr.card.show(cr.slide, "kakaoInvite");
			// ģ�� �ʴ� �ڵ� �ۼ�
		}
	}
}