package GUI;

import Authentication_Server.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Authentication_Server.AuthenticationInterface;
import Authentication_Server.CustomerModule;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import Transaction_Server.*;

public class UtilityPaymentFrame extends JFrame {

	private JPanel contentPane;
	private static TransactionModule module;
	private static TransactionInterface transactionInterface;
	private static AuthenticationInterface authenticationInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String name= "rmi://localhost:1099/Transaction";
		try {
			transactionInterface = (TransactionInterface)Naming.lookup(name);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		module = new TransactionModule();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtilityPaymentFrame frame = new UtilityPaymentFrame();
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
	public UtilityPaymentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		setTitle("Select Utility Payment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWaterBill = new JButton("Water Bill");
		btnWaterBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 WaterBillFrame waterBill = new WaterBillFrame();
				 waterBill.setVisible(true);
				 dispose();
			}
		});
		btnWaterBill.setRequestFocusEnabled(false);
		btnWaterBill.setOpaque(false);
		btnWaterBill.setMargin(new Insets(0, 0, 2, 0));
		btnWaterBill.setForeground(Color.WHITE);
		btnWaterBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWaterBill.setFocusPainted(false);
		btnWaterBill.setDefaultCapable(false);
		btnWaterBill.setContentAreaFilled(false);
		btnWaterBill.setBorder(new RoundedBorder(20));
		btnWaterBill.setBackground(new Color(255, 51, 102));
		btnWaterBill.setBounds(105, 100, 159, 72);
		contentPane.add(btnWaterBill);
		
		JButton btnElectricityBill = new JButton("Electricity Bill");
		btnElectricityBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 ElectricityBillFrame electricityBill = new ElectricityBillFrame();
				 electricityBill.setVisible(true);
				 dispose();
			}
		});
		btnElectricityBill.setRequestFocusEnabled(false);
		btnElectricityBill.setOpaque(false);
		btnElectricityBill.setMargin(new Insets(0, 0, 2, 0));
		btnElectricityBill.setForeground(Color.WHITE);
		btnElectricityBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnElectricityBill.setFocusPainted(false);
		btnElectricityBill.setDefaultCapable(false);
		btnElectricityBill.setContentAreaFilled(false);
		btnElectricityBill.setBorder(new RoundedBorder(20));
		btnElectricityBill.setBackground(new Color(255, 51, 102));
		btnElectricityBill.setBounds(541, 100, 159, 72);
		contentPane.add(btnElectricityBill);
		
		JButton btnPhoneBill = new JButton("Phone Bill");
		btnPhoneBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf=new JFrame();  
				 PhoneBillFrame phoneBill = new PhoneBillFrame();
				 phoneBill.setVisible(true);
				 dispose();
			}
		});
		btnPhoneBill.setRequestFocusEnabled(false);
		btnPhoneBill.setOpaque(false);
		btnPhoneBill.setMargin(new Insets(0, 0, 2, 0));
		btnPhoneBill.setForeground(Color.WHITE);
		btnPhoneBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhoneBill.setFocusPainted(false);
		btnPhoneBill.setDefaultCapable(false);
		btnPhoneBill.setContentAreaFilled(false);
		btnPhoneBill.setBorder(new RoundedBorder(20));
		btnPhoneBill.setBackground(new Color(255, 51, 102));
		btnPhoneBill.setBounds(105, 248, 159, 72);
		contentPane.add(btnPhoneBill);
		
		JButton btnGenerateGraph = new JButton("Generate Graph");
		btnGenerateGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					authenticationInterface = (AuthenticationInterface)Naming.lookup("rmi://localhost:1098/Authentication");
					authenticationInterface.Customer_Chart();
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGenerateGraph.setRequestFocusEnabled(false);
		btnGenerateGraph.setOpaque(false);
		btnGenerateGraph.setMargin(new Insets(0, 0, 2, 0));
		btnGenerateGraph.setForeground(Color.WHITE);
		btnGenerateGraph.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGenerateGraph.setFocusPainted(false);
		btnGenerateGraph.setDefaultCapable(false);
		btnGenerateGraph.setContentAreaFilled(false);
		btnGenerateGraph.setBorder(new RoundedBorder(20));
		btnGenerateGraph.setBackground(new Color(255, 51, 102));
		btnGenerateGraph.setBounds(541, 248, 159, 72);
		contentPane.add(btnGenerateGraph);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnBack.setBounds(12, 15, 111, 33);
		contentPane.add(btnBack);
		
		JLabel redAreaHolder = new JLabel("");
		redAreaHolder.setBackground(new Color(220, 20, 60));
		redAreaHolder.setOpaque(true);
		redAreaHolder.setBounds(0, 0, 830, 421);
		contentPane.add(redAreaHolder);
	}
}
