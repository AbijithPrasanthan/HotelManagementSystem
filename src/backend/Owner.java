package dbthing;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class Owner extends Manager {

	Owner(String s) {
		super(s);
	}
	
	void FireEmployee() throws SQLException
	{
		System.out.print("Enter ssn of the Employee to be Fired : ");
		String sn = ob.next();
		
		preparedStatement = connect.prepareStatement("Delete from Hotelemp WHERE ssn = ?");
		preparedStatement.setString(1, sn);
		preparedStatement.executeUpdate();
		
		preparedStatement = connect.prepareStatement("Delete from Employee WHERE ssn = ?");
		preparedStatement.setString(1, sn);
		preparedStatement.executeUpdate();

		System.out.println("Employee Terminated..");
	}
	
	void HireEmployee() throws SQLException
	{
		System.out.print("Enter ssn of the Employee Hired : ");
		String sn = ob.next();
		System.out.print("Enter fname of the Employee Hired : ");
		String fname = ob.next();
		System.out.print("Enter lname of the Employee Hired : ");
		String lname = ob.next();
		Date date = Calendar.getInstance().getTime();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dStr = formatter.format(date);
		java.sql.Date target = java.sql.Date.valueOf(dStr);
		System.out.print("Enter Address : ");
		String address = ob.next();
		System.out.print("Enter phone : ");
		String phone = ob.next();
		System.out.print("Enter salary of the Employee Hired : ");
		Double salary = ob.nextDouble();
		System.out.print("Enter designation of the Employee Hired : ");
		String designation = ob.next();
		
		preparedStatement = connect.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?)");
    		preparedStatement.setString(1,sn);
		preparedStatement.setString(2,fname);
		preparedStatement.setString(3,lname);
		preparedStatement.setDate(4,target);
		preparedStatement.setDouble(5,salary);
		preparedStatement.setString(6, designation);
		preparedStatement.setString(7, phone);
		preparedStatement.setString(8, address);
		preparedStatement.executeUpdate();

		System.out.println("New Row Inserted !!!!");
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Owner o = new Owner("E8456");
		o.init();
		o.ViewPersonaldetails();
		o.HireEmployee();
		o.FireEmployee();
	}

}
