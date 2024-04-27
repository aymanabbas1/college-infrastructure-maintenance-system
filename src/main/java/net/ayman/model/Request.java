package net.ayman.model;

import java.sql.Date;

public class Request {
    private int userId;
    private int serviceId;
    private Date dateOfRequest;
    private String location;
    private String status;
    private int requestId;
    private Integer staffId;
    private Date dateOfCompletion;

    // Constructors
    public Request() {
    }

    public Request(int requestId, int userId, int serviceId, Date dateOfRequest, String location, String status) {
        this.requestId = requestId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.dateOfRequest = dateOfRequest;
        this.location = location;
        this.status = status;
    }

    // Getters and setters
    
    
    public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Date getDateOfCompletion() {
		return dateOfCompletion;
	}

	public void setDateOfCompletion(Date dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

