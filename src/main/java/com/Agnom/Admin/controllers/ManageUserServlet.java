package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.LoginDAO;
import com.Agnom.models.User;

/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet("/AddUserServlet")
public class ManageUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        //list empty
        List<User> users;
        try {
        	//object to use method
            LoginDAO logDao = new LoginDAO();
    
            //action add of button
            String successAdd = request.getParameter("add");
                String role= "user";
                // getting user role users with user role
                users= logDao.getUserDetails(role);
                if(successAdd==null) {
                	// when opening the page
                    request.setAttribute("usersdets", users);
                    request.getRequestDispatcher("/pages/admin/manageUser.jsp").forward(request, response);
                }
                else {
                	//if click on add button 
                    if(successAdd.equals("success")){
                        request.setAttribute("usersdets", users);
                        request.setAttribute("successMessage", "Staff has been added Successfully");
                        request.getRequestDispatcher("/pages/admin/manageUser.jsp").forward(request, response);

                    }
                    else {
                    	// no click on add button
                        request.setAttribute("usersdets", users);
                        request.setAttribute("errorMessage", "Add failed");
                        request.getRequestDispatcher("/pages/admin/manageUser.jsp").forward(request, response);
                    }
                }
            
        
                
            }


         catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

                LoginDAO logDao;
                try {
                    logDao = new LoginDAO();
                    //parameter
                    String uName = request.getParameter("username");
                    String action = request.getParameter("action");
                    System.out.println(action);
                    // if user not selected
                    if(uName!=null) {
                        if(action.equals("add")) {
                        	// updating roles
                            boolean updated = logDao.AddStaff(uName);
                            if(updated) {
                                //if update success
                                response.sendRedirect("AddUserServlet?add=success");
                            }
                            else {
                                response.sendRedirect("AddUserServlet?add=fail");
                            }}

                    }
                    else {
                        System.out.println("bandar");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        // TODO Auto-generated method stub

    
        

}