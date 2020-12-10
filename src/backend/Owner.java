package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Owner extends Manager {
	
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

	Owner() throws Exception {
		super("E8546");
		init();
	}
	
	void FireEmployee(String ssn) throws SQLException
	{
		System.out.println(ssn);
		preparedStatement = connect.prepareStatement("Delete from Hotelemp WHERE ssn = ?");
		preparedStatement.setString(1, ssn);
		preparedStatement.executeUpdate();
		
		preparedStatement = connect.prepareStatement("Delete from Employee WHERE ssn = ?");
		preparedStatement.setString(1, ssn);
		preparedStatement.executeUpdate();

		System.out.println("Employee Terminated..");
	}
	
	void HireEmployee(String hid, String ssn,String fname, String lname, double salary, String designation,String phone, String address) throws SQLException
	{
		Date date = Calendar.getInstance().getTime();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dStr = formatter.format(date);
		java.sql.Date target = java.sql.Date.valueOf(dStr);

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?)");
	    	preparedStatement.setString(1,ssn);
			preparedStatement.setString(2,fname);
			preparedStatement.setString(3,lname);
			preparedStatement.setDate(4,target);
			preparedStatement.setDouble(5,salary);
			preparedStatement.setString(6, designation);
			preparedStatement.setString(7, phone);
			preparedStatement.setString(8, address);
			preparedStatement.executeUpdate();
			
			preparedStatement = connect.prepareStatement("INSERT INTO Hotelemp VALUES(?,?)");
			preparedStatement.setString(1,hid);
			preparedStatement.setString(2,ssn);
			preparedStatement.executeUpdate();
		}
		catch(Exception E) {
			throw E;
		}
    }

}
