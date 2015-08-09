import java.rmi.*;
import java.util.*;

public interface KakaoServerInterface extends Remote
{
	public void setClient(KakaoClientInterface client, String name, String talkName) throws RemoteException;
	public ArrayList<User> getClient() throws RemoteException;
	public void removeClient(int index) throws RemoteException;
	public void setRoom(Room room) throws RemoteException;
	public void setMessage(Room room, String msg) throws Exception;
}