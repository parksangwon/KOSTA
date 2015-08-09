import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

//카카오 서버
public class KakaoServer extends UnicastRemoteObject implements KakaoServerInterface
{
	private ArrayList<User> users = new ArrayList<User>(); // 유저를 저장할 리스트
	private ArrayList<Room> rooms = new ArrayList<Room>(); // 방 정보를 저장할 리스트


	public KakaoServer() throws RemoteException{} // 디폴트 생성자

	public void setClient(KakaoClientInterface client,  String userId, String name, String talkName) throws RemoteException{
		User user = new User(client, userId, name, talkName);
		users.add(user); // 접속한 유저 저장
		System.out.println(name + "님이 접속했습니다. 현재 " + users.size() + "명이 접속해있습니다.");
	}

	public ArrayList<User> getClient() throws RemoteException{
		return users; // 접속한 유저 반환
	}

	// 접속 종료 시 유저 삭제
	public void removeClient(String userId) throws RemoteException{

		User user = null;

		for(int i = 0 ; i < users.size() ; i++){
			if(userId.equals(users.get(i).getName())){
				user = users.get(i);
			}
		}
		if(user != null){
			users.remove(user);
			System.out.println(user.getName() + "님이 접속을 종료했습니다. 현재 " + users.size() + "명이 접속해있습니다.");
		}

	}

	// 채팅방 추가 시 방 정보 저장
	public void setRoom(Room room) throws RemoteException{

		rooms.add(room); // 방 정보를 유지함
		for(int i = 0 ; i < room.getUserIdList().size() ; i++){
			
			String UserId = room.getUserIdList().get(i); // id로 유저를 찾음
			User user = null;

			if(UserId.equals(users.get(i).getUserId())){
				//users.get(i).client.roomId = room.getRoomId();
				user = users.get(i);
				System.out.println(user.getUserId());
				try
				{
					KakaoClientInterface kci = user.getClient();
					kci.setRoom(room.getRoomId());
				}
				catch (ConnectException ce)
				{
					//System.out.println("나간사람 발생");
					//*********************************추가
					//room.getIndex().remove(i);
					//i--;
				}
			} // if
		} // for
		
	}

	// 채팅방 리턴
	public ArrayList<Room> getRoom() throws RemoteException{
		return rooms;
	}

	// 특정 방에 메시지 보내기
	public void setMessage(String roomId, String msg) throws Exception{
		
		Room room = null;

		for(int i = 0 ; i < rooms.size() ; i++){// 방 식별
			if(roomId.equals(rooms.get(i).getRoomId())){
				room = rooms.get(i);
			}
		}
		if(room != null){// 방에 있는 사람 수
			for(int i = 0 ; i < room.getUserIdList().size() ; i++){

				String UserId = room.getUserIdList().get(i); // id로 유저를 찾음
				User user = null;

				if(UserId.equals(users.get(i).getUserId())){

					user = users.get(i);

					try
					{
						KakaoClientInterface kci = user.getClient();
						kci.setMessage(msg);
					}
					catch (ConnectException ce)
					{
						System.out.println("나간사람 발생");
						//*********************************추가
						//room.getIndex().remove(i);
						//i--;
					}
				} // if
			} // for
		} // if
	}
	
	public static void main(String[] args) throws Exception{
		Runtime rt = Runtime.getRuntime();
		rt.exec("rmiregistry");

		KakaoServer kServer = new KakaoServer();
		Naming.rebind("kakao", kServer);
		System.out.println("Server Ready ...");
	}
}