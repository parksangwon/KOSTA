import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoSlide extends JPanel {
	public KakaoTalk kakaoTalk;

	private ArrayList<JPanel> chatList = new ArrayList();

	public JPanel slide;
	public CardLayout chatCard;

	public KakaoSlide(KakaoTalk kakaoTalk) {
		this.kakaoTalk = kakaoTalk;
		slide = new JPanel();
		chatCard = new CardLayout();
	}

	public void addChatRoom(Room room) {
		JPanel newRoom = new KakaoChat(room);
		slide.add(newRoom, room.getRoomId());
		chatList.add(newRoom);
	}

	public void delChatRoom(KakaoChat kakaoChat) {
		slide.remove(kakaoChat);
		chatList.remove(kakaoChat);
	}

}
