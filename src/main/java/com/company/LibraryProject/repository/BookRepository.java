package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Book;
import com.company.LibraryProject.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByBookIdAndDeletedAtIsNull(Integer bookId);
}