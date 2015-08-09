import java.rmi.*;

public interface KakaoClientInterface extends Remote {
	public void setMessage( String msg ) throws RemoteException;
	public void setRoom( Room room ) throws RemoteException;
}

