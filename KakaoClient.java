import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

public class KakaoClient extends UnicastRemoteObject implements KakaoClientInterface {
	
	private KakaoTalk frame = null;
	private KakaoServerInterface server = null;

	public KakaoClient() throws RemoteException {}

	public KakaoClient(KakaoTalk frame, String name, String talkName) throws RemoteException, MalformedURLException, NotBoundException {
		this.frame = frame;
		server = ( KakaoServerInterface )Naming.lookup( "rmi://127.0.0.1/kakao" );
		server.setClient(this,  name,  talkName); // 서버에 유저 등록
	}
	public KakaoServerInterface getServer() {
		return server;
	}

	// 서버로 메시지 받기(메시지)
	public void setMessage( String msg ) throws RemoteException {
		System.out.println( msg );
		frame.chatView.textArea.append(msg +"\n");
	}
	
	// 서버에 접속자 목록 받아오기
	public void getConnectedUser() throws RemoteException {
	}

	// 방 생성하기(방제목, 유저정보)
	public void makeRoom( String roomName, ArrayList<Integer> invitedUserList ) throws RemoteException {
	}

	// 방 나가기
	public void exitRoom(  User user ) throws RemoteException {
	}
}




