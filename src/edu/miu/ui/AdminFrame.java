package edu.miu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JLabel lblNewLabel = new JLabel("Put the role in here");
		lblNewLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 24));
		lblNewLabel.setBounds(155, 24, 301, 48);
		panel.add(lblNewLabel);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookFrame book = new BookFrame();
				book.setVisible(true);
			}
		});
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
		btnSeeAllBooks.setBackground(Color.LIGHT_GRAY);
		btnSeeAllBooks.setBounds(420, 287, 119, 74);
		contentPane.add(btnSeeAllBooks);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(250, 404, 89, 23);
		contentPane.add(btnLogOut);
	}

}
