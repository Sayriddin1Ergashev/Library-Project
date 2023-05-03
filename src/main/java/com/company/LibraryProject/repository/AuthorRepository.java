package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
Optional<Author>findByAuthorIdAndDeletedAtIsNull(Integer authorId);
}
