package com.example.microservicespoc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.microservicespoc.entity.Books;
import com.example.microservicespoc.entity.Subscription;
import com.example.microservicespoc.repository.BooksRepository;
import com.example.microservicespoc.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getAllBooks(String bookName) {

		List<Books> books = new ArrayList<>();

		if (bookName != null) {
			books = booksRepository.findByBookName(bookName);
		} else {
			books = (List<Books>) booksRepository.findAll();
		}
		return books;
	}

	
	public List<Subscription> getAllSubscriptions(String subscriberName) {

		List<Subscription> subscriptions = new ArrayList<>();

		if (subscriberName != null) {
			subscriptions = subscriptionRepository.findBySubscriberName(subscriberName);
		} else {
			subscriptions = (List<Subscription>) subscriptionRepository.findAll();
		}
		return subscriptions;
	}
	
	@Transactional(dontRollbackOn = ResourceNotFoundException.class)
	public Subscription createSubscription(Subscription subscription) {

		Subscription saveSubscription = subscriptionRepository.saveAndFlush(subscription);		
		createSubscription(saveSubscription.getSubscriberName(),saveSubscription.getBookId(), saveSubscription.getDateSubscribed());
		return saveSubscription;
	}

	@SuppressWarnings("unused")
	private void createSubscription(String subscriberName, Integer bookId, Date dateSubscribed) {

		Subscription subscription = new Subscription();
		
		subscription.setSubscriberName(subscriberName);
		subscription.setBookId(bookId);
		subscription.setDateSubscribed(dateSubscribed);
		
		if(subscription != null) {
			throw new ResourceNotFoundException("Subscription with subscriber name " + subscriberName + " is not correct");
		}
		subscriptionRepository.save(subscription);
	}
}
