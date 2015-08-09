import javax.swing.*;
import java.awt.event.*;

public class KakaoTalkMainEvent implements ActionListener
{
	private KakaoTalk cr;
	private String id;
	private String name;
	private String nickName;

	public KakaoTalkMainEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getNickName(){
		return nickName;
	}
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public void actionPerformed(ActionEvent e)
	{		
		id = cr.mainView.idField.getText();
		name = cr.mainView.nameField.getText();
		nickName = cr.mainView.talkNameField.getText();

		if (id.equals("")){
			JOptionPane.showMessageDialog(cr, "ID 를 확인해 주세요!", "ID 오류",JOptionPane.WARNING_MESSAGE);		//11
			cr.mainView.idField.requestFocus();
		}else if(name.equals("")){
			JOptionPane.showMessageDialog(cr, "이름을 확인해 주세요!", "이름 오류",JOptionPane.WARNING_MESSAGE);		//11
			cr.mainView.nameField.requestFocus();
		}else if(nickName.equals("")){
			JOptionPane.showMessageDialog(cr, "대화명을 확인해 주세요!", "대화명 오류",JOptionPane.WARNING_MESSAGE);
			cr.mainView.talkNameField.requestFocus();
		}
		else{
			// 접속한 유저 서버에 추가
			try{

				cr.client = new KakaoClient(cr, id, name, nickName); // 클라이언트 객체 생성

			}catch (Exception re){ // TODO Auto-generated catch block
				JOptionPane.showMessageDialog(cr, "서버에 이상이 있어 접속할 수 없습니다.\n서버를 확인해 주세요.", "접속 오류", JOptionPane.WARNING_MESSAGE);
				re.printStackTrace();
				System.exit(0);
			}
			JOptionPane.showMessageDialog(cr, "축하합니다. " + name + "님, 성공적으로 입장 되었습니다.", "입장 성공",JOptionPane.PLAIN_MESSAGE);
			cr.card.show(cr.slide,"kakaoList");
		}
	}
}
		
