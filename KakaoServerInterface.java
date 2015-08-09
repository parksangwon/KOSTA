import java.rmi.*;
import java.util.*;

public interface KakaoServerInterface extends Remote
{
	public void setClient(KakaoClientInterface client,  String userId, String name, String talkName) throws RemoteException;
	public ArrayList<User> getClient() throws RemoteException;
	public void removeClient(String userId) throws RemoteException;
	public void setRoom(Room room) throws RemoteException;
	public ArrayList<Room> getRoom() throws RemoteException;
	public void setMessage(String roomId, String msg) throws Exception;
}