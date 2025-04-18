package com.Coursework.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private final static String databaseName ="hotelbooking";
	private final static String username ="root";
	private final static String password = "";
	private final static String jdbcURL ="jdbc:mysql://localhost:3306/"+databaseName;
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcURL,username,password);
		return conn;
	}
	  public static void main(String[] args) {
	    	Connection conn =null;
	    	try {
				conn = DatabaseConnection.getConnection();
				if(conn!=null) {
					System.out.println("Connection Sucess");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	catch(SQLException e) {
	    		e.printStackTrace();
	    		
	    	}
			
	    
		}

}
