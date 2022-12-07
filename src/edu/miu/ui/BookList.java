package edu.miu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class BookList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
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
	public BookList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 10, 585, 44);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel listBookLabel = new JLabel("Book List");
		listBookLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		listBookLabel.setBounds(230, 11, 135, 33);
		panel.add(listBookLabel);
		
		table = new JTable();
		table.setBounds(0, 54, 585, 311);
		contentPane.add(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(236, 406, 89, 23);
		contentPane.add(btnBack);
	}

}
