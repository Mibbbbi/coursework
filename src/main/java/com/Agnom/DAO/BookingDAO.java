package com.Agnom.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.Agnom.Database.DatabaseConnection;
import com.Agnom.models.Booking;

public class BookingDAO {
	private PreparedStatement ps;
    private Connection conn;
    
    public BookingDAO() throws ClassNotFoundException, SQLException {
    	System.out.println("HOLA");
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    public boolean makeBooking(int roomid, int user_id,int days) throws SQLException {
    	/* making booking to the room by users and adding to the database
    	 * input: roomid to update status, userid to who booked and days to find expireday of booking
    	 * return: boolean to confirm
    	 */
    	Date today = Date.valueOf(LocalDate.now());
    	LocalDate expire = LocalDate.now().plusDays(days);
    	Date expireDate = Date.valueOf(expire);
    	
    	//uploading query
    	String query="INSERT INTO bookings(user_id,room_id,booking_date,expire_date,clockIn_date,clockOut_date,total_cost)"
    			+ "VALUES(?,?,?,?,?,?,?)";
    	 if (conn != null) {
    			ps=conn.prepareStatement("SELECT * FROM room where room_id=? AND Status='Available'");
    			ps.setInt(1, roomid);
    			System.out.println(roomid);
    			ResultSet rs = ps.executeQuery();
    			if(!rs.next()) {
    				return false;
    			}
    			int price=0;
    			int totalPrice=0;
    			// getting price to add in booking.
    			ps=conn.prepareStatement("SELECT price FROM room where room_id=?");
    			ps.setInt(1, roomid);
    			ResultSet prices=ps.executeQuery();
    			if (prices.next()) {
    				price=prices.getInt(1);
    				totalPrice = price*days;
    			}else {
    				return false;
    			}
				ps=conn.prepareStatement(query)	;
				ps.setInt(1,user_id);
				ps.setInt(2,roomid);
				ps.setDate(3, today);
				ps.setDate(4, expireDate);
				ps.setNull(5, java.sql.Types.DATE);
				ps.setNull(6, java.sql.Types.DATE);
				ps.setInt(7, totalPrice);
				
				int rows = ps.executeUpdate();
				if(rows>0) {
					//updating status of room
					ps=conn.prepareStatement("Update room SET status='booked' where room_id=?");
					ps.setInt(1, roomid);
					ps.executeUpdate();
					return true;	
				} 
    	 }
    	 return false;
    }
    
    public List<Booking> getBookingDetails(int userID, LocalDate sDate, LocalDate eDate) throws SQLException {
    	/* to dsplay in booking history page, it gets data from the database according to the parameters passed 
    	 * and can find the booking date in range of sDate and eDate
    	 * input: int userid to get booking related to user, localdate sdate as startdate , localdate edate as end date
    	 * return: list of Booking objects
    	 */
        List<Booking> bookingDetails = new ArrayList<Booking>();
        PreparedStatement ps = null; // Initialize the PreparedStatement

        if (sDate == null && eDate == null) {
            // If both dates are null, fetch all bookings for the user
            String query = "SELECT * FROM bookings WHERE user_id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
        } else {
            // If dates are provided, fetch bookings within the specified date range
            String query = "SELECT * FROM bookings WHERE user_id =? AND booking_date BETWEEN ? AND ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setDate(2, java.sql.Date.valueOf(sDate));
            ps.setDate(3, java.sql.Date.valueOf(eDate));
        }

        if (ps != null) { // Ensure ps is not null before executing the query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("booking_id"),
                    userID,
                    rs.getInt("room_id"),
                    rs.getDate("booking_date"),
                    rs.getDate("expire_date"),
                    rs.getDate("clockIn_Date"),
                    rs.getDate("clockOut_Date"),
                    rs.getDouble("total_cost")
                );
                bookingDetails.add(booking);
            }
        }
        return bookingDetails;
    }
    public Booking currentBooking(int userID) throws SQLException {
    	/* to get the booking details that is currently active with the user in the parameter
    	 * input: useriD int to know which user
    	 * return: BOoing object 
    	 */
    	Date today = Date.valueOf(LocalDate.now());
    	
    	Booking booking=null;
    	//booking details of room that hasnot ended
    	String query ="SELECT * from bookings where user_id=? AND expire_date>=? And clockOut_date IS NULL ";
			ps=conn.prepareStatement(query);
			ps.setInt(1, userID);
	    	ps.setDate(2, today);
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()) {
	    		booking = new Booking(
	                    rs.getInt("booking_id"),
	                    userID,
	                    rs.getInt("room_id"),
	                    rs.getDate("booking_date"),
	                    rs.getDate("expire_date"),
	                    rs.getDate("clockIn_Date"),
	                    rs.getDate("clockOut_Date"),
	                    rs.getDouble("total_cost")
	                );
	    	}
    	return booking;
    }
}
