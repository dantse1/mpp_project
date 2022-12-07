package edu.miu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class BookCheckoutFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCheckoutFrame frame = new BookCheckoutFrame();
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
	public BookCheckoutFrame() {
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
		
		JLabel checkoutBookLabel = new JLabel("Checkout Book");
		checkoutBookLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		checkoutBookLabel.setBounds(221, 11, 182, 33);
		panel.add(checkoutBookLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 54, 347, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setBounds(21, 31, 66, 14);
		panel_1.add(memberIDLabel);
		
		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(21, 69, 46, 14);
		panel_1.add(isbnLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 28, 108, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 66, 108, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 198, 575, 242);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 555, 220);
		panel_2.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(548, 11, 17, 208);
		panel_2.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(10, 202, 528, 17);
		panel_2.add(scrollBar_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(352, 54, 223, 133);
		contentPane.add(panel_3);
	}

}
