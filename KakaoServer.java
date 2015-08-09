import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

//īī�� ����
public class KakaoServer extends UnicastRemoteObject implements KakaoServerInterface
{
	private ArrayList<User> users = new ArrayList<User>(); // ������ ������ ����Ʈ
	private ArrayList<Room> rooms = new ArrayList<Room>(); // �� ������ ������ ����Ʈ


	public KakaoServer() throws RemoteException{} // ����Ʈ ������

	public void setClient(KakaoClientInterface client,  String userId, String name, String talkName) throws RemoteException{
		User user = new User(client, userId, name, talkName);
		users.add(user); // ������ ���� ����
		System.out.println(name + "���� �����߽��ϴ�. ���� " + users.size() + "���� �������ֽ��ϴ�.");
	}

	public ArrayList<User> getClient() throws RemoteException{
		return users; // ������ ���� ��ȯ
	}

	// ���� ���� �� ���� ����
	public void removeClient(String userId) throws RemoteException{

		User user = null;

		for(int i = 0 ; i < users.size() ; i++){
			if(userId.equals(users.get(i).getName())){
				user = users.get(i);
			}
		}
		if(user != null){
			users.remove(user);
			System.out.println(user.getName() + "���� ������ �����߽��ϴ�. ���� " + users.size() + "���� �������ֽ��ϴ�.");
		}

	}

	// ä�ù� �߰� �� �� ���� ����
	public void setRoom(Room room) throws RemoteException{

		rooms.add(room); // �� ������ ������
		for(int i = 0 ; i < room.getUserIdList().size() ; i++){
			
			String UserId = room.getUserIdList().get(i); // id�� ������ ã��
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
					//System.out.println("������� �߻�");
					//*********************************�߰�
					//room.getIndex().remove(i);
					//i--;
				}
			} // if
		} // for
		
	}

	// ä�ù� ����
	public ArrayList<Room> getRoom() throws RemoteException{
		return rooms;
	}

	// Ư�� �濡 �޽��� ������
	public void setMessage(String roomId, String msg) throws Exception{
		
		Room room = null;

		for(int i = 0 ; i < rooms.size() ; i++){// �� �ĺ�
			if(roomId.equals(rooms.get(i).getRoomId())){
				room = rooms.get(i);
			}
		}
		if(room != null){// �濡 �ִ� ��� ��
			for(int i = 0 ; i < room.getUserIdList().size() ; i++){

				String UserId = room.getUserIdList().get(i); // id�� ������ ã��
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
						System.out.println("������� �߻�");
						//*********************************�߰�
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