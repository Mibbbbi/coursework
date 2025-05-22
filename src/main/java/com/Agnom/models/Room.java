package com.Agnom.models;

public class Room {
	private int roomID;
	private double price;
	private String description;
	private String category;
	private String image_path;
	private String status;
	
	public Room(int roomID, double price, String description, String category, String image_path) {
		//constructor with initialization to insert value while creating object.
		this.roomID = roomID;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image_path = image_path;
		this.status = "Available";
	}
	
	//setting and getter
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
