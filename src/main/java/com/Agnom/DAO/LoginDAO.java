package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.User;

public class LoginDAO {
    private PreparedStatement ps;
    private Connection conn;

   
    public LoginDAO() throws ClassNotFoundException, SQLException {
    	System.out.println("HOLA");
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
     
    }

    public User login(String username, String password) throws SQLException {
    	/* to get the user whole details and turn it into session by servlet
    	 * input: String, String
    	 * return: User object
    	 */
        User user = null;
        //getting the user that was trying to login
        String query = "SELECT * FROM user WHERE user_name = ? AND password = ?";
       
        
        if (conn != null) {

                ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet userSet = ps.executeQuery();

                if (userSet.next()) {
                	
                        user = new User(
                        
                        userSet.getString("user_name"),
                        userSet.getString("password"),
                        userSet.getLong("contact"),
                        userSet.getString("Email"),
                        userSet.getString("first_name"),
                        userSet.getString("last_name")
                        
                    );
                        //setting values since constructor doesnt have attribbutes
                    user.setRole(userSet.getString("role"));
                    user.setId(userSet.getInt("user_id"));
                }
                else {
                	System.out.println("Not FOund");
                }
        }
        
        return user;

    }
    public List<User> getUserDetails(String role) throws SQLException {
    	/* getting details of staff and user to add staff and remove staff with role and username
    	 * input string, string
    	 * return list of User object
    	 */
        List<User> userDetails = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query;

            query = "SELECT * FROM user WHERE Role = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, role);
        
        rs = ps.executeQuery();

        while (rs.next()) {
            User user = new User(
                rs.getString("user_name"),
                rs.getString("password"),
                rs.getLong("contact"),
                rs.getString("Email"),
                rs.getString("first_name"),
                rs.getString("last_name")
            );
            user.setRole(rs.getString("Role"));
            userDetails.add(user);
        }

        return userDetails;
    }
    
    public Boolean AddStaff(String Username) throws SQLException {
    	/* add staff role to the existing user from the database using username(unique), boolean to confirm
    	 * input string
    	 * return boolean
    	 */
    	boolean addStaff= false;
    	//adding role query
    	String query="Update user Set Role='staff' where user_name=?";
    	if(conn!=null) {
    		PreparedStatement  ps = conn.prepareStatement(query);
    		ps.setString(1, Username);
    		int rows = ps.executeUpdate();
    		if(rows>0) 
    		{
    			addStaff=true;
    		}
    		
    		
    	}
    	return addStaff;
    	
    }
    public Boolean RemoveStaff(String Username) throws SQLException {
    	/* remove staff role form the staff roled user from the database useing username, boolean to confirm
    	 * input username as string
    	 * returns boolean to confirm
    	 */
    	boolean addStaff= false;
    	//removing role query
    	String query="Update user Set Role='user' where user_name=?";
    	if(conn!=null) {
    		PreparedStatement  ps = conn.prepareStatement(query);
    		ps.setString(1, Username);
    		int rows = ps.executeUpdate();
    		if(rows>0) 
    		{
    			addStaff=true;
    		}
    		
    		
    	}
    	return addStaff;
    	
    }
    
}


