package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.Room;

public class SearchDAO {
	private Connection conn;

public SearchDAO() throws ClassNotFoundException, SQLException {
    	
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
	}

    	public List<Room> searchRooms(String searchWord) throws SQLException {
    		/* take a string word as parameter to check the pattern similar with it in category or description from database
    		 * Returns a list of Room objects that matches the entered string pattern.
    		 * input: string
    		 * return: list of Room objects
    		 */
    		
    		List<Room> searchDetails = new ArrayList<Room>();
    		String query="SELECT * FROM room WHERE category LIKE ? OR Description LIKE ?";
    		
    		if(conn!=null) {
    			PreparedStatement ps = conn.prepareStatement(query);
    			ps.setString(1, "%" + searchWord + "%");
    			ps.setString(2, "%" + searchWord + "%");
    			ResultSet rs = ps.executeQuery();
    			while (rs.next()) {
    				Room room = new Room(
    						rs.getInt("room_id"),
    						rs.getDouble("price"),
    						rs.getString("description"),
    						rs.getString("category"),
    						rs.getString("image_path"));
    				room.setStatus(rs.getString("Status"));
    				searchDetails.add(room);
    			}
    		}
    		return searchDetails;
    	}
    
}
