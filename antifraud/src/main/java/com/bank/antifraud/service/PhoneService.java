package com.bank.antifraud.service;

import com.bank.antifraud.dto.PhoneTransferDTO;
import com.bank.antifraud.entity.PhoneTransfer;

public interface PhoneService {
    PhoneTransferDTO getPhoneTransferById(int id);

    PhoneTransferDTO saveOrUpdatePhoneTransfer(PhoneTransfer phoneTransfers);

    void deleteByIdPhoneTransfer(Integer id);
}
