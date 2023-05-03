package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PublishersRepository extends JpaRepository<Publisher, Integer> {
    Optional<Publisher> findByPublisherIdAndDeletedAtIsNull(Integer id);

}
