package com.login;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

/**
 * Servlet implementation class ViewUsers
 */
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBInfo dbInfo = new DBInfo();

		ConnectionImpl con = dbInfo.getConnection();

		try {

			String query = "select * from tbl_user";

			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);

				System.out.println("User ID is =" + id + "\nUserName is" + name + "\nUser Password is " + password);
				

			}
			request.getRequestDispatcher("/home.jsp").forward(request, response);

		} catch (SQLException exception) {
			System.out.println("got an exception while getting user details " + exception.getMessage());
		}

	}

}
