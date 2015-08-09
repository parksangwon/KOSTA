import java.util.*;
import java.io.*;

public class Room implements Serializable
{
	private String roomName; // ���̸�
	private ArrayList<Integer> index; // ���� ���� �ε���

	public Room(String roomName, ArrayList<Integer> index){
		this.roomName = roomName;
		this.index = index;
	}

	public void setRoomName(String roomName){
		this.roomName = roomName;
	}

	public void setIndex(ArrayList<Integer> index){
		this.index = index;
	}

	public String getRoomName(){
		return roomName;
	}
	
	public ArrayList<Integer> getIndex(){
		return index;
	}
}