package com.login;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userid = (Integer.parseInt(request.getParameter("userid")));
		String userName = request.getParameter("username");
		
		
		DBInfo dbInfo = new DBInfo();
		ConnectionImpl con = dbInfo.getConnection();
		
		try {
			String query = "insert into tbl_user values(?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setString(2, userName);
			statement.setString(3, "abc123@");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			    request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
			
		}catch(SQLException exception) {
			System.out.println("got an insert exception "+exception.getMessage());
		}
	
	}

}
