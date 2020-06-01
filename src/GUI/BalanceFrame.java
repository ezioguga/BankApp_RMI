package GUI;

import Authentication_Server.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BalanceFrame extends JFrame {

	private JPanel contentPane;
	private static AuthenticationInterface authenticationInterface;
	CustomerModule module = new CustomerModule();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceFrame frame = new BalanceFrame();
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
	public BalanceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Balance");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Full Name:");
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblAccountNumber.setBounds(197, 111, 138, 16);
		contentPane.add(lblAccountNumber);
		
		JLabel lblBalance = new JLabel("Balance :");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblBalance.setBounds(197, 171, 138, 16);
		contentPane.add(lblBalance);
		
		JLabel lblPrintFullName = new JLabel("");
		lblPrintFullName.setForeground(Color.WHITE);
		lblPrintFullName.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPrintFullName.setBounds(481, 112, 138, 16);
		contentPane.add(lblPrintFullName);
		
		JLabel lblPrintBalance = new JLabel("");
		String val = null;
		try {
			authenticationInterface = (AuthenticationInterface)Naming.lookup("rmi://localhost:1098/Authentication");
			val = authenticationInterface.MainBalance();
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblPrintBalance.setText(val);
		lblPrintBalance.setForeground(Color.WHITE);
		lblPrintBalance.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPrintBalance.setBounds(481, 171, 138, 16);
		contentPane.add(lblPrintBalance);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 TransactionsFrame transaction = new TransactionsFrame();
				 transaction.setVisible(true);
				 dispose();
			}
		});
		btnDone.setRequestFocusEnabled(false);
		btnDone.setOpaque(false);
		btnDone.setMargin(new Insets(0, 0, 2, 0));
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDone.setFocusPainted(false);
		btnDone.setDefaultCapable(false);
		btnDone.setContentAreaFilled(false);
		btnDone.setBorder(new RoundedBorder(20));
		btnDone.setBackground(new Color(255, 51, 102));
		btnDone.setBounds(597, 290, 159, 72);
		contentPane.add(btnDone);
		
		JLabel redAreaHolder = new JLabel("");
		redAreaHolder.setOpaque(true);
		redAreaHolder.setBackground(new Color(220, 20, 60));
		redAreaHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreaHolder);
	}

}
