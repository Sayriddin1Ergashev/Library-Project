package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    //select cd from card as cd where cd.card_id = ? and cd.deleted_at is null
    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer id);

}
