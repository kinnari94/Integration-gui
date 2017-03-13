package peach.main.intface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import peach.main.intface.SubjectId;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.manager.PatientManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SubIdDetails extends JFrame {

	private JPanel contentPane;
	private JTable tablePatient1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubIdDetails frame = new SubIdDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void FillData()throws Exception{
		DefaultTableModel dfm = new DefaultTableModel();
		dfm.addColumn("Name");
		dfm.addColumn("City");
		
		String subid = SubjectId.subjid.getText();
		String ns=SubjectId.textFieldNamespace.getText();
		IPatient patient = PatientManager.getPatientDetailsFromSubjectId(subid,ns);
		IEHR ehr = patient.getEhr();
		IPerson person = patient.getPerson();
		dfm.addRow(new Object[]{person.getGivenName(),person.getCity()});
		tablePatient1.setModel(dfm);
		
	}
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public SubIdDetails() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 227);
		contentPane.add(scrollPane);
		
		tablePatient1 = new JTable();
		scrollPane.setViewportView(tablePatient1);
		FillData();
	}
}
