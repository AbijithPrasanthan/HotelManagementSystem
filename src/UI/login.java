/*CREATED BY:
 * 
 * ABIJITH PRASHATHAN	(AM.EN.U4CSE19102)
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
	JFrame main_f=null;    
    JLabel label =null;            
    JPasswordField value = null;    
    JLabel l1=null;
    JLabel l2=null;  
    JButton b = null;
    JTextField text =null;  
    
    JFrame Admin_log=null;
    JFrame Admin=null;
    JFrame senior_manager=null;
    JFrame branch_manager=null;
    
    login()
    {
    	//--------------------------------------------------------Main Login Frame--------------------------------------------------------------------------
    	main_f=new JFrame("The Red Fork");//main page
    	main_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();            
        label.setBounds(20,150, 200,50);  
        main_f.add(label);
        
        
    		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST/the-red-cafe.png");
    		JLabel label3= new JLabel(i);							//logo
    		label3.setBounds(490,10, 300,400);  
    		main_f.add(label3);
       	
    		JButton b2 = new JButton("Admin Login");//Admin login
    		b2.setBounds(1140,20, 120,30); 
    		main_f.add(b2);
    		b2.addActionListener(new ActionListener() 
    	     {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		main_f.setVisible(false);
    	    		Admin_log.setVisible(true);
    	    	}
    	     });
       	
    		JLabel label4= new JLabel("The Red Fork ");//title
    		label4.setFont(new Font("Verdana", Font.PLAIN, 30));
    		label4.setBounds(550,200, 300,400);
    		main_f.add(label4);
     	
           
    		l1=new JLabel("Username:");//username    							
    		l1.setBounds(520,500, 80,30);  
    		main_f.add(l1); 
    		text = new JTextField();  
    		text.setBounds(600,500, 200,30);
    		main_f.add(text);
        
        
    		l2=new JLabel("Password:");//password    
    		l2.setBounds(520,550, 80,30); 							
    		main_f.add(l2);
    		value = new JPasswordField();   
    		value.setBounds(600,550,200,30);
    		main_f.add(value);
        
        
    		b = new JButton("Login");//login button
    		b.setBounds(600,600, 200,30);
    		main_f.add(b); 
    		b.addActionListener(new ActionListener()    //button action
    	   	{
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		String data=text.getText();
    	    		String data2=new String(value.getPassword());
    	    		JFrame alert=new JFrame();  
    	    		if( data.equals("anandks") )
    	    		{
    	    			if(data2.equals(""))
    	    			{
    	    				JOptionPane.showMessageDialog(alert,"Enter password");
    	    			}
    	    			if(data2.equals("password123"))
    	    			{
    	    				senior_manager.setVisible(true);
    	    				main_f.setVisible(false);
    	    				
    	    			}
    	    					 
    	    		}
    	    		else if( data.equals("abijithprashanthan") )
    	    		{
    	    			if(data2.equals(""))
    	    			{
    	    				JOptionPane.showMessageDialog(alert,"Enter password");
    	    			}
    	    			if(data2.equals("password123"))
    	    			{
    	    				branch_manager.setVisible(true);
    	    				main_f.setVisible(false);
    	    			}
    	    					 
    	    		}
    	    		else if( data.equals("gauthamsanthosh") )
    	    		{
    	    			if(data2.equals(""))
    	    			{
    	    				JOptionPane.showMessageDialog(alert,"Enter password");
    	    			}
    	    			if(data2.equals("password123"))
    	    			{
    	    				JOptionPane.showMessageDialog(alert,"Logging you in");
    	    			}
    	    					 
    	    		}
    	    		
    	    		else
    	    		{
    	    			JOptionPane.showMessageDialog(alert,"ACCESS DENIED!!"+"\n"+"Access only for Admin.");
    	    		}
    	    	}
    	    	
    	   	});
        
           
         
    	main_f.setSize(2000,1000);    
    	main_f.setLayout(null);    
    	main_f.setVisible(true); 
        
        //----------------------------------------------------------------Admin Login Frame------------------------------------------------------------------
        
        Admin_log= new JFrame("The Red Fork(Admin)");
        Admin_log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Admin_log.setSize(2000,1000);    
        Admin_log.setLayout(null);    
        Admin_log.setVisible(false);
        
        
        	JButton back = new JButton("BACK");//back button
        	back.setBounds(20,20, 120,30); 
        	Admin_log.add(back);
        	back.addActionListener(new ActionListener() 
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			main_f.setVisible(true);
        			Admin_log.setVisible(false);
        		}
        	});
        
			ImageIcon  i2 = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\HMS_PROJECT\\src\\TEST/the-red-cafe.png");
			JLabel logo= new JLabel(i);							//logo
			logo.setBounds(490,10, 300,400);  
			Admin_log.add(logo);
			
			JLabel title= new JLabel("The Red Fork ");//title
			title.setFont(new Font("Verdana", Font.PLAIN, 30));
			title.setBounds(550,200, 300,400);
			JLabel title2=new JLabel("Administrative access");
			title2.setBounds(580,250, 300,400);
			Admin_log.add(title);
			Admin_log.add(title2);
			
			l1=new JLabel("Username:"); //username    							
    		l1.setBounds(520,500, 80,30);  
    		Admin_log.add(l1); 
    		JTextField username = new JTextField();  
    		username.setBounds(600,500, 200,30);
    		Admin_log.add(username);
        
        
    		l2=new JLabel("Password:");//password    
    		l2.setBounds(520,550, 80,30); 							
    		Admin_log.add(l2);
    		JPasswordField password = new JPasswordField();   
    		password.setBounds(600,550,200,30);
    		Admin_log.add(password);
        
        
    		b = new JButton("Login");//login button
    		b.setBounds(600,600, 200,30);
    		Admin_log.add(b);
    		b.addActionListener(new ActionListener()    //button action
   	     	{
    			public void actionPerformed(ActionEvent e)
    			{
    				 String data=username.getText();
    				 String data2=new String(password.getPassword());
    				 JFrame alert=new JFrame();  
    				 if( data.equals("b") )
    				 {
    					 if(data2.equals(""))
    					 {
    						 JOptionPane.showMessageDialog(alert,"Enter password");
    					 }
    					 if(data2.equals("1"))
    					 {
    						 Admin.setVisible(true);
    						 
     	    				Admin_log.setVisible(false);
    					 }
    					 
    				 }
    				 else
    				 {
    					 JOptionPane.showMessageDialog(alert,"ACCESS DENIED!!"+"\n"+"Access only for Admin.");
    				 }
    			}
   	     	});
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
        
    senior_manager=new JFrame("The Red Fork(Senior Manager)"); //Senior Manager page
    senior_manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    senior_manager.setSize(2000,1000);    
    senior_manager.setLayout(null);    
    senior_manager.setVisible(false); 
    label = new JLabel();            
    label.setBounds(20,150, 200,50);  
    senior_manager.add(label);
        
   
   //--------------------------------------------------------------------Branch Manage Frame------------------------------------------------------------------------------------------------------------ 
    
   branch_manager=new JFrame("The Red Fork(Branch Manager)"); //Branch Manager page
   branch_manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   branch_manager.setSize(2000,1000);    
   branch_manager.setLayout(null);    
   branch_manager.setVisible(false); 
    
   // senior_manager.add(label);
    
    
    
    
    
    
    
    
    
    
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) 
	{
		 new login();   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
