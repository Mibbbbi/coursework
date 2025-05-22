package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.Issue;


public class IssueDAO {
	private Connection conn;
	public IssueDAO() throws SQLException{

		try {
			this.conn = DatabaseConnection.getConnection();
		} 
		catch (ClassNotFoundException e) {				
			e.printStackTrace();
		}


	}
	public boolean  feedbacks(Issue issue) {
		/* uploading to issue database with parameter issue object
		 * input Issue object to upload
		 * return boolean to confirm
		 */
		boolean fdbcksuccess = false;
			try {
			if(conn!=null) {
				//uploading query
				String query ="Insert into issue(room_id,user_id,Issue_Date,Issue_Description,Issue_type)" + "values(?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, issue.getRoomId());
				ps.setInt(2,issue.getUserId() );
				ps.setTimestamp(3,java.sql.Timestamp.valueOf(issue.getIssueDate()));
				ps.setString(4, issue.getIssueDesc());
				ps.setString(5, issue.getIssueType());
				int rows = ps.executeUpdate();
				if(rows>0) {
					fdbcksuccess = true;
				}
			}
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return fdbcksuccess;
		
	}
	public List <Issue> issues() throws SQLException{
		/* selecting issue details from database to display
		 * input: none
		 * return list of issue object for displaying
		 */
		String query = "SELECT issue.*, bookings.booking_id, user.user_id, user.user_name , issue.Issue_Date\r\n"
				+ "FROM issue\r\n"
				+ "JOIN bookings ON bookings.room_id = issue.room_id\r\n"
				+ "JOIN user ON user.user_id = bookings.user_id\r\n"
				;
		List <Issue>  issuedets = new ArrayList<Issue>();
		if(conn!=null) {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Issue issuedetail = new Issue(
					    rs.getInt("issue_id"),
					    rs.getString("Issue_Description"),
					    rs.getString("issue_type"),
					    rs.getTimestamp("issue_date").toLocalDateTime(),
					    rs.getString("solve_status"),
					    rs.getInt("room_id"),
					    rs.getInt("booking_id"),
					    rs.getInt("user_id"),
					    rs.getString("user_name")
					    
					);
				issuedets.add(issuedetail);
			}
		}
		
		return issuedets;
		
	}
	public int countIssuesByStatus(String status) throws SQLException  {
		/*counting issue by solve/unsolved status to display in dashboard
		 * input status as string
		 * return int as count.
		 */
	    String query = "SELECT COUNT(*) AS total FROM issue WHERE solve_status = ?";
	    int count = 0;

	    if (conn != null) {
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, status);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt("total");
	        }
	    }

	    return count;
	}
	public boolean updateStatus(int issueId,int solvedBy) throws SQLException{ 
		/*updating the issue status when check by staff/admin
		 * input: issueID as int , solveBy as in (adminId/staffID)
		 * retunr coolean to confirm
		 */
		boolean updated = false;
		String query= "UPDATE issue SET solve_status='Solved', "
				+ "SolvedBy=? "
				+ "WHERE Issue_ID=?";
		if(conn!=null) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, solvedBy);
			ps.setInt(2, issueId);
			int rows = ps.executeUpdate();
			if(rows>0) {
				updated = true;
			}
			
		}
		return updated;
		
	}

}
