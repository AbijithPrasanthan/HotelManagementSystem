package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class customer{
	
	String[] orderedDishes;
	int[] orderedQuantity;
	
	String HName;
	int orderWater;
	int count;
	
	customer() throws Exception
	{
		orderWater = 0;
		count = 0;
		orderedDishes = new String[10];
		orderedQuantity = new int[10];
	}
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void init() throws Exception{
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbms","postgres", "password");
    		statement = connect.createStatement();
    		System.out.println("Connection established");
    	}
    	
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    public void orderDishes(ArrayList<String> dishes, ArrayList<Integer> quan) {
    	for(int i=0;i<dishes.size();i+=2) {
    		orderedDishes[i] = dishes.get(i);
    		orderedQuantity[i] = quan.get(i);
    	}
    		
    		count += 1;
    }
	
	public void ViewAndPayBill() throws SQLException {
		double amt = 0;
		double disc = 0.0;			
		if(isWeekend()) {
			disc += 0.2;
		}
		
		for(int i=0;i<orderedDishes.length;i+=2) {
			resultSet = statement.executeQuery("select price from dish where dname = '" + (String)orderedDishes[i] + "'");
			while(resultSet.next()) {
				amt += (resultSet.getDouble("price")) * (int)orderedQuantity[i];                                    // Added orderedQuantity
			}
		}
		
		amt += orderWater * 20;
		amt -= resultSet.getDouble("price")*disc;
		amt = BulkorderPrice(amt);
		preparedStatement = connect.prepareStatement("UPDATE Hotel SET Revenue = (Revenue + ?) WHERE hname = ?");
        preparedStatement.setDouble(1,amt);   
        preparedStatement.setString(2,HName); 
        preparedStatement.executeUpdate();
	}
	
	public boolean isWeekend() {
		Calendar Curr = Calendar.getInstance();
		if ((Curr.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)  || (Curr.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			return true;
		}
		return false;
	}
	
	public double BulkorderPrice(double amt) {
		if(this.orderedDishes.length > 20) {
			amt -= amt*0.10;
		}
		
		return amt;
	}
	
}
