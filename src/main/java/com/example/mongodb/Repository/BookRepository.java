package com.example.mongodb.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

}
