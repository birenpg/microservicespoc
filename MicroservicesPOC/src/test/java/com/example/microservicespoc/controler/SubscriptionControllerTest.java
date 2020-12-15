package com.example.microservicespoc.controler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.microservicespoc.controller.SubscriptionController;
import com.example.microservicespoc.service.SubscriptionService;

@ExtendWith(MockitoExtension.class)
public class SubscriptionControllerTest {

	@Mock
	private SubscriptionService subscriptionService;

	@InjectMocks
	private SubscriptionController subscriptionController;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(subscriptionController).build();
	}

	@Test
	void getSubscriptionShouldReturnStatusIsOk() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subscriptions/Subscriber1").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(subscriptionService, Mockito.times(1)).getAllSubscriptions(Mockito.anyString());
	}

	@Test
	void getAllSubscriptionShouldReturnStatusIsOk() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subscriptions").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(subscriptionService, Mockito.times(1)).getAllSubscriptions(Mockito.any());
	}
	
	@Test
	void getBooksShouldReturnStatusIsOk() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/Book1").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(subscriptionService, Mockito.times(1)).getAllBooks(Mockito.anyString());
	}

	@Test
	void getAllBooksShouldReturnStatusIsOk() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(subscriptionService, Mockito.times(1)).getAllBooks(Mockito.any());
	}
	
}
