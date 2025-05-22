package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.Room;

public class RoomDAO {
    private Connection conn;

    public RoomDAO() throws ClassNotFoundException, SQLException {
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
     
    }
    public boolean checkRoom(int room_id) {
    	/*to check if the entered room number field exists or not
    	 * input int 
    	 * return boolean
    	 */
    	
        boolean exists = false;
        //confirming existence query
        String query="Select * from room where room_id=?";
        if(conn!=null) {
            PreparedStatement ps;
            try {
                ps = conn.prepareStatement(query);
                ps.setInt(1,room_id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    exists = true;
                }
            } catch (SQLException e) {
               
                e.printStackTrace();
            }


        }
        return exists;
    }
    public boolean addNewRoom(Room room) throws SQLException {
    	/* Adds new room to the database and gives boolean value if the room is added or not
    	 * input Room objects
    	 * returns boolean
    	 */
    	//adding query
    	String query = "Insert into room (room_id,price,description,category,image_path,status)"+
    		    "values(?,?,?,?,?,?)";
    	
    	if(conn!=null) {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, room.getRoomID());
				ps.setDouble(2, room.getPrice());
				ps.setString(3, room.getDescription());
				ps.setString(4, room.getCategory());
				ps.setString(5, room.getImage_path());
				ps.setString(6, room.getStatus());
				
				int rows=ps.executeUpdate();
				if (rows>0) {
					return true;
				}
				
    	}
    	return false;
    }
    
    public boolean removeRoom(int room_id) throws SQLException {
    	/* removing a room that matches the room id from database and give boolean to confirm
    	 *  input: int
    	 *  return boolean
    	 */
    	
    	String query="DELETE FROM room WHERE room_id=?";
    	if(conn!=null) {
    		//deleting FK before delete room
    		PreparedStatement ps = conn.prepareStatement("DELETE FROM bookings where room_id=?");
    		ps.setInt(1, room_id);
    		ps.executeUpdate();
    		ps = conn.prepareStatement("DELETE FROM issue where room_id=?");
    		ps.setInt(1, room_id);
    		ps.executeUpdate();
    		
    		
    		//removing room query
			ps = conn.prepareStatement(query);
				ps.setInt(1, room_id);
				int rows=ps.executeUpdate();
				if (rows>0) {
					return true;
				}
			
    	}
    	return false;
    }
    
    public boolean updateRoom(Room room) {
    	/* updates the room with the room object passed in the database and give boolean to confirm
    	 * input: Room object
    	 * return boolean
    	 */
    	
    	//updating query
        String query="Update room SET price=?,description=?,category=?,image_path=?,status=? where room_id=?";
                
        if(conn!=null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(6, room.getRoomID());
                ps.setDouble(1, room.getPrice());
                ps.setString(2, room.getDescription());
                ps.setString(3, room.getCategory());
                ps.setString(4, room.getImage_path());
                ps.setString(5, room.getStatus());
                
                int rows=ps.executeUpdate();
                if (rows>0) {
                    return true;
                }
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }
}
