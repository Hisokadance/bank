package com.bank.antifraud.service;

import com.bank.antifraud.dto.PhoneTransferDTO;
import com.bank.antifraud.entity.PhoneTransfer;
import com.bank.antifraud.mapper.PhoneTransferMapper;
import com.bank.antifraud.repository.PhoneTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneTransferRepository phoneTransfersRepository;
    private final PhoneTransferMapper phoneTransfersMapper;


    @Transactional()
    @Override
    public PhoneTransferDTO getPhoneTransferById(int id) {
        PhoneTransfer phoneTransfers = phoneTransfersRepository.findById(id).orElseThrow();
        return phoneTransfersMapper.toDto(phoneTransfers);
    }
    @Transactional
    @Override
    public PhoneTransferDTO saveOrUpdatePhoneTransfer(PhoneTransfer phoneTransfer) {
        PhoneTransfer savedPhoneTransfer = phoneTransfersRepository.save(phoneTransfer);
        return phoneTransfersMapper.toDto(savedPhoneTransfer);
    }

    @Transactional
    @Override
    public void deleteByIdPhoneTransfer(Integer id) {
        phoneTransfersRepository.deleteById(id);
    }
}
