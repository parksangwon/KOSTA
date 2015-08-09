import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

public class KakaoClient extends UnicastRemoteObject implements KakaoClientInterface {
	
	private KakaoTalk frame = null;
	private KakaoServerInterface server = null;
	String roomId;

	public KakaoClient() throws RemoteException {}

	public KakaoClient(KakaoTalk frame, String id, String name, String talkName) throws RemoteException, MalformedURLException, NotBoundException {
		this.frame = frame;
		server = ( KakaoServerInterface )Naming.lookup( "rmi://127.0.0.1/kakao" );
		server.setClient(this, id, name, talkName); // ������ ���� ���
	}
	public KakaoServerInterface getServer() {
		return server;
	}

	// ������ �޽��� �ޱ�(�޽���)
	public void setMessage( String msg ) throws RemoteException {
		frame.chatView.textArea.append(msg +"\n");
	}

	// ä�ù����� �̵�
	public void setRoom( String roomId ) throws RemoteException {
		this.roomId = roomId;
		frame.card.show(frame.slide, "kakaochatView");
	}
}
