import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

public class KakaoClient extends UnicastRemoteObject implements KakaoClientInterface {
	
	private KakaoTalk frame = null;
	private KakaoServerInterface server = null;

	public KakaoClient() throws RemoteException {}

	public KakaoClient(KakaoTalk frame, String id, String name, String talkName) throws RemoteException, MalformedURLException, NotBoundException {
		this.frame = frame;
		server = ( KakaoServerInterface )Naming.lookup( "rmi://192.168.0.67/kakao" );
		server.setClient(this, id, name, talkName); // 서버에 유저 등록
	}
	public KakaoServerInterface getServer() {
		return server;
	}

	// 서버로 메시지 받기(메시지)
	public void setMessage( String msg ) throws RemoteException {
		System.out.println( msg );
	}

	// 채팅방으로 이동
	public void setRoom() throws RemoteException {
		frame.card.show(frame.slide, "kakaoChatView");
	}
}




