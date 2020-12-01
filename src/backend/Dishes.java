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
    public void Adddish( String Dishid, String Dishname, double price) throws SQLException 
    {
    	preparedStatement = connect.prepareStatement("INSERT INTO Dishes VALUES(?,?,?)");
    	
    	preparedStatement.setString(1,Dishid);
    	preparedStatement.setString(2,Dishname);
    	preparedStatement.setDouble(3,price);
    	
    	preparedStatement.executeUpdate();
    	
    	System.out.println("New Row Inserted !!!!");
    }
    
    public void UpdatePrice(String Dishid,double price) throws SQLException
    {
    	preparedStatement = connect.prepareStatement("UPDATE Dishes SET Price = ? WHERE Dishid = ?");
    	preparedStatement.setDouble(1, price);
    	preparedStatement.setString(2,Dishid);
    	
    	preparedStatement.executeUpdate();
    }
    public static void main(String[] args) throws Exception 
    {
        	Dishes di = new Dishes();
    		Scanner sc = new Scanner(System.in);
    		di.init();
    		
    		System.out.println("Enter 1 to Upadate price 2 to add dish");
    		int c= sc.nextInt(); 
    		if(c==1)
    		{
    			System.out.println("Enter the Dishid of the dish to be updated ");
    			String did =sc.nextLine();
    			System.out.println("Enter the  new price ");
    			double price=sc.nextDouble();
    			di.UpdatePrice(did,price);
    			}
    		else
    		{
    			System.out.println("Enter the  new dishid ");
    			String did =sc.nextLine();
    			System.out.println("Enter the  new dishname ");
    			String dna =sc.nextLine();
    			System.out.println("Enter the  new price ");
    			double price=sc.nextDouble();
    			di.Adddish(did, dna, price);
    		}
    		
			sc.close();
					
    }
	
}