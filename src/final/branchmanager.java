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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class branchmanager {

	private JFrame branchmanager;
	Manager obj;
	Dishes dobj;
	JPanel updt_persbm;
	JPanel updt_pricebm;
	JPanel persn_det;
	JPanel officialDetailsBM;

	public branchmanager(String ssn) throws Exception {
		obj = new Manager(ssn);
		dobj = new Dishes();
		obj.init();
		dobj.init();
		initialize();
	}

	private void initialize() throws SQLException 
	{
		JFrame alert=new JFrame();
		branchmanager = new JFrame();//branchmanager frame details
		branchmanager.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		branchmanager.getContentPane().setBackground(new Color(220, 20, 60));
		branchmanager.setBackground(Color.DARK_GRAY);
		branchmanager.setSize(2000,780);
		branchmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
		branchmanager.getContentPane().setLayout(null);
		branchmanager.setVisible(true);
		
		JPanel sidebar = new JPanel();//SIDE PANEL
		sidebar.setBounds(0, 0, 173, 749);
		sidebar.setBackground(new Color(0, 0, 0));
		branchmanager.getContentPane().add(sidebar);
		sidebar.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		sidebar.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel title = new JPanel();//HEADING PANEL
		title.setBounds(167, 32, 1203, 49);
		title.setBackground(new Color(0, 0, 0));
		branchmanager.getContentPane().add(title);
		title.setLayout(null);
		
		JLabel restaurantname = new JLabel("RedFork  Restaurant -BRANCH MANAGER");//RESTAURANT NAME
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
		
		JButton ViewOfficialDet = new JButton("View Official Details");
		ViewOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_persbm.setVisible(false);
				updt_pricebm.setVisible(false);
				persn_det.setVisible(false);
				officialDetailsBM.setVisible(true);
			}
		});
		ViewOfficialDet.setBackground(Color.WHITE);
		ViewOfficialDet.setBounds(10, 271, 153, 36);
		sidebar.add(ViewOfficialDet);
		
		JButton UpdateOfficialDet = new JButton("Update Personal Details ");
		UpdateOfficialDet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		UpdateOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_persbm.setVisible(true);
				updt_pricebm.setVisible(false);
				persn_det.setVisible(true);
				officialDetailsBM.setVisible(false);
				
			}
		});
		UpdateOfficialDet.setBackground(Color.WHITE);
		UpdateOfficialDet.setBounds(10, 224, 153, 36);
		sidebar.add(UpdateOfficialDet);
		
		JButton UpdatePrices = new JButton("Update Prices");
		UpdatePrices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pricebm.setVisible(true);
				updt_persbm.setVisible(false);
				persn_det.setVisible(false);
				officialDetailsBM.setVisible(false);
				
			}
		});
		UpdatePrices.setBackground(Color.WHITE);
		UpdatePrices.setBounds(10, 318, 153, 36);
		sidebar.add(UpdatePrices);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(167, 32, 1203, 49);
		panel_1.setBackground(new Color(0, 0, 0));
		branchmanager.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(199, 118, 1150, 571);
		branchmanager.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		
		//------------------------------------update personal details panel-----------------------------------------------
		
		updt_persbm = new JPanel();//update personal details panel
		updt_persbm.setVisible(false);
		updt_persbm.setBounds(258, 298, 621, 194);
		panel_4.add(updt_persbm);
		updt_persbm.setLayout(null);
		
		Object[] Details = obj.ViewPersonaldetails();
		
		persn_det = new JPanel();
		persn_det.setVisible(false);
		persn_det.setBounds(258, 50, 621, 194);
		panel_4.add(persn_det);
		persn_det.setLayout(null);
		
		JLabel persn_det_lbl = new JLabel("Personal Details:");
		persn_det_lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		persn_det_lbl.setBounds(10, 11, 137, 20);
		persn_det.add(persn_det_lbl);
		
		JLabel name_lbl = new JLabel("Name: " + Details[0] + " " + Details[1]);
		name_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		name_lbl.setBounds(30, 53, 400, 14);
		persn_det.add(name_lbl);
		
		JLabel doj_lbl = new JLabel("DOJ :" + Details[2]);
		doj_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		doj_lbl.setBounds(30, 78, 150, 14);
		persn_det.add(doj_lbl);
		
		JLabel add_lbl = new JLabel("Address :" + Details[3]);
		add_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		add_lbl.setBounds(30, 103, 150, 14);
		persn_det.add(add_lbl);
		
		JLabel phn_lbl = new JLabel("Phone :" + Details[4]);
		phn_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phn_lbl.setBounds(30, 128, 150, 14);
		persn_det.add(phn_lbl);
		
		JLabel pers_dtbm_lbl = new JLabel("Update Personal Details:");//heading label of panel
		pers_dtbm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pers_dtbm_lbl.setBounds(6, 6, 220, 21);
		updt_persbm.add(pers_dtbm_lbl);
		
		JLabel phonebm_lbl = new JLabel("Phone:");//phone label
		phonebm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phonebm_lbl.setBounds(20, 43, 46, 14);
		updt_persbm.add(phonebm_lbl);
		
		JTextField phonebm_txt = new JTextField(null);// phone text field
		phonebm_txt.setBounds(155, 43, 245, 20);
		updt_persbm.add(phonebm_txt);
		phonebm_txt.setColumns(10);
		
		JLabel addrbm_lbl = new JLabel("Address:");//address label
		addrbm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addrbm_lbl.setBounds(20, 83, 80, 14);
		updt_persbm.add(addrbm_lbl);
		
		JTextField addrbm_txt = new JTextField(null);// phone text field
		addrbm_txt.setBounds(155, 83, 245, 20);
		updt_persbm.add(addrbm_txt);
		addrbm_txt.setColumns(10);
		
		JButton updatebm = new JButton("Update");//update button
		updatebm.setForeground(Color.WHITE);
		updatebm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebm.setBackground(Color.BLACK);
		updatebm.setBounds(440, 150, 120, 23);
		updt_persbm.add(updatebm);
		
		updatebm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phn,add;
				try {
					phn = phonebm_txt.getText();
				}
				catch(Exception phnE) {
					phn = "";
				}
				try {
					add = addrbm_txt.getText();
				}
				catch(Exception addE) {
					add = "";
				}
				
				try {
					obj.UpdatePersonaldetails(phn, add);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				phn_lbl.setText("Phone: " + phn);
				add_lbl.setText("Address: " + add);
				JOptionPane.showMessageDialog(alert,"Updated !!");
			}
		});
		
		//------------------------------------Update Prices panel--------------------------------------------
		
		updt_pricebm = new JPanel();//update price  panel
		updt_pricebm.setVisible(false);
		updt_pricebm.setBounds(255, 62, 621, 194);
		panel_4.add(updt_pricebm);
		updt_pricebm.setLayout(null);
		
		JLabel pricebm_lbl = new JLabel("Update Price :");//heading label of panel
		pricebm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pricebm_lbl.setBounds(6, 6, 220, 21);
		updt_pricebm.add(pricebm_lbl);
		
		JLabel dishid_bm_lbl = new JLabel("Dish Id:");//dish id label
		dishid_bm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dishid_bm_lbl.setBounds(20, 43, 46, 14);
		updt_pricebm.add(dishid_bm_lbl);
		
		JTextField dishid_bm_txt = new JTextField(null);// dish id text field
		dishid_bm_txt.setBounds(155, 43, 245, 20);
		updt_pricebm.add(dishid_bm_txt);
		dishid_bm_txt.setColumns(10);
		
		JLabel updtpricebm_lbl = new JLabel("Updated Price:");//updated price label
		updtpricebm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		updtpricebm_lbl.setBounds(20, 83, 100, 14);
		updt_pricebm.add(updtpricebm_lbl);
		
		JTextField updtprice_bm_txt = new JTextField(null);// updated price  text field
		updtprice_bm_txt.setBounds(155, 83, 245, 20);
		updt_pricebm.add(updtprice_bm_txt);
		updtprice_bm_txt.setColumns(10);
		
		JButton updatebtn4 = new JButton("Update");//update button
		updatebtn4.setForeground(Color.WHITE);
		updatebtn4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn4.setBackground(Color.BLACK);
		updatebtn4.setBounds(440, 150, 120, 23);
		updt_pricebm.add(updatebtn4);
		
		updatebtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DishId=null;
				Double newPrice=0.0;
				
				try {
					DishId = dishid_bm_txt.getText();
					newPrice = Double.valueOf(updtprice_bm_txt.getText());
					if(DishId.isEmpty()) {
						throw new Exception();
					}
				}
				
				catch(Exception DishE) {
					JOptionPane.showMessageDialog(alert,"Fields Should not be empty");
				}
				try {
					dobj.UpdatePrice(DishId, newPrice);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(alert,"Updated !!");
			}
		});
	
	
	
	//------------------------------------- View Official Details ----------------------
	
		 officialDetailsBM = new JPanel();
		 officialDetailsBM.setVisible(false);
		 officialDetailsBM.setBounds(258, 50, 621, 194);
		 panel_4.add(officialDetailsBM);
		 officialDetailsBM.setLayout(null);
		 
		 Object[] dets = obj.ViewOfficialdetails();
		 
		 JLabel heading = new JLabel("View Official Details");
		 heading.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 heading.setBounds(10, 11, 300, 20);
		 officialDetailsBM.add(heading);
		 
		JLabel ssn_hcf = new JLabel("SSN: " + dets[0]);
		ssn_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssn_hcf.setBounds(30, 53, 137, 20);
		officialDetailsBM.add(ssn_hcf);
		
		JLabel desig_hcf = new JLabel("Designation: " + dets[1]);
		desig_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		desig_hcf.setBounds(30, 78, 300, 14);
		officialDetailsBM.add(desig_hcf);
		
		JLabel wrkplc_hcf = new JLabel("Workplace :" + dets[3]);
		wrkplc_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wrkplc_hcf.setBounds(30, 103, 300, 14);
		officialDetailsBM.add(wrkplc_hcf);
		
		JLabel sal_hcf = new JLabel("Salary :" + dets[2]);
		sal_hcf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sal_hcf.setBounds(30, 127, 300, 14);
		officialDetailsBM.add(sal_hcf);
	}
}

