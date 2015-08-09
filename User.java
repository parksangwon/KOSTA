import java.io.*;

public class User implements Serializable{
	private KakaoClientInterface kc;
	private String userId;
	private String name;
	private String talkName;

	// id = UserList에 저장된 인덱스
	public User(KakaoClientInterface kc, String userId, String name, String talkName) {
		this.kc = kc;
		this.userId = userId;
		this.name = name;
		this.talkName = talkName;
	}

	public KakaoClientInterface getClient() {
		return kc;
	}
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String talkName() {
		return talkName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTalkName(String talkName) {
		this.talkName = talkName;
	}
	public boolean equals(User otherUser) {
		String otherName = otherUser.getName();
		return this.name.equals(otherName);
	}
}
