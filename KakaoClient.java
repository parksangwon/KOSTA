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
		server.setClient(this, id, name, talkName); // ������ ���� ���
	}
	public KakaoServerInterface getServer() {
		return server;
	}

	// ������ �޽��� �ޱ�(�޽���)
	public void setMessage( String msg ) throws RemoteException {
		System.out.println( msg );
	}

	// ä�ù����� �̵�
	public void setRoom() throws RemoteException {
		frame.card.show(frame.slide, "kakaoChatView");
	}
}




