package com.Agnom.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// for connection to the database with xammp
	private final static String databaseName ="hotelbooking";
	private final static String username ="root";
	private final static String password = "";
	private final static String jdbcURL ="jdbc:mysql://localhost:3306/"+databaseName;
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");//optional to get class for driver.
		conn = DriverManager.getConnection(jdbcURL,username,password);
		return conn;
	}
	  public static void main(String[] args) {
		  //checking whether the connection is successful or not.
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
