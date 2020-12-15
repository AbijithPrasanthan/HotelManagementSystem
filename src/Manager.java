package project;

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

public class Manager implements Employee {

  protected Connection connect = null;
  protected Statement statement = null;
  protected PreparedStatement preparedStatement = null;
  protected ResultSet resultSet = null;

  String ssn;
  static Scanner ob = new Scanner(System. in );

  Manager(String ssn) {
    this.ssn = ssn;
  }

  public void init() throws Exception {
    try {
      Class.forName("org.postgresql.Driver");
      connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem", "postgres", "password");
      System.out.println("Connected to database");
      statement = connect.createStatement();
    }

    catch(Exception e) {
      throw e;
    }
  }

  @Override
  public Object[] ViewPersonaldetails() throws SQLException {
	
	  Object[] details = new Object[10];
	  System.out.println(ssn);
	resultSet = statement.executeQuery("select fname,lname,doj,address,phone from employee where ssn = '" + ssn + "'");
    while (resultSet.next()) {
      String fname = resultSet.getString("fname");
      details[0] = fname;
      String lname = resultSet.getString("lname");
      details[1] = lname;
      Date date = resultSet.getDate("doj");
      details[2] = date;
      String address = resultSet.getString("address");
      details[3] = address;
      String phone = resultSet.getString("phone");
      details[4] = phone;
    }
    return details;
  }

  @Override
  public Object[] ViewOfficialdetails() throws SQLException {
	  Object[] dets = new Object[10];
    resultSet = statement.executeQuery("select ssn,designation,sal from Employee where ssn = '" + ssn + "'");
    while (resultSet.next()) {
    	String ssn = resultSet.getString("ssn");
    	dets[0] = ssn;
      String designation = resultSet.getString("designation");
      dets[1] = designation;
      Double salary = resultSet.getDouble("sal");
      dets[2] = salary;
    }
    resultSet = statement.executeQuery("select hname from Hotelemp NATURAL JOIN Hotel where ssn = '" + ssn + "'");
    while (resultSet.next()) {
      String hname = resultSet.getString("Hname");
      dets[3] = hname;
    }
    return dets;
  }

  @Override
  public void UpdatePersonaldetails(String phone, String address) throws SQLException {
    if (!phone.isEmpty()) {
      preparedStatement = connect.prepareStatement("UPDATE Employee SET phone = ? WHERE SSN = ?");
      preparedStatement.setString(1, phone);
      preparedStatement.setString(2, ssn);
      preparedStatement.executeUpdate();
    }

    if (!address.isEmpty()) {
      preparedStatement = connect.prepareStatement("UPDATE Employee SET address = ? WHERE SSN = ?");
      preparedStatement.setString(1, address);
      preparedStatement.setString(2, ssn);
      preparedStatement.executeUpdate();
    }
  }

  void UpdateWorkplace(String wrk, String ssn) throws SQLException {
    preparedStatement = connect.prepareStatement("UPDATE HotelEmp SET Hid = ? WHERE SSN = ?");
    preparedStatement.setString(1, wrk);
    preparedStatement.setString(2, ssn);
    preparedStatement.executeUpdate();
  }

  void UpdateOfficialdetails(String ssn, String desig, String wrk, Double salPercent) throws SQLException {
	  System.out.println();
	  System.out.println(ssn);

    Double sal = 0.0;
    try {
      if (!desig.isEmpty()) {
    	  System.out.println(desig);
        preparedStatement = connect.prepareStatement("UPDATE Employee SET designation = ? WHERE SSN = ?");
        preparedStatement.setString(1, desig);
        preparedStatement.setString(2, ssn);
        preparedStatement.executeUpdate();
      }
      if (salPercent > 0) {
    	  System.out.println(salPercent);

        resultSet = statement.executeQuery("select sal from Employee where ssn = '" + ssn + "'");
        while (resultSet.next()) {
          sal = resultSet.getDouble("sal");
        }
        sal = Double.valueOf(String.format("%.2f", sal));
        sal = sal + sal * salPercent * 100;
        sal = sal + calculatebonus();
        sal = Double.valueOf(String.format("%.2f", sal));
        preparedStatement = connect.prepareStatement("UPDATE Employee SET SAL = ? WHERE SSN = ?");
        preparedStatement.setDouble(1, sal);
        preparedStatement.setString(2, ssn);
        preparedStatement.executeUpdate();
      }
      if (!wrk.isEmpty()) {
    	  System.out.println(wrk);
        UpdateWorkplace(wrk, ssn);
      }
    }
    catch(Exception e) {
    	System.out.println(e);
      throw e;
    }
  }

  private double calculatebonus() throws SQLException {
    // TODO Auto-generated method stub
    Date date = Calendar.getInstance().getTime();
    Calendar calendar1 = new GregorianCalendar();
    calendar1.setTime(date);
    int year1 = calendar1.get(Calendar.YEAR);

    java.sql.Date dojyear = null;
    resultSet = statement.executeQuery("select doj from employee where ssn = '" + ssn + "'");
    while (resultSet.next()) {
      dojyear = resultSet.getDate("doj");
    }
    Calendar calendar2 = new GregorianCalendar();
    calendar2.setTime(dojyear);
    int year2 = calendar2.get(Calendar.YEAR);

    double bonus = (double)((year1 - year2) / (double) year2 * 100000.00);
    bonus = Double.valueOf(String.format("%.2f", bonus));
    return bonus;
  }

}