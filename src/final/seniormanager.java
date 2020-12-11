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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class seniormanager 
{

	private JFrame seniormanager;
	
	JPanel updt_pers_sm;
	JPanel updt_pricesm;
	JPanel profitsm;
	JPanel maintenancesm;
	JPanel updt_offdt_sm;
	JPanel off_det_sm;
	JPanel persn_det_sm;
	
	String HName;
	
	Manager mobj;
	Dishes dobj;
	hotel hobj;

	public seniormanager(String ssn) throws Exception{
		mobj = new Manager(ssn);
		mobj.init();
		dobj = new Dishes();
		dobj.init();
		hobj = new hotel();
		hobj.init();
		initialize();
	}

	
	private void initialize() throws SQLException 
	{
		JFrame alert = new JFrame();
		seniormanager = new JFrame();//senior manager frame details
		seniormanager.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		seniormanager.getContentPane().setBackground(new Color(220, 20, 60));
		seniormanager.setBackground(Color.DARK_GRAY);
		seniormanager.setSize(2000,780);
		seniormanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		seniormanager.setVisible(true);
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
		seniormanager.getContentPane().setLayout(null);
		
		
		JPanel sidebar = new JPanel();//SIDE PANEL
		sidebar.setBounds(0, 0, 173, 749);
		sidebar.setBackground(new Color(0, 0, 0));
		seniormanager.getContentPane().add(sidebar);
		sidebar.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		sidebar.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
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

		
		ViewOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				off_det_sm.setVisible(true);
				updt_pers_sm.setVisible(false);
				updt_pricesm.setVisible(false);
				profitsm.setVisible(false);
				maintenancesm.setVisible(false);
				updt_offdt_sm.setVisible(false);
			}
		});
		
		JButton UpdateOfficialDet = new JButton("Update Personal Details");//Update Personal Details Button
		UpdateOfficialDet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pers_sm.setVisible(true);
				updt_pricesm.setVisible(false);
				profitsm.setVisible(false);
				maintenancesm.setVisible(false);
				updt_offdt_sm.setVisible(false);
				off_det_sm.setVisible(false);
			}
		});
		UpdateOfficialDet.setBackground(Color.WHITE);
		UpdateOfficialDet.setBounds(10, 224, 153, 36);
		sidebar.add(UpdateOfficialDet);
		
		JButton UpdatePrices_sm = new JButton("Update Prices");//Update Prices Button
		UpdatePrices_sm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_pricesm.setVisible(true);
				updt_pers_sm.setVisible(false);
				profitsm.setVisible(false);
				maintenancesm.setVisible(false);
				updt_offdt_sm.setVisible(false);
				off_det_sm.setVisible(false);
			}
		});
		UpdatePrices_sm.setBackground(Color.WHITE);
		UpdatePrices_sm.setBounds(10, 318, 153, 36);
		sidebar.add(UpdatePrices_sm);
		
		JButton profitabilitysm = new JButton("Profitability");//profitsmability Button
		profitabilitysm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				profitsm.setVisible(true);
				updt_pricesm.setVisible(false);
				updt_pers_sm.setVisible(false);
				maintenancesm.setVisible(false);
				updt_offdt_sm.setVisible(false);
				off_det_sm.setVisible(false);
			}
		});
		profitabilitysm.setBackground(Color.WHITE);
		profitabilitysm.setBounds(10, 365, 153, 36);
		sidebar.add(profitabilitysm);
		
		JButton CheckMaint_sm = new JButton("Check maintenancesm ");//Check maintenancesm Button
		CheckMaint_sm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				maintenancesm.setVisible(true);
				profitsm.setVisible(false);
				updt_pricesm.setVisible(false);
				updt_pers_sm.setVisible(false);
				updt_offdt_sm.setVisible(false);
				off_det_sm.setVisible(false);
			}
		});
		CheckMaint_sm.setBackground(Color.WHITE);
		CheckMaint_sm.setBounds(10, 412, 153, 36);
		sidebar.add(CheckMaint_sm);
		
		JButton UpdateDet_sm = new JButton("Update Official Details");//Update Official Details Button
		UpdateDet_sm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updt_offdt_sm.setVisible(true);
				maintenancesm.setVisible(false);
				profitsm.setVisible(false);
				updt_pricesm.setVisible(false);
				updt_pers_sm.setVisible(false);
				off_det_sm.setVisible(false);
			}
		});
		UpdateDet_sm.setBackground(Color.WHITE);
		UpdateDet_sm.setBounds(10, 459, 153, 36);
		sidebar.add(UpdateDet_sm);
		
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(199, 118, 1150, 571);
		seniormanager.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//------------------------------------update personal details panel-----------------------------------------------
		
		updt_pers_sm = new JPanel();//update personal details panel
		updt_pers_sm.setVisible(false);
		updt_pers_sm.setBounds(255, 62, 621, 194);
		panel_3.add(updt_pers_sm);
		updt_pers_sm.setLayout(null);
		
		JLabel pers_dtsm_lbl = new JLabel("Update Personal Details:");//heading label of panel
		pers_dtsm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pers_dtsm_lbl.setBounds(6, 6, 220, 21);
		updt_pers_sm.add(pers_dtsm_lbl);
		
		JLabel phonesm_lbl = new JLabel("Phone:");//phone label
		phonesm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phonesm_lbl.setBounds(20, 43, 46, 14);
		updt_pers_sm.add(phonesm_lbl);
		
		JTextField phonesm_txt = new JTextField(null);// phone text field
		phonesm_txt.setBounds(155, 43, 245, 20);
		updt_pers_sm.add(phonesm_txt);
		phonesm_txt.setColumns(10);
		
		JLabel addrsm_lbl = new JLabel("Address:");//address label
		addrsm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addrsm_lbl.setBounds(20, 83, 80, 14);
		updt_pers_sm.add(addrsm_lbl);
		
		JTextField addrsm_txt = new JTextField(null);// phone text field
		addrsm_txt.setBounds(155, 83, 245, 20);
		updt_pers_sm.add(addrsm_txt);
		addrsm_txt.setColumns(10);
		
		JButton updatesm = new JButton("Update");//update button
		updatesm.setForeground(Color.WHITE);
		updatesm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatesm.setBackground(Color.BLACK);
		updatesm.setBounds(440, 150, 120, 23);
		updt_pers_sm.add(updatesm);
		
		updatesm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = phonesm_txt.getText();
				String add = addrsm_txt.getText();
				
				try {
					mobj.UpdatePersonaldetails(phone, add);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(alert,"Invalid Details !!");
				}
				JOptionPane.showMessageDialog(alert,"Details Updated !!");
			}
		});
		
		//------------------------------------Update Prices panel--------------------------------------------
		
		updt_pricesm = new JPanel();//update price  panel
		updt_pricesm.setVisible(false);
		updt_pricesm.setBounds(255, 62, 621, 194);
		panel_3.add(updt_pricesm);
		updt_pricesm.setLayout(null);
		
		JLabel pricesm_lbl = new JLabel("Update Price :");//heading label of panel
		pricesm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pricesm_lbl.setBounds(6, 6, 220, 21);
		updt_pricesm.add(pricesm_lbl);
		
		JLabel dishid_sm_lbl = new JLabel("Dish Id:");//dish id label
		dishid_sm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dishid_sm_lbl.setBounds(20, 43, 46, 14);
		updt_pricesm.add(dishid_sm_lbl);
		
		JTextField dishid_sm_txt = new JTextField(null);// dish id text field
		dishid_sm_txt.setBounds(155, 43, 245, 20);
		updt_pricesm.add(dishid_sm_txt);
		dishid_sm_txt.setColumns(10);
		
		JLabel updtpricesm_lbl = new JLabel("Updated Price:");//updated price label
		updtpricesm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		updtpricesm_lbl.setBounds(20, 83, 100, 14);
		updt_pricesm.add(updtpricesm_lbl);
		
		JTextField updtprice_sm_txt = new JTextField(null);// updated price  text field
		updtprice_sm_txt.setBounds(155, 83, 245, 20);
		updt_pricesm.add(updtprice_sm_txt);
		updtprice_sm_txt.setColumns(10);
		
		JButton updatesm_2 = new JButton("Update");//update button
		updatesm_2.setForeground(Color.WHITE);
		updatesm_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatesm_2.setBackground(Color.BLACK);
		updatesm_2.setBounds(440, 150, 120, 23);
		updt_pricesm.add(updatesm_2);
		
		updatesm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DishId = null;
				Double newPrice = 0.0;
				
				try {
					DishId = dishid_sm_txt.getText().toUpperCase();
					newPrice = Double.valueOf(updtprice_sm_txt.getText());
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
				JOptionPane.showMessageDialog(alert,"Price Updated !!");
			}
		});
		
		//------------------------------------------------profitability panel----------------------------------------
		
		profitsm = new JPanel();
		profitsm.setVisible(false);
		profitsm.setBounds(234, 62, 621, 291);
		panel_3.add(profitsm);
		profitsm.setLayout(null);
		
		
		JLabel profitsm_lbl = new JLabel("Profitability:");
		profitsm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		profitsm_lbl.setBounds(6, 6, 120, 21);
		profitsm.add(profitsm_lbl);
		
		
		JLabel restname_sm = new JLabel("Select your restaurant :");
		restname_sm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		restname_sm.setBounds(6, 56, 138, 20);
		profitsm.add(restname_sm);
		
		JRadioButton Whole_Delight_sm = new JRadioButton("RedFork Whole Delight");
		Whole_Delight_sm.setBounds(113, 83, 179, 23);
		profitsm.add(Whole_Delight_sm);
		
		JRadioButton Olive_sm = new JRadioButton("RedFork Olive_sm");
		Olive_sm.setBounds(113, 111, 179, 23);
		profitsm.add(Olive_sm);
		
		JRadioButton East_Treats_sm = new JRadioButton("RedFork East Treats");
		East_Treats_sm.setBounds(113, 137, 179, 23);
		profitsm.add(East_Treats_sm);
		
		JRadioButton Four_Seasons_sm = new JRadioButton("RedFork Four Seasons");
		Four_Seasons_sm.setBounds(113, 163, 179, 23);
		profitsm.add(Four_Seasons_sm);
		
		JRadioButton Delightful_sm = new JRadioButton("RedFork Delightful_sm");
		Delightful_sm.setBounds(113, 189, 179, 23);
		profitsm.add(Delightful_sm);
		
		JLabel msg = new JLabel();
		msg.setBounds(113, 250, 500, 23);
		profitsm.add(msg);
		
	
	    System.out.println(HName);
	    
	    JButton chk_sm = new JButton("Check");
		chk_sm.setBounds(522, 203, 89, 23);
		profitsm.add(chk_sm);
		chk_sm.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		String STR;
	    		 if(Whole_Delight_sm.isSelected()) {
	    			 HName = "RedFork Whole Delight";
				    }
				    
				    if(Olive_sm.isSelected()) {
				    	HName = "RedFork Olive_sm";
				    }
				    
				    if(East_Treats_sm.isSelected()) {
				    	HName = "RedFork East Treats";
				    }
				    
				    if(Four_Seasons_sm.isSelected()) {
				    	HName = "RedFork Four Seasons";
				    }
				    
				    if(Delightful_sm.isSelected()) {
				    	HName = "RedFork Delightful_sm";
				    }
				    
				    try {
						Double profitVal = Double.valueOf(String.format("%.2f",hobj.ViewProfitability(HName)));
						if(profitVal > 0) {
							STR = HName + " is at a profit of " + profitVal;
						}
						else {
							STR = HName + " is at a loss of " + profitVal;
						}
						msg.setText(STR);
					} 
				    catch (SQLException e1) {
						e1.printStackTrace();
					}
				    
				    
	    	}
	    });
		
		//-------------------------------------------Check Maintenance Panel------------------------------------------------------
		maintenancesm = new JPanel();
		maintenancesm.setVisible(false);
		maintenancesm.setBounds(234, 62, 621, 291);
		panel_3.add(maintenancesm);
		maintenancesm.setLayout(null);
		
		
		JLabel profit_sm_lbl = new JLabel("Check Maintenance:");
		profit_sm_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		profit_sm_lbl.setBounds(6, 6, 220, 21);
		maintenancesm.add(profit_sm_lbl);
		
		
		JLabel rest_sm_lbl = new JLabel("Select your restaurant :");
		rest_sm_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rest_sm_lbl.setBounds(6, 56, 138, 20);
		maintenancesm.add(rest_sm_lbl);
		
		JRadioButton Whole_Delight_sm2 = new JRadioButton("RedFork Whole Delight");
		Whole_Delight_sm2.setBounds(113, 83, 179, 23);
		maintenancesm.add(Whole_Delight_sm2);
		
		JRadioButton Olive2_sm2 = new JRadioButton("RedFork Olive");
		Olive2_sm2.setBounds(113, 111, 179, 23);
		maintenancesm.add(Olive2_sm2);
		
		JRadioButton East_Treats_sm2 = new JRadioButton("RedFork East Treats");
		East_Treats_sm2.setBounds(113, 137, 179, 23);
		maintenancesm.add(East_Treats_sm2);
		
		JRadioButton Four_Seasons_sm2 = new JRadioButton("RedFork Four Seasons");
		Four_Seasons_sm2.setBounds(113, 163, 179, 23);
		maintenancesm.add(Four_Seasons_sm2);
		
		JRadioButton Delightful_sm2 = new JRadioButton("RedFork Delightful");
		Delightful_sm2.setBounds(113, 189, 179, 23);
		maintenancesm.add(Delightful_sm2);
		
	
		JLabel maintainMsg = new JLabel();
		maintainMsg.setBounds(113, 250, 500, 23);
		maintenancesm.add(maintainMsg);
		
	    JButton chk_sm2 = new JButton("Check");
		chk_sm2.setBounds(522, 203, 89, 23);
		maintenancesm.add(chk_sm2);
		chk_sm2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		String str;
	    		 if(Whole_Delight_sm2.isSelected()) {
	    			 HName = "RedFork Whole Delight";
				    }
				    
				    if(Olive2_sm2.isSelected()) {
				    	HName = "RedFork Olive";
				    }
				    
				    if(East_Treats_sm2.isSelected()) {
				    	HName = "RedFork East Treats";
				    }
				    
				    if(Four_Seasons_sm2.isSelected()) {
				    	HName = "RedFork Four Seasons";
				    }
				    
				    if(Delightful_sm2.isSelected()) {
				    	HName = "RedFork Delightful";
				    }
				    
				    try {
						long dur = hobj.checkMaintenence(HName);
						if(dur > 365) {
							str = "Your maintenance is due !!!";
						}
						
						else {
							str = "You have " + dur + " days till next maintenance";
						}
						maintainMsg.setText(str);
				    } catch (Exception e1) {
						e1.printStackTrace();
					} 
	    	}
	    });	
		
		//------------------------------------------------update official details------------------------------------------------
		
		
		updt_offdt_sm =new JPanel(); //panel for updating official details
		updt_offdt_sm.setVisible(false);
		updt_offdt_sm.setBounds(234, 62, 621, 291);
		panel_3.add(updt_offdt_sm);
		updt_offdt_sm.setLayout(null);
		
		JLabel offdet_lbl_sm = new JLabel("Update Official Details:");//heading label of panel
		offdet_lbl_sm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		offdet_lbl_sm.setBounds(6, 6, 220, 21);
		updt_offdt_sm.add(offdet_lbl_sm);
		
		JLabel SSN3 = new JLabel("SSN:");//ssn label
		SSN3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		SSN3.setBounds(20, 43, 46, 14);
		updt_offdt_sm.add(SSN3);
		
		JTextField SSN_text3 = new JTextField(null);// SSN text field
		SSN_text3.setBounds(155, 41, 245, 20);
		updt_offdt_sm.add(SSN_text3);
		SSN_text3.setColumns(10);
		
		

		JLabel desig_lbl_sm= new JLabel("Designation:");//designation label
		desig_lbl_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		desig_lbl_sm.setBounds(20,80, 86, 24);
		updt_offdt_sm.add(desig_lbl_sm);
		
		JTextField desig_txt_sm = new JTextField(null);// designation text field
		desig_txt_sm.setBounds(155, 80, 245, 20);
		updt_offdt_sm.add(desig_txt_sm);
		desig_txt_sm.setColumns(10);
		 
		JLabel wrkplc_lbl_sm= new JLabel("Work Place:");// Work Place label
		wrkplc_lbl_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wrkplc_lbl_sm.setBounds(20,120, 86, 24);
		updt_offdt_sm.add(wrkplc_lbl_sm);
		
		JTextField wrkplc_txt_sm = new JTextField(null);// workplace text field
		wrkplc_txt_sm.setBounds(155, 120, 245, 20);
		updt_offdt_sm.add(wrkplc_txt_sm);
		wrkplc_txt_sm.setColumns(10);
		
		JLabel sal_lbl_sm= new JLabel("Salary %:");//   salary label
		sal_lbl_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sal_lbl_sm.setBounds(20,160, 86, 24);
		updt_offdt_sm.add(sal_lbl_sm);
		
		JTextField sal_txt_sm = new JTextField(null);// salary text field
		sal_txt_sm.setBounds(155, 160, 245, 20);
		updt_offdt_sm.add(sal_txt_sm);
		sal_txt_sm.setColumns(10);
		
		JButton updatebtn_sm = new JButton("Update");//update button
		updatebtn_sm.setForeground(Color.WHITE);
		updatebtn_sm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		updatebtn_sm.setBackground(Color.BLACK);
		updatebtn_sm.setBounds(450, 240, 120, 23);
		updt_offdt_sm.add(updatebtn_sm);
		
		updatebtn_sm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String desig,ssnUpd = null,wrk;
				double salPercent = 0.0;
				try {
					ssnUpd = SSN_text3.getText();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(alert,"SSN should not be empty");
				}
				try{
					desig = desig_txt_sm.getText();
				}
				catch(Exception e2) {
					desig = "";
				}
				try {
					wrk = wrkplc_txt_sm.getText();
				}
				catch(Exception e3) {
					wrk = "";
				}
				try {
					salPercent = Double.valueOf(sal_txt_sm.getText());
				}
				catch(Exception e4) {
					salPercent = 0.0;
				}
				try {
					mobj.UpdateOfficialdetails(ssnUpd, desig, wrk, salPercent);
				} catch (Exception e1) {
					System.out.println("Invalid");
				}
				JOptionPane.showMessageDialog(alert,"Updated Details !!!");
			}
		});
		
		
		//-------------------------------------
		
		Object[] dets = mobj.ViewOfficialdetails();
		
		off_det_sm = new JPanel();
		off_det_sm.setBounds(258, 50, 621, 194);
		off_det_sm.setVisible(false);
		panel_3.add(off_det_sm);
		off_det_sm.setLayout(null);
 
		JLabel off_hcf_sm = new JLabel("Official details:");
		off_hcf_sm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		off_hcf_sm.setBounds(10, 11, 800, 20);
		off_det_sm.add(off_hcf_sm);
		
		JLabel ssn_sm = new JLabel("SSN:" + dets[0]);
		ssn_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssn_sm.setBounds(30, 53, 800, 20);
		off_det_sm.add(ssn_sm);
		
		JLabel desig_sm = new JLabel("Designation:" + dets[1]);
		desig_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		desig_sm.setBounds(30, 93, 800, 14);
		off_det_sm.add(desig_sm);
		
		JLabel wrkplc_sm = new JLabel("Workplace :" + dets[3]);
		wrkplc_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wrkplc_sm.setBounds(30, 133, 800, 14);
		off_det_sm.add(wrkplc_sm);
		
		JLabel sal_sm = new JLabel("Salary :" + dets[2]);
		sal_sm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sal_sm.setBounds(30, 173, 800, 14);
		off_det_sm.add(sal_sm);
		
		
		
	}

}

