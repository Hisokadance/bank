package com.bank.antifraud.controller;

import com.bank.antifraud.dto.PhoneTransferDTO;
import com.bank.antifraud.entity.PhoneTransfer;
import com.bank.antifraud.service.PhoneService;

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


@RestController
@RequestMapping("/api/phone-transfers")
public class PhoneTransferController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneTransferController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneTransferDTO> getAccountController(@PathVariable int id) {
        PhoneTransferDTO phoneTransfersDTO = phoneService.getPhoneTransferById(id);
        return ResponseEntity.ok(phoneTransfersDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<PhoneTransferDTO> saveAccountController(@RequestBody PhoneTransfer phoneTransfers) {
        PhoneTransferDTO savedPhoneTransfers = phoneService.saveOrUpdatePhoneTransfer(phoneTransfers);
        return ResponseEntity.ok(savedPhoneTransfers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PhoneTransferDTO> deleteAccountById(@PathVariable Integer id) {
        phoneService.deleteByIdPhoneTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
