package com.example.microservicespoc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer bookId;
	private String bookName; 
	private String authorName;
	private Integer availQty; 
	private Integer totalQty;
	
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getAvailQty() {
		return availQty;
	}
	public void setAvailQty(Integer availQty) {
		this.availQty = availQty;
	}
	public Integer getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}