package com.bank.antifraud.service;

import com.bank.antifraud.dto.AccountTransferDTO;
import com.bank.antifraud.entity.AccountTransfer;
import com.bank.antifraud.mapper.AccountTransferMapper;
import com.bank.antifraud.repository.AccountTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с счетами.
 * Предоставляет методы для получения, сохранения и удаления информации о переводах средств между счетами.
 */
@RequiredArgsConstructor//конструкор для бинов
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountTransferRepository accountTransferRepository;
    private final AccountTransferMapper accountTransfersMapper;

    /**
     * Метод для получения информации о переводе по идентификатору.
     *
     * @param id идентификатор перевода
     * @return объект AccountTransferDTO с информацией о переводе
     */
    @Transactional(readOnly = true)
    @Override
    public AccountTransferDTO getAccountTransferById(int id) {
        AccountTransfer accountTransfer = accountTransferRepository.findById(id).orElseThrow();
        return accountTransfersMapper.toDto(accountTransfer);
    }

    /**
     * Метод для сохранения или обновления информации о переводе.
     *
     * @param accountTransfer объект AccountTransfer с информацией о переводе
     * @return объект AccountTransferDTO с сохраненной информацией о переводе
     */
    @Transactional
    @Override
    public AccountTransferDTO saveOrUpdateAccountTransfer(AccountTransfer accountTransfer) {
        AccountTransfer savedAccountTransfer = accountTransferRepository.save(accountTransfer);
        return accountTransfersMapper.toDto(savedAccountTransfer);
    }

    /**
     * Метод для удаления информации о переводе по идентификатору.
     *
     * @param id идентификатор перевода
     */
    @Transactional
    @Override
    public void deleteByIdAccountTransfer(Integer id) {
        accountTransferRepository.deleteById(id);
    }
}

