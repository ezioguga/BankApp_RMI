package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;

import Authentication_Server.*;

import java.net.MalformedURLException;
import java.rmi.*;

public class PaymentTypeFrame extends JFrame {

	private JPanel contentPane;
	private static AuthenticationInterface authenticationInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentTypeFrame frame = new PaymentTypeFrame();
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
	public PaymentTypeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Select Payment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUtilityPayment = new JButton("Utility Payment");
		btnUtilityPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUtilityPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UtilityPaymentFrame utilityPayment = new UtilityPaymentFrame();
				utilityPayment.setVisible(true);
				dispose();
			}
		});
		btnUtilityPayment.setRequestFocusEnabled(false);
		btnUtilityPayment.setOpaque(false);
		btnUtilityPayment.setMargin(new Insets(0, 0, 2, 0));
		btnUtilityPayment.setForeground(Color.WHITE);
		btnUtilityPayment.setFocusPainted(false);
		btnUtilityPayment.setDefaultCapable(false);
		btnUtilityPayment.setContentAreaFilled(false);
		btnUtilityPayment.setBorder(new RoundedBorder(20));
		btnUtilityPayment.setBackground(new Color(255, 51, 102));
		btnUtilityPayment.setBounds(144, 178, 159, 72);
		contentPane.add(btnUtilityPayment);
		
		JButton btnTransaction = new JButton("Transactions");
		btnTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTransaction.setPreferredSize(new Dimension(117, 25));
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionsFrame transactions = new TransactionsFrame();
				transactions.setVisible(true);
				dispose();
			}
		});
		btnTransaction.setRequestFocusEnabled(false);
		btnTransaction.setOpaque(false);
		btnTransaction.setMargin(new Insets(0, 0, 2, 0));
		btnTransaction.setForeground(Color.WHITE);
		btnTransaction.setFocusPainted(false);
		btnTransaction.setDefaultCapable(false);
		btnTransaction.setContentAreaFilled(false);
		btnTransaction.setBorder(new RoundedBorder(20));
		btnTransaction.setBackground(new Color(255, 51, 102));
		btnTransaction.setBounds(520, 178, 159, 72);
		contentPane.add(btnTransaction);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mySessionCookie = "not set";
					authenticationInterface = (AuthenticationInterface)Naming.lookup("rmi://localhost:1098/Authentication");
					String result=authenticationInterface.Logout(mySessionCookie);
					if(result.equals("empty"))
					{
						JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,"You are logged out");  
						SignInFrame signIn = new SignInFrame();
						signIn.setVisible(true);
						dispose();
					}
						
					
				}catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
			}
		});
		btnLogout.setRequestFocusEnabled(false);
		btnLogout.setOpaque(false);
		btnLogout.setMargin(new Insets(0, 0, 2, 0));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setDefaultCapable(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(new RoundedBorder(20));
		btnLogout.setBackground(new Color(255, 51, 102));
		btnLogout.setBounds(697, 32, 98, 50);
		contentPane.add(btnLogout);
		
		JLabel redAreadHolder = new JLabel("");
		redAreadHolder.setOpaque(true);
		redAreadHolder.setBackground(new Color(220, 20, 60));
		redAreadHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreadHolder);
	}
}
