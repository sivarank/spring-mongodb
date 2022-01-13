package com.javatechie.spring.mongo.api.resource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.javatechie.spring.mongo.api.model.Book;

import lombok.var;
import reactor.core.publisher.Flux;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@SpringBootTest(webEnvironment = RANDOM_PORT)
class BookControllerTest {
	@LocalServerPort
	private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
    
	@Test
	void testSaveBook() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBook() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBooks() {
		String baseUrl = "http://localhost:" + port + "/books";
		//Flux<T>
		//var books = restTemplate.getForEntity(baseUrl, Flux<Book>.class);
		//assertTrue(var.length > 1);
	}

	@Test
	void testDeleteBook() {
		fail("Not yet implemented");
	}

}
