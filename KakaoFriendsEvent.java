import java.awt.event.*;

public class KakaoFriendsEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoFriendsEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent e)
	{		
		cr.card.show(cr.slide,"kakaoList");
	}
}