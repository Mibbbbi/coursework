package com.Coursework.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Coursework.Database.DatabaseConnection;

public class RegisterDAO {
	private PreparedStatement ps;
    private Connection conn;
    
   public RegisterDAO() throws ClassNotFoundException, SQLException {
	   this.conn = DatabaseConnection.getConnection();
   }
}
