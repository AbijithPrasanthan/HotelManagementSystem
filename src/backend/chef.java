package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class chef 
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
    
    public void UpdateWorkplace(String ssn,String workplace) throws SQLException
    {
    	preparedStatement = connect.prepareStatement("UPDATE chef SET Worklace = ? WHERE SSN = ?");
    	preparedStatement.setString(1, workplace);
    	preparedStatement.setString(2,ssn);
    	
    	preparedStatement.executeUpdate();
    }
    public static void main(String[] args) throws Exception 
    {
        	chef ch = new chef();
    		Scanner sc = new Scanner(System.in);
    		ch.init();
    		
			System.out.println("Enter the SSN of the chef to be updated ");
			String ssn =sc.nextLine();
			System.out.println("Enter the the new work place ");
			String workp =sc.nextLine();
			
			ch.UpdateWorkplace(ssn, workp);
			sc.close();
					
    }
	
}
