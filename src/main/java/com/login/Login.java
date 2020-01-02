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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		DBInfo dbInfo = new DBInfo();
		ConnectionImpl con = dbInfo.getConnection();

		try {

			String query = "select * from tbl_user where username = '" + userName + "' and password = '" + password
					+ "'";
			System.out.println(query);
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			System.out.println("query response is " + resultSet.next());

			if (resultSet.first()) {
				request.setAttribute("username", userName);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("error.jsp");
			}

		} catch (SQLException exception) {
			System.out.println("got an Exception = " + exception.getMessage());
		}

	}

}
