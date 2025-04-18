package com.Coursework.controllers; 


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Coursework.DAO.LoginDAO;
import com.Coursework.models.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		System.out.println(username+ "JSP");
		String password = request.getParameter("password");
		System.out.println(password +"JSP");
		out.println("<html><body><p>" + username + "</p></body></html>");
		try {
			LoginDAO logindao = new LoginDAO();
			User user = logindao.login(username, password);
			
			if(user!=null) {
				String role = user.getRole();
				System.out.println("User role:" + role);
				 request.getSession().setAttribute("loggedInUser", user);
		         response.sendRedirect(request.getContextPath() + "/pages/Home.jsp");
			}
			else {
				System.out.println("Mismatched Login Details");
				
			}
			
			
		} catch (ClassNotFoundException e) {
				out.println("ClassErrowr");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("sQl error");
			e.printStackTrace();
		} 
		
		/*
		 * try { LoginDAO logindao = new LoginDAO(); User user =
		 * logindao.login(username, password); if(user!=null) { out.println("<html>");
		 * out.println("<body>"); out.println("<p>hola</p>"); out.println("</body>");
		 * out.println("</html>");
		 * 
		 * 
		 * } else { out.println("Idiot");
		 * 
		 * }
		 * 
		 * } catch(ClassNotFoundException | SQLException e) { out.println("typeError");
		 * 
		 * 
		 * }
		 */
		
	}
}

