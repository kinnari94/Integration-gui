package peach.main.intface;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setBounds(61, 56, 90, 16);
		contentPane.add(lblSearchBy);
		
		JLabel lblEthercisAndOpenempi = new JLabel("EtherCIS and OpenEMPI Middleware");
		lblEthercisAndOpenempi.setBounds(117, 13, 217, 31);
		contentPane.add(lblEthercisAndOpenempi);
		
		JRadioButton rdbtnEhrid = new JRadioButton("EhrId");
		rdbtnEhrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EhrId ehrid = new EhrId();
				ehrid.setVisible(true);
			}
		});
		rdbtnEhrid.setBounds(50, 81, 127, 25);
		contentPane.add(rdbtnEhrid);
		
		JRadioButton rdbtnSubjectid = new JRadioButton("SubjectId");
		rdbtnSubjectid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectId subid = new SubjectId();
				subid.setVisible(true);
			}
		});
		rdbtnSubjectid.setBounds(50, 120, 127, 25);
		contentPane.add(rdbtnSubjectid);
	}
}
