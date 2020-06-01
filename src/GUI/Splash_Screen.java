package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class Splash_Screen extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblNewLabel_1;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int x;
					Splash_Screen frame = new Splash_Screen();
					frame.setVisible(true);
					
					try {
					for(x=0;x<=100;x++) {
						Splash_Screen.progressBar.setValue(x);
							Thread.sleep(50);
							Splash_Screen.lblNewLabel_1.setText(Integer.toString(x)+ " %");
							if(x==100) {
								SignInFrame signing = new SignInFrame();
								signing.setVisible(true);
								frame.dispose();
							}
					}
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}

	/**
	 * Create the frame.
	 */
	public Splash_Screen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 99, 71));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 776, 501);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/banking11.gif"));
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 128, 128));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(10, 527, 776, 24);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(357, 508, 67, 24);
		contentPane.add(lblNewLabel_1);
	}
}
