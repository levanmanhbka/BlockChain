package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GUIStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldBirth;
	private JTextField textFieldId;
	private JTable tableStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIStudent frame = new GUIStudent();
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
	public GUIStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(90, 189, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(90, 231, 46, 14);
		contentPane.add(lblBirth);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(90, 268, 46, 14);
		contentPane.add(lblId);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(152, 186, 173, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldBirth = new JTextField();
		textFieldBirth.setBounds(152, 228, 173, 20);
		contentPane.add(textFieldBirth);
		textFieldBirth.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(152, 265, 173, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(152, 321, 74, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(236, 321, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblInputStudentInformation = new JLabel("Input Student Information");
		lblInputStudentInformation.setBounds(152, 11, 173, 14);
		contentPane.add(lblInputStudentInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 42, 237, 118);
		contentPane.add(scrollPane);
		
		tableStudent = new JTable();
		scrollPane.setViewportView(tableStudent);
	}
}
