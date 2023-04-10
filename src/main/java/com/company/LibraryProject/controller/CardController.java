package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/card")
@RequiredArgsConstructor
public class CardController {


    private final CardService cardService;


    @PostMapping(value = "/create")
    public ResponseDto<CardDto> create(@RequestBody CardDto dto) {

        return cardService.createCard(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<CardDto> get(@PathVariable("id") Integer id) {

        return cardService.getCard(id);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseDto<CardDto> updateCard(@RequestBody CardDto dto, @PathVariable(value = ("id")) Integer id) {
        return cardService.updateCard(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<CardDto> deleteCard(@PathVariable(value = ("id")) Integer id){
        return cardService.deleteCard(id);
    }
}