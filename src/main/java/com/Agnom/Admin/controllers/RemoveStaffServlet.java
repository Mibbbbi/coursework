package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.LoginDAO;
import com.Agnom.models.User;

/**
 * Servlet implementation class RemoveStaffServlet
 */
@WebServlet("/RemoveStaffServlet")
public class RemoveStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<User> users;
		try {
			//parameters
			LoginDAO logDao = new LoginDAO();
			String removeSuccess = request.getParameter("remove");
			String removal = request.getParameter("removed");
			String role ="staff";
			//getting staffs in the database
			users = logDao.getUserDetails(role);
			if(removal==null) {
				//not removed
				request.setAttribute("usersdets", users);
				request.getRequestDispatcher("/pages/admin/removeStaff.jsp").forward(request, response);;
			}
			else {
				//if removed
				if(removeSuccess.equals("removed")) {
					request.setAttribute("usersdets", users);
					request.setAttribute("successMessage", "Staff has been removed successfully");
					request.getRequestDispatcher("/pages/admin/removeStaff.jsp").forward(request, response);;
					
				}
				else {
					//remove failed
					request.setAttribute("usersdets", users);
					request.setAttribute("errorMessage", "Removal has been Failed");
					request.getRequestDispatcher("/pages/admin/removeStaff.jsp").forward(request, response);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			LoginDAO logDao = new LoginDAO();
			// parameter values
			String uName = request.getParameter("username");
			if(uName!=null) {
				//remove the staff with Username
				boolean removeStaff = logDao.RemoveStaff(uName);
				if(removeStaff) {
					//redirecting with paramter remove=removed & removed=remove.
					response.sendRedirect("RemoveStaffServlet?remove=removed&removed=remove");
				}
				else {
					response.sendRedirect("RemoveStaffServlet?remove=failed&removed=remove");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
