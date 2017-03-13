package peach.main.intface;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubjectId extends JFrame {

	private JPanel contentPane;
	public static JTextField subjid;
	private JLabel lblEnterNamespace;
	public static JTextField textFieldNamespace;
	private JButton btnRetrieveSubId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectId frame = new SubjectId();
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
	public SubjectId() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterSubjectId = new JLabel("Enter Subject Id:");
		lblEnterSubjectId.setBounds(34, 31, 97, 23);
		contentPane.add(lblEnterSubjectId);
		
		JTextField subjid = new JTextField();
		subjid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		subjid.setBounds(34, 56, 116, 22);
		contentPane.add(subjid);
		subjid.setColumns(10);
		
		lblEnterNamespace = new JLabel("Enter Namespace:");
		lblEnterNamespace.setBounds(34, 116, 116, 23);
		contentPane.add(lblEnterNamespace);
		
		textFieldNamespace = new JTextField();
		textFieldNamespace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namespace = textFieldNamespace.getText();
			}
		});
		textFieldNamespace.setBounds(34, 141, 116, 22);
		contentPane.add(textFieldNamespace);
		textFieldNamespace.setColumns(10);
		
		btnRetrieveSubId = new JButton("Retrieve Record");
		btnRetrieveSubId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubIdDetails subid=null;
				try {
					subid = new SubIdDetails();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				subid.setVisible(true);
				
			}
		});
		btnRetrieveSubId.setBounds(34, 198, 128, 31);
		contentPane.add(btnRetrieveSubId);
	}

}
