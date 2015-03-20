package com.uttara.GroupBasedTaskManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCHelper {
	public static Connection getConnection() {
		Connection con=null;
		
		try
		{
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PASSWORD);
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

}

