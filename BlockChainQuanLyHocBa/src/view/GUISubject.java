package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.MSubject;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUISubject extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTable tableSubject;
	
	private ArrayList<MSubject> subjects;

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
		subjects = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 200, 46, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(119, 200, 189, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(67, 249, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(119, 249, 189, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText().toString();
				String id = textFieldId.getText().toString();
				String pervHash = "0";
				if(subjects.size()>0)
					pervHash = subjects.get(subjects.size()-1).toHashString();
				MSubject subject = new MSubject(name, id, pervHash);
				subjects.add(subject);
				UpdateTableView();
			}
		});
		btnAdd.setBounds(123, 305, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

	public void SetSubjectBlockChain(ArrayList<MSubject> arrayList) { //manh.lv
		this.subjects = arrayList;
		UpdateTableView();
	}
	
	public void UpdateTableView() { //manh.lv
		tableSubject.removeAll();
		tableSubject.setModel(new DefaultTableModel(new Object[][] {}, 
				new String[] { "Name", "Id"}));
		
		DefaultTableModel model = (DefaultTableModel) tableSubject.getModel();
		Object[] row = new Object[2];
		for(int i=0; i< subjects.size(); i++) {
			row[0] = ""+subjects.get(i).getName();
			row[1] = ""+subjects.get(i).getId();
			model.addRow(row);
		}
	}
}
