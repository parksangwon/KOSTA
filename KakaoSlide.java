import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoSlide extends JPanel {
	private ArrayList<JPanel> chatList = new ArrayList();

	public JPanel slide;
	public CardLayout chatCard;

	public KakaoSlide() {
		slide = new JPanel();
		chatCard = new CardLayout();
	}

	public void addChatRoom(Room room) {
		JPanel newRoom = new KakaoChat();
		slide.add(newRoom, room.getRoomId());
		chatList.add(newRoom);
	}

}
