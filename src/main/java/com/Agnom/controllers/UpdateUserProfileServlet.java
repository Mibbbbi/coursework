package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.UpdateSettingUserDAO;
import com.Agnom.models.User;
import com.Agnom.utility.Encryption;

/**
 * Servlet implementation class UpdateUserProfileServlet
 */
@WebServlet("/UpdateUserProfileServlet")
public class UpdateUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//getting value from parameter
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String role=request.getParameter("role");
		String email=request.getParameter("email");
		long contact = Long.parseLong(request.getParameter("contact"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int userid=Integer.parseInt(request.getParameter("userid"));
		//encrypting the password
		String hashPassword=Encryption.encrypt(password);
		
		try {
			//object of UpdateSettingUser
			UpdateSettingUserDAO settingUpdate= new UpdateSettingUserDAO();
			boolean updated=settingUpdate.updateSetting(userid, firstName, lastName, email, contact, username, hashPassword);
			
			if(updated) {
				// if update success
				request.setAttribute("message", "update successful");
			}else {
				request.setAttribute("message", "update failed");	
			}
			request.getRequestDispatcher("/pages/user/updateProfile.jsp").include(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			//les go error page
			e.printStackTrace();
			request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
		
		
	}
}
