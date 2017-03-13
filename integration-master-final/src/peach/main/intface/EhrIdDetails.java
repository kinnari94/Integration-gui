package peach.main.intface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.manager.PatientManager;
import peach.main.entity.IEHR;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class EhrIdDetails extends JFrame {

	private JPanel contentPane;
	private JTable tablePatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EhrIdDetails frame = new EhrIdDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void FillData() throws Exception{
		DefaultTableModel dfm = new DefaultTableModel();
		dfm.addColumn("Name");
		dfm.addColumn("City");
		String ehrvalue = EhrId.ehrval.getText();
		IPatient patient = PatientManager.getPatientDetailsFromEHRId(ehrvalue);
		
		IPerson person = patient.getPerson();
		dfm.addRow(new Object[]{person.getGivenName(),person.getCity()});
		tablePatient.setModel(dfm);
		
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public EhrIdDetails() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 26, 391, 214);
		contentPane.add(scrollPane);
		
		tablePatient = new JTable();
		scrollPane.setViewportView(tablePatient);
		FillData();
		
	}
}
