package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhoneBillFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccountNumber;
	private JTextField txtNIC;
	private JTextField txtPhoneNumber;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBillFrame frame = new PhoneBillFrame();
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
	public PhoneBillFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Phone Bill");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number :");
		lblAccountNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setBounds(186, 79, 141, 16);
		contentPane.add(lblAccountNumber);
		
		JLabel lblNic = new JLabel("NIC :");
		lblNic.setForeground(Color.WHITE);
		lblNic.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNic.setBounds(186, 118, 141, 16);
		contentPane.add(lblNic);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(186, 160, 141, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblAmount.setBounds(186, 212, 141, 16);
		contentPane.add(lblAmount);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setBounds(362, 77, 218, 22);
		contentPane.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtNIC = new JTextField();
		txtNIC.setColumns(10);
		txtNIC.setBounds(362, 116, 218, 22);
		contentPane.add(txtNIC);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(362, 158, 218, 22);
		contentPane.add(txtPhoneNumber);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(362, 210, 218, 22);
		contentPane.add(txtAmount);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.setRequestFocusEnabled(false);
		btnPayBill.setOpaque(false);
		btnPayBill.setMargin(new Insets(0, 0, 2, 0));
		btnPayBill.setForeground(Color.WHITE);
		btnPayBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPayBill.setFocusPainted(false);
		btnPayBill.setDefaultCapable(false);
		btnPayBill.setContentAreaFilled(false);
		btnPayBill.setBorder(new RoundedBorder(20));
		btnPayBill.setBackground(new Color(255, 51, 102));
		btnPayBill.setBounds(617, 287, 159, 72);
		contentPane.add(btnPayBill);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 UtilityPaymentFrame utilityBill = new UtilityPaymentFrame();
				 utilityBill.setVisible(true);
				 dispose();
			}
		});
		button.setRequestFocusEnabled(false);
		button.setOpaque(false);
		button.setMargin(new Insets(0, 0, 2, 0));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setFocusPainted(false);
		button.setDefaultCapable(false);
		button.setContentAreaFilled(false);
		button.setBorder(new RoundedBorder(20));
		button.setBackground(new Color(255, 51, 102));
		button.setBounds(36, 287, 159, 72);
		contentPane.add(button);
		
		JLabel redAreaHolder = new JLabel("");
		redAreaHolder.setOpaque(true);
		redAreaHolder.setBackground(new Color(220, 20, 60));
		redAreaHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreaHolder);
	}
}
