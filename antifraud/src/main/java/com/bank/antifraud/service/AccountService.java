package com.bank.antifraud.service;


import com.bank.antifraud.dto.AccountTransferDTO;
import com.bank.antifraud.entity.AccountTransfer;

public interface AccountService {

    AccountTransferDTO saveOrUpdateAccountTransfer(AccountTransfer accountTransfer);

    void deleteByIdAccountTransfer(Integer id);

    AccountTransferDTO getAccountTransferById(int id);

}
