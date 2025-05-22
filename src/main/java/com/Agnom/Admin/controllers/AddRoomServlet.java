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
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get form parameters
            int room_id = Integer.parseInt(request.getParameter("room_id"));
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            
            // Get the uploaded image
            Part image = request.getPart("image");
            String fileName = image.getSubmittedFileName();
            
            // Validate fileName
            if (fileName == null || fileName.trim().isEmpty()) {
                request.setAttribute("failedMessage", "No image uploaded.");
                request.getRequestDispatcher("/pages/admin/addRoom.jsp").forward(request, response);
                return;
            }

            // Sanitize fileName (optional: add logic to prevent path traversal or invalid characters)
            fileName = fileName.replaceAll("[^a-zA-Z0-9.-]", "_"); // Replace invalid characters

            // Define the storage directory (relative to deployment folder)
            String storePath = request.getServletContext().getRealPath("") + File.separator + "photos";
            File photosDir = new File(storePath);

            // Create the photos directory if it doesn't exist
            if (!photosDir.exists()) {
                photosDir.mkdirs(); // Creates the directory and any necessary parent directories
            }

            // Prepare the file path (e.g., photos/filename.jpg)
            String filePath = "photos" + File.separator + fileName;
            String uploadPath = request.getServletContext().getRealPath("/Agnom");
            String fullFilePath = storePath + File.separator + fileName;
            String fullFilePath2= uploadPath+ File.separator + fileName;
            // Save the image to the photos directory
            image.write(fullFilePath);
            System.out.println(fullFilePath);
            System.out.println(fullFilePath2);
            // Store the relative path for database (e.g., photos/filename.jpg)
            String image_path = filePath; // Use relative path for DB storage
            
            // Add room to the database
            RoomDAO addRoomDao = new RoomDAO();
            Room room = new Room(room_id, price, description, category, image_path);
            boolean success = addRoomDao.addNewRoom(room);

            // Set success or failure message
            if (success) {
                request.setAttribute("successMessage", "Room successfully registered.");
            } else {
                request.setAttribute("failedMessage", "Room registration failed.");
            }

            // Forward to the JSP page
            request.getRequestDispatcher("/pages/admin/addRoom.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            // Handle database errors
            request.setAttribute("error", "Database error occurred. Please try again.");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle invalid number format (e.g., room_id or price)
            request.setAttribute("error", "Invalid input format. Please check your data.");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        } catch (IOException e) {
            // Handle file I/O errors
            request.setAttribute("error", "Error saving the image. Please try again.");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }


}
