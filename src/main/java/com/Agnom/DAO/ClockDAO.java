package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.Agnom.Database.DatabaseConnection;

public class ClockDAO {
	
	private PreparedStatement ps;
    private Connection conn;
    
    public ClockDAO() throws ClassNotFoundException, SQLException {
    	System.out.println("HOLA");
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    public boolean clockIn(int bookID) throws SQLException {
    	/* to show the last check in date for the active booking of the user
    	 * input: book id to change the checkin date
    	 * return: boolean to confirm
    	 */
    	
    	String query="UPDATE bookings SET clockIn_date=? WHERE booking_id=?";
    	Date today = Date.valueOf(LocalDate.now());
			ps=conn.prepareStatement(query);
			ps.setInt(2, bookID);
			ps.setDate(1, today);
			
			int row=ps.executeUpdate();
			if (row==1) {
				return true;
			}
    	return false;
    }
    public boolean clockOut(int bookID) throws SQLException {
    	/*to cleck out in the database which will end the booking session for the user
    	 * input: book id to update
    	 * return: boolean to confirm
    	 */
    	String query="UPDATE bookings SET clockOut_date=? WHERE booking_id=?";
    	Date today = Date.valueOf(LocalDate.now());
    		ps=conn.prepareStatement(query);
    		ps.setInt(2, bookID);
    		ps.setDate(1, today);
    		
    		int row=ps.executeUpdate();
    		if (row==1) {
    			ps = conn.prepareStatement(
    				    "UPDATE room r " +
    				    "JOIN bookings b ON b.room_id = r.room_id " +
    				    "SET r.Status = 'Available' " +
    				    "WHERE b.booking_id = ?"
    				);
    				ps.setInt(1, bookID);
    				ps.executeUpdate();

    			return true;
    		}
    		
    	return false;
    }
    
}
