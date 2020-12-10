package demoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu 
{
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	static Scanner ob = new Scanner(System.in);
    public void init() throws Exception
    {
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem",
                    "postgres", "gautham");
    		
    		connect.createStatement();
    	}
    	
    	catch(Exception e) 
    	{
    		throw e;
    	}
    }
    
    public void ViewMenu() throws SQLException
    {   
    	System.out.println("Enter the Menuid of the menu to be viewed ");
		String Mid =ob.next();
		
    	preparedStatement =connect.prepareStatement("select Dname from partof natural join dish where mid ='"+Mid+"'");  
    	ResultSet rs=preparedStatement.executeQuery(); 
    	System.out.println("    Menu     ");
    	int i=1;
    	while(rs.next())
    	{  
    		String dish = rs.getString(1);
    		System.out.println("\t"+ i +"\t"+ dish ); 
    		i++;
    	}
    	

    	
    }
    public static void main(String[] args) throws Exception 
    {
    		Menu me = new Menu();
 
    		me.init();
			me.ViewMenu();
    }
	
}
