import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

//카카오 서버
public class KakaoServer extends UnicastRemoteObject implements KakaoServerInterface
{
	private ArrayList<User> users = new ArrayList<User>(); // 유저를 저장할 리스트
	private ArrayList<Room> rooms = new ArrayList<Room>(); // 방 정보를 저장할 리스트


	public KakaoServer() throws RemoteException{} // 디폴트 생성자

	public void setClient(KakaoClientInterface client, String name, String talkName) throws RemoteException{
		User user = new User(client, name, talkName);
		users.add(user); // 접속한 유저 저장
		System.out.println(name + "님이 접속했습니다. 현재 " + users.size() + "명이 접속해있습니다.");
	}
	public ArrayList<User> getClient() throws RemoteException{
		return users; // 접속한 유저 반환
	}

	public void removeClient(int index) throws RemoteException{
		User user = users.get(index); // 이 이후에 있는 사람들은 모두 인덱스 하나씩 감소
		users.remove(index);
		System.out.println(user.getName() + "님이 접속을 종료했습니다. 현재 " + users.size() + "명이 접속해있습니다.");
	}

	public void setRoom(Room room) throws RemoteException{
		rooms.add(room); // 방 정보를 유지함
	}

	public void setMessage(Room room, String msg) throws Exception{

		//Thread로 구현??
		for(int i = 0 ; i < room.getIndex().size() ; i++){ // 방에 있는 사람 수

			int UserIndex = room.getIndex().get(i); // 인덱스를 가져와서 유저를 찾기위해
			User user = users.get(UserIndex); // 유저에게 메시지 전달
			try
			{
				KakaoClientInterface kci = user.getClient();
				kci.setMessage(msg);
			}
			catch (ConnectException ce)
			{
				System.out.println("나간사람 발생");
				room.getIndex().remove(i);
				i--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Runtime rt = Runtime.getRuntime();
		rt.exec("rmiregistry");

		KakaoServer kServer = new KakaoServer();
		Naming.rebind("kakao", kServer);
		System.out.println("Server Ready ...");
	}
}