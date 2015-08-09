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
			JOptionPane.showMessageDialog(cr, "ID �� Ȯ���� �ּ���!", "ID ����",JOptionPane.WARNING_MESSAGE);		//11
			cr.mainView.idField.requestFocus();
		}else if(name.equals("")){
			JOptionPane.showMessageDialog(cr, "�̸��� Ȯ���� �ּ���!", "�̸� ����",JOptionPane.WARNING_MESSAGE);		//11
			cr.mainView.nameField.requestFocus();
		}else if(nickName.equals("")){
			JOptionPane.showMessageDialog(cr, "��ȭ���� Ȯ���� �ּ���!", "��ȭ�� ����",JOptionPane.WARNING_MESSAGE);
			cr.mainView.talkNameField.requestFocus();
		}
		else{
			// ������ ���� ������ �߰�
			try{

				cr.client = new KakaoClient(cr, id, name, nickName); // Ŭ���̾�Ʈ ��ü ����

			}catch (Exception re){ // TODO Auto-generated catch block
				JOptionPane.showMessageDialog(cr, "������ �̻��� �־� ������ �� �����ϴ�.\n������ Ȯ���� �ּ���.", "���� ����", JOptionPane.WARNING_MESSAGE);
				re.printStackTrace();
				System.exit(0);
			}
			JOptionPane.showMessageDialog(cr, "�����մϴ�. " + name + "��, ���������� ���� �Ǿ����ϴ�.", "���� ����",JOptionPane.PLAIN_MESSAGE);
			cr.card.show(cr.slide,"kakaoList");
		}
	}
}
		
