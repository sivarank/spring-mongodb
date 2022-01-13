package com.javatechie.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@Document(collection = "Book")
public class Book {
	@Id
	@Generated
	private int id;
	@NonNull
	private String bookName;
	//@NonNull
	private String authorName;
}
