package com.example.microservicespoc.exception;

import java.time.Instant;

public class ExceptionResponseMessage {
	
	Instant time;
	int status;
	String error;
	String exception;
	
	public ExceptionResponseMessage(Instant time, int status, String error, String exception) {
		
		this.time = time;
		this.status = status;
		this.error = error;
		this.exception = exception;
	}
	
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
}
