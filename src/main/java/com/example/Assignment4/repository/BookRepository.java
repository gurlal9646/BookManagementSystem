package com.example.Assignment4.repository;

import com.example.Assignment4.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
