/*CREATED BY:
 * 
 * ABIJITH PRASANTHAN	(AM.EN.U4CSE19102)
 * ANAND K S 		 	(AM.EN.U4CSE19106)
 * BHARATH PRATHAP NAIR	(AM.EN.U4CSE19113)
 * GAUTHAM SATHOSH KUMAR(AM.EN.U4CSE19121)
 * 
*/

/***********************************************************************************************************************************************************************************/

package TEST;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class login implements ActionListener
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
    
    login()
    {
    	//--------------------------------------------------------HOME PAGE------------------------------------------------------------------------------------
    	home = new JFrame();
		home.setSize(2000,780);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img =new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST//mainpage.jpg");//background
//      							------------------------------------------------------------------------------------
//                          		 This is the path of the image file stored in your system.this path may vary from system to system.
//                           		 So to get a the proper layout of the image,do go to the src folder of this project and copy the path of homepage.jpg file.
		home.getContentPane().setLayout(null);
		
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
				new login();
				
				
				
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
		//-------------------------------------------------------MAIN LOGIN FRAME-----------------------------------------------------------------------------------------
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
		
		loginbutton = new JButton("Login");//login button
		loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		loginbutton.setBackground(Color.BLACK);
		loginbutton.setForeground(Color.WHITE);
		loginbutton.setBounds(643, 518, 196, 39);
		loginframe.getContentPane().add(loginbutton);
		
		JLabel Background2=new JLabel("",img,JLabel.CENTER);//background
		Background2.setBounds(10, 0, 1350, 840);
		loginframe.getContentPane().add(Background2);
		//--------------------------------------------------------ADMIN LOGIN FRAME----------------------------------------------------------------------------------------
		adminlogframe = new JFrame();
		adminlogframe.setSize(2000,780);
		adminlogframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img =new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST//homepage.jpg");//background
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
		
		JLabel lblNewLabel = new JLabel("      ( Administrative Access)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(584, 292, 212, 14);
		adminlogframe.getContentPane().add(lblNewLabel);
		
		JLabel Background3=new JLabel("",img,JLabel.CENTER);//background
		Background3.setBounds(10, 0, 1350, 840);
		adminlogframe.getContentPane().add(Background3);
    	
    //----------------------------------------------------------------------Admin's Frame-------------------------------------------------------------------------------------------------------
    		
    		
    	Admin=new JFrame("The Red Fork(Admin)");
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
    		
    		
    		
    //----------------------------------------------------------------------Senior Manager Frame-----------------------------------------------------------------------------------		
        
       		seniormanager = new JFrame();//senior manager frame details
    		seniormanager.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
    		seniormanager.getContentPane().setBackground(new Color(220, 20, 60));
    		seniormanager.setBackground(Color.DARK_GRAY);
    		seniormanager.setSize(2000,780);
    		seniormanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		
    		
    		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
    		seniormanager.getContentPane().setLayout(null);
    		
    		
    		JPanel sidebar = new JPanel();//SIDE PANEL
    		sidebar.setBounds(0, 0, 173, 749);
    		sidebar.setBackground(new Color(0, 0, 0));
    		seniormanager.getContentPane().add(sidebar);
    		sidebar.setLayout(null);
    		JLabel label4= new JLabel(i);
    		label4.setBounds(10, 11, 140, 143);
    		sidebar.add(label4);
    		label4.setHorizontalAlignment(SwingConstants.LEFT);
    		
    		JPanel title = new JPanel();//HEADING PANEL
    		title.setBounds(167, 32, 1203, 49);
    		title.setBackground(new Color(0, 0, 0));
    		seniormanager.getContentPane().add(title);
    		title.setLayout(null);
    		
    		JLabel restaurantname = new JLabel("RedFork  Restaurant -SENIOR MANAGER");//RESTAURANT NAME
    		restaurantname.setFont(new Font("Segoe Script", Font.BOLD, 20));
    		restaurantname.setForeground(Color.WHITE);
    		restaurantname.setBounds(105, 11, 542, 38);
    		title.add(restaurantname);
    		
    		JButton BACK = new JButton("BACK");//BACK BUTTON
    		BACK.setForeground(Color.WHITE);
    		BACK.setBackground(Color.BLACK);
    		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    		BACK.setBounds(1075, 11, 89, 23);
    		title.add(BACK);
    		
    		JButton ViewOfficialDet = new JButton("View Official Details");//View Official Details Buttons
    		ViewOfficialDet.setBackground(Color.WHITE);
    		ViewOfficialDet.setBounds(10, 271, 153, 36);
    		sidebar.add(ViewOfficialDet);
    		
    		JButton UpdateOfficialDet2 = new JButton("Update Personal Details");//Update Personal Details Button
    		UpdateOfficialDet2.setBackground(Color.WHITE);
    		UpdateOfficialDet2.setBounds(10, 224, 153, 36);
    		sidebar.add(UpdateOfficialDet2);
    		
    		JButton UpdatePrices = new JButton("Update Prices");//Update Prices Button
    		UpdatePrices.setBackground(Color.WHITE);
    		UpdatePrices.setBounds(10, 318, 153, 36);
    		sidebar.add(UpdatePrices);
    		
    		JButton Profitability2 = new JButton("Profitability");//Profitability Button
    		Profitability2.setBackground(Color.WHITE);
    		Profitability2.setBounds(10, 365, 153, 36);
    		sidebar.add(Profitability2);
    		
    		JButton CheckMaint = new JButton("Check Maintenance ");//Check Maintenance Button
    		CheckMaint.setBackground(Color.WHITE);
    		CheckMaint.setBounds(10, 412, 153, 36);
    		sidebar.add(CheckMaint);
    		
    		JButton UpdateDet = new JButton("Update Official Details");//Update Official Details Button
    		UpdateDet.setBackground(Color.WHITE);
    		UpdateDet.setBounds(10, 459, 153, 36);
    		sidebar.add(UpdateDet);
    		
    		
    		Panel panel_3 = new Panel();
    		panel_2.setBackground(new Color(255, 255, 255));
    		panel_2.setBounds(199, 118, 1150, 571);
    		seniormanager.getContentPane().add(panel_2);
        
   
   //--------------------------------------------------------------------Branch Manage Frame------------------------------------------------------------------------------------------------------------ 
    
          
    		branchmanager = new JFrame();//branchmanager frame details
    		branchmanager.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
    		branchmanager.getContentPane().setBackground(new Color(220, 20, 60));
    		branchmanager.setBackground(Color.DARK_GRAY);
    		branchmanager.setSize(2000,780);
    		branchmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		
    		
    		i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
    		branchmanager.getContentPane().setLayout(null);
    		
    		
    		JPanel sidebar2 = new JPanel();//SIDE PANEL
    		sidebar2.setBounds(0, 0, 173, 749);
    		sidebar2.setBackground(new Color(0, 0, 0));
    		branchmanager.getContentPane().add(sidebar2);
    		sidebar2.setLayout(null);
    		JLabel label5= new JLabel(i);
    		label5.setBounds(10, 11, 140, 143);
    		sidebar2.add(label3);
    		label5.setHorizontalAlignment(SwingConstants.LEFT);
    		
    		JPanel title2 = new JPanel();//HEADING PANEL
    		title2.setBounds(167, 32, 1203, 49);
    		title2.setBackground(new Color(0, 0, 0));
    		branchmanager.getContentPane().add(title2);
    		title2.setLayout(null);
    		
    		JLabel restaurantname2 = new JLabel("RedFork  Restaurant -BRANCH MANAGER");//RESTAURANT NAME
    		restaurantname2.setFont(new Font("Segoe Script", Font.BOLD, 20));
    		restaurantname2.setForeground(Color.WHITE);
    		restaurantname2.setBounds(105, 11, 542, 38);
    		title2.add(restaurantname2);
    		
    		BACK = new JButton("BACK");//BACK BUTTON
    		BACK.setForeground(Color.WHITE);
    		BACK.setBackground(Color.BLACK);
    		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    		BACK.setBounds(1075, 11, 89, 23);
    		title2.add(BACK);
    		
    		JButton ViewOfficialDet2 = new JButton("View Official Details");
    		ViewOfficialDet2.setBackground(Color.WHITE);
    		ViewOfficialDet2.setBounds(10, 271, 153, 36);
    		sidebar.add(ViewOfficialDet2);
    		
    		JButton UpdateOfficialDet3 = new JButton("Update Personal Details Details");
    		UpdateOfficialDet3.setBackground(Color.WHITE);
    		UpdateOfficialDet3.setBounds(10, 224, 153, 36);
    		sidebar.add(UpdateOfficialDet3);
    		
    		JButton UpdatePrices2 = new JButton("Update Prices");
    		UpdatePrices2.setBackground(Color.WHITE);
    		UpdatePrices2.setBounds(10, 318, 153, 36);
    		sidebar.add(UpdatePrices2);
    		
    		JPanel panel_1 = new JPanel();
    		panel_1.setBounds(167, 32, 1203, 49);
    		panel_1.setBackground(new Color(0, 0, 0));
    		branchmanager.getContentPane().add(panel_1);
    		panel_1.setLayout(null);
    		
    		
    		Panel panel_4 = new Panel();
    		panel_2.setBackground(new Color(255, 255, 255));
    		panel_2.setBounds(199, 118, 1150, 571);
    		branchmanager.getContentPane().add(panel_2);
   
    //---------------------------------------------------------------------CHEF FRAME--------------------------------------------------------------------------------
    
    		chef = new JFrame();//chef frame details
    		chef.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
    		chef.getContentPane().setBackground(new Color(220, 20, 60));
    		chef.setBackground(Color.DARK_GRAY);
    		chef.setSize(2000,780);
    		chef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		
    		
    		i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
    		chef.getContentPane().setLayout(null);
    		
    		
    		JPanel sidebar3 = new JPanel();//SIDE PANEL
    		sidebar3.setBounds(0, 0, 173, 749);
    		sidebar3.setBackground(new Color(0, 0, 0));
    		chef.getContentPane().add(sidebar3);
    		sidebar3.setLayout(null);
    		JLabel label6= new JLabel(i);
    		label6.setBounds(10, 11, 140, 143);
    		sidebar3.add(label6);
    		label6.setHorizontalAlignment(SwingConstants.LEFT);
    		
    		JPanel title4 = new JPanel();//HEADING PANEL
    		title4.setBounds(167, 32, 1203, 49);
    		title4.setBackground(new Color(0, 0, 0));
    		chef.getContentPane().add(title);
    		title.setLayout(null);
    		
    		JLabel restaurantname3 = new JLabel("RedFork  Restaurant -CHEF");//RESTAURANT NAME
    		restaurantname3.setFont(new Font("Segoe Script", Font.BOLD, 20));
    		restaurantname3.setForeground(Color.WHITE);
    		restaurantname3.setBounds(105, 11, 542, 38);
    		title.add(restaurantname3);
    		
    		BACK = new JButton("BACK");//BACK BUTTON
    		BACK.setForeground(Color.WHITE);
    		BACK.setBackground(Color.BLACK);
    		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    		BACK.setBounds(1075, 11, 89, 23);
    		title.add(BACK);
    		
    		JButton ViewOfficialDet3 = new JButton("Update Personal Details");//View Official Details Buttons
    		ViewOfficialDet3.setBackground(Color.WHITE);
    		ViewOfficialDet3.setBounds(10, 271, 153, 36);
    		sidebar3.add(ViewOfficialDet3);
    		
    		JButton UpdatePrices3 = new JButton("Update Prices");//Update Prices Button
    		UpdatePrices3.setBackground(Color.WHITE);
    		UpdatePrices3.setBounds(10, 318, 153, 36);
    		sidebar3.add(UpdatePrices3);
    		
    		JButton Profitability3 = new JButton("Profitability");//Profitability Button
    		Profitability3.setBackground(Color.WHITE);
    		Profitability3.setBounds(10, 365, 153, 36);
    		sidebar3.add(Profitability3);
    		
    		JButton CheckMaint2 = new JButton("Check Maintenance ");//Check Maintenance Button
    		CheckMaint2.setBackground(Color.WHITE);
    		CheckMaint2.setBounds(10, 412, 153, 36);
    		sidebar.add(CheckMaint2);
    		
    		JButton UpdateDet2 = new JButton("Update Official Details");//Update Official Details Button
    		UpdateDet2.setBackground(Color.WHITE);
    		UpdateDet2.setBounds(10, 459, 153, 36);
    		sidebar3.add(UpdateDet2);
    		
    		JButton btnViewBranchDet = new JButton("View Branch Details");
    		btnViewBranchDet.setBackground(Color.WHITE);
    		btnViewBranchDet.setBounds(10, 224, 153, 36);
    		sidebar.add(btnViewBranchDet);
    		
    		
    		Panel panel_5 = new Panel();
    		panel_5.setBackground(new Color(255, 255, 255));
    		panel_5.setBounds(199, 118, 1150, 571);
    		chef.getContentPane().add(panel_5);
    
    
    }
    
    public static void main(String[] args) 
	{
		 new login();   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
