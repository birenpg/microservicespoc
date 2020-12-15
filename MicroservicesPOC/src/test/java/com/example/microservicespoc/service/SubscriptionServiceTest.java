package com.example.microservicespoc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.microservicespoc.entity.Books;
import com.example.microservicespoc.entity.Subscription;
import com.example.microservicespoc.repository.BooksRepository;
import com.example.microservicespoc.repository.SubscriptionRepository;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

	@InjectMocks
	private SubscriptionService subscriptionService;

	@Mock
	private SubscriptionRepository subscriptionRepository;
	
	@Mock
	private BooksRepository booksRepository;

	private Subscription subscription;
	private Books books;
	
	private List<Subscription> returedSubscription;
	private List<Books> returedBooks;
	
	
	  @BeforeEach 
	  public void setup() {	  
		  setupSubscriptionData();
		  setupBooksData();	  		  
	  }
	 
	  private void setupSubscriptionData() {
		  
		  returedSubscription = new ArrayList<Subscription>();
		  Date currentDateTime = new Date();
		  
		  subscription = new Subscription();
		  subscription.setSubscriberName("TestSubscriber");
		  subscription.setBookId(1111); 
		  subscription.setDateReturned(currentDateTime);
		  subscription.setDateSubscribed(currentDateTime);
	  
		  returedSubscription.add(subscription); 		  
	  }
	  
	  private void setupBooksData() {
		  
		  returedBooks = new ArrayList<Books>();
		  
		  books = new Books();
		  books.setAuthorName("TestAuthor");
		  books.setAvailQty(100);
		  books.setBookId(1111);
		  books.setBookName("TestBook");
		  books.setTotalQty(100);
	  
		  returedBooks.add(books); 		  
	  }
	  
	@Test
	public void getListOfSubscription() {

		Mockito.when(subscriptionRepository.findAll()).thenReturn(returedSubscription);
		List<Subscription> returnedSubs = subscriptionService.getAllSubscriptions(null);
		
		assertEquals(subscription, returnedSubs.get(0));
		Mockito.verify(subscriptionRepository, Mockito.times(0)).findBySubscriberName(Mockito.eq("TestSubscriber"));
		Mockito.verify(subscriptionRepository, Mockito.times(1)).findAll();
	}
  
	@Test
	public void getListOfBooks() {

		Mockito.when(booksRepository.findAll()).thenReturn(returedBooks);
		List<Books> returedBuks = subscriptionService.getAllBooks(null);
		
		assertEquals(books, returedBuks.get(0));
		Mockito.verify(booksRepository, Mockito.times(0)).findByBookName(Mockito.eq("TestBook"));
		Mockito.verify(booksRepository, Mockito.times(1)).findAll();
	}
	

}
