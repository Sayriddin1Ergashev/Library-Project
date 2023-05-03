package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {
    Optional<Books>findByBooksIdAndDeletedAtIsNull(Integer booksId);
}
