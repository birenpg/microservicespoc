package com.example.microservicespoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicespoc.entity.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
		
	List<Subscription> findBySubscriberName(String subscriberName);
}
