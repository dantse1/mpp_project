package edu.miu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.miu.service.BookService;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Button;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.SwingConstants;

public class BookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField isbnText;
	private JTextField titleText;
	private JTextField copiesNumText;
	private JTextField checkoutDaysText;
	private JTable table;
	private BookService bookService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookFrame frame = new BookFrame();
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
	public BookFrame() {
		bookService = BookService.getService();
		//System.out.println(bookService.getAllBooks().get(0).getTitle());
		
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
		
		JLabel addMemberLabel = new JLabel("Create Book");
		addMemberLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		addMemberLabel.setBounds(221, 11, 182, 33);
		panel.add(addMemberLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 585, 289);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(10, 21, 57, 14);
		panel_1.add(isbnLabel);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(10, 58, 57, 14);
		panel_1.add(titleLabel);
		
		JLabel authorLabel = new JLabel("Author");
		authorLabel.setBounds(10, 99, 57, 14);
		panel_1.add(authorLabel);
		
		JLabel numCopiesLabel = new JLabel("Number of Copies");
		numCopiesLabel.setBounds(273, 21, 121, 14);
		panel_1.add(numCopiesLabel);
		
		JLabel maxCheckoutLengthLabel = new JLabel("Maximum Checkout \r\nLength");
		maxCheckoutLengthLabel.setBounds(273, 58, 159, 14);
		panel_1.add(maxCheckoutLengthLabel);
		
		JButton btnAddBook = new JButton("Save");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = isbnText.getText();
				String title = titleText.getText();
				int copiesNum = Integer.parseInt(copiesNumText.getText());
				int checkoutDays = Integer.parseInt(checkoutDaysText.getText());
				
				 bookService.addBook(isbn, title, checkoutDays, copiesNum);
			}
		});
		btnAddBook.setBounds(437, 266, 107, 23);
		panel_1.add(btnAddBook);
		
		isbnText = new JTextField();
		isbnText.setBounds(67, 18, 184, 20);
		panel_1.add(isbnText);
		isbnText.setColumns(10);
		
		titleText = new JTextField();
		titleText.setColumns(10);
		titleText.setBounds(67, 55, 184, 20);
		panel_1.add(titleText);
		
		copiesNumText = new JTextField();
		copiesNumText.setColumns(10);
		copiesNumText.setBounds(442, 18, 133, 20);
		panel_1.add(copiesNumText);
		
		checkoutDaysText = new JTextField();
		checkoutDaysText.setColumns(10);
		checkoutDaysText.setBounds(442, 55, 133, 20);
		panel_1.add(checkoutDaysText);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 94, 508, 27);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 133, 553, 121);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Frist name");
		lblNewLabel_1.setBounds(6, 5, 66, 16);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setBounds(145, 5, 64, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(271, 5, 38, 16);
		panel_2.add(lblPhone);
		
		JLabel lblCredentials = new JLabel("Credentials");
		lblCredentials.setBounds(404, 5, 71, 16);
		panel_2.add(lblCredentials);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(155, 61, 25, 16);
		panel_2.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(271, 61, 31, 16);
		panel_2.add(lblState);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(415, 58, 20, 16);
		panel_2.add(lblZip);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 33, 51, 16);
		panel_2.add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(6, 58, 36, 16);
		panel_2.add(lblStreet);
		
		table = new JTable();
		table.setBounds(10, 376, 565, 61);
		contentPane.add(table);
	}
}
