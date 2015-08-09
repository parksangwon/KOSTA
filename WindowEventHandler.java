import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class WindowEventHandler implements WindowListener
{
	private static boolean KakaoExitOpened = false; // 종료창 한번만 띄우기 위해
	private KakaoTalk cr;
	public WindowEventHandler(KakaoTalk cr)
	{
		this.cr = cr;
	}

	public void windowClosing(WindowEvent we){ // Frame의 닫기 버튼을 눌렀을 때 호출
		if(KakaoExitOpened == false){ 
			KakaoExitOpened = true;
			KakaoExit exit = new KakaoExit();
			exit.makeGUI();
		}
	}

	public void windowOpened(WindowEvent we){}
	public void windowIconified(WindowEvent we){}
	public void windowDeiconified(WindowEvent we){}
	public void windowClosed(WindowEvent we){}
	public void windowActivated(WindowEvent we){}
	public void windowDeactivated(WindowEvent we){}

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
			super("접속 종료");
			ctn = getContentPane();

			toolkit = Toolkit.getDefaultToolkit();
			screenSize = toolkit.getScreenSize();
			
			text = new JLabel("접속을 종료하시겠습니까?", JLabel.CENTER);
	
			buttonPanel = new JPanel();
			ok = new JButton("확인");
			cancle = new JButton("취소");
		}

		public void makeGUI(){
			setSize(230,150);
			setLocation((int)(screenSize.getWidth()/2 - getWidth()/2), (int)(screenSize.getHeight()/2 - getHeight()/2));

			//이벤트
			ok.addActionListener(this);
			cancle.addActionListener(this);

			//배경
			ctn.setBackground(new Color(255,235,51));
			buttonPanel.setBackground(new Color(255,235,51));
			ok.setBackground(new Color(69,44,42));
			ok.setForeground(new Color(255,255,255));
			cancle.setBackground(new Color(69,44,42));
			cancle.setForeground(new Color(255,255,255));

			//컴포넌트 추가
			buttonPanel.add(ok);
			buttonPanel.add(cancle);

			ctn.add(text);
			ctn.add(buttonPanel, "South");

			setVisible(true);
			setResizable(false);
		}

		public void actionPerformed(ActionEvent ae){
			
			String button = ((JButton)ae.getSource()).getText();

			if(button.equals("확인")){
				// **********************접속 종료 서버에 알림추가***************************
				// **********************접속 종료 서버에 알림추가***************************
				try
				{
					//cr.client.getServer().removeClient(0);
					// 자신의 아이디를 알고 있어야 그 인덱스를 지움
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// **********************접속 종료 서버에 알림추가***************************
				// **********************접속 종료 서버에 알림추가***************************
				
				cr.setVisible(false); // Frame을 화면에서 보이지 않도록
				cr.dispose(); // 메모리에서 제거
				System.exit(0); // 프로그램 종료
				
			}
			KakaoExitOpened = false; // 종료창 다시 띄우기 위해
			setVisible(false); // 종료창 화면에 보이지 않게
			dispose(); // 종료창 메모리에서 제거
		}
	}
}