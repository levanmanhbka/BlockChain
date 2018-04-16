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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.FileManager;
import common.HashUtil;
import model.MSubject;
import model.MarkBlock;
import model.MarkMessage;
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

	private GUIViewMark guiViewMark;

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
		LoadDataBase();

		guiMarkTable = new GUIMarkTable();
		guiMarkTable.SetMarkBlockChain(markBlocks);
		;
		guiMarkTable.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveMarkBlockChain(markBlocks);
			}
		});

		guiStudent = new GUIStudent();
		guiStudent.SetStudentBlockChain(students);
		guiStudent.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveStudentBlockChain(students);
			}
		});

		guiSubject = new GUISubject();
		guiSubject.SetSubjectBlockChain(subjects);
		guiSubject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				fileManager.SaveSubjectBlockChain(subjects);
			}
		});

		guiViewMark = new GUIViewMark();
		guiViewMark.SetOwner(this);
		guiViewMark.setVisible(true);

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
				LoadDataBase();

				if (HashUtil.isMarkBlockChainValid(markBlocks) == false)
					JOptionPane.showMessageDialog(null, "Mark data invalid", "verification", 2);
				else if (HashUtil.isStudentBlockChainValid(students) == false)
					JOptionPane.showMessageDialog(null, "Student data invalid", "verification", 2);
				else if (HashUtil.isSubjectBlockChainValid(subjects) == false)
					JOptionPane.showMessageDialog(null, "Subject data invalid", "verification", 2);
				else
					JOptionPane.showMessageDialog(null, "All data is valid", "verification", 2);

			}
		});
		btnVerify.setBounds(10, 48, 113, 23);
		contentPane.add(btnVerify);

		JButton btnBackUpDatabase = new JButton("Back Up Database");
		btnBackUpDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackUpdataBase();
			}
		});
		btnBackUpDatabase.setBounds(10, 94, 119, 23);
		contentPane.add(btnBackUpDatabase);

		JButton btnInputStudent = new JButton("Input Student");
		btnInputStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiStudent.setVisible(true);
			}
		});
		btnInputStudent.setBounds(289, 55, 119, 23);
		contentPane.add(btnInputStudent);

		JButton btnInputSubject = new JButton("Input Subject");
		btnInputSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiSubject.setVisible(true);
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

		JButton btnRestoreDatabase = new JButton("Restore Database");
		btnRestoreDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestoreDataBase();
			}
		});
		btnRestoreDatabase.setBounds(10, 144, 119, 23);
		contentPane.add(btnRestoreDatabase);
	}

	private void LoadDataBase() {
		fileManager.ORIGINAL_PATH = FileManager.ORIGINAL_PATH_DATA;
		subjects = fileManager.GetSubjectBlockChain();
		students = fileManager.GetStudentBlockChain();
		markBlocks = fileManager.GetMarkBlockChain();
	}

	private void BackUpdataBase() { // lay lai data tu thu muc back up
		fileManager.ORIGINAL_PATH = FileManager.ORIGINAL_PATH_BACKUP;
		subjects = fileManager.GetSubjectBlockChain();
		students = fileManager.GetStudentBlockChain();
		markBlocks = fileManager.GetMarkBlockChain();
		fileManager.ORIGINAL_PATH = FileManager.ORIGINAL_PATH_DATA;
		fileManager.SaveMarkBlockChain(markBlocks);
		fileManager.SaveStudentBlockChain(students);
		fileManager.SaveSubjectBlockChain(subjects);
	}

	private void RestoreDataBase()// luu data vao thu muc back up
	{
		fileManager.ORIGINAL_PATH = FileManager.ORIGINAL_PATH_BACKUP;
		fileManager.SaveMarkBlockChain(markBlocks);
		fileManager.SaveStudentBlockChain(students);
		fileManager.SaveSubjectBlockChain(subjects);
		fileManager.ORIGINAL_PATH = FileManager.ORIGINAL_PATH_DATA;
	}

	public void HandleMessageViewInfo(String studentId) {
		LoadDataBase();
		
		Student student = null;
		ArrayList<MarkMessage> arrayList = new ArrayList<>();
		if(IsValidAllData()) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getId().equals(studentId))
					student = students.get(i);
			}

			if (student != null) {
				for (int i = 0; i < markBlocks.size(); i++) {
					if (markBlocks.get(i).getStudentId().equals(studentId)) {
						MarkMessage message = new MarkMessage();
						message.subjectId = markBlocks.get(i).getSubjectId();
						message.midleMark = markBlocks.get(i).getMidleMark();
						message.endMark = markBlocks.get(i).getEndMark();
						for (int j = 0; j < subjects.size(); j++) {
							if (subjects.get(j).getId().equals(message.subjectId))
								message.subjectName = subjects.get(j).getName();
						}
						arrayList.add(message);
					}
				}
			} else {
				MarkMessage message = new MarkMessage();
				message.status = -1;
				arrayList.add(message);
			}	
		}
		else {
			MarkMessage message = new MarkMessage();
			message.status = -2;
			arrayList.add(message);
		}
		
		guiViewMark.ReciverMessageViewInfo(arrayList);
	}

	private boolean IsValidAllData() {
		if (HashUtil.isMarkBlockChainValid(markBlocks) == false)
			return false;

		if (HashUtil.isStudentBlockChainValid(students) == false)
			return false;
		else if (HashUtil.isSubjectBlockChainValid(subjects) == false)
			return false;

		return true;
	}
}
