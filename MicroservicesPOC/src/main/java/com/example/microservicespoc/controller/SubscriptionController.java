package com.example.microservicespoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicespoc.entity.Books;
import com.example.microservicespoc.entity.Subscription;
import com.example.microservicespoc.service.SubscriptionService;

@RestController
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;


	@GetMapping("/subscriptions/{subscriberName}") 
	public List<Subscription> getSubscription(@PathVariable String subscriberName)
	{
		return subscriptionService.getAllSubscriptions(subscriberName); 
	}

	@GetMapping("/books/{bookName}") 
	public List<Books> getBook(@PathVariable String bookName)
	{
		return subscriptionService.getAllBooks(bookName); 
	}
	
	@GetMapping("/books")
	public List<Books> getAllBooks(@RequestParam(required = false) String bookName) {

		return subscriptionService.getAllBooks(bookName);
	}

	@GetMapping("/subscriptions")
	public List<Subscription> getAllSubscriptions(@RequestParam(required = false) String subscriberName) {

		return subscriptionService.getAllSubscriptions(subscriberName);
	}

	@PostMapping("/createsubscription")
	public Subscription createSubscription(@RequestBody Subscription subscription) {

		return subscriptionService.createSubscription(subscription);
	}
}
