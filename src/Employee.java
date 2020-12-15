package project;

import java.sql.SQLException;

public interface Employee {
	
	Object[] ViewPersonaldetails() throws SQLException;
	Object[] ViewOfficialdetails() throws SQLException;
	void UpdatePersonaldetails(String phone,String address) throws SQLException;

}