import java.io.*;

public class User implements Serializable{
	private KakaoClientInterface kc;
	private String name;
	private String talkName;

	// id = UserList에 저장된 인덱스
	public User(KakaoClientInterface kc, String name, String talkName) {
		this.kc = kc;
		this.name = name;
		this.talkName = talkName;
	}

	public KakaoClientInterface getClient() {
		return kc;
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
}
