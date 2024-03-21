package com.bank.antifraud.controller;

import com.bank.antifraud.dto.PhoneTransferDTO;
import com.bank.antifraud.entity.PhoneTransfer;
import com.bank.antifraud.service.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/phone-transfers")
public class PhoneTransferController {

    private final PhoneService phoneService;

    @Operation(summary = "Получить информацию о переводе телефона по ID")
    @ApiResponse(responseCode = "200", description = "Успешное получение данных о переводе телефона",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PhoneTransferDTO.class)))
    @GetMapping("/{id}")
    public ResponseEntity<PhoneTransferDTO> getAccountController(@PathVariable int id) {
        PhoneTransferDTO phoneTransfersDTO = phoneService.getPhoneTransferById(id);
        return ResponseEntity.ok(phoneTransfersDTO);
    }

    @Operation(summary = "Сохранить информацию о переводе телефона")
    @ApiResponse(responseCode = "200", description = "Успешное сохранение данных о переводе телефона",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PhoneTransferDTO.class)))
    @PostMapping("/save")
    public ResponseEntity<PhoneTransferDTO> saveAccountController(@RequestBody PhoneTransfer phoneTransfers) {
        PhoneTransferDTO savedPhoneTransfers = phoneService.saveOrUpdatePhoneTransfer(phoneTransfers);
        return ResponseEntity.ok(savedPhoneTransfers);
    }

    @Operation(summary = "Обновить информацию о переводе телефона")
    @ApiResponse(responseCode = "200", description = "Успешное обновление данных о переводе телефона",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PhoneTransferDTO.class)))
    @PutMapping("/update")
    public ResponseEntity<PhoneTransferDTO> updateAccountController(@RequestBody PhoneTransfer phoneTransfers) {
        PhoneTransferDTO savedPhoneTransfers = phoneService.saveOrUpdatePhoneTransfer(phoneTransfers);
        return ResponseEntity.ok(savedPhoneTransfers);
    }

    @Operation(summary = "Удалить информацию о переводе телефона по ID")
    @ApiResponse(responseCode = "200", description = "Успешное удаление данных о переводе телефона")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PhoneTransferDTO> deleteAccountById(@PathVariable Integer id) {
        phoneService.deleteByIdPhoneTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
