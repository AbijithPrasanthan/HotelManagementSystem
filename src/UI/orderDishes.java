package backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class orderDishes {
    JFrame menu2;
    JPanel sidebar4;
    JLabel label8;
    JPanel title6;
    JLabel restaurantname5;
    JButton BACK2;
    Panel contents2;
    JPanel placeorder;
    JLabel ORDERStitle;
    JLabel Dish;
    JButton plusbutton;
    JTextField quantity;
    JButton minusbutton;
    Label Quantity;
    Button AddItem;
    JLabel yourselecteditems;

    int count;

    private JTable insTable;
    private DefaultTableModel table;
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    String[] Dishes;
    String HName;
    ArrayList < String > ordered = new ArrayList < String > ();
    ArrayList < Integer > quan = new ArrayList < Integer > ();

    public void init() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbms",
                "postgres", "password");

            statement = connect.createStatement();
        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
	orderDishes(String name) throws Exception {
        init();
        addDishes(name);

        menu2 = new JFrame();
        menu2.getContentPane().setFont(new Font("Adobe Fangsong Std R", Font.BOLD, 18));
        menu2.getContentPane().setBackground(new Color(220, 20, 60));
        menu2.setBackground(Color.DARK_GRAY);
        menu2.setSize(2000, 1000);
        menu2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu2.setVisible(true);


        ImageIcon i = new ImageIcon("C:\\Users\\bhara\\Documents\\documents\\college\\SEM3\\OOPs\\sample/the-red-cafe.png"); //logo
        menu2.getContentPane().setLayout(null);


        JPanel sidebar4 = new JPanel(); //SIDE PANEL
        sidebar4.setBounds(0, 0, 173, 749);
        sidebar4.setBackground(new Color(0, 0, 0));
        menu2.getContentPane().add(sidebar4);
        sidebar4.setLayout(null);

        JLabel label8 = new JLabel(i);
        label8.setBounds(10, 11, 140, 143);
        sidebar4.add(label8);
        label8.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel title6 = new JPanel(); //HEADING PANEL
        title6.setBounds(167, 32, 1203, 49);
        title6.setBackground(new Color(0, 0, 0));
        menu2.getContentPane().add(title6);
        title6.setLayout(null);

        JLabel restaurantname5 = new JLabel("RedFork  Restaurant -MENU"); //RESTAURANT NAME
        restaurantname5.setFont(new Font("Segoe Script", Font.BOLD, 20));
        restaurantname5.setForeground(Color.WHITE);
        restaurantname5.setBounds(105, 11, 542, 38);
        title6.add(restaurantname5);

        JButton BACK2 = new JButton("BACK"); //BACK BUTTON
        BACK2.setForeground(Color.WHITE);
        BACK2.setBackground(Color.BLACK);
        BACK2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        BACK2.setBounds(1075, 11, 89, 23);
        title6.add(BACK2);

        BACK2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu2.setVisible(false);
                try {
                    new selectHotel();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        Panel contents2 = new Panel();
        contents2.setBackground(new Color(255, 255, 255));
        contents2.setBounds(199, 118, 1150, 571);
        menu2.getContentPane().add(contents2);
        contents2.setLayout(null);


        JPanel placeorder = new JPanel();
        placeorder.setBounds(10, 112, 1115, 135);
        contents2.add(placeorder);
        placeorder.setLayout(null);

        JLabel ORDERStitle = new JLabel("ORDER DISHES");
        ORDERStitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        ORDERStitle.setBounds(10, 11, 211, 30);
        placeorder.add(ORDERStitle);

        @SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox = new JComboBox(Dishes);
        comboBox.setBounds(125, 78, 205, 22);
        placeorder.add(comboBox);

        JLabel Dish = new JLabel("Dish:");
        Dish.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        Dish.setBounds(125, 58, 29, 14);
        placeorder.add(Dish);

        JButton plusbutton = new JButton("+");
        plusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(quantity.getText());
                count = count + 1;

                quantity.setText(String.valueOf(count));
            }
        });
        plusbutton.setBounds(533, 78, 41, 23);
        placeorder.add(plusbutton);

        quantity = new JTextField("0");
        quantity.setBounds(437, 79, 86, 20);
        placeorder.add(quantity);
        quantity.setColumns(10);

        JButton minusbutton = new JButton("-");
        minusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(quantity.getText());
                count = count - 1;

                quantity.setText(String.valueOf(count));
            }
        });
        minusbutton.setBounds(386, 78, 41, 23);
        placeorder.add(minusbutton);

        Label Quantity = new Label("Quantity:");
        Quantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        Quantity.setBounds(396, 50, 62, 22);
        placeorder.add(Quantity);


        Button AddItem = new Button("Add Item");

        JLabel yourselecteditems = new JLabel("Your selected dish:");
        yourselecteditems.setBounds(210, 279, 259, 32);
        contents2.add(yourselecteditems);

        table = new DefaultTableModel();
        insTable = new JTable(table);
        //	      sPane = new JScrollPane(insTable);

        table.addColumn("Ordered");
        table.addColumn("count");
        insTable.setBounds(220, 322, 393, 135);
        contents2.add(insTable);

        AddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dishSelected = comboBox.getSelectedItem().toString();
                ordered.add(dishSelected); // TO an arraylist

                int dishCount = Integer.parseInt(quantity.getText());
                quan.add(dishCount);

                addRow(dishSelected, dishCount);
            }
        });



        AddItem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        AddItem.setBounds(775, 78, 92, 22);
        placeorder.add(AddItem);

        Button PlaceOrder = new Button("Place Order"); //place order button
        PlaceOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        PlaceOrder.setBounds(873, 78, 85, 22);
        placeorder.add(PlaceOrder);

        JLabel lblNewLabel = new JLabel("Quantity:");
        lblNewLabel.setBounds(479, 288, 70, 14);
        contents2.add(lblNewLabel);



        System.out.println(HName);

        JPanel bottles = new JPanel(); //water bottles pannel
        bottles.setLayout(null);
        bottles.setBounds(10, 33, 1115, 49);
        contents2.add(bottles);

        JButton plus = new JButton("+"); //plus button
        plus.setBounds(500, 9, 41, 23);
        bottles.add(plus);


        JTextField no_of_bottles = new JTextField("0"); //textfield of number of bottles.
        no_of_bottles.setColumns(10);
        no_of_bottles.setBounds(393, 10, 86, 20);
        bottles.add(no_of_bottles);

        plus.addActionListener(new ActionListener() { // button action of plus button.
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(no_of_bottles.getText());
                count = count + 1;

                no_of_bottles.setText(String.valueOf(count));
            }
        });

        JButton minus = new JButton("-"); //minus button
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(no_of_bottles.getText());
                count = count - 1;

                no_of_bottles.setText(String.valueOf(count));
            }
        });
        minus.setBounds(326, 9, 41, 23);
        bottles.add(minus);

        Label label_2 = new Label("Number of water bottles :");
        label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label_2.setBounds(26, 10, 199, 22);
        bottles.add(label_2);


    }

    private void addDishes(String name) throws Exception {
        resultSet = statement.executeQuery("select dname from dish natural join partof natural join menu natural join hotel where hname = '" + name + "'");
        //resultSet = statement.executeQuery("select * from dish");
        ArrayList < String > TDishes = new ArrayList < String > ();
        while (resultSet.next()) {
            TDishes.add(resultSet.getString("dname"));
        }
        Dishes = new String[TDishes.size()];
        for (int i = 0; i < TDishes.size(); i++) {
            Dishes[i] = TDishes.get(i);
        }
    }

    public void addRow(String dishSelected, int dishCount) {
        table.insertRow(this.count, new Object[] {
            dishSelected,
            dishCount
        });
        this.count += 1;

    }
}