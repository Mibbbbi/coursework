package com.Agnom.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.Agnom.models.Booking;
import com.Agnom.Database.DatabaseConnection;

public class DashboardDAO {
	private PreparedStatement ps;
    private Connection conn;
    
    public DashboardDAO() throws ClassNotFoundException, SQLException {
    	System.out.println("HOLA");
    	try {   this.conn = DatabaseConnection.getConnection();
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    public int getTotalUser() throws SQLException {
    	/* counting total user in the database
    	 * input none
    	 * return int as count of user
    	 */
    	String query="Select Count(*) from user where role='user'";
    	int userCount=0;
    	if (conn != null) {
				ps=conn.prepareStatement(query);
				ResultSet count= ps.executeQuery();
				
				if (count.next()) {
		            userCount = count.getInt(1); // Now you have the count
				}
    	 }
    	return userCount;
    }
    
    public int getTotalRoom() throws SQLException {
    	/*counting total rooms in the database
    	 * input none
    	 * retunr int as number of rooms
    	 */
    	int roomCount=0;
    	ps=conn.prepareStatement("Select count(*) FROM room");
		ResultSet countR= ps.executeQuery();
		if (countR.next()) {
            roomCount = countR.getInt(1); // Now you have the count
        }
    	return roomCount;
    }
    
    public int getBookRoomCount() throws SQLException {
    	/* counting tootal booked room in the database
    	 * input none
    	 * return int as number of booke room
    	 */
    	int bookedCount=0;
    	ps=conn.prepareStatement("SELECT Count(*) FROM room WHERE status='booked'");
    	ResultSet bookedRoom=ps.executeQuery();
    	if(bookedRoom.next()){
    		bookedCount=bookedRoom.getInt(1);
    	}
    	return bookedCount;
    }
    
    public int getTotalRevenue() throws SQLException {
    	/*sumr of total pricing in th booking table
    	 * input none
    	 * return int as total revenue
    	 */
    	int cost=0;
    	ps=conn.prepareStatement("SELECT sum(total_cost) from bookings");
    	ResultSet revenue=ps.executeQuery();
    	if(revenue.next()) {
    		cost=revenue.getInt(1);
    	}
    	return cost;
    }
    

    public List<Booking> getBookingDets(LocalDate sDate, LocalDate eDate ,String method) throws SQLException {
    	/* to get booking that lies in between the sDate start and eData end, and method that was use to access the feature
    	 * input startDate and endDate and method that was used(null,button)
    	 * return: list of Booking object to display
    	 */
        List<Booking> bookings = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String query;
            //when date is not entered or initial state
            if (sDate == null && eDate == null) {
             
                query = "SELECT b.*, u.user_name FROM bookings b " +
                        "JOIN user u ON u.user_id = b.user_id " ;
                if(method.equals("getdets")) {
                	query+="Order BY booking_date DESc";
                }
                else {
                	query+="Order By booking_date desc Limit 10";
                }
                  
                ps = conn.prepareStatement(query);
            } else {
               //when date is entered display inbetween date for booking
                query = "SELECT b.*, u.user_name " +
                        "FROM bookings b " +
                        "JOIN user u ON u.user_id = b.user_id " +
                        "WHERE b.booking_date BETWEEN ? AND ?";
                ps = conn.prepareStatement(query);
               
                ps.setDate(1, java.sql.Date.valueOf(sDate));
                ps.setDate(2, java.sql.Date.valueOf(eDate));
            }

            // Execute query
            rs = ps.executeQuery();

            // Process result set and create Booking objects
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("booking_id"), 
                    rs.getInt("room_id"),
                    rs.getDate("booking_date"),
                    rs.getDate("expire_date"),
                    rs.getDate("clockIn_Date"),
                    rs.getDate("clockOut_Date"),
                    rs.getDouble("total_cost"),
                    rs.getString("user_name")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions here or log them
            e.printStackTrace();
            throw e;
        } finally {
            // Always close resources to prevent memory leaks
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return bookings;
    }
 public int mostIssuedRoom() throws SQLException {
	 int roomid=0;
	 String query="select count(*) AS TC,room_id from issue Group by room_id"
	 		+ " order by TC desc limit 1";
	 ps= conn.prepareStatement(query);
	 ResultSet rs= ps.executeQuery();
	 if(rs.next()) {
		 roomid=rs.getInt("room_id");
	 }
	 return roomid;
 }
 
 public int leastBookedRoom() throws SQLException {
	 int roomid=0;
	 String query="select count(*) as TC,room_id from bookings Group by room_id"
			 + " order by TC limit 1";
	 ps= conn.prepareStatement(query);
	 ResultSet rs= ps.executeQuery();
	 if(rs.next()) {
		 roomid=rs.getInt("room_id");
	 }
	 return roomid;
 }
}
				
			
				
			

