package person;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.AbstractListModel;

public class Consumer {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consumer window = new Consumer();
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
	public Consumer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 26, 103, 35);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(124, 26, 308, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(542, 26, 229, 330);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btnNewButton.setBounds(444, 24, 77, 38);
		frame.getContentPane().add(btnNewButton);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"\uC0AC\uACFC", "\uBC30", "\uADE4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(12, 83, 509, 296);
		frame.getContentPane().add(list_1);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btnNewButton_1.setBounds(542, 382, 217, 57);
		frame.getContentPane().add(btnNewButton_1);
	}
}
