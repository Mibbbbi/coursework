package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.Room;

public class ProductDAO {
	private Connection conn;
	
	public ProductDAO() throws SQLException {
		try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
	}
	
	public List<Room> getProducts() throws SQLException {
		/* to get all the rows of room table from database.
		 * input: none
		 * return: list of Room object
		 */
		
		List<Room> productDetails = new ArrayList<Room>();
		
		//selecting all rooms
		String query="SELECT * FROM room";
		
		if(conn!=null) {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Room room = new Room(
						rs.getInt("room_id"),
						rs.getDouble("price"),
						rs.getString("description"),
						rs.getString("category"),
						rs.getString("image_path"));
				room.setStatus(rs.getString("Status"));
				//adding each room table rows
				productDetails.add(room);
			}
		}
		return productDetails;
	}
	
	public Room roomBooking(int room_id) throws SQLException {
		/* to get a room detailed description to show in booking page to make booking
		 * input: int
		 * return: Room object
		 */
		
		//getting all columns of a room
		String query="Select * from room where room_id=?";
		Room room= null;
		if(conn!=null) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, room_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				room = new Room(
						rs.getInt("room_id"),
						rs.getDouble("price"),
						rs.getString("description"),
						rs.getString("category"),
						rs.getString("image_path"));
			}
		}
		return room;
	}

}
