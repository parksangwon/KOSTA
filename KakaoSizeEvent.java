// 11 ~ 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class KakaoSizeEvent implements ActionListener
{
	private KakaoTalk cr;

	public KakaoSizeEvent(KakaoTalk cr)
	{
		this.cr = cr; 
	}

	public void actionPerformed(ActionEvent ae){
		Dimension maximumSize = new Dimension(0, 0);
		cr.setMaximumSize(maximumSize);
	}
}