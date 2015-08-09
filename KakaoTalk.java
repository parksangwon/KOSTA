import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.io.*;

public class KakaoTalk extends JFrame
{
	
	Container ctp;

	Toolkit toolkit;
	Dimension screenSize;
		
	JPanel slide;
	CardLayout card;
	KakaoMain mainView;
	KakaoList chatListView;
	KakaoSlide chatSlide;
	//KakaoChat chatView;
	KakaoFriends friendListView;
	KakaoInvite inviteView;
	
	KakaoClient client; // Ŭ���̾�Ʈ �α��ΰ� ���ÿ� ��ü ����
	
	public KakaoTalk()
	{
		super("KakaoTalk");
		ctp = getContentPane();

		toolkit = Toolkit.getDefaultToolkit();
		screenSize = toolkit.getScreenSize();

		slide = new JPanel();
		card = new CardLayout();
		mainView = new KakaoMain();
		chatListView = new KakaoList();
		chatSlide = new KakaoSlide(); // ä�ù� ī����� ������ �г�
		//chatView = new KakaoChat();
		friendListView = new KakaoFriends();	
		inviteView = new KakaoInvite();
	}
	public void makeGUI()
	{
		setSize(350,600);
		setLocation((int)(screenSize.getWidth()/2 - getWidth()/2) , (int)(screenSize.getHeight()/2 - getHeight()/2));
		setUndecorated(true);
		slide.setLayout(card);

		//â�� �⺻ �����߿��� â������ ���
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowEventHandler(this));

		//kakaoTalkMain
		KakaoTalkMainEvent mainEvent = new KakaoTalkMainEvent(this);
		mainView.enterButton.addActionListener(mainEvent);
		mainView.idField.addActionListener(mainEvent);
		mainView.nameField.addActionListener(mainEvent);
		mainView.talkNameField.addActionListener(mainEvent);
		mainView.minimize.addActionListener(new KakaoSizeEvent(this));
		
		//KakaoList
		KakaoListEvent listEvent = new KakaoListEvent(this);
		chatListView.enterButton.addActionListener(listEvent);
		chatListView.fListButton.addActionListener(listEvent);
		chatListView.addChatButton.addActionListener(listEvent);

		//KakaoChatEvent
		//KakaoChatEvent chatEvent = new KakaoChatEvent(this);
		//chatSlide.preButton.addActionListener(chatEvent);
		//chatSlide.exitButton.addActionListener(chatEvent);
		//chatSlide.sendButton.addActionListener(chatEvent);
		//chatSlide.inputField.addActionListener(chatEvent);
		//chatSlide.inviteButton.addActionListener(chatEvent);
		
		//KakaoFriendsEvent
		friendListView.listButton.addActionListener(new KakaoFriendsEvent(this));

		//KakaoInviteEvent
		KakaoInviteEvent inviteEvent = new KakaoInviteEvent(this);
		inviteView.inviteButton.addActionListener(inviteEvent);
		inviteView.backButton.addActionListener(inviteEvent);

		//ī���ϿϷ�
		slide.add(mainView,"kakaoMain");
		slide.add(chatListView,"kakaoList");
		slide.add(chatSlide,"kakaoChatSlide"); // ������ ä�ù濡 ���� ���⼭ ���̴°ɷ�
		slide.add(friendListView,"kakaoFriends");
		slide.add(inviteView,"kakaoInvite");

		ctp.add(slide);

		setVisible(true);
		setResizable(false);

		card.show(slide,"kakaoChatSlide");
	}
	
	public static void main(String[] args) 
	{
		KakaoTalk cr = null;
		cr = new KakaoTalk();
		cr.makeGUI();
		
	}
}
