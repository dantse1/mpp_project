package edu.miu.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.miu.domain.Account;

public class LoginFrame extends JFrame {

	public static final String INSTANCE = null;
	private JPanel contentPane;
	private JTextField userIDField;
	private JPasswordField passwordField;
	private static List<Account> accountList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginFrame frame = new LoginFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 0, 218, 440);
		contentPane.add(panel_1);

		JPanel panel = new JPanel();
		panel.setBounds(238, 0, 337, 440);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateAccount("Admin");
			}
		});
		btnLogin.setBounds(89, 312, 138, 23);
		panel.add(btnLogin);

		JLabel usernameLabel = new JLabel("UserID");
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameLabel.setBounds(30, 166, 64, 29);
		panel.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordLabel.setBounds(30, 213, 79, 23);
		panel.add(passwordLabel);

		JLabel lblNewLabel_2 = new JLabel("WELCOME TO LIBRARY SYSTEM");
		lblNewLabel_2.setFont(new Font("UTM Amerika Sans", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(29, 42, 277, 102);
		panel.add(lblNewLabel_2);

		userIDField = new JTextField();
		userIDField.setBounds(104, 171, 178, 20);
		panel.add(userIDField);
		userIDField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 215, 178, 20);
		panel.add(passwordField);
	}

	public void addAccount() {
		Account account1 = new Account("Admin", "101", "123");
		Account account2 = new Account("Librarian", "102", "123");
		Account account3 = new Account("BOTH", "103", "123");
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
	}

	public void validateAccount(String role) {
		String userText;
		String pwdText;

		userText = userIDField.getText();
		pwdText = passwordField.getName();

		for (Account acc : accountList) {
			if (userText.equalsIgnoreCase(acc.getUserID()) && pwdText.equalsIgnoreCase(acc.getPassword())) {
				if (role.equalsIgnoreCase("Admin")) {
					JOptionPane.showMessageDialog(this, "Login Successful");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}
		}
	}
}