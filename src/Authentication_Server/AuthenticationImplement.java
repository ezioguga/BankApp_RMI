package Authentication_Server;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

import javax.mail.*;
import javax.mail.internet.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Name: H.N. Dasuni Uthpala Wickramasinghe
//ID number: 1940797
//Group ID: 02

public class AuthenticationImplement extends UnicastRemoteObject implements AuthenticationInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// set cookies
	private String sessionCookie = "abc" + Math.random();

	// define arraylist and get CustomerModule
	ArrayList<String> list = new ArrayList<>();
	CustomerModule module = new CustomerModule();

	// declare MySql
	String URL = "jdbc:mysql://localhost:3306/online_banking";
	String user = "root";
	String pass = "";

	public AuthenticationImplement() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	// register user and save data to customers table in MySQL database

	@Override
	public String register(String fullNameWithEnitials, String goodName, String email, String password, String nic,
			String gender) {
		// TODO Auto-generated method stub
		boolean correct = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection C = DriverManager.getConnection(URL, user, pass);
			System.out.println("connection Established");
			PreparedStatement p = C.prepareStatement("insert into customers values(?,?,?,?,?,?,?)");

			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);

			module.setFullNameWithEnitials(fullNameWithEnitials);
			String val1 = module.getFullNameWithEnitials();
			list.add(val1);

			module.setGoodName(goodName);
			String val2 = module.getGoodName();
			list.add(val2);

			module.setEmail(email);
			String val3 = module.getEmail();
			list.add(val3);

			module.setPassword(password);
			String val4 = module.getPassword();
			list.add(val4);

			module.setGender(gender);
			String val5 = module.getGender();
			list.add(val5);

			module.setNIC(nic);
			String val6 = module.getNIC();
			list.add(val6);
			
			String main=val6;
			int num = Integer.parseInt(main.substring(1,2));
			String mainbalance = null;
			
			if(num!=0) {
				if(num<5) {
					mainbalance="15000";
				}
				if((num>=5) && (num<6)) {
					mainbalance="20000";
				}
				if((num>=6) && (num<7)) {
					mainbalance="30000";
				}
				if((num>=7) && (num<8)) {
					mainbalance="40000";
				}
				if((num>=8) && (num<9)) {
					mainbalance="50000";
				}
				if((num>=9) && (num<10)) {
					mainbalance="60000";
				}
			}else {
				mainbalance="150000";
			}

			p.setString(1, val1);
			p.setString(2, val2);
			p.setString(3, val3);
			p.setString(4, val4);
			p.setString(5, val5);
			p.setString(6, val6);
			p.setString(7, mainbalance);

			p.executeUpdate();

			correct = true;

			int pin = PinNumberPatternGenerator();
			EmailSender(pin);
			UserLocalIP();

			String username = module.getGoodName();
			String pass = module.getPassword();
			Login(username, pass);

			PreparedStatement ps = C.prepareStatement("insert into customers_pin_number values(?,?)");

			ps.setString(1, list.get(1));
			ps.setLong(2, pin);
			ps.executeUpdate();

			String location = UserLocation();
			PreparedStatement pr = C.prepareStatement("insert into customers_location values(?,?)");

			pr.setString(1, list.get(1));
			pr.setString(2, location.toString());
			pr.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (correct) {
			return "welcome";

		} else {
			return "something wrong";
		}
	}

	// this function logged user and return the cookies

	@Override
	public String Login(String Username, String Pass) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		boolean found = false;
		InetAddress inetAddress;
		String currentUser = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection C = DriverManager.getConnection(URL, user, pass);
			stmt = C.createStatement();
			String sql = "SELECT c.goodName,c.password,i.IP_Address, L.Location FROM customers c, customers_ip_number i, customers_location L where c.goodName=i.goodName AND c.goodName=L.goodName";
			ResultSet rs = stmt.executeQuery(sql);

			String mypinNumber = UserLocation();
			inetAddress = InetAddress.getLocalHost();
			currentUser = inetAddress.getHostAddress();
			while (rs.next()) {
				if (Username.equals(rs.getString(1)) && Pass.equals(rs.getString(2))) {
					String databaseip = rs.getString(3);
					if (currentUser.equals(databaseip)) {
						if (mypinNumber.equals(rs.getString(4))) {
							sessionCookie = "xyz" + Math.random();
							found = true;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (found) {
			return sessionCookie;

		} else {
			return "wrong";
		}

	}

// this function generate a new pin number using gender and nic number
	@Override
	public int PinNumberPatternGenerator() {
		// TODO Auto-generated method stub
		Statement stmt = null;

		int pin = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection C = DriverManager.getConnection(URL, user, pass);
			stmt = C.createStatement();
			String sql = "SELECT * FROM `customers`";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String gender = rs.getString(5);
				int num = Integer.parseInt(rs.getString(6).substring(6, 9));
				if (gender.compareToIgnoreCase("Male") == 0) {
					if (num == 000) {
						int num2 = Integer.parseInt(rs.getString(6).substring(1, 3));
						int newNumber = (int) (Math.random() * 100000) + num2;
						String val = (Integer.toString(newNumber)).substring(0, 4);
						pin = Integer.parseInt(val);
					} else {
						pin = num * 10;
					}
				} else {
					if (num < 2000) {
						pin = num * 5;
					} else {
						pin = (int) ((num / 2) + (Math.random() * 1000));
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pin;
	}

//this function send pin number to logged user

	@Override
	public void EmailSender(int pin) {
		// TODO Auto-generated method stub

		String to = list.get(2);
		final String from = "myemailpractice1002@gmail.com";
		final String password = "uutqqozctbgjahbt";

		// Get the session object
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Online Banking");
			message.setText("Dear " + list.get(1) + ", \n\nThis your Pin number: " + pin
					+ "\n\n Please use this pin number when you are logging to our online banking"
					+ "\n\n Thank you for Join with us" + "\n\n Have a good day" + "\n\n\n Best Regards!");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

//user logout

	@Override
	public String Logout(String cookie) throws RemoteException {
		// TODO Auto-generated method stub

		return "empty";
	}

//get current user ip address and save it to database
	@Override
	public String UserLocalIP() throws RemoteException {
		// TODO Auto-generated method stub

		InetAddress inetAddress;
		String myip = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection C = DriverManager.getConnection(URL, user, pass);

			inetAddress = InetAddress.getLocalHost();
			myip = inetAddress.getHostAddress();

			PreparedStatement ps2 = C.prepareStatement("insert into customers_ip_number values(?,?)");
			ps2.setString(1, list.get(1));
			ps2.setString(2, myip);
			ps2.executeUpdate();

		} catch (UnknownHostException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myip;

	}

	// this will give the open ip address
	@Override
	public String UserIp() throws RemoteException {
		// TODO Auto-generated method stub
		String userip = null;
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(),
				"UTF-8").useDelimiter("\\A")) {
			userip = s.nextLine();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return userip;
	}

	// This is the API used to get the current location

	@Override
	public String UserLocation() throws RemoteException {
		try {
			String userip = UserIp();

			String url = "https://geo.ipify.org/api/v1?apiKey=at_8Z1S2Citda4wW7ookUIyUzAHx1JVg&ipAddress=" + userip;
			URL obj;

			obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject myjson = new JSONObject(response.toString());
			Object val = myjson.getJSONObject("location").get("city");

			in.close();

			return val.toString();
		} catch (Exception e) {
			System.out.println("Something went wrong with connecting to the server.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int User_Pin_Number_Verification() throws RemoteException {
		// TODO Auto-generated method stub
		Statement stmt=null;
		String username =list.get(1);
		int pin = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection C = DriverManager.getConnection(URL, user, pass);
			stmt = C.createStatement();
			String sql = "SELECT `pin` FROM `customers_pin_number` WHERE `goodName`="+username;
			ResultSet rs = stmt.executeQuery(sql);
			
			pin=Integer.parseInt(rs.getString(2));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pin;
	}

	@Override
	public void Customer_Chart() throws RemoteException {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection C = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT L.Location, c.mainBalance FROM customers c, customers_location L where c.goodName=L.goodName";
		
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(C,sql);
		JFreeChart chart = ChartFactory.createBarChart("Customer Chart", "Location", "mainBalance", dataset, PlotOrientation.VERTICAL, false, true, true);//("Customer Chart", "Age", "Location", dataset, PlotOrientation.VERTICAL, false, true, true);
		BarRenderer renderer = null;
		CategoryPlot plot = null;
		
		renderer = new BarRenderer();
		ChartFrame frame = new ChartFrame("Customer Chart", chart);
		frame.setVisible(true);
		frame.setSize(400,650);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String MainBalance() throws RemoteException {
	// TODO Auto-generated method stub
	Statement stmt=null;
	String mainBalance=null;

	try {
		
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection C = DriverManager.getConnection(URL, user, pass);
	stmt = C.createStatement();
	String sql = "SELECT c.mainBalance FROM customers c, customers_ip_number i  where c.goodName=i.goodName AND i.IP_Address='169.254.206.99'";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		mainBalance = rs.getString(1);
	}


	


	} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return mainBalance;
	}
}
