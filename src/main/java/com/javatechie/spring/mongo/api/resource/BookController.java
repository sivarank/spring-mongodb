package com.javatechie.spring.mongo.api.resource;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.Book;
import com.javatechie.spring.mongo.api.repository.BookRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import io.micrometer.core.instrument.Tags;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
	
Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookRepository repository;

	
	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping(value="/books")
	public String saveBook(@NonNull @RequestBody Book book) {
		repository.save(book);
		return "Added book with id : " + book.getId();
	}
	
	@Operation(summary = "Returns authorization context for a given authentication profile name " +
	        "which is required to make a secure outbound call.",
	        operationId = "getOutboundAuthorizationContext",
	        description = "Returns authorization context for a given authentication profile " +
	            "name which is required to make a secure outbound call. " +
	            "Authorization context contains the access token from external " +
	            "authorization server in case of oauth2 type authentication profile" )
	
    @ApiResponse(description = "Bad request", responseCode = "400")
        
    
	@GetMapping(value = "/books/{id}")
	public Mono<Book> getBook(@PathVariable int id) {
//		
//		Tracer tracer = GlobalTracer.get();
//		Tracer.SpanBuilder spanBuilder = tracer.buildSpan("CustomSpan")
//		        .withTag(Tags.SPAN_KIND.getKey(), Tags.SPAN_KIND_SERVER);
//		 
//		Span span = spanBuilder.start();
//		Tags.COMPONENT.set(span, "AppAController");
//		span.setTag("testtag", "test");
//		span.finish();
		
		BookControllerWithNewRelic.testNewRelic();
		logger.info(" "+id);
		logger.error("error: "+id);
		//DBObject query = new BasicDBObject("bookName", "Siva");
		//repository.findOne(query);
		return repository.findById(id);
	}
	
	@GetMapping(value="/books")
	@Cacheable("books")
	public Flux<Book> getBooks() {
		MDC.put("requestId", String.valueOf(UUID.randomUUID()));
		logger.error("getBooks");
		return repository.findAll();
	}

	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted with id : " + id;
	}

}
