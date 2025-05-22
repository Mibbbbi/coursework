package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.ChangePasswordDAO;
import com.Agnom.utility.Encryption;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// parameter value
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		String confirmPassword=request.getParameter("confirmPassword");
		int userID= Integer.parseInt(request.getParameter("userId"));
		
		//if they entered same password for new and confirm
		if(!newPassword.equals(confirmPassword)) {
			request.setAttribute("errorMessage", "Password didnt match!");
		}//if old and new same
		else if(oldPassword.equals(confirmPassword)) {
			request.setAttribute("errorMessage", "New password cannot be old password!");
		}
		else {
			try {
				//updaing the password using ChangePasswordDAO
				ChangePasswordDAO passwordUpdate= new ChangePasswordDAO();
				//encrypting password
				String hashOldPW=Encryption.encrypt(oldPassword);
				String hashNewPW=Encryption.encrypt(newPassword);
				boolean passwordChanged=passwordUpdate.changePassword(userID, hashOldPW, hashNewPW);
				//if success
				if(passwordChanged) {
					request.setAttribute("successMessage", "Password updated succesfully!");
				}else {
					request.setAttribute("errorMessage", "Password updated failed!!");					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", "Please try login again");
			}
			
		}
		// dispatching with attributes
		 request.getRequestDispatcher("/pages/user/updateProfile.jsp").forward(request, response);
	}

}
