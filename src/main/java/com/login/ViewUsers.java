package com.login;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBInfo;
import com.model.User;
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

			// store all userinfo in arraylist
			ArrayList<User> userList = new ArrayList<User>();

			while (resultSet.next()) {

				User user = new User(resultSet.getString(2), resultSet.getInt(1));

				userList.add(user);
				System.out.println("users are "+userList.size());

			}
			
			
			
			for(int i=0;i<userList.size();i++) {
				
				System.out.println("\nuser name is "+userList.get(i).getUserName()+" user id is "+userList.get(i).getId());
				
				
			}
			
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/userinfo.jsp").forward(request, response);

		} catch (SQLException exception) {
			System.out.println("got an exception while getting user details " + exception.getMessage());
		}

	}

}
