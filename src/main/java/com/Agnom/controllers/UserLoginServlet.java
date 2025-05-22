package com.Agnom.controllers; 


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.LoginDAO;
import com.Agnom.models.User;
import com.Agnom.utility.Encryption;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// get parameter values
		String username = request.getParameter("username");
		System.out.println(username+ "JSP");
		String password = request.getParameter("password");
		System.out.println(password +"JSP");
		
		try {
			//LoginDAO object to use method in it
			LoginDAO logindao = new LoginDAO();
			String hashPassword=Encryption.encrypt(password);
			User user = logindao.login(username, hashPassword);
			
			if(user!=null) {
				//for debugging
				String role = user.getRole();
				System.out.println("User role:" + role);
				String fname = user.getFirstname();
				String lname = user.getLastname();
				System.out.println(fname + " "+ lname);
				
				//creating session if no session
				HttpSession session=request.getSession();
				session.setAttribute("loggedInUser", user);
				session.setAttribute("role", role);
				session.setMaxInactiveInterval(30*60); //30min
				
				//rediret to home page
				response.sendRedirect(request.getContextPath() + "/Home.jsp");
		         
				
			}
			else {
				//if login fails.
				System.out.println("login failed.");
				request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
				out.println("ClassError");
			// not working database
				request.setAttribute("error", "Please try login again");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
		} 
		
	}
}

