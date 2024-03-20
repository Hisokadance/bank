package com.bank.antifraud.service;


import com.bank.antifraud.dto.CardTransferDTO;
import com.bank.antifraud.entity.CardTransfer;

public interface CardService {
    CardTransferDTO saveOrUpdateCardTransfer(CardTransfer cardTransfer);

    void deleteByIdCardTransfer(Integer id);

    CardTransferDTO getCardTransferById(int id);
}
