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

public class AddCardFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCardNumber;
	private JTextField txtPIN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCardFrame frame = new AddCardFrame();
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
	public AddCardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Add Card");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Card Number :");
		lblAccountNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setBounds(186, 121, 141, 16);
		contentPane.add(lblAccountNumber);
		
		JLabel lblPhoneNumber = new JLabel("PIN :");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(186, 181, 141, 16);
		contentPane.add(lblPhoneNumber);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(362, 119, 218, 22);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtPIN = new JTextField();
		txtPIN.setColumns(10);
		txtPIN.setBounds(362, 179, 218, 22);
		contentPane.add(txtPIN);
		
		JButton btnAddCard = new JButton("Add Card");
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 TransactionsFrame transaction = new TransactionsFrame();
				 transaction.setVisible(true);
				 dispose();
			}
		});
		btnAddCard.setRequestFocusEnabled(false);
		btnAddCard.setOpaque(false);
		btnAddCard.setMargin(new Insets(0, 0, 2, 0));
		btnAddCard.setForeground(Color.WHITE);
		btnAddCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCard.setFocusPainted(false);
		btnAddCard.setDefaultCapable(false);
		btnAddCard.setContentAreaFilled(false);
		btnAddCard.setBorder(new RoundedBorder(20));
		btnAddCard.setBackground(new Color(255, 51, 102));
		btnAddCard.setBounds(617, 287, 159, 72);
		contentPane.add(btnAddCard);
		
		JLabel redAreaHolder = new JLabel("");
		redAreaHolder.setOpaque(true);
		redAreaHolder.setBackground(new Color(220, 20, 60));
		redAreaHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreaHolder);
	}

}
