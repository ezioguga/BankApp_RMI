package GUI;

import Authentication_Server.*;

import java.net.MalformedURLException;
import java.rmi.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static AuthenticationInterface authenticationInterface;
	private static CustomerModule module;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		module = new CustomerModule();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInFrame frame = new SignInFrame();
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
	public SignInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Sign In");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Segoe Script", Font.PLAIN, 30));
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setBounds(73, 46, 219, 33);
		contentPane.add(lblSignIn);
		
		textField = new JTextField();
		textField.setBounds(55, 146, 205, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Username:");
		lblEmail.setBounds(55, 129, 97, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(55, 201, 72, 16);
		contentPane.add(lblPassword);
		
		JLabel lblForgetYourPassword = new JLabel("Forget Your Password?");
		lblForgetYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetYourPassword.setBounds(55, 283, 205, 16);
		contentPane.add(lblForgetYourPassword);
		
		
		
		JButton button_1 = new JButton("SIGN UP");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame register = new RegisterFrame();
				register.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Century Gothic", button_1.getFont().getStyle(), button_1.getFont().getSize() + 6));
		button_1.setRequestFocusEnabled(false);
		button_1.setOpaque(false);
		button_1.setMargin(new Insets(0, 0, 2, 0));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setFocusPainted(false);
		button_1.setDefaultCapable(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorder(new RoundedBorder(20));
		button_1.setBackground(new Color(51, 204, 51));
		button_1.setBounds(567, 334, 125, 33);
		contentPane.add(button_1);
		
		JLabel lblEnterYourDetails = new JLabel("Enter your personal details and start journey with us");
		lblEnterYourDetails.setFont(new Font("Source Code Pro", Font.PLAIN, 11));
		lblEnterYourDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourDetails.setBounds(435, 284, 383, 16);
		contentPane.add(lblEnterYourDetails);
		
		JLabel BankIcon = new JLabel("");
		BankIcon.setIcon(new ImageIcon(SignInFrame.class.getResource("/bankbuild.png")));
		BankIcon.setBounds(511, 46, 225, 225);
		contentPane.add(BankIcon);
		
		JLabel redareaholder = new JLabel("");
		redareaholder.setOpaque(true);
		redareaholder.setBackground(new Color(255, 51, 102));
		redareaholder.setBounds(412, 0, 418, 421);
		contentPane.add(redareaholder);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 220, 205, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton button = new JButton("SIGN IN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mySessionCookie = "not set";
				String Username = textField.getText();
				String Pass = textField_1.getText();
				
				try {
					authenticationInterface = (AuthenticationInterface)Naming.lookup("rmi://localhost:1098/Authentication");
					String result =authenticationInterface.Login(Username,Pass);
					if(result.equals("wrong")) {
						JFrame jf=new JFrame();  
					    JOptionPane.showMessageDialog(jf,"Wrong Password. Please Try again!"); 
					} else { 
				    	 mySessionCookie = result; 
				    	 JFrame jf=new JFrame();  
				    	 PaymentTypeFrame paymentType = new PaymentTypeFrame();
				    	 paymentType.setVisible(true);
						 dispose();
				    }
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}
		});
		button.setFont(new Font("Century Gothic", button.getFont().getStyle(), button.getFont().getSize() + 6));
		button.setRequestFocusEnabled(false);
		button.setOpaque(false);
		button.setMargin(new Insets(0, 0, 2, 0));
		button.setForeground(new Color(0, 0, 0));
		button.setFocusPainted(false);
		button.setDefaultCapable(false);
		button.setContentAreaFilled(false);
		button.setBorder(new RoundedBorder(20));
		button.setBackground(new Color(255, 51, 102));
		button.setBounds(98, 330, 125, 33);
		contentPane.add(button);
	}
}
