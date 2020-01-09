package com.database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.ConnectionImpl;

public class DBInfo {

	public ConnectionImpl con;

	public ConnectionImpl getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//System.getenv("OPENSHIFT_MYSQL_DB_HOST");
			String host =InetAddress.getLocalHost().getHostName(); 
					
			String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");

			
			

			// con = (ConnectionImpl)
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "ankitgupta",
			// "ankit123@");

			con = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/user",
					"ankitgupta", "ankit123@");

			// DriverManager.getConnection("jdbc:mysql://"+host+":3306/user", "ankitgupta",
			// "ankit123@");

			System.out.println("system hostname is " + InetAddress.getLocalHost().getHostName());
			

			System.out.println("jdbc:mysql://" + host + ":" + port);
			System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
					+ con.getMetaData().getDatabaseProductName());

			System.out.println("host name is " + System.getenv("LOCALHOST_SERVICE_HOST"));
			System.out.println("port name is " + System.getenv("LOCALHOST_SERVICE_PORT"));
			System.out.println("after executing host name is " + con.getHostPortPair());

		} catch (ClassNotFoundException notFoundException) {
			System.out.println("host name is " + System.getenv("LOCALHOST_SERVICE_HOST"));
			System.out.println("port name is " + System.getenv("LOCALHOST_SERVICE_PORT"));
			System.out.println(notFoundException.getMessage());

		} catch (SQLException exception) {
			System.out.println("host name is " + System.getenv("LOCALHOST_SERVICE_HOST"));
			System.out.println("port name is " + System.getenv("LOCALHOST_SERVICE_PORT"));
			System.out.println("Got an exception = " + exception.getMessage());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		return con;
	}

}
