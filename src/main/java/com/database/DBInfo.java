package com.database;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.ConnectionImpl;


public class DBInfo {

	public ConnectionImpl con;

	public ConnectionImpl getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Mysql123@");
			

		} catch (ClassNotFoundException notFoundException) {
			System.out.println(notFoundException.getMessage());

		} catch(SQLException exception) {
			System.out.println("Got an exception = "+exception.getMessage());
		}

		return con;
	}

}
