package com.restapi.REST_API.Exception;


import java.time.LocalDateTime;

public class Errordetails {
 
	private LocalDateTime date;
	private String message;
	private String description;
	public Errordetails(LocalDateTime localDateTime, String message, String description) {
		super();
		this.date = localDateTime;
		this.message = message;
		this.description = description;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
}
