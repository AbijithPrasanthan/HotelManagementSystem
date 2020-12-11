package project;

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
                    "postgres", "password");
    		
    		connect.createStatement();
    	}
    	
    	catch(Exception e) 
    	{
    		throw e;
    	}
    }
    public void Adddish(String DishId,String DishName,double price) throws SQLException 
    {
    	preparedStatement = connect.prepareStatement("INSERT INTO dish VALUES(?,?,?)");
    	
    	preparedStatement.setString(1,DishId);
    	preparedStatement.setString(2,DishName);
    	preparedStatement.setDouble(3,price);
    	
    	preparedStatement.executeUpdate();
    }
    
    public void UpdatePrice(String DishId, double price) throws SQLException
    {
    	preparedStatement = connect.prepareStatement("UPDATE dish SET price = ? WHERE Did = ?");
    	preparedStatement.setDouble(1, price);
    	preparedStatement.setString(2,DishId);
    	preparedStatement.executeUpdate();
    }
}