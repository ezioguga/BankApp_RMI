package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TransactionsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionsFrame frame = new TransactionsFrame();
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
	public TransactionsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Transactions");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUtilityPayment = new JButton("Check Balance");
		btnUtilityPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUtilityPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFrame jf=new JFrame();  
				 BalanceFrame balance = new BalanceFrame();
				 balance.setVisible(true);
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
		btnUtilityPayment.setBounds(51, 155, 159, 72);
		contentPane.add(btnUtilityPayment);
		
		JButton btnTransaction = new JButton("Transfer");
		btnTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTransaction.setPreferredSize(new Dimension(117, 25));
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 TransferFrame transfer = new TransferFrame();
				 transfer.setVisible(true);
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
		btnTransaction.setBounds(613, 155, 159, 72);
		contentPane.add(btnTransaction);
		
		JButton btnAddCard = new JButton("Add Card");
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 AddCardFrame addCard = new AddCardFrame();
				 addCard.setVisible(true);
				 dispose();
			}
		});
		btnAddCard.setRequestFocusEnabled(false);
		btnAddCard.setPreferredSize(new Dimension(117, 25));
		btnAddCard.setOpaque(false);
		btnAddCard.setMargin(new Insets(0, 0, 2, 0));
		btnAddCard.setForeground(Color.WHITE);
		btnAddCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCard.setFocusPainted(false);
		btnAddCard.setDefaultCapable(false);
		btnAddCard.setContentAreaFilled(false);
		btnAddCard.setBorder(new RoundedBorder(20));
		btnAddCard.setBackground(new Color(255, 51, 102));
		btnAddCard.setBounds(317, 155, 159, 72);
		contentPane.add(btnAddCard);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PaymentTypeFrame paymentType = new PaymentTypeFrame();
		    	 paymentType.setVisible(true);
				 dispose();
			}
		});
		btnBack.setRequestFocusEnabled(false);
		btnBack.setOpaque(false);
		btnBack.setMargin(new Insets(0, 0, 2, 0));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setFocusPainted(false);
		btnBack.setDefaultCapable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new RoundedBorder(20));
		btnBack.setBackground(new Color(255, 51, 102));
		btnBack.setBounds(23, 13, 125, 36);
		contentPane.add(btnBack);
		
		JLabel redAreadHolder = new JLabel("");
		redAreadHolder.setOpaque(true);
		redAreadHolder.setBackground(new Color(220, 20, 60));
		redAreadHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreadHolder);
	}

}
