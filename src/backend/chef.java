package backend;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem",
                    "postgres", "gautham");
    		
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
    public void ViewPersonaldetails() throws SQLException
    {
    	preparedStatement =connect.prepareStatement("select fname,lname,doj,address,phone from employee where ssn = '"+ssn+"'");  
    	ResultSet rs=preparedStatement.executeQuery(); 
        while(rs.next())
        {
          Fname = rs.getString(1);
          Lname = rs.getString(2);
          Date = rs.getDate(3);
          Address = rs.getString(4);
          Phone = rs.getString(5);
          System.out.println("Social Security Number : " + ssn);
          System.out.println("First Name : " + Fname);
          System.out.println("Last Name : " + Lname);
          System.out.println("Date : " + Date);
          System.out.println("Address : "+Address);
          System.out.println("Phone number : "+Phone);
        }
          preparedStatement =connect.prepareStatement("select speciality from chef where ssn = '"+ssn+"'");  
      	  ResultSet rss=preparedStatement.executeQuery();
          while(rss.next())
          {
          	Specialization = rss.getString(1);
            System.out.println("Work Place : " + Specialization);
          }
        
    }
    public  void ViewOfficialdetails()throws SQLException
	  {
       	preparedStatement =connect.prepareStatement("select designation,sal from Employee where ssn = '"+ssn+"'");  
    	ResultSet rs=preparedStatement.executeQuery(); 
        while(rs.next())
        {
          Designation = rs.getString(1);
          Salary = rs.getDouble(2);
          System.out.println("Designation : " + Designation);
          System.out.println("Salary : " + Salary);
        }  
        preparedStatement =connect.prepareStatement("select hname from Hotelemp NATURAL JOIN Hotel where ssn = '"+ssn+"'");  
    	ResultSet rss=preparedStatement.executeQuery(); 
        while(rss.next())
        {
          Workplace = rss.getString(1);
          System.out.println("Work Place : " + Workplace);
        }
        
	  }
    public  Boolean Login()
    {
    	return true;
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
	      else if(!address.isEmpty())
	      {
		        preparedStatement = connect.prepareStatement("UPDATE Employee SET address = ? WHERE SSN = ?");
		        preparedStatement.setString(1,address);    
		        preparedStatement.setString(2,ssn); 
		        preparedStatement.executeUpdate();
	      }
	}
	
}