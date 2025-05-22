package com.Agnom.models;

import java.time.LocalDateTime;

public class Issue {
	//attributes
    private int issueId;
    private String issueDesc;
    private String issueType;
    private LocalDateTime issueDate;
    private String solveStatus;
    private int roomId;
    private int bookingId;
    private int userId;
    private String userName;

    // Constructor
    public Issue(int issueId, String issueDesc, String issueType, LocalDateTime issueDate,
                          String solveStatus, int roomId, int bookingId, int userId, String userName) {
    	//constructor with intialization
        this.issueId = issueId;
        this.issueDesc = issueDesc;
        this.issueType = issueType;
        this.issueDate = issueDate;
        this.solveStatus = solveStatus;
        this.roomId = roomId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.userName = userName;
    }

    // Getters and Setters
    public int getIssueId() { return issueId; }
    public void setIssueId(int issueId) { this.issueId = issueId; }

    public String getIssueDesc() { return issueDesc; }
    public void setIssueDesc(String issueDesc) { this.issueDesc = issueDesc; }

    public String getIssueType() { return issueType; }
    public void setIssueType(String issueType) { this.issueType = issueType; }

    public LocalDateTime getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDateTime issueDate) { this.issueDate = issueDate; }

    public String getSolveStatus() { return solveStatus; }
    public void setSolveStatus(String solveStatus) { this.solveStatus = solveStatus; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; 
    }
  }

    