package com.bank.antifraud.controller;

import com.bank.antifraud.dto.CardTransferDTO;
import com.bank.antifraud.entity.CardTransfer;
import com.bank.antifraud.service.CardService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card-transfers")
public class CardTransferController {

    private final CardService cardService;

    @ApiResponse(responseCode = "200", description = "Успешное получение данных")
    @GetMapping("/{id}")
    public ResponseEntity<CardTransferDTO> getCardController(@PathVariable int id) {
        CardTransferDTO cardTransfersDTO = cardService.getCardTransferById(id);
        return ResponseEntity.ok(cardTransfersDTO);
    }

    @ApiResponse(responseCode = "200", description = "Успешное сохранение данных")
    @PostMapping("/save")
    public ResponseEntity<CardTransferDTO> saveCardController(@RequestBody CardTransfer cardTransfers) {
        CardTransferDTO savedAccountTransfers = cardService.saveOrUpdateCardTransfer(cardTransfers);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    @ApiResponse(responseCode = "200", description = "Успешное обновление данных")
    @PutMapping("/update")
    public ResponseEntity<CardTransferDTO> updateCardController(@RequestBody CardTransfer cardTransfers) {
        CardTransferDTO savedAccountTransfers = cardService.saveOrUpdateCardTransfer(cardTransfers);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    @ApiResponse(responseCode = "200", description = "Успешное удаление данных")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CardTransferDTO> deleteCardById(@PathVariable Integer id) {
        cardService.deleteByIdCardTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
