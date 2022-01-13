package com.javatechie.spring.mongo.api.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
	@Autowired
	BookRepository repo;
	@Test
	void testFindByBookName() {
		System.out.println(repo.findById(12));
		//System.out.println(repo.findByBookName("Siva"));
	}

}
