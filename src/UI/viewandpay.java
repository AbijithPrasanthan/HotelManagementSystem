import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class viewandpay {

	private JFrame viewpay;
	
	JPanel add_dish_hcf;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewandpay window = new viewandpay();
					window.viewpay.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public viewandpay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		viewpay = new JFrame();
		viewpay.setSize(2000,780);
		viewpay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewpay.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
		viewpay.getContentPane().setBackground(new Color(220, 20, 60));
		viewpay.setBackground(Color.DARK_GRAY);
		
		
		
		
		ImageIcon  i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png");//logo
		viewpay.getContentPane().setLayout(null);
		
		
		JPanel sidebar_cust = new JPanel();//SIDE PANEL
		sidebar_cust.setBounds(0, 0, 173, 749);
		sidebar_cust.setBackground(new Color(0, 0, 0));
		viewpay.getContentPane().add(sidebar_cust);
		sidebar_cust.setLayout(null);
		JLabel label3= new JLabel(i);
		label3.setBounds(10, 11, 140, 143);
		sidebar_cust.add(label3);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel title_cust = new JPanel();//HEADING PANEL
		title_cust.setBounds(167, 32, 1203, 49);
		title_cust.setBackground(new Color(0, 0, 0));
		viewpay.getContentPane().add(title_cust);
		title_cust.setLayout(null);
		
		JLabel restaurantname = new JLabel("RedFork  Restaurant -CUSTOMER");//RESTAURANT NAME
		restaurantname.setFont(new Font("Segoe Script", Font.BOLD, 20));
		restaurantname.setForeground(Color.WHITE);
		restaurantname.setBounds(105, 11, 542, 38);
		title_cust.add(restaurantname);
		
		JButton BACK = new JButton("BACK");//BACK BUTTON
		BACK.setForeground(Color.WHITE);
		BACK.setBackground(Color.BLACK);
		BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BACK.setBounds(1075, 11, 89, 23);
		title_cust.add(BACK);
		
		Panel panel_cust = new Panel();
		panel_cust.setBackground(new Color(255, 255, 255));
		panel_cust.setBounds(199, 118, 1150, 571);
		viewpay.getContentPane().add(panel_cust);
		panel_cust.setLayout(null);
		
		//---------------------------------------------------------
		
		JPanel ordrd_dshs = new JPanel();//ordered dishes panel 
		ordrd_dshs.setBounds(83, 44, 1017, 212);
		panel_cust.add(ordrd_dshs);
		ordrd_dshs.setLayout(null);
		
		JLabel ordrd_dshs_lbl = new JLabel("Ordered Dishes:");// ordered dish label
		ordrd_dshs_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ordrd_dshs_lbl.setBounds(32, 11, 162, 21);
		ordrd_dshs.add(ordrd_dshs_lbl);
		
		JPanel totl_amnt = new JPanel();//total amount panel
		totl_amnt.setBounds(83, 354, 1017, 48);
		panel_cust.add(totl_amnt);
		totl_amnt.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL AMOUNT :");//total amount label
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(73, 11, 351, 26);
		totl_amnt.add(lblNewLabel_1);
		
		JButton paybill_btn = new JButton("PAY BILL");//pay bill button
		JFrame alert=new JFrame();
		
		paybill_btn.addActionListener(new ActionListener() {//pay bill button action
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(alert,"PAYMENT SUCCESSFUL");
			}
		});
		paybill_btn.setForeground(new Color(255, 255, 255));
		paybill_btn.setBackground(new Color(0, 0, 0));
		paybill_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		paybill_btn.setBounds(911, 479, 189, 41);
		panel_cust.add(paybill_btn);
		
		
		

			
	}

}
