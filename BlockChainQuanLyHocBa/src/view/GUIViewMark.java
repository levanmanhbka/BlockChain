package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.MarkMessage;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIViewMark extends JFrame {

	private JPanel contentPane;
	private JTable tableMark;
	private JTextField textFieldId;
	
	private GUIMain guiMain;
	
	private ArrayList<MarkMessage> markMessages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIViewMark frame = new GUIViewMark();
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
	public GUIViewMark() {
		markMessages = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 30, 454, 218);
		contentPane.add(scrollPane);
		
		tableMark = new JTable();
		scrollPane.setViewportView(tableMark);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(155, 269, 145, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnViewMark = new JButton("View Mark");
		btnViewMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessageRequestViewInfo();
			}
		});
		btnViewMark.setBounds(422, 266, 89, 23);
		contentPane.add(btnViewMark);
		
		JLabel lblStudentsId = new JLabel("Student's ID");
		lblStudentsId.setBounds(56, 275, 89, 14);
		contentPane.add(lblStudentsId);
	}
	
	private void UpdateViewTable()
	{
		tableMark.removeAll();
		tableMark.setModel(new DefaultTableModel(new Object[][] {}, 
				new String[] { "Subject Name", "Subject ID", "Midle Mark", "End Mark" }));
		
		DefaultTableModel model = (DefaultTableModel) tableMark.getModel();
		Object[] row = new Object[4];
		for(int i=0; i< markMessages.size(); i++) {
			
			row[0] = ""+markMessages.get(i).subjectName;
			row[1] = ""+markMessages.get(i).subjectId;
			row[2] = ""+markMessages.get(i).midleMark;
			row[3] = ""+markMessages.get(i).endMark;
			
			model.addRow(row);
		}
	}
	
	public void SetOwner(GUIMain owner) {
		guiMain = owner;
	}
	
	public void ReciverMessageViewInfo(ArrayList<MarkMessage> arrayList) {
		if(arrayList.size() > 0)
		{
			if(arrayList.get(0).status == -1) {
				JOptionPane.showMessageDialog(null, "Have no data of student ", "response", 2);
				return;
			}
			else if(arrayList.get(0).status == -2) {
				JOptionPane.showMessageDialog(null, "Have wrong data in server", "response", 2);
				return;
			}
			else {
				markMessages = arrayList;
				UpdateViewTable();
			}
		}
	}
	
	public void SendMessageRequestViewInfo() {
		if(guiMain == null) return;
		String stutentId = textFieldId.getText().toString();
		guiMain.HandleMessageViewInfo(stutentId);
	}
}
