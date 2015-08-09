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
		server = ( KakaoServerInterface )Naming.lookup( "rmi://127.0.0.1/kakao" );
		server.setClient(this, id, name, talkName); // ������ ���� ���
	}
	public KakaoServerInterface getServer() {
		return server;
	}

	// ������ �޽��� �ޱ�(�޽���)
	public void setMessage( String msg ) throws RemoteException {
		System.out.println( msg );
		// TODO
		//frame.chatView.textArea.append(msg +"\n");
	}

	// ä�ù� �ʴ� �ޱ�(������)
	public void setRoom( Room room ) throws RemoteException {
		KakaoList kakaoList = frame.chatListView;
		kakaoList.addChatRoom( room );
	}
}




