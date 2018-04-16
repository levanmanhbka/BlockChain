package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import model.MarkBlock;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class GUIMarkTable extends JFrame {

	private JPanel contentPane;
	private JTable tableMark;
	private JTextField textFieldStudent;
	private JTextField textFieldSubject;
	private JTextField textFieldMidle;
	private JTextField textFieldEnd;
	
	private ArrayList<MarkBlock> markBlocks; //manh.lv
	
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
		markBlocks = new ArrayList<>(); //manh.lv
		
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
		tableMark.setModel(new DefaultTableModel(new Object[][] {}, //manh.lv
				new String[] { "Student ID", "Subject ID", "Midle Mark", "End Mark" }));
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId = textFieldStudent.getText().toString();
				String subjectId = textFieldSubject.getText().toString();
				double midleMark = Double.parseDouble(textFieldMidle.getText().toString());
				double endMark = Double.parseDouble(textFieldEnd.getText().toString());
				String  prevHash = "0";
				if(markBlocks.size() > 0)
					prevHash = markBlocks.get(markBlocks.size()-1).toHashString();
				MarkBlock block = new MarkBlock(studentId, subjectId, midleMark, endMark, prevHash);
				markBlocks.add(block);
				UpdateTableView();
			}
		});
		btnAdd.setBounds(154, 337, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(283, 337, 89, 23);
		contentPane.add(btnDelete);
	}

	public void SetMarkBlockChain(ArrayList<MarkBlock> arrayList) { //manh.lv
		this.markBlocks = arrayList;
		UpdateTableView();
	}
	
	public void UpdateTableView() { //manh.lv
		tableMark.removeAll();
		tableMark.setModel(new DefaultTableModel(new Object[][] {}, 
				new String[] { "Student ID", "Subject ID", "Midle Mark", "End Mark" }));
		
		DefaultTableModel model = (DefaultTableModel) tableMark.getModel();
		Object[] row = new Object[4];
		for(int i=0; i< markBlocks.size(); i++) {
			row[0] = ""+markBlocks.get(i).getStudentId();
			row[1] = ""+markBlocks.get(i).getSubjectId();
			row[2] = ""+markBlocks.get(i).getMidleMark();
			row[3] = ""+markBlocks.get(i).getEndMark();
			model.addRow(row);
		}
	}
}
