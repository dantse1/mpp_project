package edu.miu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import edu.miu.domain.LibraryMember;
import edu.miu.service.LibraryMemberService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComponent;

public class MemberFrame extends JFrame {

	private JPanel contentPane;
	private JTextField memberIDText;
	private JTextField fnameText;
	private JTextField lnameText;
	private JTextField phoneText;
	private JTextField streetText;
	private JTextField cityText;
	private JTextField stateText;
	private JTextField zipText;
	private JTable listMemberTable;
	LibraryMemberService libraryMemberService = LibraryMemberService.getService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
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
		
		JLabel addMemberLabel = new JLabel("Create Member");
		addMemberLabel.setFont(new Font("UTM Colossalis", Font.PLAIN, 17));
		addMemberLabel.setBounds(221, 11, 182, 33);
		panel.add(addMemberLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 585, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setBounds(10, 21, 57, 14);
		panel_1.add(memberIDLabel);
		
		JLabel memFirstNameLabel = new JLabel("First Name");
		memFirstNameLabel.setBounds(10, 58, 57, 14);
		panel_1.add(memFirstNameLabel);
		
		JLabel memLastNameLabel = new JLabel("Last Name");
		memLastNameLabel.setBounds(10, 96, 57, 14);
		panel_1.add(memLastNameLabel);
		
		JLabel memTelephoneLabel = new JLabel("Telephone");
		memTelephoneLabel.setBounds(10, 134, 68, 14);
		panel_1.add(memTelephoneLabel);
		
		JLabel streetLable = new JLabel("Street");
		streetLable.setBounds(295, 21, 46, 14);
		panel_1.add(streetLable);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(295, 58, 46, 14);
		panel_1.add(cityLabel);
		
		JLabel zipLable = new JLabel("Zip");
		zipLable.setBounds(295, 134, 46, 14);
		panel_1.add(zipLable);
		
		JLabel stateLable = new JLabel("State");
		stateLable.setBounds(295, 96, 46, 14);
		panel_1.add(stateLable);
		
		memberIDText = new JTextField();
		memberIDText.setBounds(74, 18, 166, 20);
		panel_1.add(memberIDText);
		memberIDText.setColumns(10);
		memberIDText.setEditable(false);
		
		fnameText = new JTextField();
		fnameText.setColumns(10);
		fnameText.setBounds(74, 55, 166, 20);
		panel_1.add(fnameText);
		
		lnameText = new JTextField();
		lnameText.setColumns(10);
		lnameText.setBounds(74, 93, 166, 20);
		panel_1.add(lnameText);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(74, 131, 166, 20);
		panel_1.add(phoneText);
		
		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(345, 18, 166, 20);
		panel_1.add(streetText);
		
		cityText = new JTextField();
		cityText.setColumns(10);
		cityText.setBounds(345, 55, 166, 20);
		panel_1.add(cityText);
		
		stateText = new JTextField();
		stateText.setColumns(10);
		stateText.setBounds(345, 93, 166, 20);
		panel_1.add(stateText);
		
		zipText = new JTextField();
		zipText.setColumns(10);
		zipText.setBounds(345, 131, 166, 20);
		panel_1.add(zipText);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(234, 170, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(e -> submitButtonPress(e));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 269, 585, 171);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		listMemberTable = new JTable();
		listMemberTable.setBounds(10, 11, 565, 176);
		panel_2.add(listMemberTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(558, 0, 17, 176);
		panel_2.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(10, 170, 565, 17);
		panel_2.add(scrollBar_1);
	}
	
	private void submitButtonPress(ActionEvent e) {
		System.out.println("!!!!!! submitButtonPress !!!!!!!!!");
		System.out.println("fnameText: " + fnameText.getText());
		System.out.println("lnameText: " + lnameText.getText());
		System.out.println("phoneText: " + phoneText.getText());
		System.out.println("streetText: " + streetText.getText());
		System.out.println("cityText: " + cityText.getText());
		System.out.println("stateText: " + stateText.getText());
		System.out.println("zipText: " + zipText.getText());
		String fname = fnameText.getText();
		String lname = lnameText.getText();
		String phone = phoneText.getText();
		String street = streetText.getText();
		String city = cityText.getText();
		String state = stateText.getText();
		String zip = zipText.getText();
		
		LibraryMember libraryMember = libraryMemberService.createNewLibraryMember(fname, lname, phone, street, city, state, zip);
		
		
		final JComponent[] inputs = new JComponent[] { new JLabel("Member \"" + fname + " " + lname + "\" has been created with ID: " + libraryMember.getMemberId()) };
		JOptionPane.showMessageDialog(null, inputs, "Success", JOptionPane.PLAIN_MESSAGE);
		
	}
}
