package com.example.microservicespoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicespoc.entity.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>{
	
	List<Books> findByBookName(String bookName);
}
