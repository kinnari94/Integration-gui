package peach.main.intface;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import peach.main.entity.IPatient;
import peach.main.manager.PatientManager;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.entity.impl.Person;
import peach.main.entity.impl.Person.Genders;
import peach.main.entity.impl.Person.PersonIdentifiers;
import peach.main.entity.impl.Person.Race;
import peach.main.manager.PatientManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EhrId extends JFrame {

	private JPanel contentPane;
	public static JTextField ehrval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EhrId frame = new EhrId();
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
	public EhrId() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterEhrId = new JLabel("Enter Ehr Id:");
		lblEnterEhrId.setBounds(29, 29, 82, 24);
		contentPane.add(lblEnterEhrId);
		
		JTextField ehrval = new JTextField();
		ehrval.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ehrval.setBounds(29, 73, 116, 22);
		contentPane.add(ehrval);
		ehrval.setColumns(10);
		
		JButton btnNewButton = new JButton("Retrieve record");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//String ehrvalue = EhrId.ehrval.getText();
				//IPatient patient = PatientManager.getPatientDetailsFromEHRId(ehrvalue);
				EhrIdDetails eid=null;
				try {
					eid = new EhrIdDetails();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				eid.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(29, 123, 147, 34);
		contentPane.add(btnNewButton);
	}
}
