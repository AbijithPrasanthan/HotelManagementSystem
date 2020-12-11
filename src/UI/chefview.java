package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class chefview 
{
private JFrame chef;
	
	JPanel updt_pers_cf;
	JPanel persn_det_cf;
	JPanel vmenu_cf;
	JPanel off_det_cf;
	JPanel vbrnch_det_cf;
	
	Object[] HData;
	hotel hobj;
	Menu mobj;
	chef cobj;
	Dishes dobj;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chefview window = new chefview();
					window.chef.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public chefview() throws Exception 
	{
		hobj = new hotel();
		hobj.init();
		cobj = new chef("E1343");
		cobj.init();
		mobj = new Menu();
		mobj.init();
		dobj = new Dishes();
		dobj.init();
		HData = new Object[10];
		initialize();
	}

	private void initialize() throws SQLException 
	{
		JFrame alert = new JFrame();
		chef = new JFrame();//chef frame details
		chef.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		chef.getContentPane().setBackground(new Color(220, 20, 60));
		chef.setBackground(Color.DARK_GRAY);
		chef.setSize(2000,780);
		chef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
		chef.getContentPane().setLayout(null);
		
		
		JPanel sidebar_cf = new JPanel();//SIDE PANEL
		sidebar_cf.setBounds(0, 0, 173, 749);
		sidebar_cf.setBackground(new Color(0, 0, 0));
		chef.getContentPane().add(sidebar_cf);
		sidebar_cf.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		sidebar_cf.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel title_cf = new JPanel();//HEADING PANEL
		title_cf.setBounds(167, 32, 1203, 49);
		title_cf.setBackground(new Color(0, 0, 0));
		chef.getContentPane().add(title_cf);
		title_cf.setLayout(null);
		
		JLabel restaurantname_cf = new JLabel("RedFork  Restaurant -CHEF");//RESTAURANT NAME
		restaurantname_cf.setFont(new Font("Segoe Script", Font.BOLD, 20));
		restaurantname_cf.setForeground(Color.WHITE);
		restaurantname_cf.setBounds(105, 11, 542, 38);
		title_cf.add(restaurantname_cf);
		
		JButton BACK_cf = new JButton("BACK");//BACK BUTTON
		BACK_cf.setForeground(Color.WHITE);
		BACK_cf.setBackground(Color.BLACK);
		BACK_cf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BACK_cf.setBounds(1075, 11, 89, 23);
		title_cf.add(BACK_cf);
		
		JButton ViewOfficialDet_cf = new JButton("Update Personal Details");//View Official Details Buttons
		ViewOfficialDet_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers_cf.setVisible(true);
				persn_det_cf.setVisible(true);
				vmenu_cf.setVisible(false);
				off_det_cf.setVisible(false);
				vbrnch_det_cf.setVisible(false);
			}
		});
		ViewOfficialDet_cf.setBackground(Color.WHITE);
		ViewOfficialDet_cf.setBounds(10, 271, 153, 36);
		sidebar_cf.add(ViewOfficialDet_cf);
		
		JButton UpdateDet_cf = new JButton("View Official Details");//Update Official Details Button
		UpdateDet_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				off_det_cf.setVisible(true);
				vmenu_cf.setVisible(false);
				updt_pers_cf.setVisible(false);
				persn_det_cf.setVisible(false);
				vbrnch_det_cf.setVisible(false);
				
			}
		});
		UpdateDet_cf.setBackground(Color.WHITE);
		UpdateDet_cf.setBounds(10, 318, 153, 36);
		sidebar_cf.add(UpdateDet_cf);
		
		JButton ViewBranchDet_cf = new JButton("View Branch Details");//View Branch Details Button
		ViewBranchDet_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
				vbrnch_det_cf.setVisible(true);
				vmenu_cf.setVisible(false);
				updt_pers_cf.setVisible(false);
				persn_det_cf.setVisible(false);
				off_det_cf.setVisible(false);
				
				try 
				{
					AddHDetails("E1343", "H_CHEF");
				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			
			}
		});
		ViewBranchDet_cf.setBackground(Color.WHITE);
		ViewBranchDet_cf.setBounds(10, 224, 153, 36);
		sidebar_cf.add(ViewBranchDet_cf);
		
		JButton ViewMenu_cf = new JButton("View Menu");//View Menu button
		ViewMenu_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vmenu_cf.setVisible(true);
				updt_pers_cf.setVisible(false);
				persn_det_cf.setVisible(false);
				off_det_cf.setVisible(false);
				vbrnch_det_cf.setVisible(false);
			}
		});
		ViewMenu_cf.setBackground(Color.WHITE);
		ViewMenu_cf.setBounds(10, 365, 153, 36);
		sidebar_cf.add(ViewMenu_cf);
		
		
		Panel panel_cf = new Panel();
		panel_cf.setBackground(new Color(255, 255, 255));
		panel_cf.setBounds(199, 118, 1150, 571);
		chef.getContentPane().add(panel_cf);
		panel_cf.setLayout(null);
		
		//----------------------------------------View branch details panel------------------------------------------------------
		
				vbrnch_det_cf =new JPanel();
				vbrnch_det_cf.setVisible(false);
				vbrnch_det_cf.setBounds(258, 26, 621, 343);
				panel_cf.add(vbrnch_det_cf);
				vbrnch_det_cf.setLayout(null);
				
				JLabel vw_brnchdet_lbl_cf = new JLabel("View Branch Details:");//heading label
				vw_brnchdet_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 16));
				vw_brnchdet_lbl_cf.setBounds(45, 11, 700, 20);
				vbrnch_det_cf.add(vw_brnchdet_lbl_cf);
		
		//--------------------------------------update personal details panel--------------------------------------
		
		updt_pers_cf = new JPanel();//update personal details panel
		updt_pers_cf.setVisible(false);
		updt_pers_cf.setBounds(258, 344, 621, 194);
		panel_cf.add(updt_pers_cf);
		updt_pers_cf.setLayout(null);
		
		JLabel persndt_lbl_cf = new JLabel("Update Personal Details:");//heading label of panel
		persndt_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		persndt_lbl_cf.setBounds(6, 6, 220, 21);
		updt_pers_cf.add(persndt_lbl_cf);
		
		JLabel phone_lbl_cf = new JLabel("Phone:");//phone label
		phone_lbl_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phone_lbl_cf.setBounds(20, 43, 46, 14);
		updt_pers_cf.add(phone_lbl_cf);
		
		JTextField phone_txt_cf = new JTextField(null);// phone text field
		phone_txt_cf.setBounds(155, 43, 245, 20);
		updt_pers_cf.add(phone_txt_cf);
		phone_txt_cf.setColumns(10);
		
		JLabel addr_lbl_cf = new JLabel("Address:");//address label
		addr_lbl_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addr_lbl_cf.setBounds(20, 83, 80, 14);
		updt_pers_cf.add(addr_lbl_cf);
		
		JTextField addr_txt_cf = new JTextField(null);// phone text field
		addr_txt_cf.setBounds(155, 83, 245, 20);
		updt_pers_cf.add(addr_txt_cf);
		addr_txt_cf.setColumns(10);
		
		JButton updatebtn_cf = new JButton("Update");//update button
		updatebtn_cf.setForeground(Color.WHITE);
		updatebtn_cf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn_cf.setBackground(Color.BLACK);
		updatebtn_cf.setBounds(440, 150, 120, 23);
		updt_pers_cf.add(updatebtn_cf);
		updatebtn_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phn,add;
				
				try {
					phn = phone_txt_cf.getText();
				}
				catch(Exception phnE) {
					phn = "";
				}
				try {
					add = addr_txt_cf.getText();
				}
				catch(Exception addE) {
					add = "";
				}
				
				try {
					cobj.UpdatePersonaldetails(phn, add);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				phone_lbl_cf.setText("Phone: " + phn);
				addr_lbl_cf.setText("Address: " + add);
				JOptionPane.showMessageDialog(alert,"Updated !!");
			}
		});
		//-----------------------view personal details-----------------
		
		Object[] Details = cobj.ViewPersonaldetails();
		
		persn_det_cf = new JPanel();
		persn_det_cf.setBounds(258, 50, 621, 194);
		persn_det_cf.setVisible(false);
		panel_cf.add(persn_det_cf);
		persn_det_cf.setLayout(null);
		
		JLabel persn_det_cf_lbl = new JLabel("Personal Details:");
		persn_det_cf_lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		persn_det_cf_lbl.setBounds(10, 11, 300, 20);
		persn_det_cf.add(persn_det_cf_lbl);
		
		JLabel name_lbl = new JLabel("Name:"+Details[0] + " " + Details[1]);
		name_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		name_lbl.setBounds(30, 53, 300, 14);
		persn_det_cf.add(name_lbl);
		
		JLabel doj_lbl = new JLabel("DOJ :"+ Details[2]);
		doj_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		doj_lbl.setBounds(30, 78, 300, 14);
		persn_det_cf.add(doj_lbl);
		
		JLabel add_lbl = new JLabel("Address :"+ Details[3]);
		add_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		add_lbl.setBounds(30, 103, 300, 14);
		persn_det_cf.add(add_lbl);
		
		JLabel phn_lbl = new JLabel("Phone :" +Details[4]);
		phn_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phn_lbl.setBounds(30, 128, 300, 14);
		persn_det_cf.add(phn_lbl);
		

		
		//-------------------------------------View Official details panel-----------------------------------------
		
		Object[] dets = cobj.ViewOfficialdetails();
		off_det_cf = new JPanel();
		off_det_cf.setBounds(258, 50, 621, 194);
		off_det_cf.setVisible(false);
		panel_cf.add(off_det_cf);
		off_det_cf.setLayout(null);
		 
			JLabel off_cf = new JLabel("Official details:");
			off_cf.setFont(new Font("Times New Roman", Font.BOLD, 16));
			off_cf.setBounds(10, 11, 800, 20);
			off_det_cf.add(off_cf);
			
			JLabel ssn_cf = new JLabel("SSN:" + dets[0]);
			ssn_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			ssn_cf.setBounds(30, 53, 800, 20);
			off_det_cf.add(ssn_cf);
			
			JLabel desig_cf = new JLabel("Designation:"+ dets[1]);
			desig_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			desig_cf.setBounds(30, 93, 800, 14);
			off_det_cf.add(desig_cf);
			
			JLabel spec_cf = new JLabel("Specification :"+ dets[3]);
			spec_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			spec_cf.setBounds(30, 133, 800, 14);
			off_det_cf.add(spec_cf);
			
			JLabel wrkplc_cf = new JLabel("Workplace :"+dets[4]);
			wrkplc_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			wrkplc_cf.setBounds(30, 173, 800, 14);
			off_det_cf.add(wrkplc_cf);
			
			JLabel sal_cf = new JLabel("Salary :"+dets[3]);
			sal_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			sal_cf.setBounds(30, 210, 800, 14);
			off_det_cf.add(sal_cf);
		
		//----------------------------------------view menu panel------------------------------------------
		
		
		vmenu_cf = new JPanel();
		vmenu_cf.setVisible(false);
		vmenu_cf.setBounds(258, 26, 621, 343);
		panel_cf.add(vmenu_cf);
		vmenu_cf.setLayout(null);
		
		JLabel vw_menu_lbl_cf = new JLabel("View Menu:");
		vw_menu_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		vw_menu_lbl_cf.setBounds(45, 11, 100, 20);
		vmenu_cf.add(vw_menu_lbl_cf);
		
		String[] columns = new String[] {"Slno.", "Dish Name", "Price"};
		//actual data for the table_cf in a 2d array
		Object[][] data = populate_menu();
		
		JLabel slno_lbl_cf = new JLabel("Slno:");
		slno_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		slno_lbl_cf.setBounds(50, 53, 800, 20);
		vmenu_cf.add(slno_lbl_cf);
		
		JLabel dname_lbl_cf = new JLabel("Dish Name:");
		dname_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dname_lbl_cf.setBounds(230, 53, 800, 20);
		vmenu_cf.add(dname_lbl_cf);
		
		JLabel dprice_lbl_cf = new JLabel("Price:");
		dprice_lbl_cf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dprice_lbl_cf.setBounds(420, 53, 800, 20);
		vmenu_cf.add(dprice_lbl_cf);

		//create table_cf with data
		JTable table_cf = new JTable(data, columns);
		table_cf.setBounds(50, 80, 550, 48);
	
		vmenu_cf.add(table_cf);
		
		
		
		
	}
	//-----------------------------------------functions-----------------------------------
	
	public Object[][] populate_menu() throws SQLException {
		Object[][] dishInfo = new Object[10][10];
		dishInfo = mobj.ViewMenu("E1343");
		return dishInfo;
	}
	
	
	
	public void AddHDetails(String ssn, String desig) throws Exception {
		HData = hobj.ViewBranchDetails(ssn, desig);
    	
    	JLabel hid_viwbrch=new JLabel();	
		hid_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		hid_viwbrch.setBounds(6, 40, 300, 20);	
		vbrnch_det_cf.add(hid_viwbrch);	
			
		JLabel hname_viwbrch=new JLabel();	
		hname_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		hname_viwbrch.setBounds(6, 70, 300, 20);	
		vbrnch_det_cf.add(hname_viwbrch);	
			
		JLabel strtdt_viwbrch=new JLabel();	
		strtdt_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		strtdt_viwbrch.setBounds(6, 100, 300, 20);	
		vbrnch_det_cf.add(strtdt_viwbrch);	
			
		JLabel location_viwbrch=new JLabel();	
		location_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		location_viwbrch.setBounds(6, 130, 300, 20);	
		vbrnch_det_cf.add(location_viwbrch);	

		
		hid_viwbrch.setText("Hotel ID: " + HData[0]);
		hname_viwbrch.setText("Name: " + HData[1]);
		strtdt_viwbrch.setText("Start Date: " + HData[2]);
		location_viwbrch.setText("Location: " + HData[3] + ", " + HData[4]);
	}
	
}
