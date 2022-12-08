package edu.miu.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Optional;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.miu.domain.Book;
import edu.miu.service.BookService;

import javax.swing.JButton;

public class CopybookFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2685158913067470488L;
	private JPanel contentPane;
	private JTextField isbnText;
	BookService bookService = BookService.getService();
	private Book book;
	private String bookLabel = "<html>ISBN: %s<br/>Title: %s<br/>Number of copy: %s</html>";

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
		panel_1.setBounds(0, 65, 585, 240);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(26, 27, 46, 14);
		panel_1.add(isbnLabel);
		
		isbnText = new JTextField();
		isbnText.setColumns(10);
		isbnText.setBounds(63, 23, 120, 22);
		panel_1.add(isbnText);
		
		JLabel jLabel = new JLabel("", SwingConstants.LEFT);
		jLabel.setBounds(26, 40, 500, 100);
		jLabel.setVisible(false);
		panel_1.add(jLabel);

		
		JButton btnAddBookCopy = new JButton("Add Copy");
		btnAddBookCopy.setBounds(224, 140, 89, 23);
		btnAddBookCopy.setVisible(false);
		btnAddBookCopy.addActionListener(e -> addCopyButtonPress(e, jLabel));
		panel_1.add(btnAddBookCopy);
		panel_1.setVisible(true);
		
		JButton btnFindBook = new JButton("Find");
		btnFindBook.setBounds(200, 23, 60, 23);
		btnFindBook.addActionListener(e -> findButtonPress(e,btnAddBookCopy, jLabel));
		panel_1.add(btnFindBook);
		

	}
	
	private void findButtonPress(ActionEvent actionEvent, JButton btnAddBookCopy, JLabel jLabel) {
		System.out.println("Button Find pressed");
		String isbnToFind = isbnText.getText();
		if(null == isbnToFind || isbnToFind.isBlank()) {
			final JComponent[] inputs = new JComponent[] { new JLabel("Please input isbn to find a book") };
			JOptionPane.showMessageDialog(null, inputs, "Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Optional<Book> bookOpt = bookService.getBookById(isbnToFind);
		if(bookOpt.isPresent()) {
			//book found
			this.book = bookOpt.get();
			btnAddBookCopy.setVisible(true);
			jLabel.setText(String.format(bookLabel,book.getIsbn(), book.getTitle(), book.getBookcopies().size()+""));
			jLabel.setVisible(true);
			
		}else {
			final JComponent[] inputs = new JComponent[] { new JLabel("Book not found") };
			JOptionPane.showMessageDialog(null, inputs, "Success", JOptionPane.ERROR_MESSAGE);
			btnAddBookCopy.setVisible(false);
			jLabel.setText("");
			jLabel.setVisible(false);
			return;
		}
		
	}
	
	private void addCopyButtonPress(ActionEvent actionEvent, JLabel jLabel) {
		System.out.println("Button Add Copy pressed");
		if(null == book) {
			final JComponent[] inputs = new JComponent[] { new JLabel("Please find a book before adding a book copy") };
			JOptionPane.showMessageDialog(null, inputs, "Find book", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			book.addNewBookCopy();
			book = bookService.saveBook(book);
			final JComponent[] inputs = new JComponent[] { new JLabel("A new copy of book \"" + book.getTitle() + "\" has been added successfully") };
			JOptionPane.showMessageDialog(null, inputs, "Success", JOptionPane.INFORMATION_MESSAGE);
			
			jLabel.setText(String.format(bookLabel,book.getIsbn(), book.getTitle(), book.getBookcopies().size()+""));
		}
	}

}
