package com.bank.antifraud.service;

import com.bank.antifraud.dto.CardTransferDTO;
import com.bank.antifraud.entity.CardTransfer;
import com.bank.antifraud.mapper.CardTransferMapper;
import com.bank.antifraud.repository.CardTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final CardTransferRepository cardTransferRepository;
    private final CardTransferMapper cardTransferMapper;

    @Transactional
    @Override
    public CardTransferDTO getCardTransferById(int id) {
        CardTransfer cardTransfers = cardTransferRepository.findById(id).orElseThrow();
        return cardTransferMapper.toDto(cardTransfers);
    }

    @Transactional
    @Override
    public CardTransferDTO saveOrUpdateCardTransfer(CardTransfer cardTransfer) {
        CardTransfer savedCardTransfer = cardTransferRepository.save(cardTransfer);
        return cardTransferMapper.toDto(savedCardTransfer);
    }

    @Transactional
    @Override
    public void deleteByIdCardTransfer(Integer id) {
        cardTransferRepository.deleteById(id);
    }
}
