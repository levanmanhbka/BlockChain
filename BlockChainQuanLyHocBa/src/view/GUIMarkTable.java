package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUIMarkTable extends JFrame {

	private JPanel contentPane;
	private JTable tableMark;
	private JTextField textFieldStudent;
	private JTextField textFieldSubject;
	private JTextField textFieldMidle;
	private JTextField textFieldEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMarkTable frame = new GUIMarkTable();
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
	public GUIMarkTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 11, 294, 124);
		contentPane.add(scrollPane);
		
		tableMark = new JTable();
		scrollPane.setViewportView(tableMark);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(81, 179, 46, 14);
		contentPane.add(lblStudent);
		
		textFieldStudent = new JTextField();
		textFieldStudent.setBounds(154, 176, 218, 20);
		contentPane.add(textFieldStudent);
		textFieldStudent.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(81, 219, 46, 14);
		contentPane.add(lblSubject);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(154, 216, 218, 20);
		contentPane.add(textFieldSubject);
		textFieldSubject.setColumns(10);
		
		JLabel lblMidlemark = new JLabel("MidleMark");
		lblMidlemark.setBounds(81, 254, 60, 14);
		contentPane.add(lblMidlemark);
		
		textFieldMidle = new JTextField();
		textFieldMidle.setBounds(154, 251, 218, 20);
		contentPane.add(textFieldMidle);
		textFieldMidle.setColumns(10);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setBounds(154, 293, 218, 20);
		contentPane.add(textFieldEnd);
		textFieldEnd.setColumns(10);
		
		JLabel lblEndmark = new JLabel("EndMark");
		lblEndmark.setBounds(81, 296, 46, 14);
		contentPane.add(lblEndmark);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(154, 337, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(283, 337, 89, 23);
		contentPane.add(btnDelete);
	}

}
