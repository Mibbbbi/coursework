package com.Agnom.Admin.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Agnom.DAO.RoomDAO;
import com.Agnom.models.Room;

/**
 * Servlet implementation class UpdateRoomServlet
 */
@WebServlet("/UpdateRoomServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//paramter
		int room_id= Integer.parseInt(request.getParameter("roomid"));
		String category = request.getParameter("category");
		String description=request.getParameter("description");
		System.out.println("price");
		double price = Double.parseDouble(request.getParameter("price"));
		System.out.println(price);
		Part image = request.getPart("image");
		String fileName = image.getSubmittedFileName();
		
		
		String storePath = request.getServletContext().getRealPath(""); //get path of deployment folder
		String filePath = "photos"+File.separator+fileName;   //prepared file path like photos\fileName.jpg
		//System.out.println(storePath);
		
		String image_path = request.getContextPath()+File.separator+filePath;
		
		image.write(storePath+File.separator +filePath);
		//System.out.println("1");
		try {
			RoomDAO addRoomDao = new RoomDAO();
			Room room = new Room(room_id,price,description,category,image_path);
			//System.out.println("2");
			boolean success =addRoomDao.updateRoom(room);
			if(success) {
				request.setAttribute("successMessage", "Room successfully updated.");
				//System.out.println("3");
				}
			else {
				request.setAttribute("failedMessage", "Room successfully not updated.");
				//System.out.println("4");
			}
			//System.out.println("5");
			request.getRequestDispatcher("ManageRoomServlet").forward(request, response);
		
		} catch (ClassNotFoundException | SQLException e) {
			// error page
			request.setAttribute("error", "Please try login again");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}
}

