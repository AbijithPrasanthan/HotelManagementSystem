package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class hotel {
	protected String Hid;
	public String HName;
	protected String BranchMgrSSN;
	protected Menu Mobj = new Menu();
	@SuppressWarnings("unused")
	private double Revenue,Expenditure,rawMaterialCost;
	public String HCity,HState;
	@SuppressWarnings("unused")
	private Date LastMaintenenceDate;
	protected Date SDate;
	
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
	
	public void ViewBranchDetails() throws SQLException{
		resultSet = statement.executeQuery("SELECT * FROM HOTEL");
		while(resultSet.next()) {
			Hid = resultSet.getString("hid");
			HName = resultSet.getString("hname");
			SDate = resultSet.getDate("sdate");
			Revenue = resultSet.getDouble("revenue");
			Expenditure = resultSet.getDouble("expenditure");
			HCity = resultSet.getString("city");
			HState = resultSet.getString("state");
		}
	}
	
	protected boolean ViewProfitability(String name) throws SQLException{		
		resultSet = statement.executeQuery("SELECT hname,revenue,expenditure FROM HOTEL where hname = " + name);
		if(resultSet.getDouble("revenue") > resultSet.getDouble("expenditure")) {
			System.out.println("Hotel: " + name);
			System.out.println("Profit: " + (resultSet.getDouble("revenue")  - resultSet.getDouble("expenditure")));
			return true;
		}
		return false;
	}
	
	protected boolean checkMaintenence(String Hid) throws SQLException, ParseException {
		Date date = Calendar.getInstance().getTime();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String dStr = formatter.format(date);
		java.sql.Date target = java.sql.Date.valueOf(dStr);
		LocalDate end = LocalDate.parse(dStr, dtf);
		
	    resultSet = statement.executeQuery("SELECT sdate from hotel where Hid = '" + Hid + "'");
	    
	    while(resultSet.next()) {
	    	Date left = resultSet.getDate("sdate");
	    	long dur = TimeUnit.MILLISECONDS.toDays(date.getTime()-left.getTime());

	    	/*Make sdate to lastMaintence*/
	    	
	    	if(dur > 365) {
	    		preparedStatement = connect.prepareStatement("UPDATE HOTEL SET sdate = ? where HID = ?");
	    		preparedStatement.setDate(1, target);
	    		preparedStatement.setString(2, Hid);
	    		
	    		preparedStatement.executeUpdate();
	    		return true;
	    	}
	    }
	    return false;
	}
	void UpdateOfficialdetails(String Hid) throws SQLException
	    {
	    System.out.println("Choose what to update : ");
		System.out.println("1. Revenue");
		System.out.println("2. Expenditure");
		int choice = ob.nextInt();
		if(choice == 1)
		{
		  System.out.println("Enter new Revenue to be updated ");  
		  Double rev = ob.nextDouble();
		  preparedStatement = connect.prepareStatement("UPDATE hotel SET revenue = ? WHERE hid = ?");
		    preparedStatement.setDouble(1,rev);    
		    preparedStatement.setString(2,Hid); 
		    preparedStatement.executeUpdate();
		}
		else if(choice == 2)
		{
		  System.out.println("Enter new Expenditure to be updated ");
		  Double exe = ob.nextDouble();
		  preparedStatement = connect.prepareStatement("UPDATE hotel SET expenditure = ? WHERE hid = ?");
		    preparedStatement.setDouble(1,exe);    
		    preparedStatement.setString(2,Hid); 
		    preparedStatement.executeUpdate();
		}

	    }
	
	
	public static void main(String[] args) throws Exception{
		hotel o = new hotel();
		o.init();
		System.out.println(o.checkMaintenence("H5061"));
		o.ViewBranchDetails();
		System.out.println("DONE");
	}
}
