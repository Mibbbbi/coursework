package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agnom.Database.DatabaseConnection;

	public class ChangePasswordDAO {
		private PreparedStatement ps;
	    private Connection conn;
	    
	    public ChangePasswordDAO() throws ClassNotFoundException, SQLException {
	    	System.out.println("HOLA");
	    	try {   this.conn = DatabaseConnection.getConnection();
	    	}
	    	catch(ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public boolean changePassword(int userId, String oldPassword, String newPassword) throws SQLException {
	    	/* to update the password of the user accord to entries password fields provided
	    	 * input userid to update the current user, oldpassword and replace with new passowrd
	    	 * return boolena to confirm
	    	 */
	    	// get user with oldpasswrd and userid
	    	ps=conn.prepareStatement("Select * from user WHERE user_id=? AND password=?");
	    	ps.setInt(1, userId);
	    	ps.setString(2, oldPassword);
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()) {
	    		//updating query
		    	String query ="UPDATE user SET password=? WHERE user_id=?";
		    	ps=conn.prepareStatement(query);
		    	ps.setString(1,newPassword);
		    	ps.setInt(2, userId);
		    	int rows=ps.executeUpdate();
		    	if(rows==1) {
		    		return true;
		    	}
	    	}else {
	    		return false;
	    	}
	    	return true;
	    }
	}
