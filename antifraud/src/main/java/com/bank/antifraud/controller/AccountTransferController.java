package com.bank.antifraud.controller;

import com.bank.antifraud.dto.AccountTransferDTO;
import com.bank.antifraud.entity.AccountTransfer;
import com.bank.antifraud.service.AccountService;
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

/**
 * Контроллер для управления операциями счета.
 * Обрабатывает запросы, связанные с переводами средств между счетами.
 */
@RestController
@RequestMapping("/api/account-transfers")
public class AccountTransferController {

    private final AccountService accountService;

    /**
     * Конструктор контроллера AccountTransferController.
     *
     * @param accountService сервис для работы с счетами
     */
    @Autowired
    public AccountTransferController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Метод для получения информации о переводе по идентификатору счета.
     *
     * @param id идентификатор перевода
     * @return ResponseEntity с объектом AccountTransferDTO и статусом OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<AccountTransferDTO> getAccountController(@PathVariable int id) {
        AccountTransferDTO accountTransferDTO = accountService.getAccountTransferById(id);
        return ResponseEntity.ok(accountTransferDTO);
    }

    /**
     * Метод для сохранения или обновления информации о переводе.
     *
     * @param accountTransfer объект AccountTransfer с информацией о переводе
     * @return ResponseEntity с объектом AccountTransferDTO и статусом OK
     */
    @PostMapping("/edit")
    public ResponseEntity<AccountTransferDTO> saveAccountController(@RequestBody AccountTransfer accountTransfer) {
        AccountTransferDTO savedAccountTransfers = accountService.saveOrUpdateAccountTransfer(accountTransfer);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    /**
     * Метод для удаления информации о переводе по идентификатору.
     *
     * @param id идентификатор перевода
     * @return ResponseEntity с пустым телом и статусом OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountTransferDTO> deleteAccountById(@PathVariable Integer id) {
        accountService.deleteByIdAccountTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


