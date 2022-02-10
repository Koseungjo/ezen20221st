package member;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Member {

	private JFrame frame;
	MemberDAO dao = new MemberDAO();
	MemberDAO2 dao2 = new MemberDAO2();
	boolean a = false;
	boolean b = false;

	public Member() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 342);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		Label label = new Label("ID");
		label.setBounds(35, 27, 52, 23);
		frame.getContentPane().add(label);

		Label label_1 = new Label("PW");
		label_1.setBounds(35, 81, 52, 23);
		frame.getContentPane().add(label_1);

		Label label_2 = new Label("PW \uD655\uC778");
		label_2.setBounds(35, 135, 52, 23);
		frame.getContentPane().add(label_2);

		TextField idt = new TextField();
		idt.setBounds(93, 27, 166, 23);
		frame.getContentPane().add(idt);

		TextField pwdt = new TextField();
		pwdt.setEchoChar('*');
		pwdt.setBounds(93, 81, 166, 23);
		frame.getContentPane().add(pwdt);

		TextField pwdt2 = new TextField();
		pwdt2.setEchoChar('*');
		pwdt2.setBounds(93, 135, 166, 23);
		frame.getContentPane().add(pwdt2);

		Label check = new Label("\uD68C\uC6D0\uAC00\uC785\uC744 \uC9C4\uD589\uD574\uC8FC\uC138\uC694");
		check.setBounds(120, 219, 205, 23);
		frame.getContentPane().add(check);
		
		Label label_3 = new Label("\uC8FC\uC18C");
		label_3.setBounds(35, 184, 52, 23);
		frame.getContentPane().add(label_3);
		
		TextField addr = new TextField();
		addr.setBounds(93, 184, 166, 23);
		frame.getContentPane().add(addr);

		Button bt = new Button("\uD655\uC778");
		bt.setBounds(287, 27, 59, 23);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check.setText("");
				if (idt.getText().equals("")) {
					check.setText("ID를 입력하세요.");
				} else {
					ArrayList<MemberVo> list = dao.list(idt.getText());

					if (list.size() == 0) {
						check.setText("사용 가능한 아이디 입니다.");
						idt.setEditable(false);
						a = true;
					} else {
						check.setText("이미 사용중인 아이디 입니다.");
					}
				}
			}
		});
		frame.getContentPane().add(bt);

		Button bt2 = new Button("\uD655\uC778");
		bt2.setBounds(287, 135, 59, 23);
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check.setText("");
				if (pwdt.getText().equals("")) {
					check.setText("password를 입력하세요.");
				} else {
					if (pwdt.getText().equals(pwdt2.getText())) {
						check.setText("비밀번호가 일치합니다");
						pwdt.setEditable(false);
						pwdt2.setEditable(false);
						b = true;
					} else {
						check.setText("비밀번호가 일치하지 않습니다");
					}
				}

			}
		});
		frame.getContentPane().add(bt2);

		Button bt3 = new Button("\uAC00\uC785\uD558\uAE30");
		bt3.setBounds(162, 270, 59, 23);
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (a == true && b == true) {
					ArrayList<MemberVo> list = dao2.list(idt.getText(), pwdt.getText(), addr.getText());
					check.setText("회원가입이 완료되었습니다.");

				} else {
					check.setText("정보를 정확히 입력해주세요");
				}

			}
		});
		frame.getContentPane().add(bt3);
		
		Label label_4 = new Label("\uC8FC\uC18C\uAC00 \uC815\uD655\uD558\uC9C0 \uC54A\uC73C\uBA74 \uBC30\uC1A1\uC5D0 \uBB38\uC81C\uAC00 \uC0DD\uAE41\uB2C8\uB2E4.");
		label_4.setBounds(60, 237, 272, 27);
		frame.getContentPane().add(label_4);

	}
}
