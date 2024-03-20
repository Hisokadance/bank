package com.bank.antifraud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.antifraud.dto.CardTransferDTO;
import com.bank.antifraud.entity.CardTransfer;
import com.bank.antifraud.service.CardService;

@RestController
@RequestMapping("/api/card-transfers")
public class CardTransferController {

    private final CardService cardService;

    @Autowired
    public CardTransferController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardTransferDTO> getCardController(@PathVariable int id) {
        CardTransferDTO cardTransfersDTO = cardService.getCardTransferById(id);
        return ResponseEntity.ok(cardTransfersDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<CardTransferDTO> saveCardController(@RequestBody CardTransfer cardTransfers) {
        CardTransferDTO savedAccountTransfers = cardService.saveOrUpdateCardTransfer(cardTransfers);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CardTransferDTO> deleteCardById(@PathVariable Integer id) {
        cardService.deleteByIdCardTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
