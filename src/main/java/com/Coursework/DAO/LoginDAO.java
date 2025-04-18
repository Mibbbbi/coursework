package com.Coursework.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Coursework.Database.DatabaseConnection;
import com.Coursework.models.User;

public class LoginDAO {
    private PreparedStatement ps;
    private Connection conn;

   
    public LoginDAO() throws ClassNotFoundException, SQLException {
    	  this.conn = DatabaseConnection.getConnection();
    }

    public User login(String username, String password) {
    	
        User user = null;
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        if (conn != null) {
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet userSet = ps.executeQuery();

                if (userSet.next()) {
                	
                        user = new User(
                        userSet.getInt("user_id"),
                        userSet.getString("username"),
                        userSet.getString("password"),
                        userSet.getString("Role"),
                        userSet.getInt("contact"),
                        userSet.getString("Email"),
                        userSet.getString("first_name"),
                        userSet.getString("last_name")
                    );
                    
                }
                else {
                	System.out.println("Not FOund");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;

    }
    
}


