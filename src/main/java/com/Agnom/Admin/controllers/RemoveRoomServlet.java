package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.RoomDAO;

/**
 * Servlet implementation class RemoveRoomServlet
 */
@WebServlet("/RemoveRoomServlet")
public class RemoveRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRoomServlet() {
        super();	
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//parameter
		String parameterValue= request.getParameter("param");
		
		try {
			//roomdao object to remove
			RoomDAO deleteRoom= new RoomDAO();
			//changing to int
			int room_id=Integer.parseInt(parameterValue);
			//deleting room with roomid
			boolean roomDeleted=deleteRoom.removeRoom(room_id);
			//if deleted success
			if(roomDeleted) {
				request.setAttribute("successMessage", "Room successfully deleted.");
			}else {
				request.setAttribute("errorMessage", "Room was not deleted.");
			}
			response.sendRedirect("ManageRoomServlet");
		} catch (ClassNotFoundException | SQLException e) {
			// to errorpage
			e.printStackTrace();
			request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
		
	}

}
