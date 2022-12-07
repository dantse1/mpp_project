package edu.miu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class MemberListFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberListFrame frame = new MemberListFrame();
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
	public MemberListFrame() {
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

		JLabel listMemberLabel = new JLabel("Member List");
		listMemberLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		listMemberLabel.setBounds(230, 11, 135, 33);
		panel.add(listMemberLabel);
		
		table = new JTable();
		table.setBounds(0, 54, 585, 311);
		contentPane.add(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(236, 406, 89, 23);
		contentPane.add(btnBack);
	}

}
