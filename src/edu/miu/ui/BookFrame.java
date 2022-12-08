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

public class BookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField isbnText;
	private JTextField titleText;
	private JTextField authorText;
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
		bookService = new BookService();
		
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
		panel_1.setBounds(0, 65, 585, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(10, 21, 57, 14);
		panel_1.add(isbnLabel);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(10, 58, 57, 14);
		panel_1.add(titleLabel);
		
		JLabel authorLabel = new JLabel("Author");
		authorLabel.setBounds(10, 93, 57, 14);
		panel_1.add(authorLabel);
		
		JLabel numCopiesLabel = new JLabel("Number of Copies");
		numCopiesLabel.setBounds(273, 21, 121, 14);
		panel_1.add(numCopiesLabel);
		
		JLabel maxCheckoutLengthLabel = new JLabel("Maximum Checkout \r\nLength");
		maxCheckoutLengthLabel.setBounds(273, 58, 159, 14);
		panel_1.add(maxCheckoutLengthLabel);
		
		JButton btnAddBook = new JButton("Add");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = isbnText.getText();
				String title = titleText.getText();
				int copiesNum = Integer.parseInt(copiesNumText.getText());
				int checkoutDays = Integer.parseInt(checkoutDaysText.getText());
				
				 bookService.addBook(isbn, title, checkoutDays, copiesNum);
			}
		});
		btnAddBook.setBounds(414, 131, 109, 23);
		panel_1.add(btnAddBook);
		
		isbnText = new JTextField();
		isbnText.setBounds(67, 18, 184, 20);
		panel_1.add(isbnText);
		isbnText.setColumns(10);
		
		titleText = new JTextField();
		titleText.setColumns(10);
		titleText.setBounds(67, 55, 184, 20);
		panel_1.add(titleText);
		
		authorText = new JTextField();
		authorText.setColumns(10);
		authorText.setBounds(67, 90, 184, 20);
		panel_1.add(authorText);
		
		copiesNumText = new JTextField();
		copiesNumText.setColumns(10);
		copiesNumText.setBounds(442, 18, 133, 20);
		panel_1.add(copiesNumText);
		
		checkoutDaysText = new JTextField();
		checkoutDaysText.setColumns(10);
		checkoutDaysText.setBounds(442, 55, 133, 20);
		panel_1.add(checkoutDaysText);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(256, 93, 41, 17);
		panel_1.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 254, 565, 197);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(558, 254, 17, 197);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(10, 434, 565, 17);
		contentPane.add(scrollBar_1);
	}

}
