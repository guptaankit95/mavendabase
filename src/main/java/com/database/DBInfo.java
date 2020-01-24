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

			String host = System.getenv("LOCALHOST_SERVICE_HOST");

			String port = System.getenv("LOCALHOST_SERVICE_PORT");

			String localhost = "localhost";
			String localport = "3306";

			String localIpAddress = InetAddress.getByName("localhost").getHostAddress();
			
			//check if database is on local server or remote server
			if (InetAddress.getLocalHost().getHostName().equals("ITEM-S32234") || (localIpAddress == "127.0.0.1")) {

				System.out.println("this application is running on " + localIpAddress);
				con = (ConnectionImpl) DriverManager.getConnection(
						"jdbc:mysql://" + localhost + ":" + localport + "/user", "ankitgupta", "ankit123@");

			} else {

				System.out.println("this application is running on remote server ");
				System.out.println("host name is " + System.getenv("LOCALHOST_SERVICE_HOST"));
				System.out.println("port name is " + System.getenv("LOCALHOST_SERVICE_PORT"));
				con = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/user",
						"ankitgupta", "ankit123@");

			}

			System.out.println("after executing host name is " + con.getHostPortPair());

		} catch (ClassNotFoundException notFoundException) {

			System.out.println(notFoundException.getMessage());

		} catch (SQLException exception) {

			System.out.println("Got an exception = " + exception.getMessage());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		return con;
	}

}
