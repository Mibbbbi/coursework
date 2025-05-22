package com.Agnom.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Agnom.DAO.IssueDAO;
import com.Agnom.DAO.RoomDAO;
import com.Agnom.models.Issue;
import com.mysql.cj.Session;

/**
 * Servlet implementation class IssueServlet
 */
@WebServlet("/issueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//creating empty list
		List<Issue>  issuedets;
		//checking if session exists
		HttpSession session=request.getSession(false);
         if(session==null) {
         	response.sendRedirect("/pages/login.jsp");
         	return;
         }
         //getting role attribute from session
         String role=(String) session.getAttribute("role");
         System.out.println(role);
		
		try {
			//Object of IssueDAO and using method
			IssueDAO issuedao = new IssueDAO();
			String solvedAdd = request.getParameter("status");
			if(solvedAdd==null) {
				//issue object as attribute
				request.setAttribute("issuedets", issuedao.issues());
				//directing to go to role wise page to view
				if(role.equals("Admin")) {
					request.getRequestDispatcher("pages/admin/manageIssues.jsp").forward(request, response);
            		
            	}else if(role.equals("staff")) {
            		request.getRequestDispatcher("/pages/staff/manageIssues.jsp").forward(request, response);
            	}
			}
			else {
				//if issue is solved 
				if(solvedAdd.equals("solved")) {
					//issue object as attribute
					request.setAttribute("issuedets", issuedao.issues());
					request.setAttribute("successMessage", "The issue has been resolved");
					//directing to go to role wise page after solve
					if(role.equals("Admin")) {
						request.getRequestDispatcher("pages/admin/manageIssues.jsp").forward(request, response);
	            
	            	}else if(role.equals("staff")) {
	            		request.getRequestDispatcher("/pages/staff/manageIssues.jsp").forward(request, response);
	            	}
				}
				else {
					//failure of solving issue
					request.setAttribute("issuedets", issuedao.issues());
					request.setAttribute("failedMessage", "The issue couldn't be resolved");
					request.getRequestDispatcher("pages/admin");
				}
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		//for posting on browser
//		PrintWriter out = response.getWriter();
		//parameter values
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String  feedbackType = request.getParameter("type");
		String feedbackDescription = request.getParameter("description");
		int roomId = Integer.parseInt(request.getParameter("room_id"));
		LocalDateTime myDateObj = LocalDateTime.now();
		boolean issueStatus = false;
		
		//for debugging
//		 out.println(roomId);
//		 out.println(feedbackType);
//		 out.println(feedbackDescription);
//		 out.println(myDateObj);
		 
		 // object of IssueDAO and RoomDAO
		 IssueDAO issueDAO;
		try {
			RoomDAO addRoom = new RoomDAO();
			//if given room id exists
			if (addRoom.checkRoom(roomId)) {
				issueDAO = new IssueDAO();
				//creating new issue object
				 Issue issue = new Issue(0,feedbackDescription,feedbackType,myDateObj,"unsolved",roomId,0,user_id,null );
				 //sending to database
				 issueStatus = issueDAO.feedbacks(issue);
				 if(issueStatus) {
					 
				 }
			}
			else {
				//if failed
				request.setAttribute("errorMessage", "Room with the provided room no doesn't exist");
				
				request.getRequestDispatcher("/pages/user/issues.jsp").forward(request, response);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(issueStatus) {
			//sending to thank you page roll the credits
			request.setAttribute("successMessage","Your issue has been registered successfully");
			request.getRequestDispatcher("/pages/issuethankyou.jsp").forward(request, response);
		
			
		}
		
		 
	}

}
