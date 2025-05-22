package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.BookingDAO;
import com.Agnom.models.Booking;
import com.Agnom.models.User;

@WebServlet("/BookingDetailsServlet")
public class BookingDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookingDetailsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//geting session if exist else return null
		HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
		}
		//casting to User object
		User user=(User) session.getAttribute("loggedInUser");
        int uid = user.getId();  
        
       //getting parameter optional 
        String sDatestr = request.getParameter("sDate"); 
        String eDatestr = request.getParameter("eDate");
        
        //empty variable 
        List<Booking> bookings;
        Booking currentBooking=null;

        try {
        	//Object of BookDao
            BookingDAO bookDAO = new BookingDAO();
            
           // checking if fields are empty or provided
            if (sDatestr == null || eDatestr == null || sDatestr.isEmpty() || eDatestr.isEmpty()) {
              
                bookings = bookDAO.getBookingDetails(uid, null, null);
                currentBooking = bookDAO.currentBooking(uid);
                // Passing nulls for both dates
            } else {
                //creating date values for sql
                LocalDate sDate = LocalDate.parse(sDatestr);
                LocalDate eDate = LocalDate.parse(eDatestr);
                bookings = bookDAO.getBookingDetails(uid, sDate, eDate);
                currentBooking = bookDAO.currentBooking(uid);
                
            }
            
           //debugging
            for (Booking booking : bookings) {
                System.out.println("User ID: " + booking.getUser_id());
                System.out.println("Room ID: " + booking.getRoom_id());
                System.out.println("Date: " + booking.getBook_date());
                System.out.println("------");
            }
            
            // Forward the bookings to the JSP page
            request.setAttribute("currentBooking", currentBooking);
            request.setAttribute("bookings", bookings);
            request.getRequestDispatcher("/pages/user/bookingDetails.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
        	request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
