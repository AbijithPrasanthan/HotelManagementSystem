import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.TextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class testpage {

	private JFrame frame;
	private JFrame main_f;
	
	JPanel hire_employee;
	JPanel fire_employee;
	JPanel Update_WkPlce;
	JPanel profit ;
	JPanel maintenance;
	JPanel updt_branchdet;
	JPanel updt_offdt;
	JPanel updt_pers;
	JPanel updt_price;
	
	String HName;

	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testpage window = new testpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public testpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(220, 20, 60));
		frame.setBackground(Color.DARK_GRAY);
		frame.setSize(2000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 173, 749);
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		panel.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnFireEmployee = new JButton("Fire Employee");
		btnFireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fire_employee.setVisible(true);
				hire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				profit.setVisible(false);
				maintenance.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_offdt.setVisible(false);
				updt_pers.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnFireEmployee.setBackground(Color.WHITE);
		btnFireEmployee.setBounds(10, 264, 140, 36);
		panel.add(btnFireEmployee);
		
		
		JButton btnHireEmployee = new JButton("Hire Employee");
		btnHireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				hire_employee.setVisible(true);
				fire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				profit.setVisible(false);
				maintenance.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_offdt.setVisible(false);
				updt_pers.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnHireEmployee.setBackground(Color.WHITE);
		btnHireEmployee.setBounds(10, 217, 140, 36);
		panel.add(btnHireEmployee);
		
		JButton btnCheckMaintenance = new JButton("Check Maintenance");
		btnCheckMaintenance.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCheckMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				maintenance.setVisible(true);
				hire_employee.setVisible(false);
				fire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				profit.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_offdt.setVisible(false);
				updt_pers.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnCheckMaintenance.setBounds(10, 417, 140, 36);
		panel.add(btnCheckMaintenance);
		
		
		JButton btnNewButton_3 = new JButton("View Branch Details");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setBounds(10, 464, 140, 36);
		panel.add(btnNewButton_3);
		
		JButton btnUpdateBranchDetails = new JButton("Update Branch Details");
		btnUpdateBranchDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_branchdet.setVisible(true);
				maintenance.setVisible(false);
				hire_employee.setVisible(false);
				fire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				profit.setVisible(false);
				updt_offdt.setVisible(false);
				updt_pers.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnUpdateBranchDetails.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUpdateBranchDetails.setBounds(10, 511, 140, 36);
		panel.add(btnUpdateBranchDetails);
		
		
		JButton btnUpdateOfficialDetails = new JButton("Update Official Details");
		btnUpdateOfficialDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_offdt.setVisible(true);
				Update_WkPlce.setVisible(false);
				fire_employee.setVisible(false);
				hire_employee.setVisible(false);
				profit.setVisible(false);
				maintenance.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_pers.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnUpdateOfficialDetails.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUpdateOfficialDetails.setBounds(10, 558, 140, 36);
		panel.add(btnUpdateOfficialDetails);
		
		JButton btnUpdatePersonalDetails = new JButton("Update Personal Details");
		btnUpdatePersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers.setVisible(true);
				Update_WkPlce.setVisible(false);
				fire_employee.setVisible(false);
				hire_employee.setVisible(false);
				profit.setVisible(false);
				maintenance.setVisible(false);
				updt_offdt.setVisible(false);
				updt_price.setVisible(false);
				updt_branchdet.setVisible(false);
			}
		});
		btnUpdatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnUpdatePersonalDetails.setBounds(10, 605, 140, 36);
		panel.add(btnUpdatePersonalDetails);
		
		
		JButton btnUpdatePrices = new JButton("Update Prices");
		btnUpdatePrices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_price.setVisible(true);
				profit.setVisible(false);
				hire_employee.setVisible(false);
				fire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_pers.setVisible(false);
				updt_offdt.setVisible(false);
				maintenance.setVisible(false);
			}
		});
		btnUpdatePrices.setBounds(10, 649, 140, 36);
		panel.add(btnUpdatePrices);
		
		JButton btnProfitability = new JButton("Profitability");
		btnProfitability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				profit.setVisible(true);
				hire_employee.setVisible(false);
				fire_employee.setVisible(false);
				Update_WkPlce.setVisible(false);
				updt_branchdet.setVisible(false);
				updt_pers.setVisible(false);
				updt_offdt.setVisible(false);
				maintenance.setVisible(false);
				updt_price.setVisible(false);
			}
		});
		btnProfitability.setBounds(10, 370, 140, 36);
		panel.add(btnProfitability);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(167, 32, 1203, 49);
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RedFork  Restaurant (Admin Applications)");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(105, 11, 542, 38);
		panel_1.add(lblNewLabel);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(199, 118, 1150, 571);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		//------------------------------------------------fire employee panel-------------------------------------------
		
		fire_employee = new JPanel();//fire employee panel
		fire_employee.setVisible(false);
		fire_employee.setBounds(255, 62, 621, 194);
		panel_2.add(fire_employee);
		fire_employee.setLayout(null);
		
		JLabel fire_emp = new JLabel("Fire Employee");
		fire_emp.setFont(new Font("Times New Roman", Font.BOLD, 17));
		fire_emp.setBounds(10, 11, 225, 21);
		fire_employee.add(fire_emp);
		
		
		JLabel SSN2 = new JLabel("SSN:");
		SSN2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		SSN2.setBounds(20, 43, 46, 14);
		fire_employee.add(SSN2);
		
		JTextField SSN_text2 = new JTextField();// SSN text field
		SSN_text2.setBounds(155, 41, 245, 20);
		fire_employee.add(SSN_text2);
		SSN_text2.setColumns(10);
		
		JButton firebtn = new JButton("FIRE");//appoint button
		firebtn.setForeground(Color.WHITE);
		firebtn.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		firebtn.setBackground(Color.BLACK);
		firebtn.setBounds(476, 131, 89, 23);
		fire_employee.add(firebtn);
	    
	    
		
		
		//-------------------------------hire employee panel------------------------------------------
		
		hire_employee = new JPanel();//hire employee panel
		hire_employee.setVisible(false);
		hire_employee.setBounds(255, 62, 621, 383);
		panel_2.add(hire_employee);
		hire_employee.setLayout(null);
		
		
		
		JLabel hire_lbl = new JLabel("Hire Employee");
		hire_lbl.setFont(new Font("Times New Roman", Font.BOLD, 17));
		hire_lbl.setBounds(10, 11, 225, 21);
		hire_employee.add(hire_lbl);
		
		JLabel SSN = new JLabel("SSN:");
		SSN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		SSN.setBounds(20, 43, 46, 14);
		hire_employee.add(SSN);
		
		JTextField SSN_text = new JTextField();// SSN text field
		SSN_text.setBounds(155, 41, 245, 20);
		hire_employee.add(SSN_text);
		SSN_text.setColumns(10);
		
		JLabel Fname = new JLabel("First Name:");
		Fname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Fname.setBounds(20, 81, 85, 14);
		hire_employee.add(Fname);
		
		JTextField Fname_txt = new JTextField();//Textfield for first name
		Fname_txt.setColumns(10);
		Fname_txt.setBounds(155, 79, 245, 20);
		hire_employee.add(Fname_txt);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLastName.setBounds(20, 119, 85, 14);
		hire_employee.add(lblLastName);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining:");
		lblDateOfJoining.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateOfJoining.setBounds(20, 154, 99, 14);
		hire_employee.add(lblDateOfJoining);
		
		JTextField Lname_txt = new JTextField();//textfield for last name
		Lname_txt.setColumns(10);
		Lname_txt.setBounds(155, 117, 245, 20);
		hire_employee.add(Lname_txt);
		
		JTextField doj_txt = new JTextField();//text field for doj
		doj_txt.setColumns(10);
		doj_txt.setBounds(155, 152, 245, 20);
		hire_employee.add(doj_txt);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSalary.setBounds(20, 191, 99, 14);
		hire_employee.add(lblSalary);
		
		JTextField salary_txt = new JTextField();//text field for salary
		salary_txt.setColumns(10);
		salary_txt.setBounds(155, 189, 245, 20);
		hire_employee.add(salary_txt);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDesignation.setBounds(20, 223, 99, 14);
		hire_employee.add(lblDesignation);
		
		JTextField Desig_txt = new JTextField();//text field for designation
		Desig_txt.setColumns(10);
		Desig_txt.setBounds(155, 221, 245, 20);
		hire_employee.add(Desig_txt);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhone.setBounds(20, 258, 99, 14);
		hire_employee.add(lblPhone);
		
		JTextField Phn_txt = new JTextField();//phone number text field
		Phn_txt.setColumns(10);
		Phn_txt.setBounds(155, 256, 245, 20);
		hire_employee.add(Phn_txt);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(20, 301, 99, 14);
		hire_employee.add(lblAddress);
		
		JTextField add_txt = new JTextField();//text field for address
		add_txt.setColumns(10);
		add_txt.setBounds(155, 299, 245, 21);
		hire_employee.add(add_txt);
		
		JButton appointbtn = new JButton("APPOINT");//appoint button
		appointbtn.setForeground(Color.WHITE);
		appointbtn.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		appointbtn.setBackground(Color.BLACK);
		appointbtn.setBounds(497, 349, 89, 23);
		hire_employee.add(appointbtn);
		
		
		
		
		//----------------------------------------------------update workplace panel-------------------------
		Update_WkPlce=new JPanel();
		Update_WkPlce.setBounds(-77, 68, 688, 228);
		hire_employee.add(Update_WkPlce);
		Update_WkPlce.setVisible(false);
		Update_WkPlce.setLayout(null);
		
		JLabel Update_Work = new JLabel("Update Work Place:");//label for panel heading
		Update_Work.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Update_Work.setBounds(27, 11, 179, 27);
		Update_WkPlce.add(Update_Work);
		
		JLabel ssn_lbl = new JLabel("SSN :");//ssn label
		ssn_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ssn_lbl.setBounds(100, 63, 46, 14);
		Update_WkPlce.add(ssn_lbl);
		
		JTextField ssn_txt = new JTextField();//ssn text field
		ssn_txt.setBounds(193, 60, 198, 20);
		Update_WkPlce.add(ssn_txt);
		ssn_txt.setColumns(10);
		
		JLabel hid_lbl = new JLabel("HID:");//hid label
		hid_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		hid_lbl.setBounds(100, 136, 46, 14);
		Update_WkPlce.add(hid_lbl);
		
		JTextField hid_txt = new JTextField();// hid textfield
		hid_txt.setBounds(193, 133, 198, 20);
		Update_WkPlce.add(hid_txt);
		hid_txt.setColumns(10);
		
		JButton Updatebtn = new JButton("Update");
		Updatebtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Updatebtn.setBounds(561, 194, 89, 23);
		Update_WkPlce.add(Updatebtn);
		
		//------------------------------------profitability panel---------------------------------------
		profit = new JPanel();
		profit.setVisible(false);
		profit.setBounds(234, 62, 621, 291);
		panel_2.add(profit);
		profit.setLayout(null);
		
		
		JLabel profit_lbl = new JLabel("Profitability:");
		profit_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		profit_lbl.setBounds(6, 6, 99, 21);
		profit.add(profit_lbl);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select your restaurant :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(6, 56, 138, 20);
		profit.add(lblNewLabel_1);
		
		JRadioButton Whole_Delight = new JRadioButton("RedFork Whole Delight");
		Whole_Delight.setBounds(113, 83, 179, 23);
		profit.add(Whole_Delight);
		
		JRadioButton Olive = new JRadioButton("RedFork Olive");
		Olive.setBounds(113, 111, 179, 23);
		profit.add(Olive);
		
		JRadioButton East_Treats = new JRadioButton("RedFork East Treats");
		East_Treats.setBounds(113, 137, 179, 23);
		profit.add(East_Treats);
		
		JRadioButton Four_Seasons = new JRadioButton("RedFork Four Seasons");
		Four_Seasons.setBounds(113, 163, 179, 23);
		profit.add(Four_Seasons);
		
		JRadioButton Delightful = new JRadioButton("RedFork Delightful");
		Delightful.setBounds(113, 189, 179, 23);
		profit.add(Delightful);
		
	
	    System.out.println(HName);
	    
	    JButton chk_btn = new JButton("Check");
		chk_btn.setBounds(522, 203, 89, 23);
		profit.add(chk_btn);
		chk_btn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		 if(Whole_Delight.isSelected()) {
				    	HName = "RedFork Whole Delight";
				    }
				    
				    if(Olive.isSelected()) {
				    	HName = "RedFork Olive";
				    }
				    
				    if(East_Treats.isSelected()) {
				    	HName = "RedFork East Treats";
				    }
				    
				    if(Four_Seasons.isSelected()) {
				    	HName = "RedFork Four Seasons";
				    }
				    
				    if(Delightful.isSelected()) {
				    	HName = "RedFork Delightful";
				    }
	    	}
	    });
		
		//-----------------------------------Check Maintenance panel---------------------------------------------
		maintenance = new JPanel();
		maintenance.setVisible(false);
		maintenance.setBounds(234, 62, 621, 291);
		panel_2.add(maintenance);
		maintenance.setLayout(null);
		
		
		JLabel profit_lbl2 = new JLabel("Check Maintenance:");
		profit_lbl2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		profit_lbl2.setBounds(6, 6, 220, 21);
		maintenance.add(profit_lbl2);
		
		
		JLabel rest_lbl = new JLabel("Select your restaurant :");
		rest_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rest_lbl.setBounds(6, 56, 138, 20);
		maintenance.add(rest_lbl);
		
		JRadioButton Whole_Delight2 = new JRadioButton("RedFork Whole Delight");
		Whole_Delight2.setBounds(113, 83, 179, 23);
		maintenance.add(Whole_Delight2);
		
		JRadioButton Olive2 = new JRadioButton("RedFork Olive");
		Olive2.setBounds(113, 111, 179, 23);
		maintenance.add(Olive2);
		
		JRadioButton East_Treats2 = new JRadioButton("RedFork East Treats");
		East_Treats2.setBounds(113, 137, 179, 23);
		maintenance.add(East_Treats2);
		
		JRadioButton Four_Seasons2 = new JRadioButton("RedFork Four Seasons");
		Four_Seasons2.setBounds(113, 163, 179, 23);
		maintenance.add(Four_Seasons2);
		
		JRadioButton Delightful2 = new JRadioButton("RedFork Delightful");
		Delightful2.setBounds(113, 189, 179, 23);
		maintenance.add(Delightful2);
		
	
	    System.out.println(HName);
	    
	    JButton chk_btn2 = new JButton("Check");
		chk_btn2.setBounds(522, 203, 89, 23);
		maintenance.add(chk_btn2);
		chk_btn2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		 if(Whole_Delight2.isSelected()) {
				    	HName = "RedFork Whole Delight";
				    }
				    
				    if(Olive2.isSelected()) {
				    	HName = "RedFork Olive";
				    }
				    
				    if(East_Treats2.isSelected()) {
				    	HName = "RedFork East Treats";
				    }
				    
				    if(Four_Seasons2.isSelected()) {
				    	HName = "RedFork Four Seasons";
				    }
				    
				    if(Delightful2.isSelected()) {
				    	HName = "RedFork Delightful";
				    }
	    	}
	    });		    
		
		//-------------------------------------------update branch details panel- ------------------------------------------------------
		
		updt_branchdet = new JPanel();
		updt_branchdet.setVisible(false);
		updt_branchdet.setBounds(192, 62, 688, 383);
		panel_2.add(updt_branchdet);
		updt_branchdet.setLayout(null);
		
		
		JLabel branchdet_lbl = new JLabel("Update Branch Details:");
		branchdet_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		branchdet_lbl.setBounds(6, 6, 220, 21);
		updt_branchdet.add(branchdet_lbl);
		
		
		JLabel rest_lbl2 = new JLabel("Select your restaurant :");
		rest_lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rest_lbl2.setBounds(6, 56, 138, 20);
		updt_branchdet.add(rest_lbl2);
		
		JRadioButton Whole_Delight3 = new JRadioButton("RedFork Whole Delight");
		Whole_Delight3.setBounds(113, 83, 179, 23);
		updt_branchdet.add(Whole_Delight3);
		
		JRadioButton Olive3 = new JRadioButton("RedFork Olive");
		Olive3.setBounds(113, 111, 179, 23);
		updt_branchdet.add(Olive3);
		
		JRadioButton East_Treats3 = new JRadioButton("RedFork East Treats");
		East_Treats3.setBounds(113, 137, 179, 23);
		updt_branchdet.add(East_Treats3);
		
		JRadioButton Four_Seasons3 = new JRadioButton("RedFork Four Seasons");
		Four_Seasons3.setBounds(113, 163, 179, 23);
		updt_branchdet.add(Four_Seasons3);
		
		JRadioButton Delightful3 = new JRadioButton("RedFork Delightful");
		Delightful3.setBounds(113, 189, 179, 23);
		updt_branchdet.add(Delightful3);
		
	
	    System.out.println(HName);
	    
	    JButton submitbtn = new JButton("Update");//submit button
	    submitbtn.setBounds(300, 350, 89, 23);
	    submitbtn.setForeground(Color.WHITE);
	    submitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    submitbtn.setBackground(Color.BLACK);
		updt_branchdet.add(submitbtn);
		
		JLabel revenue_lbl = new JLabel("Updated Revenue:");
		revenue_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		revenue_lbl.setBounds(6, 250, 220, 21);
		updt_branchdet.add(revenue_lbl);
		
		JTextField revenue =new JTextField("0");//textfield for revenue
		revenue.setBounds(180, 250, 220, 21);
		updt_branchdet.add(revenue);
		
		JLabel expen_lbl = new JLabel("Updated Expenditure:");
		expen_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		expen_lbl.setBounds(6, 290, 220, 21);
		updt_branchdet.add(expen_lbl);
		
		JTextField expenditure =new JTextField("0");//textfield for expenditure
		expenditure.setBounds(180, 290, 220, 21);
		updt_branchdet.add(expenditure);
	
		submitbtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		 if(Whole_Delight2.isSelected()) {
				    	HName = "RedFork Whole Delight";
				    }
				    
				    if(Olive2.isSelected()) {
				    	HName = "RedFork Olive";
				    }
				    
				    if(East_Treats2.isSelected()) {
				    	HName = "RedFork East Treats";
				    }
				    
				    if(Four_Seasons2.isSelected()) {
				    	HName = "RedFork Four Seasons";
				    }
				    
				    if(Delightful2.isSelected()) {
				    	HName = "RedFork Delightful";
				    }
	    	}
	    });		    
		
	
	
		
		//---------------------------------------------update official details panel------------------------
		
		updt_offdt =new JPanel(); //panel for updating official details
		updt_offdt.setVisible(false);
		updt_offdt.setBounds(234, 62, 621, 291);
		panel_2.add(updt_offdt);
		updt_offdt.setLayout(null);
		
		JLabel offdet_lbl = new JLabel("Update Official Details:");//heading label of panel
		offdet_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		offdet_lbl.setBounds(6, 6, 220, 21);
		updt_offdt.add(offdet_lbl);
		
		JLabel SSN3 = new JLabel("SSN:");//ssn label
		SSN3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		SSN3.setBounds(20, 43, 46, 14);
		updt_offdt.add(SSN3);
		
		JTextField SSN_text3 = new JTextField(null);// SSN text field
		SSN_text3.setBounds(155, 41, 245, 20);
		updt_offdt.add(SSN_text3);
		SSN_text3.setColumns(10);
		
		

		JLabel desig_lbl= new JLabel("Designation:");//designation label
		desig_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		desig_lbl.setBounds(20,80, 86, 24);
		updt_offdt.add(desig_lbl);
		
		JTextField desig_txt = new JTextField(null);// designation text field
		desig_txt.setBounds(155, 80, 245, 20);
		updt_offdt.add(desig_txt);
		desig_txt.setColumns(10);
		 
		JLabel wrkplc_lbl= new JLabel("Work Place:");// Work Place label
		wrkplc_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wrkplc_lbl.setBounds(20,120, 86, 24);
		updt_offdt.add(wrkplc_lbl);
		
		JTextField wrkplc_txt = new JTextField(null);// workplace text field
		wrkplc_txt.setBounds(155, 120, 245, 20);
		updt_offdt.add(wrkplc_txt);
		wrkplc_txt.setColumns(10);
		
		JLabel sal_lbl= new JLabel("Salary %:");//   salary label
		sal_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sal_lbl.setBounds(20,160, 86, 24);
		updt_offdt.add(sal_lbl);
		
		JTextField sal_txt = new JTextField(null);// salary text field
		sal_txt.setBounds(155, 160, 245, 20);
		updt_offdt.add(sal_txt);
		sal_txt.setColumns(10);
		
		JButton updatebtn = new JButton("Update");//update button
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn.setBackground(Color.BLACK);
		updatebtn.setBounds(450, 240, 120, 23);
		updt_offdt.add(updatebtn);
		
		//----------------------------------------update personal details panel---------------------------------------------------
		
		
		updt_pers = new JPanel();//update personal details panel
		updt_pers.setVisible(false);
		updt_pers.setBounds(255, 62, 621, 194);
		panel_2.add(updt_pers);
		updt_pers.setLayout(null);
		
		JLabel persndt_lbl = new JLabel("Update Personal Details:");//heading label of panel
		persndt_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		persndt_lbl.setBounds(6, 6, 220, 21);
		updt_pers.add(persndt_lbl);
		
		JLabel phone_lbl = new JLabel("Phone:");//phone label
		phone_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phone_lbl.setBounds(20, 43, 46, 14);
		updt_pers.add(phone_lbl);
		
		JTextField phone_txt = new JTextField(null);// phone text field
		phone_txt.setBounds(155, 43, 245, 20);
		updt_pers.add(phone_txt);
		phone_txt.setColumns(10);
		
		JLabel addr_lbl = new JLabel("Address:");//address label
		addr_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addr_lbl.setBounds(20, 83, 80, 14);
		updt_pers.add(addr_lbl);
		
		JTextField addr_txt = new JTextField(null);// phone text field
		addr_txt.setBounds(155, 83, 245, 20);
		updt_pers.add(addr_txt);
		addr_txt.setColumns(10);
		
		JButton updatebtn2 = new JButton("Update");//update button
		updatebtn2.setForeground(Color.WHITE);
		updatebtn2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn2.setBackground(Color.BLACK);
		updatebtn2.setBounds(440, 150, 120, 23);
		updt_pers.add(updatebtn2);
		
		//---------------------------------------------------------Update price panel----------------------------------------------------------------------------
		
		updt_price = new JPanel();//update price  panel
		updt_price.setVisible(false);
		updt_price.setBounds(255, 62, 621, 194);
		panel_2.add(updt_price);
		updt_price.setLayout(null);
		
		JLabel price_lbl = new JLabel("Update Price :");//heading label of panel
		price_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		price_lbl.setBounds(6, 6, 220, 21);
		updt_price.add(price_lbl);
		
		JLabel dishid_lbl = new JLabel("Dish Id:");//dish id label
		dishid_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dishid_lbl.setBounds(20, 43, 46, 14);
		updt_price.add(dishid_lbl);
		
		JTextField dishid_txt = new JTextField(null);// dish id text field
		dishid_txt.setBounds(155, 43, 245, 20);
		updt_price.add(dishid_txt);
		dishid_txt.setColumns(10);
		
		JLabel updtprice_lbl = new JLabel("Updated Price:");//updated price label
		updtprice_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		updtprice_lbl.setBounds(20, 83, 100, 14);
		updt_price.add(updtprice_lbl);
		
		JTextField updtprice_txt = new JTextField(null);// updated price  text field
		updtprice_txt.setBounds(155, 83, 245, 20);
		updt_price.add(updtprice_txt);
		updtprice_txt.setColumns(10);
		
		JButton updatebtn3 = new JButton("Update");//update button
		updatebtn3.setForeground(Color.WHITE);
		updatebtn3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn3.setBackground(Color.BLACK);
		updatebtn3.setBounds(440, 150, 120, 23);
		updt_price.add(updatebtn3);
		
		
		
		
		
		
		
		
		
		
	}
}
