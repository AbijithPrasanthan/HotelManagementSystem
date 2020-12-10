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
    
    Object[] vals;
    
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
    
    hotel() throws Exception{
    	init();
    }
	
	public Object[] ViewBranchDetails(String name) throws SQLException{
		Object HData[] = new Object[10];
		resultSet = statement.executeQuery("SELECT * FROM HOTEL where hname = '" + name + "'");
		while(resultSet.next()) {
			Hid = resultSet.getString("hid");
			HData[0] = Hid;
			HName = resultSet.getString("hname");
			HData[1] = HName;
			SDate = resultSet.getDate("sdate");
			HData[2] = SDate;
			Revenue = resultSet.getDouble("revenue");
			HData[3] = Revenue;
			Expenditure = resultSet.getDouble("expenditure");
			HData[4] = Expenditure;
			HCity = resultSet.getString("city");
			HData[5] = HCity;
			HState = resultSet.getString("state");
			HData[6] = HState;
			LastMaintenenceDate = resultSet.getDate("last_maintenance");
			HData[7] = LastMaintenenceDate;
		}
		return HData;
	}
	
	protected double ViewProfitability(String name) throws SQLException{	
		Double profit = 0.0;
		resultSet = statement.executeQuery("SELECT hname,revenue,expenditure FROM HOTEL where hname = '" + name + "'");
		while(resultSet.next())
			profit = resultSet.getDouble("revenue")  - resultSet.getDouble("expenditure");
		return profit;
	}
	
	protected long checkMaintenence(String name) throws SQLException, ParseException {
		long dur = 0;
		Date date = Calendar.getInstance().getTime();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String dStr = formatter.format(date);
		java.sql.Date target = java.sql.Date.valueOf(dStr);
		LocalDate end = LocalDate.parse(dStr, dtf);
		
	    resultSet = statement.executeQuery("SELECT Last_Maintenance from hotel where hname = '" + name + "'");
	    
	    while(resultSet.next()) {
	    	Date left = resultSet.getDate("last_maintenance");
	    	dur = TimeUnit.MILLISECONDS.toDays(date.getTime()-left.getTime());	    	
	    	if(dur > 365) {
	    		preparedStatement = connect.prepareStatement("UPDATE HOTEL SET Last_Maintenance = ? where hname = ?");
	    		preparedStatement.setDate(1, target);
	    		preparedStatement.setString(2, name);
	    		
	    		preparedStatement.executeUpdate();
	    	}
	    }
    	return dur;
	}
	
	void UpdateOfficialdetails(double rev,double exp,String name) throws SQLException
    {
		if(rev > 0)
		{
		  preparedStatement = connect.prepareStatement("UPDATE hotel SET revenue = ? WHERE hname = ?");
		    preparedStatement.setDouble(1,rev);    
		    preparedStatement.setString(2,name); 
		    preparedStatement.executeUpdate();
		}
		if(exp > 0)
		{
		  preparedStatement = connect.prepareStatement("UPDATE hotel SET expenditure = ? WHERE hname = ?");
		    preparedStatement.setDouble(1,exp);    
		    preparedStatement.setString(2,name); 
		    preparedStatement.executeUpdate();
		}

    }
}
