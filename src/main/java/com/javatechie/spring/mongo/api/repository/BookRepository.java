package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.javatechie.spring.mongo.api.model.Book;
public interface BookRepository extends ReactiveMongoRepository<Book, Integer>{
	Book findByBookName(String bookName);
}
