package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.DashboardDAO;
import com.Agnom.models.Booking;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DashboardDAO dashboard = new DashboardDAO();
            //parameter values
            String sDatestr = request.getParameter("sDate");
            String eDateStr = request.getParameter("eDate");
            String method = request.getParameter("dets");
            //when not click on button
            if(method==null) {
            	method="null";
            }
            System.out.println(method);
            List<Booking> bookings;
            //setting atribute for dashboard display
            request.setAttribute("totalUser", dashboard.getTotalUser());
            request.setAttribute("totalRoom", dashboard.getTotalRoom());
            request.setAttribute("totalBooked", dashboard.getBookRoomCount());
            request.setAttribute("totalRevenue", dashboard.getTotalRevenue());
            request.setAttribute("mostIssuedRoom", dashboard.mostIssuedRoom());
            request.setAttribute("leastBookedRoom", dashboard.leastBookedRoom());
            //if session exist of not
            HttpSession session=request.getSession(false);
            if(session==null) {
            	response.sendRedirect("/pages/login.jsp");
            	return;
            }
            String role=(String) session.getAttribute("role");
            System.out.println(role);
            //displaying more booking details
            if(method.equals("getdets") && method!=null) {
            	if (sDatestr == null || eDateStr == null || sDatestr.isEmpty() || eDateStr.isEmpty()) {
                    bookings = dashboard.getBookingDets(null, null,method);
                } else {
                    LocalDate sDate = LocalDate.parse(sDatestr);
                    LocalDate eDate = LocalDate.parse(eDateStr);
                    bookings = dashboard.getBookingDets(sDate, eDate,method);
                }
            }
            else {
            	
            	bookings = dashboard.getBookingDets(null, null, "none");
            }
            //sending attribute
            request.setAttribute("bookingsdets", bookings);
            //role wise directing
            if(method.equals("null")) {
            	if(role.equals("Admin")) {
            		request.getRequestDispatcher("/pages/admin/adminDashboard.jsp").forward(request, response);
            	}else if(role.equals("staff")) {
            		request.getRequestDispatcher("/pages/staff/staffDashboard.jsp").forward(request, response);
            	}
            }
            else {
            	if(role.equals("Admin")) {
            		request.getRequestDispatcher("/pages/admin/viewBookingDets.jsp").forward(request, response);
            	}else if(role.equals("staff")) {
            		request.getRequestDispatcher("/pages/staff/viewBookingDets.jsp").forward(request, response);
            	}
            }
            
          

        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        	request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }


}
