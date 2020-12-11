package backend;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu 
{
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	Array array;
	String dishes;
	double prices;
	Object[][] dets;

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
    
    public Object[][] ViewMenu(String ssn) throws SQLException
    {
    	dets = new Object[3][3];
    	int j=0;
    	String query = "select dname,price from dish natural join partof natural join menu natural join hotelemp where ssn = '" + ssn + "'";
    	resultSet = statement.executeQuery(query);
    	while(resultSet.next()) {
    		dishes = resultSet.getString("dname");
    		prices = resultSet.getDouble("price");
    		dets[j][0] = (j+1);
    		dets[j][1] = dishes;
    		dets[j][2] = prices;
    		j++;
    	}
        
		return dets;
    }
}
