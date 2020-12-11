package backend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class selectHotel {

    private JFrame frame;
    int count;
    String HName;
    customer cobj;


    public selectHotel() throws Exception {
        count = 0;
        initialize();
    }


    protected void initialize() throws Exception {
    	cobj = new customer();
    	
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
        frame.getContentPane().setBackground(new Color(220, 20, 60));
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(2000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png"); //logo
        frame.getContentPane().setLayout(null);


        JPanel sidebar = new JPanel(); //SIDE PANEL
        sidebar.setBounds(0, 0, 173, 749);
        sidebar.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(sidebar);
        sidebar.setLayout(null);
        JLabel label3 = new JLabel(i);
        label3.setBounds(10, 11, 140, 143);
        sidebar.add(label3);
        label3.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel title = new JPanel(); //HEADING PANEL
        title.setBounds(167, 32, 1203, 49);
        title.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(title);
        title.setLayout(null);

        JLabel restaurantname = new JLabel("RedFork  Restaurant -Select Hotel"); //RESTAURANT NAME
        restaurantname.setFont(new Font("Segoe Script", Font.BOLD, 20));
        restaurantname.setForeground(Color.WHITE);
        restaurantname.setBounds(105, 11, 542, 38);
        title.add(restaurantname);

        JButton BACK = new JButton("BACK"); //BACK BUTTON
        BACK.setForeground(Color.WHITE);
        BACK.setBackground(Color.BLACK);
        BACK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        BACK.setBounds(1075, 11, 89, 23);
        title.add(BACK);

        Panel contents = new Panel();
        contents.setBackground(new Color(255, 255, 255));
        contents.setBounds(199, 119, 1150, 571);
        frame.getContentPane().add(contents);
        contents.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Select your restaurant :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(32, 21, 155, 14);
        contents.add(lblNewLabel_1);

        JRadioButton Whole_Delight = new JRadioButton("RedFork Whole Delight");
        Whole_Delight.setBounds(32, 42, 155, 23);
        contents.add(Whole_Delight);

        if (Whole_Delight.isSelected()) {
            HName = "RedFork Whole Delight";
        }

        JRadioButton Olive = new JRadioButton("RedFork Olive");
        Olive.setBounds(32, 66, 155, 23);
        contents.add(Olive);

        if (Olive.isSelected()) {
            HName = "RedFork Olive";
        }

        JRadioButton East_Treats = new JRadioButton("RedFork East Treats");
        East_Treats.setBounds(32, 92, 155, 23);
        contents.add(East_Treats);

        if (East_Treats.isSelected()) {
            HName = "RedFork East Treats";
        }

        JRadioButton Four_Seasons = new JRadioButton("RedFork Four Seasons");
        Four_Seasons.setBounds(32, 118, 155, 23);
        contents.add(Four_Seasons);

        if (Four_Seasons.isSelected()) {
            HName = "RedFork Four Seasons";
        }

        JRadioButton Delightful = new JRadioButton("RedFork Delightful");
        Delightful.setBounds(32, 144, 155, 23);
        contents.add(Delightful);

        if (Delightful.isSelected()) {
            HName = "RedFork Delightful";
        }

        JButton select = new JButton("Select");
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Whole_Delight.isSelected()) {
                    HName = "RedFork Whole Delight";
                }

                if (Olive.isSelected()) {
                    HName = "RedFork Olive";
                }

                if (East_Treats.isSelected()) {
                    HName = "RedFork East Treats";
                }

                if (Four_Seasons.isSelected()) {
                    HName = "RedFork Four Seasons";
                }

                if (Delightful.isSelected()) {
                    HName = "RedFork Delightful";
                }
                try {
                	cobj.HName = HName;
                    new orderDishes(HName,cobj);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);

            }
        });
        select.setBounds(32, 215, 125, 23);
        contents.add(select);
    }

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    selectHotel window = new selectHotel();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}