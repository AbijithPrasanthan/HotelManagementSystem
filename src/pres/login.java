package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class login
{
	JFrame Admin=null;

    public static JFrame home;//home frame
    
    public static JFrame loginframe;//elements of login frame
	public JTextField loginfield;
	public JPasswordField passwordField;
	private JButton loginbutton;
	
	
	private JFrame adminlogframe;//elements of admin login frame
	public JTextField adm_loginfield;
	public JPasswordField adm_passwordField;
	private JButton adm_loginbutton;
	
	private JFrame seniormanager;//senior manager frame	
	private JFrame branchmanager;//branch manager frame	
	private JFrame chef; //chef frame 	
	private JFrame h_chef;//head chef frame

	private Connection connect = null;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void init() throws Exception{
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem",
                    "postgres", "password");
    		
    		statement = connect.createStatement();
    	}
    	
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    login() throws Exception
    {
		init();
    	//--------------------------------------------------------HOME PAGE------------------------------------------------------------------------------------
    	home = new JFrame();
		home.setSize(2000,780);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img =new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST//mainpage.jpg");//background
//      							------------------------------------------------------------------------------------
//                          		 This is the path of the image file stored in your system.this path may vary from system to system.
//                           		 So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		home.getContentPane().setLayout(null);
		home.setVisible(true);
		
		JButton viewmenu = new JButton("VIEW MENU");//view menu button
		viewmenu.setForeground(Color.WHITE);
		viewmenu.setBackground(Color.BLACK);
		viewmenu.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		viewmenu.setBounds(312, 588, 170, 42);
		home.getContentPane().add(viewmenu);
		
		JButton loginbt = new JButton("LOG IN");//login button
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					home.setVisible(false);
					loginframe.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		viewmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					home.setVisible(false);
					new selectHotel();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginbt.setBackground(Color.BLACK);
		loginbt.setForeground(Color.WHITE);
		loginbt.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		loginbt.setBounds(908, 588, 170, 42);
		home.getContentPane().add(loginbt);
		
		
		JLabel Background=new JLabel("",img,JLabel.CENTER);//background
		Background.setBounds(10, 0, 1350, 840);
		home.getContentPane().add(Background);
		
		//--------------------------------------------------------MAIN LOGIN FRAME-----------------------------------------------------------------------------------------
		
		loginframe = new JFrame();
		loginframe.setSize(2000,780);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		img =new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST//homepage.jpg");//background
		//                           ------------------------------------------------------------------------------------
		//                           This is the path of the image file stored in your system.this path may vary from system to system.
		//                           So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		
		loginframe.getContentPane().setLayout(null);
		
		loginfield = new JTextField();//login textfield
		loginfield.setBounds(643, 410, 196, 39);
		loginframe.getContentPane().add(loginfield);
		loginfield.setColumns(10);
		
		passwordField = new JPasswordField();//password field
		passwordField.setBounds(643, 460, 196, 32);
		loginframe.getContentPane().add(passwordField);
		
		JButton adminlogin = new JButton("Admin Login");//admin login button
		adminlogin.setBackground(Color.BLACK);
		adminlogin.setForeground(Color.WHITE);
		adminlogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		adminlogin.setBounds(1158, 47, 131, 39);
		loginframe.getContentPane().add(adminlogin);
		
		adminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginframe.setVisible(false);
				adminlogframe.setVisible(true);
			}
		});
		
		
		loginbutton = new JButton("Login");//login button
		loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = loginfield.getText().toUpperCase();
				String eid = new String(passwordField.getPassword()).toUpperCase();
				JFrame alert=new JFrame();  
				try {
					if(SR_MangerLogin(name,eid)) 		//if the employee is a senior manager,it loads the frame of senior manager.
					{
						loginframe.setVisible(false);
						new seniormanager(eid);	
					}
					else if(MangerLogin(name,eid))     //if the employee is a manager,it loads the frame of chef.
					{
						loginframe.setVisible(false);
						new branchmanager(eid);
					}
					else if(ChefLogin(name,eid))      //if the employee is a chef,it loads the frame of chef.
					{
						loginframe.setVisible(false);
						new chefview(eid);
					}
					else if(H_ChefLogin(name,eid))  //if the employee is a head chef,it loads the frame of head chef.
					{
						loginframe.setVisible(false);
						new headchef(eid);
					}
					else 
					{
						JOptionPane.showMessageDialog(alert,"Invalid Credentials");
					}
					
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		loginbutton.setBackground(Color.BLACK);
		loginbutton.setForeground(Color.WHITE);
		loginbutton.setBounds(643, 518, 196, 39);
		loginframe.getContentPane().add(loginbutton);
		
		JLabel Background2=new JLabel("",img,JLabel.CENTER);//background
		Background2.setBounds(10, 0, 1350, 840);
		loginframe.getContentPane().add(Background2);
		
		JButton backbutton = new JButton("BACK");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(true);
				loginframe.setVisible(false);
			}
		});
		backbutton.setForeground(Color.WHITE);
		backbutton.setBackground(Color.BLACK);
		backbutton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		backbutton.setBounds(48, 49, 94, 32);
		loginframe.getContentPane().add(backbutton);
		//--------------------------------------------------------ADMIN LOGIN FRAME----------------------------------------------------------------------------------------
		
		adminlogframe = new JFrame();
		adminlogframe.setSize(2000,780);
		adminlogframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img2 =new ImageIcon("C:\\\\Users\\\\bhara\\\\Documents\\\\documents\\\\college\\\\SEM3\\\\OOPs\\\\HMS_PROJECT\\\\src\\\\TEST//homepage.jpg");//background
		//                           ------------------------------------------------------------------------------------
		//                           This is the path of the image file stored in your system.this path may vary from system to system.
		//                           So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		
		adminlogframe.getContentPane().setLayout(null);
		
		adm_loginfield = new JTextField();//login textfield
		adm_loginfield.setBounds(643, 410, 196, 39);
		adminlogframe.getContentPane().add(adm_loginfield);
		adm_loginfield.setColumns(10);
		
		adm_passwordField = new JPasswordField();//password field
		adm_passwordField.setBounds(643, 460, 196, 32);
		adminlogframe.getContentPane().add(adm_passwordField);
		
		adm_loginbutton = new JButton("Login");//login button
		adm_loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adm_loginbutton.setBackground(Color.BLACK);
		adm_loginbutton.setForeground(Color.WHITE);
		adm_loginbutton.setBounds(643, 518, 196, 39);
		adminlogframe.getContentPane().add(adm_loginbutton);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(631, 46, 105, 32);
		adminlogframe.getContentPane().add(lblNewLabel);
		
		JLabel Background3=new JLabel("",img2,JLabel.CENTER);//background
		Background3.setBounds(10, 0, 1350, 840);
		adminlogframe.getContentPane().add(Background3);
		JFrame alert2=new JFrame();  
		adm_loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = adm_loginfield.getText().toUpperCase();
				String eid = new String(adm_passwordField.getPassword()).toUpperCase();
				try {
					if(AdminLogin(name,eid)) 
					{
						new AdminView();
						adminlogframe.setVisible(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(alert2,"ACCESS DENIED!!"+"\n"+"Access only for Admin.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton backbutton2 = new JButton("BACK");
		backbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginframe.setVisible(true);
				adminlogframe.setVisible(false);
			}
		});
		backbutton2.setForeground(Color.WHITE);
		backbutton2.setBackground(Color.BLACK);
		backbutton2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		backbutton2.setBounds(48, 49, 94, 32);
		adminlogframe.getContentPane().add(backbutton2);}
		
		//----------------------------------------------------------------------Admin's Frame-------------------------------------------------------------------------------------------------------
		
		
    	/*Admin=new JFrame("The Red Fork(Admin)");
    	Admin.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
    	Admin.getContentPane().setBackground(new Color(220, 20, 60));
    	Admin.setBackground(Color.DARK_GRAY);
    	Admin.setSize(2000,1000);
    	Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
    	Admin.getContentPane().setLayout(null);
		
		
        	JPanel panel = new JPanel();
        	panel.setBounds(0, 0, 173, 749);
       		panel.setBackground(new Color(0, 0, 0));
       		Admin.getContentPane().add(panel);
       		panel.setLayout(null);
       		JLabel label3=new JLabel();
       		label3.setBounds(10, 11, 140, 143);
       		panel.add(label3);
       		label3.setHorizontalAlignment(SwingConstants.LEFT);
       		
       		JButton UpdateWorkplace = new JButton("Update workplace");
       		UpdateWorkplace.setBounds(10, 320, 140, 39);
       		panel.add(UpdateWorkplace);

       		JButton CalculateBonus = new JButton("Calculate Bonus");
       		CalculateBonus.setBounds(10, 273, 140, 36);
       		panel.add(CalculateBonus);

       		JButton FireEmployee = new JButton("Fire Employee");
       		FireEmployee.setBackground(Color.WHITE);
       		FireEmployee.setBounds(10, 226, 140, 36);
       		panel.add(FireEmployee);

       		JButton HireEmployee = new JButton("Hire Employee");
       		HireEmployee.setBackground(Color.WHITE);
       		HireEmployee.setBounds(10, 179, 140, 36);
       		panel.add(HireEmployee);

       		JButton btnCheckMaintenance = new JButton("Check Maintenance");
       		btnCheckMaintenance.setBounds(10, 417, 140, 36);
       		panel.add(btnCheckMaintenance);

       		JButton ViewBranchDet = new JButton("View Branch Details");
       		ViewBranchDet.setBounds(10, 464, 140, 36);
       		panel.add(ViewBranchDet);

       		JButton UpdateBranchDet = new JButton("Update Branch Details");
       		UpdateBranchDet.setBounds(10, 511, 140, 36);
       		panel.add(UpdateBranchDet);

       		JButton UpdateOfficialDet = new JButton("Update Official Details");
       		UpdateOfficialDet.setBounds(10, 558, 140, 36);
       		panel.add(UpdateOfficialDet);

       		JButton UpdatePersonal = new JButton("Update Personal Details Details");
       		UpdatePersonal.setBounds(10, 605, 140, 36);
       		panel.add(UpdatePersonal);

       		JButton btnUpdatePrices = new JButton("Update Prices");
       		btnUpdatePrices.setBounds(10, 649, 140, 36);
       		panel.add(btnUpdatePrices);

       		JButton Profitability = new JButton("Profitability");
       		Profitability.setBounds(10, 370, 140, 36);
       		panel.add(Profitability);

			JPanel titlepanel = new JPanel();//TITLE PANEL
       		titlepanel.setBounds(167, 32, 1203, 49);
       		titlepanel.setBackground(new Color(0, 0, 0));
       		Admin.getContentPane().add(titlepanel);
       		titlepanel.setLayout(null);

       		JLabel title3 = new JLabel("RedFork  Restaurant (Admin Applications)");
       		title3.setFont(new Font("Segoe Script", Font.BOLD, 20));
       		title3.setForeground(Color.WHITE);
       		title3.setBounds(105, 11, 542, 38);
       		titlepanel.add(title3);

       		Panel panel_2 = new Panel();//CONTENT PANEL
       		panel_2.setBackground(new Color(255, 255, 255));
       		panel_2.setBounds(199, 118, 1150, 571);
			Admin.getContentPane().add(panel_2);
			
    }*/
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public boolean AdminLogin(String name,String password) throws SQLException// function to check login credentials of admin.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname = '" + name.toUpperCase() + "'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("ADMIN")) 
			{
				if(resultSet.getString("ssn").equals(password))
				{
					return true;
				}
			}
		}
		return false;

    }
	
	
	public boolean SR_MangerLogin(String name,String password) throws SQLException// function to check login credentials of senior manger.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname = '" + name.toUpperCase() + "'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("SR_MANAGER")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					System.out.println("YOU ARE IN");
					return true;
				}
			}
		}
		return false;

    }
	
	public boolean MangerLogin(String name,String password) throws SQLException// function to check login credentials of  manger.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname = '" + name.toUpperCase() + "'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("MANAGER")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
	
	public boolean ChefLogin(String name,String password) throws SQLException// function to check login credentials of chef.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname = '" + name.toUpperCase() + "'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("CHEF")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
	
	
	public boolean H_ChefLogin(String name,String password) throws SQLException// function to check login credentials of head chef.
	{
		String sql = "SELECT ssn,designation FROM EMPLOYEE WHERE fname = '" + name.toUpperCase() + "'";
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) 
		{
			if(resultSet.getString("designation").equals("H_CHEF")) 
			{
				if(resultSet.getString("ssn").equals(password)) 
				{
					return true;
				}
			}
		}
		return false;

    }
	
	
	
	
    public static void main(String[] args) throws Exception 
	{
		 new login();   
	}

}