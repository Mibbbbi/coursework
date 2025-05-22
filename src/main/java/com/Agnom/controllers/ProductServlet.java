package com.Agnom.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.ProductDAO;
import com.Agnom.models.Room;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//parameter
		String parameterValue= request.getParameter("param1");
		try {
			//ProductDAO object to use method
			ProductDAO productDao = new ProductDAO();
			if(parameterValue!=null) { //if paramter not empty
				int room_id=Integer.parseInt(parameterValue);
				
				//getting parameter values
				Room room = productDao.roomBooking(room_id);
				System.out.println(room_id);
				
				//dispatching to JSP for booking
				request.setAttribute("room", room);
				request.getRequestDispatcher("/pages/user/booking.jsp").forward(request, response);
			}else {
				
			//for product page	
			List<Room> products = new ArrayList<Room>();
			products = productDao.getProducts();
			
			//setting attributes and dispatching
			request.setAttribute("products", products);
			request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
		} }catch (SQLException e) {
			// to the error page
			response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
		}
		
	}
}
