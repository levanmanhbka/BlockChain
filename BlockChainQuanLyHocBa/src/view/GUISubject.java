package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GUISubject extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tableSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISubject frame = new GUISubject();
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
	public GUISubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 200, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(119, 200, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(67, 249, 46, 14);
		contentPane.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 249, 189, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(123, 305, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(222, 305, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblInputSubjectInformation = new JLabel("Input Subject Information");
		lblInputSubjectInformation.setBounds(119, 11, 183, 14);
		contentPane.add(lblInputSubjectInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 59, 243, 97);
		contentPane.add(scrollPane);
		
		tableSubject = new JTable();
		scrollPane.setViewportView(tableSubject);
	}

}
