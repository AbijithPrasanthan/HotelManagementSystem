package backend;

import java.sql.SQLException;

public interface Employee {
	
	Object[] ViewPersonaldetails() throws SQLException;
	Object[] ViewOfficialdetails() throws SQLException;
	Boolean Login();
	void UpdatePersonaldetails(String phone,String address) throws SQLException;

}
