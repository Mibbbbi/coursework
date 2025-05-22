package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.User;

public class RegisterDAO {
	private PreparedStatement ps;
    private Connection conn;
    
   public RegisterDAO() throws ClassNotFoundException, SQLException {
	   this.conn = DatabaseConnection.getConnection();
	  
   }
   public boolean userExists(String username, String email) {
	   /* checking if the user exists in the user table in database, return boolean to confirm
	    * input: String, String
	    * return: boolean
	    */
	   
	   try {
		   //existence of enter credential check
		   String query = "SELECT * FROM user WHERE user_name =? OR email=?";
		   if(conn!=null) {
			   ps = conn.prepareStatement(query);
			   ps.setString(1, username);
			   ps.setString(2, email);
			   ResultSet userExist = ps.executeQuery();
			   if(userExist.next()) {
				   return true;
			   }
			   
		   }
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return false;
   }
	   
 public boolean registerUser(User user) throws SQLException {
	 /* uploading data of user to the database and return boolean to confirm
	  * input: User object
	  * return: boolean
	  */
	 boolean isRegistered = false;
	 //checking if user exists
	 boolean alreadyExists=userExists(user.getUsername(),user.getEmail());
	 if(alreadyExists) {
		 return false;
	 }
		 //updating query
		 String query = "Insert into user (first_name,last_name,contact,email,role,password,user_name)"+
	    "values(?,?,?,?,?,?,?)";
		if(conn!=null) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setLong(3, user.getPhnno());
			ps.setString(4,user.getEmail());
			ps.setString(5, "user");
			ps.setString(6, user.getPassword());
			ps.setString(7,user.getUsername());
			int rows = ps.executeUpdate();
			if(rows>0) {
				isRegistered = true;
				
			}
		}
				 
	 
	return isRegistered;
	 
	 
 }
	   
}

