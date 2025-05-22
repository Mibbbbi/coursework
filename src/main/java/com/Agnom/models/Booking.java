package com.Agnom.models;

import java.util.Date;

public class Booking {
	//attributes
	private int booking_id;
	private int room_id;
	private int user_id;
	private Date book_date;
	private Date expire_date;
	private Date clockIn_date;
	private Date clockOut_date;
	private double price;
	private String username;
	
	
	
	
	
	
	
	
	public Booking(int booking_id,  int user_id, int room_id,Date book_date, Date expire_date, Date clockIn_date,
			Date clockOut_date, double price) {
		// to store the data into the database.
		this.booking_id = booking_id;
		this.room_id = room_id;
		this.user_id = user_id;
		this.book_date = book_date;
		this.expire_date = expire_date;
		this.clockIn_date = clockIn_date;
		this.clockOut_date = clockOut_date;
		this.price = price;
	}
	public Booking(int booking_id, int room_id,  Date book_date, Date expire_date, Date clockIn_date,
			Date clockOut_date, double price, String username) {
		// for displaying to admin with username instead of user id
		this.booking_id = booking_id;
		this.room_id = room_id;
		this.book_date = book_date;
		this.expire_date = expire_date;
		this.clockIn_date = clockIn_date;
		this.clockOut_date = clockOut_date;
		this.price = price;
		this.username = username;
	}
	
	
	//setters and getters for private attributes
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
	public Date getBook_date() {
		return book_date;
	}
	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	public Date getClockIn_date() {
		return clockIn_date;
	}
	public void setClockIn_date(Date clockIn_date) {
		this.clockIn_date = clockIn_date;
	}
	public Date getClockOut_date() {
		return clockOut_date;
	}
	public void setClockOut_date(Date clockOut_date) {
		this.clockOut_date = clockOut_date;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}