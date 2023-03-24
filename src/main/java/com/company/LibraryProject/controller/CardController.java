package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.CardService;
import org.springframework.web.bind.annotation.*;

//localhost:8080/card
@RestController
@RequestMapping("card")
public class CardController {
    //CRUD
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //localhost:8080/card/create
    @PostMapping("/create")
    public ResponseDto<CardDto> createCard(@RequestBody CardDto dto) {
        return cardService.create(dto);
    }

    //localhost:8080/card/get?id=1
    @GetMapping("/get")
    public ResponseDto<CardDto> getCard(@RequestParam Integer id) {
        return cardService.get(id);
    }

    //localhost:8080/card/update?id=1
    @PutMapping("/update")
    public ResponseDto<CardDto> updateCard(@RequestBody CardDto dto, @RequestParam Integer id) {
        return cardService.update(dto, id);
    }

    //localhost:8080/card/delete?id=1
    @DeleteMapping("/delete")
    public ResponseDto<CardDto> deleteCard(@RequestParam Integer id) {
        return cardService.delete(id);
    }


    public void add(){

    }
}
