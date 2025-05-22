package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.BookingDAO;
import com.Agnom.models.User;

/**
 * Servlet implementation class BookRoomServlet
 */
@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//parameter value
		int roomid=Integer.parseInt(request.getParameter("roomid"));	
		int days= Integer.parseInt(request.getParameter("duration"));
		
		try {
			//BookingDAO object to use methods of it 
			BookingDAO bookingDao = new BookingDAO();
			//geting session if exist else return null
			HttpSession session=request.getSession(false);
			if(session==null) {
				response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
			}
			//casting to User object
			User user=(User) session.getAttribute("loggedInUser");
			
			//doing booking
			boolean bookingDone= bookingDao.makeBooking(roomid, user.getId(), days);
			if(bookingDone) {
				request.setAttribute("successMessage", "Room successfully booked.");
				response.sendRedirect(request.getContextPath() + "/BookingDetailsServlet");
			}else {
				request.setAttribute("errorMessage", "Room already booked.");
				request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// to error pageeeeeeeeeeeeeeeeeeee
			e.printStackTrace();
			request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}

}
