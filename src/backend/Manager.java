package dbthing;

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
        connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem","postgres", "jimbalakadibamba");
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
    
    
    void UpdateWorkplace(String s) throws SQLException
    {
    	System.out.println("Enter the new hotel's id : ");
    	String hid = ob.next();
    	preparedStatement = connect.prepareStatement("UPDATE HotelEmp SET Hid = ? WHERE SSN = ?");
        preparedStatement.setString(1,hid);   
        preparedStatement.setString(2,s); 
        preparedStatement.executeUpdate();
    }
    
    
    
    void UpdateOfficialdetails() throws SQLException
    {
    	System.out.println("Enter SSN of employee : ");
    	String s = ob.next();
    	System.out.println("Choose what to update : ");
        System.out.println("1. Designation");
        System.out.println("2. Salary");
        System.out.println("3. Workplace");
        int choice = ob.nextInt();
        if(choice == 1)
        {
          System.out.println("Choose a valid designation : ");                                            //Ithu radiobutton kittiyal nallathu.
          String designation = ob.next();
          preparedStatement = connect.prepareStatement("UPDATE Employee SET designation = ? WHERE SSN = ?");
            preparedStatement.setString(1,designation);    
            preparedStatement.setString(2,s); 
            preparedStatement.executeUpdate();
        }
        else if(choice == 2)
        {
          double sal = 0;
          System.out.println("Enter salary hike percent : ");
          double salarypercent = ob.nextDouble();
          resultSet = statement.executeQuery("select sal from Employee where ssn = '"+ssn+"'");
            while(resultSet.next())
            {
              sal = resultSet.getDouble("sal");
              System.out.println("Salary : " + sal);
            } 
            sal = Double.valueOf(String.format("%.2f",sal));
            sal = sal + sal*salarypercent * 100;
            sal = sal + calculatebonus();
            sal = Double.valueOf(String.format("%.2f",sal));
            System.out.println("Salary : " + sal);
            preparedStatement = connect.prepareStatement("UPDATE Employee SET SAL = ? WHERE SSN = ?");
            preparedStatement.setDouble(1,sal);    
            preparedStatement.setString(2,s); 
            preparedStatement.executeUpdate();
        }
        else if(choice == 3)
        {
          UpdateWorkplace(s);
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
    

  public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
	  System.out.print("Enter ssn of the employee : ");
      String s = ob.next();
      Manager m = new Manager(s);
      m.init();
      m.ViewPersonaldetails();
      m.ViewOfficialdetails();
      m.UpdatePersonaldetails();
      m.UpdateOfficialdetails();
    }
  
}

