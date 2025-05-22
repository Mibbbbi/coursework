package com.Agnom.Admin.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agnom.DAO.IssueDAO;

/**
 * Servlet implementation class SolveIssueServlet
 */
@WebServlet("/SolveIssueServlet")
public class SolveIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolveIssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting paramter
		int id = Integer.parseInt(request.getParameter("user_id"));
		int issueId = Integer.parseInt(request.getParameter("issueId"));
		try {
			// IssueDAo object
			IssueDAO issuedao = new IssueDAO();
			if(issuedao.updateStatus(issueId, id)) {
				//redirecting with paramater that shows solved status
				response.sendRedirect("issueServlet?status=solved");
				
			}
			else {
				response.sendRedirect("issueServlet?status=unresolved");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//no error
		}
		
		
				
	}

}
