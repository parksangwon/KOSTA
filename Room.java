import java.util.*;
import java.io.*;

public class Room implements Serializable
{
	private String roomId; // 방 일련번호
	private String roomName; // 방이름
	private ArrayList<String> userIdList; // 유저 구분 인데스

	public Room(String roomId, String roomName, ArrayList<String> userIdList){
		this.roomId = roomId;
		this.roomName = roomName;
		this.userIdList = userIdList;
	}

	public void setRoomId(String roomId){
		this.roomId = roomId;
	}

	public void setRoomName(String roomName){
		this.roomName = roomName;
	}

	public void setUserIdList(ArrayList<String> userIdList){
		this.userIdList = userIdList;
	}
	
	public String getRoomId(){
		return roomId;
	}

	public String getRoomName(){
		return roomName;
	}
	
	public ArrayList<String> getUserIdList(){
		return userIdList;
	}
}