import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class KakaoExitEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoExitEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}

	public void actionPerformed(ActionEvent ae){
		KakaoExit exit = new KakaoExit();
		cr.setEnabled(false);
		exit.makeGUI();
	}


	// inner class
	public class KakaoExit extends JFrame implements ActionListener
	{
		Container ctn;

		Toolkit toolkit;
		Dimension screenSize;

		JLabel text;

		JPanel buttonPanel;
		JButton ok;
		JButton cancle;
		
		public KakaoExit(){
			super("���� ����");
			ctn = getContentPane();

			toolkit = Toolkit.getDefaultToolkit();
			screenSize = toolkit.getScreenSize();
			
			text = new JLabel("������ �����Ͻðڽ��ϱ�?", JLabel.CENTER);
	
			buttonPanel = new JPanel();
			ok = new JButton("Ȯ��");
			cancle = new JButton("���");
		}

		public void makeGUI(){

			setSize(230,100);
			setLocation((int)(screenSize.getWidth()/2 - getWidth()/2), (int)(screenSize.getHeight()/2 - getHeight()/2));
			setUndecorated(true);

			//�̺�Ʈ
			ok.addActionListener(this);
			cancle.addActionListener(this);

			//���
			ctn.setBackground(new Color(255,255,255));
			buttonPanel.setBackground(new Color(255,255,255));
			ok.setBackground(new Color(69,44,42));
			ok.setForeground(new Color(255,255,255));
			ok.setFocusPainted(false);
			cancle.setBackground(new Color(69,44,42));
			cancle.setForeground(new Color(255,255,255));
			cancle.setFocusPainted(false);

			//������Ʈ �߰�
			buttonPanel.add(ok);
			buttonPanel.add(cancle);

			ctn.add(text);
			ctn.add(buttonPanel, "South");

			setVisible(true);
			setResizable(false);
		}

		public void actionPerformed(ActionEvent ae){
			
			String button = ((JButton)ae.getSource()).getText();

			if(button.equals("Ȯ��")){
				// **********************���� ���� ������ �˸��߰�***************************
				// **********************���� ���� ������ �˸��߰�***************************
				try
				{
					//cr.client.getServer().removeClient(0);
					// �ڽ��� ���̵� �˰� �־�� �� �ε����� ����
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// **********************���� ���� ������ �˸��߰�***************************
				// **********************���� ���� ������ �˸��߰�***************************
				cr.setVisible(false); // Frame�� ȭ�鿡�� ������ �ʵ���
				cr.dispose(); // �޸𸮿��� ����
				System.exit(0); // ���α׷� ����
				
			}
			cr.setEnabled(true);
			setVisible(false); // ����â ȭ�鿡 ������ �ʰ�
			dispose(); // ����â �޸𸮿��� ����
		}
	}
}