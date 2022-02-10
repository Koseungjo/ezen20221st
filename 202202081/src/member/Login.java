package member;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login {

	private JFrame frame;
	MemberDAO dao = new MemberDAO();
	MemberDAO3 dao2 = new MemberDAO3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label login = new Label("\uB85C\uADF8\uC778");
		login.setFont(new Font("Dialog", Font.BOLD, 22));
		login.setBounds(171, 56, 69, 23);
		frame.getContentPane().add(login);
		
		Label label_1 = new Label("id");
		label_1.setBounds(95, 118, 69, 23);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("pw");
		label_2.setBounds(95, 147, 69, 23);
		frame.getContentPane().add(label_2);
		
		TextField id = new TextField();
		id.setBounds(207, 118, 117, 23);
		frame.getContentPane().add(id);
		
		JLabel lt = new JLabel("\uB85C\uADF8\uC778 \uD574\uC8FC\uC138\uC694.");
		lt.setBounds(128, 183, 271, 15);
		frame.getContentPane().add(lt);
		
		TextField pw = new TextField();
		pw.setEchoChar('*');
		pw.setBounds(207, 147, 117, 23);
		frame.getContentPane().add(pw);
		
		
		Button bt2 = new Button("\uAD6C\uB9E4\uC790 \uB85C\uADF8\uC778");
		bt2.setBounds(330, 118, 76, 23);
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lt.setText("");
		        if (id.getText().equals("")) {
		        	lt.setText("ID를 입력하세요.");
		        } else if (pw.getText().equals("")) {
		        	lt.setText("Password를 입력하세요.");
		        } else {
		           ArrayList<MemberVo> list = dao.list(id.getText());
		           if (list.size() == 0) {
		        	   lt.setText("ID를 잘못 입력하셨습니다.");
		           } else {
		        	   MemberVo data = (MemberVo) list.get(0);
		              String spwd = data.getpwd();
		              if(pw.getText().equals(spwd)) {
		            	  lt.setText("로그인 성공.");
		              }else {
		            	  lt.setText("Password를 잘못 입력하셨습니다.");
		              }
		           }
		        }
			}
			
		});
		
		frame.getContentPane().add(bt2);
		Button bt2_1 = new Button("\uD310\uB9E4\uC790 \uB85C\uADF8\uC778");
		bt2_1.setBounds(330, 147, 76, 23);
		bt2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lt.setText("");
		        if (id.getText().equals("")) {
		        	lt.setText("ID를 입력하세요.");
		        } else if (pw.getText().equals("")) {
		        	lt.setText("Password를 입력하세요.");
		        } else {
		           ArrayList<MemberVo2> list = dao2.list2(null, null, null);
		           if (list.size() == 0) {
		        	   lt.setText("ID를 잘못 입력하셨습니다.");
		           } else {
		        	   MemberVo2 data = (MemberVo2) list.get(0);
		              String spwd = data.getpwd();
		              if(pw.getText().equals(spwd)) {
		            	  lt.setText("로그인 성공.");
		              }else {
		            	  lt.setText("Password를 잘못 입력하셨습니다.");
		              }
		           }
		        }
			}
			
		});
		frame.getContentPane().add(bt2_1);
		
		Button bt1 = new Button("구매자 회원가입");
		bt1.setBounds(95, 203, 91, 23);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Member me = new Member();
			}
			
		});
		frame.getContentPane().add(bt1);
		
		Label label = new Label("마트 배달 프로그램");
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(95, 10, 218, 40);
		frame.getContentPane().add(label);
		
		Button bt1_1 = new Button("\uD310\uB9E4\uC790 \uD68C\uC6D0\uAC00\uC785");
		bt1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MartMember me = new MartMember();
			}
		});
		bt1_1.setBounds(233, 204, 91, 23);
		frame.getContentPane().add(bt1_1);
		
	}
}
