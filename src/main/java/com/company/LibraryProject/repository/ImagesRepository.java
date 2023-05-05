package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Integer> {
    Optional<Images> findByImageIdAndDeletedAtIsNull(Integer imageId);
    Boolean existsByTokenAndDeletedAtIsNull(String token);
}
