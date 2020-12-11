package backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class headchef {

	private JFrame h_chef;
	
	JPanel persn_det;
	JPanel updt_pers_hcf;
	JPanel off_det_hcf;
	JPanel add_dish_hcf;
	JPanel vmenu_hcf;
	JPanel vbrnch_det_hcf;
	
	Object[] HData;
	hotel hobj;
	Menu mobj;
	chef cobj;
	Dishes dobj;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					headchef window = new headchef();
					window.h_chef.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public headchef() throws Exception {
		hobj = new hotel();
		hobj.init();
		cobj = new chef("E2792");
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
		h_chef = new JFrame();//h_chef frame details
		h_chef.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		h_chef.getContentPane().setBackground(new Color(220, 20, 60));
		h_chef.setBackground(Color.DARK_GRAY);
		h_chef.setSize(2000,780);
		h_chef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
		h_chef.getContentPane().setLayout(null);
		
		
		JPanel sidebar_hcf = new JPanel();//SIDE PANEL
		sidebar_hcf.setBounds(0, 0, 173, 749);
		sidebar_hcf.setBackground(new Color(0, 0, 0));
		h_chef.getContentPane().add(sidebar_hcf);
		sidebar_hcf.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		sidebar_hcf.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel title_hcf = new JPanel();//HEADING PANEL
		title_hcf.setBounds(167, 32, 1203, 49);
		title_hcf.setBackground(new Color(0, 0, 0));
		h_chef.getContentPane().add(title_hcf);
		title_hcf.setLayout(null);
		
		JLabel restaurantname = new JLabel("RedFork  Restaurant -HEAD CHEF");//RESTAURANT NAME
		restaurantname.setFont(new Font("Segoe Script", Font.BOLD, 20));
		restaurantname.setForeground(Color.WHITE);
		restaurantname.setBounds(105, 11, 542, 38);
		title_hcf.add(restaurantname);
		
		JButton BACK = new JButton("BACK");//BACK BUTTON
		BACK.setForeground(Color.WHITE);
		BACK.setBackground(Color.BLACK);
		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BACK.setBounds(1075, 11, 89, 23);
		title_hcf.add(BACK);
		
		JButton ViewOfficialDet_hcf = new JButton("Update Personal Details");//View Official Details Buttons
		ViewOfficialDet_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers_hcf.setVisible(true);
				persn_det.setVisible(true);
				off_det_hcf.setVisible(false);
				add_dish_hcf.setVisible(false);
				vmenu_hcf.setVisible(false);
				vbrnch_det_hcf.setVisible(false);
			}
		});
		ViewOfficialDet_hcf.setBackground(Color.WHITE);
		ViewOfficialDet_hcf.setBounds(10, 271, 153, 36);
		sidebar_hcf.add(ViewOfficialDet_hcf);
		
		JButton UpdateDet_hcf = new JButton("View Official Details");//Update Official Details Button
		UpdateDet_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				off_det_hcf.setVisible(true);
				updt_pers_hcf.setVisible(false);
				persn_det.setVisible(false);
				add_dish_hcf.setVisible(false);
				vmenu_hcf.setVisible(false);
				vbrnch_det_hcf.setVisible(false);
			}
		});
		UpdateDet_hcf.setBackground(Color.WHITE);
		UpdateDet_hcf.setBounds(10, 318, 153, 36);
		sidebar_hcf.add(UpdateDet_hcf);
		
		JButton ViewBranchDet_hcf = new JButton("View Branch Details");//View Branch Details Button
		ViewBranchDet_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				vbrnch_det_hcf.setVisible(true);
				vmenu_hcf.setVisible(false);
				add_dish_hcf.setVisible(false);
				off_det_hcf.setVisible(false);
				updt_pers_hcf.setVisible(false);
				persn_det.setVisible(false);
				
				try {
					AddHDetails("E2792", "H_CHEF");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ViewBranchDet_hcf.setBackground(Color.WHITE);
		ViewBranchDet_hcf.setBounds(10, 224, 153, 36);
		sidebar_hcf.add(ViewBranchDet_hcf);
		
		JButton ViewMenu_hcf = new JButton("View Menu");//View Menu button
		ViewMenu_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vmenu_hcf.setVisible(true);
				add_dish_hcf.setVisible(false);
				off_det_hcf.setVisible(false);
				updt_pers_hcf.setVisible(false);
				persn_det.setVisible(false);
				vbrnch_det_hcf.setVisible(false);
			}
		});
		ViewMenu_hcf.setBackground(Color.WHITE);
		ViewMenu_hcf.setBounds(10, 365, 153, 36);
		sidebar_hcf.add(ViewMenu_hcf);
		
		JButton UpdateDishes_hcf = new JButton("Add Dishes");//Update dishes button
		UpdateDishes_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_dish_hcf.setVisible(true);
				off_det_hcf.setVisible(false);
				updt_pers_hcf.setVisible(false);
				persn_det.setVisible(false);
				vmenu_hcf.setVisible(false);
				vbrnch_det_hcf.setVisible(false);
			}
		});
		UpdateDishes_hcf.setBackground(Color.WHITE);
		UpdateDishes_hcf.setBounds(10, 412, 153, 36);
		sidebar_hcf.add(UpdateDishes_hcf);
		
		Panel panel_hcf = new Panel();
		panel_hcf.setBackground(new Color(255, 255, 255));
		panel_hcf.setBounds(199, 118, 1150, 571);
		h_chef.getContentPane().add(panel_hcf);
		
		//------------------------------------------update personal details panel-------------------------------------
		updt_pers_hcf = new JPanel();
		updt_pers_hcf.setBounds(258, 298, 621, 194);
		updt_pers_hcf.setVisible(false);
		panel_hcf.setLayout(null);
		panel_hcf.add(updt_pers_hcf);
		updt_pers_hcf.setLayout(null);
		
		JLabel persndt_lbl_hcf = new JLabel("Update Personal Details:");//heading label of panel
		persndt_lbl_hcf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		persndt_lbl_hcf.setBounds(6, 6, 220, 21);
		updt_pers_hcf.add(persndt_lbl_hcf);
		
		JLabel phone_lbl_cf = new JLabel("Phone:");//phone label
		phone_lbl_cf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phone_lbl_cf.setBounds(20, 43, 46, 14);
		updt_pers_hcf.add(phone_lbl_cf);
		
		JTextField phone_txt_hcf = new JTextField(null);// phone text field
		phone_txt_hcf.setBounds(155, 43, 245, 20);
		updt_pers_hcf.add(phone_txt_hcf);
		phone_txt_hcf.setColumns(10);
		
		JLabel addr_lbl_hcf = new JLabel("Address:");//address label
		addr_lbl_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addr_lbl_hcf.setBounds(20, 83, 80, 14);
		updt_pers_hcf.add(addr_lbl_hcf);
		
		JTextField addr_txt_hcf = new JTextField(null);// phone text field
		addr_txt_hcf.setBounds(155, 83, 245, 20);
		updt_pers_hcf.add(addr_txt_hcf);
		addr_txt_hcf.setColumns(10);
		
		JButton updatebtn_hcf = new JButton("Update");//update button
		updatebtn_hcf.setForeground(Color.WHITE);
		updatebtn_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn_hcf.setBackground(Color.BLACK);
		updatebtn_hcf.setBounds(440, 150, 120, 23);
		updt_pers_hcf.add(updatebtn_hcf);
		
		updatebtn_hcf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phn,add;
				
				try {
					phn = phone_txt_hcf.getText();
				}
				catch(Exception phnE) {
					phn = "";
				}
				try {
					add = addr_txt_hcf.getText();
				}
				catch(Exception addE) {
					add = "";
				}
				
				try {
					cobj.UpdatePersonaldetails(phn, add);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				phone_lbl_cf.setText("Phone: " + phn);
				addr_lbl_hcf.setText("Address: " + add);
				JOptionPane.showMessageDialog(alert,"Updated !!");
			}
		});
		
		
		//-------------------------------personal details panel--------------------------------------------
		
		Object[] Details = cobj.ViewPersonaldetails();
		
		 persn_det = new JPanel();
		 persn_det.setBounds(258, 50, 621, 194);
		 persn_det.setVisible(false);
		 panel_hcf.add(persn_det);
		 persn_det.setLayout(null);
		
		JLabel persn_det_lbl1 = new JLabel("Personal Details:");
		persn_det_lbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		persn_det_lbl1.setBounds(10, 11, 137, 20);
		persn_det.add(persn_det_lbl1);
		
		JLabel name_lbl1 = new JLabel("Name: " + Details[0] + " " + Details[1]);
		name_lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		name_lbl1.setBounds(30, 53, 300, 14);
		persn_det.add(name_lbl1);
		
		JLabel doj_lbl1 = new JLabel("DOJ :" + Details[2]);
		doj_lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		doj_lbl1.setBounds(30, 78, 300, 14);
		persn_det.add(doj_lbl1);
		
		JLabel add_lbl1 = new JLabel("Address :" + Details[3]);
		add_lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		add_lbl1.setBounds(30, 103, 300, 14);
		persn_det.add(add_lbl1);
		
		JLabel phn_lbl1 = new JLabel("Phone :" +  Details[4]);
		phn_lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phn_lbl1.setBounds(30, 128, 300, 14);
		persn_det.add(phn_lbl1);
		
		//-------------------------------------add dish----------------------------------------
		
		add_dish_hcf = new JPanel();
		add_dish_hcf.setBounds(258, 68, 621, 227);
		panel_hcf.add(add_dish_hcf);
		add_dish_hcf.setVisible(false);
		add_dish_hcf.setLayout(null);
		
		
		JLabel add_dish_hcf_lbl = new JLabel("Add Dish:");//heading label of panel
		add_dish_hcf_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add_dish_hcf_lbl.setBounds(42, 5, 78, 21);
		add_dish_hcf.add(add_dish_hcf_lbl);
		
		JLabel dishid_hcf = new JLabel("Dish id:");//dish id label
		dishid_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dishid_hcf.setBounds(52, 36, 43, 17);
		add_dish_hcf.add(dishid_hcf);
		
		JTextField dishid_txt_hcf = new JTextField(null);// dish id text field
		dishid_txt_hcf.setBounds(130, 35, 200, 20);
		add_dish_hcf.add(dishid_txt_hcf);
		dishid_txt_hcf.setColumns(10);
		
		JLabel dish_name_hcf = new JLabel("Dish Name:");//dish name label
		dish_name_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dish_name_hcf.setBounds(54, 67, 66, 17);
		add_dish_hcf.add(dish_name_hcf);
		
		JTextField dname_txt_hcf = new JTextField(null);// dish name text field
		dname_txt_hcf.setBounds(130, 66, 200, 20);
		add_dish_hcf.add(dname_txt_hcf);
		dname_txt_hcf.setColumns(10);
		
		JLabel dish_price_hcf = new JLabel("Dish Price:");//dish name label
		dish_price_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dish_price_hcf.setBounds(52, 95, 62, 17);
		add_dish_hcf.add(dish_price_hcf);
		
		JTextField dprice_txt_hcf = new JTextField(null);// dish name text field
		dprice_txt_hcf.setBounds(130, 97, 200, 20);
		add_dish_hcf.add(dprice_txt_hcf);
		dprice_txt_hcf.setColumns(10);
		
		JButton Addbtn_cf = new JButton("Add Dish");//add dish button
		Addbtn_cf.setForeground(Color.WHITE);
		Addbtn_cf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Addbtn_cf.setBackground(Color.BLACK);
		Addbtn_cf.setBounds(490, 157, 100, 27);
		add_dish_hcf.add(Addbtn_cf);
		
		Addbtn_cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dishID = dishid_txt_hcf.getText();
				String DName = dname_txt_hcf.getText();
				Double price = Double.valueOf(dprice_txt_hcf.getText());
				
				try {
					dobj.Adddish(dishID, DName, price);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(alert,"New Dish Added !!");
			}
		});
		
	
		//------------------------------------View official Details-----------------------------------------
		 off_det_hcf = new JPanel();
		 off_det_hcf.setBounds(258, 50, 621, 194);
		 off_det_hcf.setVisible(false);
		 panel_hcf.add(off_det_hcf);
		 off_det_hcf.setLayout(null);
		 
		 Object[] dets = cobj.ViewOfficialdetails();

			JLabel off_hcf = new JLabel("Official details: ");
			off_hcf.setFont(new Font("Times New Roman", Font.BOLD, 16));
			off_hcf.setBounds(10, 11, 800, 20);
			off_det_hcf.add(off_hcf);
			
			JLabel ssn_hcf = new JLabel("SSN: " + dets[0]);
			ssn_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			ssn_hcf.setBounds(30, 53, 800, 20);
			off_det_hcf.add(ssn_hcf);
			
			JLabel desig_hcf = new JLabel("Designation: " + dets[1]);
			desig_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			desig_hcf.setBounds(30, 93, 800, 14);
			off_det_hcf.add(desig_hcf);
			
			JLabel spec_hcf = new JLabel("Specialisation: " + dets[3]);
			spec_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			spec_hcf.setBounds(30, 133, 800, 14);
			off_det_hcf.add(spec_hcf);
			
			JLabel wrkplc_hcf = new JLabel("Workplace :" + dets[4]);
			wrkplc_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			wrkplc_hcf.setBounds(30, 173, 800, 14);
			off_det_hcf.add(wrkplc_hcf);
			
			JLabel sal_hcf = new JLabel("Salary :" + dets[3]);
			sal_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			sal_hcf.setBounds(30, 210, 800, 14);
			off_det_hcf.add(sal_hcf);
			
			//-------------------------------View menu panel--------------------------------------------

			
			vmenu_hcf = new JPanel();
			vmenu_hcf.setVisible(false);
			vmenu_hcf.setBounds(258, 26, 621, 343);
			panel_hcf.add(vmenu_hcf);
			vmenu_hcf.setLayout(null);
			
			JLabel vw_menu_lbl = new JLabel("View Menu:");
			vw_menu_lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
			vw_menu_lbl.setBounds(45, 11, 100, 20);
			vmenu_hcf.add(vw_menu_lbl);
			
			String[] columns = new String[] {"Slno.", "Dish Name", "Price"};
			//actual data for the table in a 2d array
			Object[][] data = populate_menu();
											
			
			JLabel slno_lbl = new JLabel("Slno:");
			slno_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
			slno_lbl.setBounds(50, 53, 800, 20);
			vmenu_hcf.add(slno_lbl);
			
			JLabel dname_lbl = new JLabel("Dish Name:");
			dname_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
			dname_lbl.setBounds(230, 53, 800, 20);
			vmenu_hcf.add(dname_lbl);
			
			JLabel dprice_lbl = new JLabel("Price:");
			dprice_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
			dprice_lbl.setBounds(420, 53, 800, 20);
			vmenu_hcf.add(dprice_lbl);
	
			//create table with data
			JTable table = new JTable(data, columns);
			table.setBounds(50, 80, 550, 48);
		
			vmenu_hcf.add(table);
			
			//----------------------------------------View branch details panel------------------------------------------------------		
			
			vbrnch_det_hcf =new JPanel();
			vbrnch_det_hcf.setVisible(false);
			vbrnch_det_hcf.setBounds(258, 26, 621, 200);
			panel_hcf.add(vbrnch_det_hcf);
			vbrnch_det_hcf.setLayout(null);
			
			JLabel vw_brnchdet_lbl = new JLabel("View Branch Details:");//heading label
			vw_brnchdet_lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
			vw_brnchdet_lbl.setBounds(45, 11, 700, 20);
			vbrnch_det_hcf.add(vw_brnchdet_lbl);
			
			

	}
	
	public Object[][] populate_menu() throws SQLException {
		Object[][] dishInfo = new Object[10][10];
		dishInfo = mobj.ViewMenu("E2792");
		return dishInfo;
	}


	public void AddHDetails(String ssn, String desig) throws Exception {
		HData = hobj.ViewBranchDetails(ssn, desig);
    	
    	JLabel hid_viwbrch=new JLabel();	
		hid_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		hid_viwbrch.setBounds(6, 40, 300, 20);	
		vbrnch_det_hcf.add(hid_viwbrch);	
			
		JLabel hname_viwbrch=new JLabel();	
		hname_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		hname_viwbrch.setBounds(6, 70, 300, 20);	
		vbrnch_det_hcf.add(hname_viwbrch);	
			
		JLabel strtdt_viwbrch=new JLabel();	
		strtdt_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		strtdt_viwbrch.setBounds(6, 100, 300, 20);	
		vbrnch_det_hcf.add(strtdt_viwbrch);	
			
		JLabel location_viwbrch=new JLabel();	
		location_viwbrch.setFont(new Font("Times New Roman", Font.PLAIN, 16));	
		location_viwbrch.setBounds(6, 130, 300, 20);	
		vbrnch_det_hcf.add(location_viwbrch);	

		
		hid_viwbrch.setText("Hotel ID: " + HData[0]);
		hname_viwbrch.setText("Name: " + HData[1]);
		strtdt_viwbrch.setText("Start Date: " + HData[2]);
		location_viwbrch.setText("Location: " + HData[3] + ", " + HData[4]);
	}
	
}


