package Data;

import java.sql.*;

public class ConnectionDB {

	public static Connection getConnection() throws SQLException 
	{
		Connection con= null;
		String user, pwd, service, url;
		
		user = "Manager";
		pwd= "1234";
		service= "localhost:1522:";
		url= "jdbc:oracle:thin:";
		
		url += user+ "/" + pwd+ "@" + service;
		
		con = DriverManager.getConnection(url);
		
		
		return con;
		
	}
	
}
