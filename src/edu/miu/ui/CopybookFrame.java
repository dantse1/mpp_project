package edu.miu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class CopybookFrame extends JFrame {

	private JPanel contentPane;
	private static String country[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopybookFrame frame = new CopybookFrame();
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
	public CopybookFrame() {
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

		JLabel bookCopyLabel = new JLabel("Copy Book");
		bookCopyLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		bookCopyLabel.setBounds(230, 11, 135, 33);
		panel.add(bookCopyLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 585, 132);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(26, 27, 46, 14);
		panel_1.add(isbnLabel);

		JComboBox comboBox = new JComboBox(country);
		comboBox.setBounds(63, 23, 120, 22);
		panel_1.add(comboBox);
		
		JButton btnAddBookCopy = new JButton("Add");
		btnAddBookCopy.setBounds(224, 81, 89, 23);
		panel_1.add(btnAddBookCopy);
		panel_1.setVisible(true);
	}

}
