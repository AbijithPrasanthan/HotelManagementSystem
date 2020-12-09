package demoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dishes 
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
    public void Adddish( ) throws SQLException 
    {
    	System.out.println("Enter the  new dishid ");
		String Dishid =ob.next();
		System.out.println("Enter the  new dishname ");
		String Dishname =ob.next();
		System.out.println("Enter the  new price ");
		double price=ob.nextDouble();
    	preparedStatement = connect.prepareStatement("INSERT INTO dish VALUES(?,?,?)");
    	
    	preparedStatement.setString(1,Dishid);
    	preparedStatement.setString(2,Dishname);
    	preparedStatement.setDouble(3,price);
    	
    	preparedStatement.executeUpdate();
    	
    	System.out.println("New Dish Inserted !!!!");
    }
    
    public void UpdatePrice() throws SQLException
    {
    	System.out.println("Enter the Dishid of the dish to be updated ");
		String Dishid =ob.next();
		System.out.println("Enter the  new price ");
		double price=ob.nextDouble();
    	preparedStatement = connect.prepareStatement("UPDATE dish SET price = ? WHERE Did = ?");
    	preparedStatement.setDouble(1, price);
    	preparedStatement.setString(2,Dishid);
    	
    	preparedStatement.executeUpdate();
    }
    public static void main(String[] args) throws Exception 
    {
        	Dishes di = new Dishes();
    		di.init();
    		
    		System.out.println("Enter 1 to Upadate price 2 to add dish");
    		int c= ob.nextInt(); 
    		if(c==1)
    		{
    			di.UpdatePrice();
    			}
    		else
    		{
    			di.Adddish();
    		}
    	
					
    }
	
}
