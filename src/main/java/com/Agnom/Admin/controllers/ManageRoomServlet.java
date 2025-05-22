package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.ProductDAO;
import com.Agnom.models.Room;

/**
 * Servlet implementation class ManageRoomServlet
 */
@WebServlet("/ManageRoomServlet")
public class ManageRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			//get details of room and send them to manage room page
			ProductDAO productDao = new ProductDAO();
				List<Room> rooms = productDao.getProducts();
				//setting attribute and sending.
				request.setAttribute("rooms", rooms);
				request.getRequestDispatcher("/pages/admin/manageRoom.jsp").forward(request, response);
		 }catch (SQLException e) {
			// to error page
			request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}
}
