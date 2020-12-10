package backend;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Manager implements Employee{
  
	protected Connection connect = null;
	protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    
    String ssn;
    static Scanner ob = new Scanner(System.in);
    
  Manager(String ssn)
  {
    this.ssn = ssn;
  }
  
    public void init() throws Exception{
      try {
        Class.forName("org.postgresql.Driver");
        connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbms","postgres", "password");
        System.out.println("Connected to database");
        statement = connect.createStatement();
      }
      
      catch(Exception e) {
        throw e;
      }
    }
    
    
    @Override
    public void ViewPersonaldetails() throws SQLException {
      // TODO Auto-generated method stub
        resultSet = statement.executeQuery("select fname,lname,doj,address,phone from employee where ssn = '"+ssn+"'");
        while(resultSet.next())
        {
          String fname = resultSet.getString("fname");
          String lname = resultSet.getString("lname");
          Date date = resultSet.getDate("doj");
          String address = resultSet.getString("address");
          String phone = resultSet.getString("phone");
          System.out.println("Social Security Number : " + ssn);
          System.out.println("First Name : " + fname);
          System.out.println("Last Name : " + lname);
          System.out.println("Date : " + date);
          System.out.println("Address : "+address);
          System.out.println("Phone number : "+phone);
        }  
    }



    @Override
    public void ViewOfficialdetails() throws SQLException {
      // TODO Auto-generated method stub
      resultSet = statement.executeQuery("select designation,sal from Employee where ssn = '"+ssn + "'");
        while(resultSet.next())
        {
          String designation = resultSet.getString("designation");
          Double salary = resultSet.getDouble("sal");
          System.out.println("Designation : " + designation);
          System.out.println("Salary : " + salary);
        }  
        resultSet = statement.executeQuery("select hname from Hotelemp NATURAL JOIN Hotel where ssn = '"+ssn + "'");
        while(resultSet.next())
        {
          String hname = resultSet.getString("Hname");
          System.out.println("Work Place : " + hname);
        }
    }


    @Override
    public Boolean Login() 
    {
      return true;
    }

    
    @Override
    public void UpdatePersonaldetails() throws SQLException {
      // TODO Auto-generated method stub
      
      System.out.println("Choose what to update : ");
      System.out.println("1. Address");
      System.out.println("2. Phone");
      int opt = ob.nextInt();
      
      if(opt == 1)
      {
    	  	System.out.print("Enter the new phone number : ");
    	  	String phone = ob.next();
	      	preparedStatement = connect.prepareStatement("UPDATE Employee SET phone = ? WHERE SSN = ?");
	        preparedStatement.setString(1,phone);   
	        preparedStatement.setString(2,ssn); 
	        preparedStatement.executeUpdate();
      }
      else if(opt == 2)
      {
    	  	System.out.print("Enter the new phone number : ");
    	  	String address = ob.next();
	        preparedStatement = connect.prepareStatement("UPDATE Employee SET address = ? WHERE SSN = ?");
	        preparedStatement.setString(1,address);    
	        preparedStatement.setString(2,ssn); 
	        preparedStatement.executeUpdate();
      }
        
    }
    
    
    void UpdateWorkplace(String wrk,String ssn) throws SQLException
    {
    	preparedStatement = connect.prepareStatement("UPDATE HotelEmp SET Hid = ? WHERE SSN = ?");
        preparedStatement.setString(1,wrk);   
        preparedStatement.setString(2,ssn); 
        preparedStatement.executeUpdate();
    }
    
    
    
    void UpdateOfficialdetails(String ssn,String desig,String wrk, Double salPercent) throws SQLException
    {
    	Double sal = 0.0;
    	try {
	        if(!desig.isEmpty())
	        {
	          preparedStatement = connect.prepareStatement("UPDATE Employee SET designation = ? WHERE SSN = ?");
	            preparedStatement.setString(1,desig);    
	            preparedStatement.setString(2,ssn); 
	            preparedStatement.executeUpdate();
	        }
	        else if(salPercent > 0)
	        {
	          resultSet = statement.executeQuery("select sal from Employee where ssn = '"+ssn+"'");
	            while(resultSet.next())
	            {
	              sal = resultSet.getDouble("sal");
	              System.out.println("Salary : " + sal);
	            } 
	            sal = Double.valueOf(String.format("%.2f",sal));
	            sal = sal + sal*salPercent * 100;
	            sal = sal + calculatebonus();
	            sal = Double.valueOf(String.format("%.2f",sal));
	            System.out.println("Salary : " + sal);
	            preparedStatement = connect.prepareStatement("UPDATE Employee SET SAL = ? WHERE SSN = ?");
	            preparedStatement.setDouble(1,sal);    
	            preparedStatement.setString(2,ssn); 
	            preparedStatement.executeUpdate();
	        }
	        else if(!wrk.isEmpty())
	        {
	          UpdateWorkplace(wrk,ssn);
	        }
    	}
    	catch(Exception e) {
    		throw e;
    	}
    }
    
     
    private double calculatebonus() throws SQLException {
    // TODO Auto-generated method stub
      Date date = Calendar.getInstance().getTime();
      Calendar calendar1 = new GregorianCalendar();
      calendar1.setTime(date);
      int year1  = calendar1.get(Calendar.YEAR);
      
      java.sql.Date dojyear = null;
      resultSet = statement.executeQuery("select doj from employee where ssn = '"+ssn+"'");
        while(resultSet.next())
        {
          dojyear = resultSet.getDate("doj");
        }           
        Calendar calendar2 = new GregorianCalendar();
      calendar2.setTime(dojyear);
      int year2  = calendar2.get(Calendar.YEAR);
      
      double bonus =(double)((year1 - year2)/(double)year2 * 100000.00);
      bonus = Double.valueOf(String.format("%.2f",bonus));
      return bonus;
  }
  
}
