package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    //select * from card as c where c.card_name = card_name;
    Optional<Card> findByCardName(String cardName);

    //select * from card where id = ? and deleted_at is null;
    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer cardId);
    //1:method query
    //2:HQL
    //3:Named Query
}
