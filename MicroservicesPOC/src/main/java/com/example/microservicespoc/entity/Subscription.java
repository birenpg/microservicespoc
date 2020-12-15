package com.example.microservicespoc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String subscriberName;
	private Date dateSubscribed; 
	private Date dateReturned;
	private Integer bookId;
	
	
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public Date getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public Date getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
		
}
