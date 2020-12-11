package backend;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class chef implements Employee
{
	String ssn;
    String Fname;
    String Lname;
    String Address;
    String Phone;
    double Salary;
    Date Date;
    String Specialization;
    String Designation;
    String Workplace;

    static Scanner ob = new Scanner(System.in);
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	public void init() throws Exception
    {
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbms",
                    "postgres", "password");
    		
    		connect.createStatement();
    	}
    	
    	catch(Exception e) 
    	{
    		throw e;
    	}
    }
	
	chef(String ssn){
		this.ssn = ssn;
	}
    
    public void UpdateWorkplace() throws SQLException
    {
        System.out.println("Enter the new hotel's id : ");
        String hid = ob.next();
        preparedStatement = connect.prepareStatement("UPDATE HotelEmp SET Hid = ? WHERE SSN = ?");
          preparedStatement.setString(1,hid);   
          preparedStatement.setString(2,ssn); 
          preparedStatement.executeUpdate();
      }
    public Object[] ViewPersonaldetails() throws SQLException
    {
    	Object det[] = new Object[10];
    	preparedStatement =connect.prepareStatement("select fname,lname,doj,address,phone from employee where ssn = '"+ssn+"'");  
    	ResultSet rs=preparedStatement.executeQuery(); 
        while(rs.next())
        {
          Fname = rs.getString(1);
          Lname = rs.getString(2);
          Date = rs.getDate(3);
          Address = rs.getString(4);
          Phone = rs.getString(5);
          det[0] = Fname;
          det[1] = Lname;
          det[2] = Date;
          det[3] = Address;
          det[4] = Phone;
        }
          preparedStatement =connect.prepareStatement("select speciality from chef where ssn = '"+ssn+"'");  
      	  ResultSet rss=preparedStatement.executeQuery();
          while(rss.next())
          {
          	Specialization = rss.getString(1);
            System.out.println("Work Place : " + Specialization);
          }
          return det;
        
    }
    public  Object[] ViewOfficialdetails()throws SQLException
	  {
    	Object[] det = new Object[10];
       	preparedStatement =connect.prepareStatement("select ssn,designation,sal,speciality from Employee natural join chef where ssn = '"+ssn+"'");  
    	ResultSet rs=preparedStatement.executeQuery(); 
        while(rs.next())
        {
          String SSN = rs.getString("ssn");
          Designation = rs.getString("designation");
          Salary = rs.getDouble("sal");
          
          det[0] = SSN;
          det[1] = Designation;
          det[2] = Salary;
          det[3] = rs.getString("speciality");
        }  
        
        
        preparedStatement =connect.prepareStatement("select hname from Hotelemp NATURAL JOIN Hotel where ssn = '"+ssn+"'");  
    	ResultSet rss=preparedStatement.executeQuery(); 
        while(rss.next())
        {
          Workplace = rss.getString(1);
          det[4] = Workplace;
        }
        return det;
        
	  }
	public  void UpdatePersonaldetails(String phone, String address)throws SQLException
	{
		if(!phone.isEmpty())
	      {
		      	preparedStatement = connect.prepareStatement("UPDATE Employee SET phone = ? WHERE SSN = ?");
		        preparedStatement.setString(1,phone);   
		        preparedStatement.setString(2,ssn); 
		        preparedStatement.executeUpdate();
	      }
	      if(!address.isEmpty())
	      {
		        preparedStatement = connect.prepareStatement("UPDATE Employee SET address = ? WHERE SSN = ?");
		        preparedStatement.setString(1,address);    
		        preparedStatement.setString(2,ssn); 
		        preparedStatement.executeUpdate();
	      }
	}
	
}
