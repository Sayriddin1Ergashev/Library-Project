package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserIdAndDeletedAtIsNull(Integer userId);


    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);


}
