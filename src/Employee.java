package dbthing;

import java.sql.SQLException;

public interface Employee {
	
	void ViewPersonaldetails() throws SQLException;
	void ViewOfficialdetails() throws SQLException;
	Boolean Login();
	void UpdatePersonaldetails() throws SQLException;
}
