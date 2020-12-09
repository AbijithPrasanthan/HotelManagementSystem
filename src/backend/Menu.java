package demoDB;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu 
{
	
	private Connection connect = null;
	private Statement statement = null;
    private ResultSet resultSet = null;
    public void init() throws Exception
    {
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem",
                    "batch", "gautham123");
    		
    		connect.createStatement();
    	}
    	
    	catch(Exception e) 
    	{
    		throw e;
    	}
    }
    
    public void ViewMenu(String Mid) throws SQLException
    {
    	String query = "SELECT Availdishes FROM Menu WHERE Menuid ="+Mid;
    	
    	resultSet = statement.executeQuery(query);
    	Array array = resultSet.getArray("Availdishes");
        String[] ad = (String[]) array.getArray();
    	System.out.println();
    	
    	System.out.println("    Menu     ");
    	for(int i=0;i<ad.length;i++)
    	{
    		System.out.println("/t"+ (i+1) +"/t"+ ad[i]  );
    		
    	}   	

    	
    }
    public static void main(String[] args) throws Exception 
    {
    		Menu me = new Menu();
    		Scanner sc = new Scanner(System.in);
    		me.init();
    		
			System.out.println("Enter the Menuid of the menu to be viewed ");
			String menuid =sc.nextLine();
			
			me.ViewMenu(menuid);
			sc.close();
					
    }
	
}