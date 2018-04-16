package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.FileManager;
import model.MSubject;
import model.MarkBlock;
import model.Student;

public class GUIMain extends JFrame {

	private JPanel contentPane;

	private ArrayList<MSubject> subjects;
	private ArrayList<Student> students;
	private ArrayList<MarkBlock> markBlocks;
	private FileManager fileManager;
	
	private GUIMarkTable guiMarkTable;
	private GUIStudent guiStudent;
	private GUISubject guiSubject;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frame = new GUIMain();
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
	public GUIMain() {
		
		fileManager = new FileManager();
		subjects = fileManager.GetSubjectBlockChain();
		students = fileManager.GetStudentBlockChain();
		markBlocks = fileManager.GetMarkBlockChain();
		
		guiMarkTable = new GUIMarkTable();
		guiMarkTable.SetMarkBlockChain(markBlocks);;
		guiMarkTable.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveMarkBlockChain(markBlocks);
			}
		});
		
		
		guiStudent = new GUIStudent();
		guiStudent.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveStudentBlockChain(students);
			}
		});
		
		guiSubject = new GUISubject();
		guiSubject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveSubjectBlockChain(subjects);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentMarkSystem = new JLabel("Student Mark System");
		lblStudentMarkSystem.setBounds(154, 23, 167, 14);
		contentPane.add(lblStudentMarkSystem);
		
		JButton btnVerify = new JButton("Verify Data Base");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerify.setBounds(10, 48, 113, 23);
		contentPane.add(btnVerify);
		
		JButton btnBackUpDatabase = new JButton("Back Up Database");
		btnBackUpDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackUpDatabase.setBounds(10, 94, 119, 23);
		contentPane.add(btnBackUpDatabase);
		
		JButton btnInputStudent = new JButton("Input Student");
		btnInputStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputStudent.setBounds(289, 55, 119, 23);
		contentPane.add(btnInputStudent);
		
		JButton btnInputSubject = new JButton("Input Subject");
		btnInputSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputSubject.setBounds(289, 107, 119, 23);
		contentPane.add(btnInputSubject);
		
		JButton btnInputmark = new JButton("InputMark");
		btnInputmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiMarkTable.setVisible(true);
			}
		});
		btnInputmark.setBounds(289, 158, 119, 23);
		contentPane.add(btnInputmark);
	}

	
}
