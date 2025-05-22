package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agnom.Database.DatabaseConnection;

public class UpdateSettingUserDAO {
	private Connection conn;
	PreparedStatement ps;

public UpdateSettingUserDAO() throws ClassNotFoundException, SQLException {
    	
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
	}

	public boolean updateSetting(int userid,String firstname,String lastname,String email,long contact,String username,String password) throws SQLException {
			/* takes inputs that will be used to update in the database and return boolean to confirm
			 * checks if the entered password is correct and update the entered details in the database
			 * input: int, string, string, string, long, string, string
			 * return: boolean
			 * */
			 
			//checking if the password is correct.
			ps=conn.prepareStatement("SELECT * FROM user WHERE user_id=? AND password=?");
			ps.setInt(1, userid);
			ps.setString(2,password);
			
			ResultSet rs= ps.executeQuery();
			if(!rs.next()) {
				System.out.println(userid);
				return false;
			}
			//updating the data with entered fields.
			String query = "UPDATE user SET first_name=?,last_name=?,email=?,contact=?,user_name=?"
					+ "WHERE user_id=?";
				ps=conn.prepareStatement(query);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, email);
				ps.setLong(4, contact);
				ps.setString(5, username);
				ps.setInt(6, userid);
				
				int rows=ps.executeUpdate();
				if(rows>0) {
					System.out.println(username);
					return true;
				}
		
		return false;
	}
}
