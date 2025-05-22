package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.ClockDAO;

/**
 * Servlet implementation class ClockInOutServlet
 */
@WebServlet("/ClockInOutServlet")
public class ClockInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClockInOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get parameter values
		String action = request.getParameter("action");
		int bookingID = Integer.parseInt(request.getParameter("bookingID"));
		
		try {
			//ClockDAO object to use methods
			ClockDAO clocking=new ClockDAO();
			//button press as action
			if ("checkin".equals(action)) {
				boolean clockedIn=clocking.clockIn(bookingID);
				//if clocking success
				if(clockedIn) {
					request.setAttribute("successMessage", "clock in successful today!");
				}else {
					request.setAttribute("successMessage", "clock in failed!");
				}
			} else if ("checkout".equals(action)) {
				boolean clockedOut=clocking.clockOut(bookingID);
				//if clock out success
				if(clockedOut) {
					
					request.setAttribute("successMessage", "thank you for choosing our service.!");
				}else {
					request.setAttribute("successMessage", "cant clock out right now.!");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
		}
		//redirecting to booking page
		response.sendRedirect(request.getContextPath() +"/BookingDetailsServlet");
	}

}
