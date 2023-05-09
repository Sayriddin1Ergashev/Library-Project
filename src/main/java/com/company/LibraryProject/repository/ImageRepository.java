package com.company.LibraryProject.repository;


import com.company.LibraryProject.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
Optional<Image> findByImageIdAndDeletedAtIsNull(Integer id);
}
