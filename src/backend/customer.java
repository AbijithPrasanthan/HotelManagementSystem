package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;



public class customer {
	String[] orderedDishes;
	int orderWater;
	
	customer(){
		orderWater = 0;
	}
	
	private Connection connect = null;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void init() throws Exception{
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbms",
                    "postgres", "password");
    		
    		statement = connect.createStatement();
    	}
    	
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    public void orderDishes() {
    	
    }
	
	public void ViewAndPayBill() throws SQLException {
		double amt = 0;
		double disc = 0.0;
			
		if(isWeekend()) {
			disc += 0.2;
		}
		
		for(int i=0;i<orderedDishes.length;i++) {
			resultSet = statement.executeQuery("select price from dish where dname = '" + orderedDishes[i] + "'");
			while(resultSet.next()) {
				amt += (resultSet.getDouble("price")); 
			}
		}
		amt += orderWater * 20;
		amt  -= resultSet.getDouble("price")*disc;
		amt = BulkorderPrice(amt);
		System.out.println("AMT: " + amt);
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