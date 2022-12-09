package edu.miu.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import edu.miu.domain.Account;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private Account account;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AdminFrame(Account account) {
		this.account = account;
		String role = account.getRole();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 575, 94);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Role: "+ role.toUpperCase(), SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 24));
		lblNewLabel.setBounds(155, 24, 301, 48);
		lblNewLabel.setForeground(Color.RED);
		panel.add(lblNewLabel);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookFrame book = new BookFrame();
				book.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Librarian")) {
			btnAddBook.setEnabled(false);
		}
		btnAddBook.setBackground(Color.LIGHT_GRAY);
		btnAddBook.setBounds(58, 152, 119, 74);
		contentPane.add(btnAddBook);

		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberFrame memberFrame = new MemberFrame();
				memberFrame.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Librarian")) {
			btnAddMember.setEnabled(false);
		}
		btnAddMember.setBackground(Color.LIGHT_GRAY);
		btnAddMember.setBounds(236, 152, 119, 74);
		contentPane.add(btnAddMember);

		JButton btnCheckoutBook = new JButton("Checkout Book");
		btnCheckoutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookCheckoutFrame bookCheckoutFrame = new BookCheckoutFrame();
				bookCheckoutFrame.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Admin")) {
			btnCheckoutBook.setEnabled(false);
		}
		btnCheckoutBook.setBackground(Color.LIGHT_GRAY);
		btnCheckoutBook.setBounds(58, 287, 119, 74);
		contentPane.add(btnCheckoutBook);

		JButton btnAddBookCopy = new JButton("Add Book Copy");
		btnAddBookCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CopybookFrame copybookFrame = new CopybookFrame();
				copybookFrame.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Librarian")) {
			btnAddBookCopy.setEnabled(false);
		}
		btnAddBookCopy.setBackground(Color.LIGHT_GRAY);
		btnAddBookCopy.setBounds(236, 287, 119, 74);
		contentPane.add(btnAddBookCopy);

		JButton btnSeeAllMembers = new JButton("See all members");
		btnSeeAllMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberListFrame memberListFrame = new MemberListFrame();
				memberListFrame.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Librarian")) {
			btnSeeAllMembers.setEnabled(false);
		}
		btnSeeAllMembers.setBackground(Color.LIGHT_GRAY);
		btnSeeAllMembers.setBounds(420, 152, 119, 74);
		contentPane.add(btnSeeAllMembers);

		JButton btnSeeAllBooks = new JButton("See all books");
		btnSeeAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookList bookList = new BookList();
				bookList.setVisible(true);
			}
		});
		if(role.equalsIgnoreCase("Librarian")) {
			btnSeeAllBooks.setEnabled(false);
		}
		btnSeeAllBooks.setBackground(Color.LIGHT_GRAY);
		btnSeeAllBooks.setBounds(420, 287, 119, 74);
		contentPane.add(btnSeeAllBooks);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(250, 404, 89, 23);
		btnLogOut.addActionListener(e -> logout());
		
		contentPane.add(btnLogOut);
	}
	
	private void logout() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
		this.setVisible(false);
	}

}
