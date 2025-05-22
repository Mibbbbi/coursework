package com.Agnom.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.RegisterDAO;
import com.Agnom.models.User;
import com.Agnom.utility.Encryption;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//parameter values
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("retypepass");
		//if password matches
		if(password.equals(repassword)) {
			//length of password 8+
			if(password.length()<8) {
				request.setAttribute("error", "Password too short.");
				request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			}
			try {
				//Registering if work
				RegisterDAO regdao = new RegisterDAO();
				if(regdao.userExists(username,email)) {
					System.out.println("Error: Username already Exists");
					request.setAttribute("error", "Username already exists.");
					request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
				}
				else {
					//encrypting the password and uploading to database
					String hashPassword=Encryption.encrypt(password);
					User user = new User(username, hashPassword, contact, email, firstname, lastname);
					boolean created = regdao.registerUser(user);
					if (created)
					{
						request.setAttribute("success", "User successfully registered.");
						request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
					}		
					else {
						
					}
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// to error page
				e.printStackTrace();
				request.setAttribute("error", "Please try login again");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
			
		
		
		
		
	}
		else {
			request.setAttribute("error", "Entered passwords didnt match");
			request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			
			
		}
	}

}
