package com.database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.ConnectionImpl;

public class DBInfo {

	public ConnectionImpl con;

	public ConnectionImpl getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// String host = InetAddress.getLocalHost().getHostAddress();
			/*
			 * String host = System.getenv("hostname"); System.out.println("host name is "+
			 * host); String port = System.getenv("MYSQL_SERVICE_PORT");
			 * System.out.println("host name is "+ port);
			 */
//this is the comment
			con = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "ankitgupta",
					"ankit123@");

			// con = (ConnectionImpl)
			// DriverManager.getConnection("jdbc:mysql://"+host+":3306/user", "ankitgupta",
			// "ankit123@");

		} catch (ClassNotFoundException notFoundException) {
			System.out.println(notFoundException.getMessage());

		} catch (SQLException exception) {
			System.out.println("Got an exception = " + exception.getMessage());
		}

		return con;
	}

}
