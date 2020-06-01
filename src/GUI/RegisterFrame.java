package GUI;


import java.awt.EventQueue;


import Authentication_Server.*;

import java.net.MalformedURLException;
import java.rmi.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.Component;

import javax.swing.JTextField;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

					//Name: S.Gugatharsan
					//ID number: 1941258
					//Group ID: 02


public class RegisterFrame extends JFrame {

	JPanel contentPane;
	
	
	private static AuthenticationInterface authenticationInterface;
	CustomerModule module = new CustomerModule();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468); //change your frame size and position here
		setTitle("Sign Up");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Header = new JLabel("Welcome Back!");
		Header.setHorizontalAlignment(SwingConstants.CENTER);
		Header.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
		Header.setForeground(new Color(255, 255, 255));
		Header.setBounds(98, 66, 243, 41);
		contentPane.add(Header);
		
		JLabel CreditCardIcon = new JLabel("");
		CreditCardIcon.setHorizontalAlignment(SwingConstants.CENTER);
		CreditCardIcon.setIcon(new ImageIcon(RegisterFrame.class.getResource("/card.png")));
		CreditCardIcon.setBounds(108, 123, 225, 176);
		contentPane.add(CreditCardIcon);
		
		JLabel lblNewLabel_1 = new JLabel("<html>To keep connected with us please login with <br> your personal info</html>");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 10));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 301, 401, 73);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignInFrame signIn = new SignInFrame();
				signIn.setVisible(true);
				dispose();
				
			}
		});
		btnSignIn.setFocusPainted(false);
		btnSignIn.setDefaultCapable(false);
		btnSignIn.setContentAreaFilled(false);
		btnSignIn.setRequestFocusEnabled(false);
		btnSignIn.setOpaque(false);
		btnSignIn.setMargin(new Insets(0, 0, 2, 0));
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setBackground(new Color(255, 51, 102));
		btnSignIn.setFont(new Font("Century Gothic", btnSignIn.getFont().getStyle(), btnSignIn.getFont().getSize() + 6));
		btnSignIn.setBorder(new RoundedBorder(20));
		
		btnSignIn.setBounds(172, 369, 125, 33);
		contentPane.add(btnSignIn);
		
		JLabel redareaholder = new JLabel("");
		redareaholder.setBackground(new Color(255, 51, 102));
		redareaholder.setOpaque(true);
		redareaholder.setBounds(0, 0, 459, 468);
		contentPane.add(redareaholder);
		
		JTextField textField;
		textField = new JTextField();
		textField.setBounds(531, 85, 273, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1;
		textField_1 = new JTextField();
		textField_1.setBounds(531, 130, 273, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2;
		textField_2 = new JTextField();
		textField_2.setBounds(531, 176, 273, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3;
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(531, 219, 273, 22);
		contentPane.add(textField_3);
		
		JTextField textField_4;
		textField_4 = new JTextField();
		textField_4.setBounds(531, 261, 273, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JTextField textField_5;
		textField_5 = new JTextField();
		textField_5.setBounds(531, 304, 273, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				module.setFullNameWithEnitials(textField.getText());
				module.setGoodName(textField_1.getText());
				module.setEmail(textField_2.getText());
				module.setPassword(textField_3.getText());
				module.setGender(textField_4.getText());
				module.setNIC(textField_5.getText());
				
				String fullNameWithEnitials = module.getFullNameWithEnitials();
				String goodName = module.getGoodName();
				String email = module.getEmail();
				String password = module.getPassword();
				String nic = module.getNIC();
				String gender = module.getGender();
				
				try {
					authenticationInterface = (AuthenticationInterface)Naming.lookup("rmi://localhost:1098/Authentication");
					String val = authenticationInterface.register(fullNameWithEnitials, goodName, email, password, nic, gender);
					if(val.equals("welcome")) {
						JFrame f=new JFrame();  
						    JOptionPane.showMessageDialog(f,"You are successfully registered.");  
					}else { 
						JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,"Sorry, something went wrong. Please try again.");
				    }
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setFont(new Font("Century Gothic", btnSignUp.getFont().getStyle(), btnSignUp.getFont().getSize() + 6));
		btnSignUp.setRequestFocusEnabled(false);
		btnSignUp.setOpaque(false);
		btnSignUp.setMargin(new Insets(0, 0, 2, 0));
		btnSignUp.setForeground(new Color(0, 0, 0));
		btnSignUp.setFocusPainted(false);
		btnSignUp.setDefaultCapable(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorder(new RoundedBorder(20));
		btnSignUp.setBackground(new Color(51, 204, 51));
		btnSignUp.setBounds(604, 372, 125, 33);
		contentPane.add(btnSignUp);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Segoe Script", Font.PLAIN, 30));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(517, 13, 301, 41);
		contentPane.add(lblCreateAccount);
		
		JLabel lblName = new JLabel("Full Name:");
		lblName.setBounds(531, 66, 71, 16);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Good Name:");
		lblEmail.setBounds(531, 109, 83, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Email:");
		lblPassword.setBounds(531, 156, 83, 16);
		contentPane.add(lblPassword);
		
		JLabel lblPhoneNumber = new JLabel("Gender:");
		lblPhoneNumber.setBounds(531, 244, 89, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("NIC:");
		lblAddress.setBounds(531, 288, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(531, 200, 89, 16);
		contentPane.add(lblPassword_1);
		
		
		//setUndecorated(true); //this removes the the frame minimize, maximize, and close border from the panel
	}
}
